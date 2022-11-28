use e_commerce;

/*-------------------------------------------------------------------*/

SELECT  CUS_GENDER,COUNT(DISTINCT CUSTOMER.CUS_ID) AS No_CUSTOMER FROM CUSTOMER,`ORDER` WHERE (CUSTOMER.CUS_ID = `ORDER`.CUS_ID && `ORDER`.ORD_AMOUNT>=3000) group by CUSTOMER.CUS_GENDER;

/*-------------------------------------------------------------------*/

SELECT PRODUCT.PRO_NAME,`ORDER`.* FROM SUPPLIER_PRICING,`ORDER`,PRODUCT WHERE (`ORDER`.CUS_ID = 2 && `ORDER`.PRICING_ID = SUPPLIER_PRICING.PRICING_ID && SUPPLIER_PRICING.PRO_ID=PRODUCT.PRO_ID);

/*-------------------------------------------------------------------*/

SELECT SUPPLIER.* FROM supplier WHERE SUPP_ID IN (SELECT SUPP_ID FROM SUPPLIER_PRICING GROUP BY SUPP_ID HAVING COUNT(PRO_ID) > 1);

/*-------------------------------------------------------------------*/

select t3.cat_id,t3.CAT_NAME,t3.pro_name, min(t3.min_price) as MIN_PRICE FROM
(select category.* , t2.pro_name, t2.min_price from category inner join  
(select product.* , t1.min_price from product inner join 
(select pro_id , min(supp_price) as MIN_PRICE from supplier_pricing group by pro_id) 
as t1 on product.pro_id=t1.pro_id) as t2 on category.CAT_ID=t2.CAT_ID) as t3 
group by t3.cat_id ;

/*-------------------------------------------------------------------*/

select product.pro_id , product.pro_name from product natural join 
`order` natural join supplier_pricing 
where `order`.ord_date>"2021-10-05";

/*-------------------------------------------------------------------*/

select cus_name,cus_gender from customer where cus_name like "%A" union 
select cus_name,cus_gender from customer where cus_name like "A%" order by cus_name;

/*-------------------------------------------------------------------*/

DELIMITER && 
CREATE PROCEDURE proc()
BEGIN 
select report.supp_id, report.supp_name,report.average, 
CASE
	when report.average=5 then "EXCELLENT SERVICE"
    when report.average>=4 then "GOOD SERVICE"
    when report.average>2 then "AVERAGE SERVICE"
    ELSE "POOR SERVICE"
    
END AS Type_of_Service from

(select final.supp_id, supplier.supp_name, final.Average from (select test2.supp_id, sum(test2.rat_ratstars)/count(test2.rat_ratstars) as Average from

(select supplier_pricing.supp_id, test.ORD_ID, test.RAT_RATSTARS 
from supplier_pricing inner join 
(select `order`.pricing_id, rating.ORD_ID, rating.RAT_RATSTARS from `order` inner join rating on rating. ord_id = `order`.ORD_ID) as test 
on test.PRICING_ID=supplier_pricing.PRICING_ID)
as test2 group by supplier_pricing.supp_id)



as final inner join supplier where final.supp_id = supplier.supp_id) as report;

END &&


call proc(); 
/*-------------------------------------------------------------------*/