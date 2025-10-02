CREATE TABLE Vehicle (
    vid int primary key auto_increment,
    vname varchar(20),
    price double(9,2),
    descr varchar(100)
);


CREATE TABLE customer (
    custid int primary key auto_increment,
    cname varchar(20),
    address varchar(50)
);

CREATE TABLE salesman (
    sid int primary key auto_increment,
    sname varchar(20),
    address varchar(100)
);


CREATE TABLE cust_vehicle(
    custid int,
    vid int,
    sid int,
    buy_price double(9,2),
    constraint fk_custid foreign key(custid) references customer(custid),
    constraint fk_vid foreign key(vid) references Vehicle(vid),
    constraint fk_sid foreign key(sid) references salesman(sid)
);


insert into Vehicle(vname, price, descr)
values('Activa', 80000, 'ksldjfjksj'),
values('Santro', 800000, 'kdjfkjsd'), 
values('Motor bike', 100000, 'fdkdfj');

INSERT INTO customer (Custid, Cname, address) VALUES
(1, 'Nilima', 'Pimpari'),
(2, 'Ganesh', 'Pune'),
(3, 'Pankaj', 'Mumbai');

INSERT INTO salesman(sname, address) VALUES
('Rajesh', 'Mumbai'),
('Seema', 'Pune'),
('Rakhi', 'Pune');

INSERT INTO cust_vehicle(custid, vid, sid, buy_price) VALUES
(1, 1, 10, 75000),
(1, 2, 10, 790000),
(2, 3, 11, 80000),
(3, 3, 11, 75000),
(3, 2, 10, 800000);


-- 1. create all given tables 
-- Done ✔
-- 2. create index on vehicle table based on price 
CREATE INDEX idx_price ON vehicle(price);
-- 3. find all customer name,vehicle name, salesman name, discount earn by all customer 
--  discount = price - buy price
--  per = (discount /price )*100

select c.cname , v.vname, s.sname , round((( v.price -cs.buy_price)/v.price)*100, 2) as discount  from customer c, Vehicle v , salesman s,cust_vehicle cs
where cs.vid = v.vid and cs.sid = s.sid and cs.custid =c.custid;

-- 4. find all customer name,vehicle name,salesman name for all salesman who stays in pune 

select c.cname , v.vname, s.sname from customer c, Vehicle v , salesman s,cust_vehicle cs
where cs.vid = v.vid and cs.sid = s.sid and cs.sid  in (select sid from salesman where address = 'Pune') and cs.custid =c.custid ;

-- 5. find how many customers bought motor bike
select count(*) from cust_vehicle cv, vehicle v
where  cv.vid = v.vid and cv.vid in (select vid from vehicle where vname = 'Motor bike');

-- 6. create a view find_discount which displays output  
-- -------to create view 
--              create view find_discount 
--              as  
--                select cname,vname,price,buying_price,price-buying_price “discount” 
--                from customer c inner join cust_vehicle cv on c.custid=cv.cid inner join vehicle v on                 
--                v.vid=cv.vid 
--           --------to display discount  
--                   select * from find_discount; 
create view find_discount as 
select c.cname , v.vname, s.sname , round((( v.price -cs.buy_price)/v.price)*100, 2) as discount  from customer c, Vehicle v , salesman s,cust_vehicle cs
where cs.vid = v.vid and cs.sid = s.sid and cs.custid =c.custid;

-- 7. find all customer name, vehicle name, salesman name, discount earn by all customer 
-- alreadY done ✔😊


-- 8. create view my_hr to display empno,ename,job,comm for all employees who earn commission 
create view my_hr as
SELECT empno , ename , job , comm from emp where comm is not  null;

-- 9. create view mgr30 to display all employees from department 30 
    create view mgr30 as
    select * from emp where deptno=30;

-- 10.  insert 3 employees in view mgr30 check whether insertion is possible 
--  yes its possible
 insert into mgr30 value(12,'kirtesh','developer',null,'2001-1-12','1200',300,30);
-- 11.  insert 3 records in dept and display all records from dept

