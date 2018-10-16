# API Platform & API-led Integration Lab 1

Lab 1 artefacts could be found here

## Lab 1 mysql datamodel
The following is to run a mysql database in a docker container. 
Then the DDLs to create the datamodel needed

```shell
docker run -d -p 3306:3306 \
-e "MYSQL_ROOT_PASSWORD=tibco123" --name LocalMySQL mysql 
```

```shell
docker ps
docker exec -it [containerid] bash
root@XXXXXXXXXX:/# mysql -u root -p
```

```sql
create database PSG;
use PSG;
```

```sql
CREATE TABLE IF NOT EXISTS Customer (
CustID      integer not null auto_increment,
Name    	varchar (50) default null,
Address 	varchar (100) default null,
City        varchar (50) default null,
State       char (2) default null,
Zipcode     varchar (5) default null,
CreditLimit decimal(10,2),
Phone 		varchar(15),
PRIMARY KEY (CustID)
);

CREATE TABLE IF NOT EXISTS CustomerOrder (
OrderID      integer not null auto_increment,
CustID	 integer not null,
OrderDate    date default null,
ShipmentDate date default null,
ShipmentStatus        varchar (50) default null,
PRIMARY KEY (OrderID),
FOREIGN KEY (CustID) REFERENCES Customer(CustID)
);

CREATE TABLE IF NOT EXISTS OrderLines (
OrderID      integer not null,
Itemno    	char(10) not null,
Description  varchar(100) default null,
Qty          integer default null,
Price		 decimal(10,2),
PRIMARY KEY (OrderID,Itemno),
FOREIGN KEY (OrderID) REFERENCES CustomerOrder(CustID)
);

create user 'psg'@'%' identified by 'tibco123';
grant all on PSG.* to 'psg'@'%';
```
