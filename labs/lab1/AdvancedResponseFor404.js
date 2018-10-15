function customCode(req, res) {
  /** 
   * JavaScript code to set mock response,
   * please refer to documentation for supported API operations. 
   * res.status = 200
   * res.body = {name:"cat"} 
   */
 
 //your code goes here
 
 var pathparams = req.params;

if (pathparams.customerid==='999')
{
	res.status = 404;
	res.body = {
  			"errorCode": "CUST_SVC_API_002",
			"errorID": "6bd9c7af-edeb-4377-bdbe-6f5b3697c7ba",
			"errorType": "TECHNICAL",
  			"more_info": "http://loalhost/docs/messages/CUST_SVC_API_000",
  			"status": 401,
 			"context": [
    			{
      				"name": "optional_name",
      				"value": "optional_value"
    			}
  			],

			}

}

else{
  res.status = 200
  res.body = {
 			"Address": "3 Silicone alley",
  			"City": "Palo Alto",
  			"CreditLimit": 12000000,
  			"CustID": 123,
  			"Name": "Moonlit Semiconductors",
  			"Phone": "(949)202-8025",
  			"State": "CA",
  			"zip": "92614"
			}
  }

 


  return res;
}