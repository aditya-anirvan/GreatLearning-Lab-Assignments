use e_commerce;

create table if not exists supplier ( 
SUPP_ID int primary key,
SUPP_NAME varchar(50) not null,
SUPP_CITY varchar(50) not null,
SUPP_PHONE varchar(50) not null);

create table if not exists customer (
CUS_ID INT PRIMARY KEY,
CUS_NAME VARCHAR(20) NOT NULL,
CUS_PHONE VARCHAR(10) NOT NULL,
CUS_CITY VARCHAR(30) NOT NULL,
CUS_GENDER CHAR(1));

create table if not exists category (
CAT_ID INT PRIMARY KEY,
CAT_NAME VARCHAR(20) NOT NULL);

create table if not exists product (
PRO_ID INT PRIMARY KEY,
PRO_NAME VARCHAR(20) DEFAULT "Dummy",
PRO_DESC VARCHAR(60),
CAT_ID INT,
FOREIGN KEY(CAT_ID) REFERENCES category(CAT_ID));

create table if not exists supplier_pricing (
PRICING_ID INT PRIMARY KEY,
PRO_ID INT,
SUPP_ID INT,
SUPP_PRICE INT DEFAULT 0,
FOREIGN KEY(PRO_ID) REFERENCES product(PRO_ID),
FOREIGN KEY(SUPP_ID) REFERENCES supplier(SUPP_ID));

create table if not exists `order` (
ORD_ID INT PRIMARY KEY,
ORD_AMOUNT INT NOT NULL,
ORD_DATE DATE NOT NULL,
CUS_ID INT,
PRICING_ID INT,
FOREIGN KEY(CUS_ID) REFERENCES customer(CUS_ID),
FOREIGN KEY(PRICING_ID) REFERENCES supplier_pricing(PRICING_ID));

create table if not exists rating (
RAT_ID INT PRIMARY KEY,
ORD_ID INT,
RAT_RATSTARS INT NOT NULL,
FOREIGN KEY(ORD_ID) REFERENCES `order`(ORD_ID));