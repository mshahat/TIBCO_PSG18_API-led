package com.tibco.tn18.be;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.tibco.cep.runtime.model.event.SimpleEvent;

import com.tibco.cep.runtime.service.tester.beunit.BETestEngine;
import com.tibco.cep.runtime.service.tester.beunit.ExpectationType;
import com.tibco.cep.runtime.service.tester.beunit.Expecter;
import com.tibco.cep.runtime.service.tester.beunit.TestDataHelper;

/**
 * @description 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMarineTransportLogistics {
	private static BETestEngine engine;
	private static TestDataHelper helper;
	private static Expecter expecter;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		engine = new BETestEngine("/opt/projects/be/mtl.ear", "/opt/tibco/cep/be/5.5/bin/be-engine.tra",
				"Deployments/MarineTransportLogistics.cdd", "FleetLogistics", "CommandCenter", true);

		// Start the test engine
		engine.start();
		
		// Create a helper to work with test data
		helper = new TestDataHelper(engine);
		
		// Create an Expecter object to test rule execution, modifications, assertions, etc.
		expecter = new Expecter(engine);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		try {
			engine.shutdown();
		} catch (Exception localException) {
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	* Test whether updates from fleet initiate and modify Voyage concepts
	*/
	@Test
	public void test1_FleetUpdatesForShip1() throws Exception {
		engine.resetSession(); 
		
		List<SimpleEvent> events = helper.createEventsFromTestData("/TestData/Events/FleetUpdate_Ship1");
		engine.assertEvents(events, true);
		
		// Make sure these 3 basic rules triggered in this order
		List<String> rules = new ArrayList<String>();
		rules.add("/Rules/CommandCenter/InitiateVoyage");
		rules.add("/Rules/CommandCenter/UpdateVoyage");
		rules.add("/Rules/CommandCenter/CompleteVoyage");
		expecter.expectOrdered(rules, ExpectationType.RULE_EXECTION);
		
		// Make sure concept got updated
		expecter.expect("/Concepts/Voyage", ExpectationType.CONCEPT_MODIFICATION);
		expecter.expectModifiedByExtId("ID_Route1_Ship1", "CurrentLocation", "At Destination");
		
		// voyage completed and deleted from working memory
		expecter.expectNotInWorkingMemoryByExtId("ID_Route1_Ship1"); 
		
	}
	
	/**
	* Test whether updates from fleet initiate and modify Voyage concepts for all 5 ships
	*/
	@Test
	public void test2_FleetUpdatesForShip1To5() throws Exception {
		engine.resetSession(); 
		
		List<SimpleEvent> events = helper.createEventsFromTestData("/TestData/Events/FleetUpdate_Ship1_2_3_4_5");
		engine.assertEvents(events, true);
				
		expecter.expectNotInWorkingMemoryByExtId("ID_Route1_Ship1"); // voyage completed and deleted from working memory
		expecter.expectNotInWorkingMemoryByExtId("ID_Route1_Ship2"); // voyage completed and deleted from working memory
		
		expecter.expectInWorkingMemoryByExtId("ID_Route3_Ship3"); // voyage still going on and thus in working memory
		expecter.expectInWorkingMemoryByExtId("ID_Route4_Ship4"); // voyage still going on and thus in working memory
		expecter.expectInWorkingMemoryByExtId("ID_Route5_Ship5"); // voyage still going on and thus in working memory
		
	}
	
	/**
	* Test whether updates from port authorities instantiate Disruptor concepts
	*/
	@Test
	public void test3_PortUpdates() throws Exception {
		engine.resetSession(); 

		List<SimpleEvent> events = helper.createEventsFromTestData("/TestData/Events/Disruptor");
		Iterator<SimpleEvent> evtIter = events.iterator();
		while(evtIter.hasNext()) {
			engine.assertEvent(evtIter.next(), true, "/Rules/CommandCenter/TriageDisruption");
		}
		
		// Make sure concepts are created
		expecter.expectInWorkingMemoryByExtId("ID_Shanghai_Trade war");
		expecter.expectInWorkingMemoryByExtId("ID_Montreal_Iceberg drifting");
		expecter.expectInWorkingMemoryByExtId("ID_New York_Weather alert");
	}
	
	/**
	* Test whether disruptions from Port authorities affect the fleet
	*/
	@Test
	public void test4_BusinessDisruptions() throws Exception {
		engine.resetSession();
		
		List<SimpleEvent> events = helper.createEventsFromTestData("/TestData/Events/Disruptor");
		Iterator<SimpleEvent> evtIter2 = events.iterator();
		while(evtIter2.hasNext()) {
			engine.assertEvent(evtIter2.next(), true, "/Rules/CommandCenter/TriageDisruption");
		}
		
		List<SimpleEvent> events2 = helper.createEventsFromTestData("/TestData/Events/FleetUpdate_Ship1_2_3_4_5");
		Iterator<SimpleEvent> evtIter = events2.iterator();
		while(evtIter.hasNext()) {
			engine.assertEvent(evtIter.next(), true); 
			Thread.sleep(5000);
		}
		
		expecter.expectRuleFired("/Rules/CommandCenter/HandleDisruption");
		
		expecter.expect("/Concepts/Voyage", ExpectationType.CONCEPT_MODIFICATION);
		
		expecter.expectInWorkingMemory("/Concepts/Voyage");
		
		expecter.expectNotInWorkingMemoryByExtId("ID_Route1_Ship1");
		expecter.expectNotInWorkingMemoryByExtId("ID_Route1_Ship2");
		
		expecter.expectInWorkingMemoryByExtId("ID_Route3_Ship3");
		expecter.expectInWorkingMemoryByExtId("ID_Route4_Ship4");
		expecter.expectInWorkingMemoryByExtId("ID_Route5_Ship5");
		
		//***************************************
		
		expecter.expectInWorkingMemory("/Concepts/Disruption");
		
		expecter.expectInWorkingMemoryByExtId("ID_Shanghai_Trade war");
		expecter.expectInWorkingMemoryByExtId("ID_Montreal_Iceberg drifting");
		
		//***************************************
				
	}	
}