-- opg 4.1
select cname from customers;

-- opg 4.2
select cname,zip from customers where phone like '%55';

-- opg 4.3
select pname from parts where qoh < 150;

-- opg 4.4
select ono,qty from odetails;

-- opg 4.5
select pname from parts where price < 18.00;

-- opg 4.6
select ono from orders,employees where employees.eno = orders.eno and ename = 'Jones';

-- opg 4.7
select cname,city from zipcodes,customers where zipcodes.zip = customers.zip;

-- opg 4.8
select cname,ono from customers,orders where customers.cno = orders.cno and street like '1%';

-- opg 4.9
select * from zipcodes left outer join employees on zipcodes.zip=employees.zip;

-- opg 4.10
select cname, ono from orders,customers where orders.cno=customers.cno and customers.zip=(select zip from zipcodes where city = 'wichita');

-- opg 4.11
select sum(price*qty) from odetails,parts where odetails.pno = parts.pno;

-- opg 4.12
select ono from orders where shipped = null;

-- opg 4.13
select orders.ono,count(distinct odetails.pno),cname,street,customers.zip,city 
from odetails,orders,zipcodes,customers 
where odetails.ono = orders.ono 
and zipcodes.zip = customers.zip 
and customers.cno = orders.cno
group by orders.ono;

-- opg 4.14
select distinct cname from customers,orders,employees,zipcodes
where customers.cno = orders.cno
and orders.eno = employees.eno
and employees.zip = zipcodes.zip 
and zipcodes.city = 'Wichita';

-- opg 4.15
select distinct parts.pname, odetails.qty, parts.price*odetails.qty
from parts,odetails
where odetails.ono = 1020
and parts.pno = odetails.pno;

-- opg 4.16
select orders.ono, sum(parts.price*odetails.qty)
from orders,parts,odetails
where orders.ono = odetails.ono
and odetails.pno = parts.pno
group by orders.ono;
