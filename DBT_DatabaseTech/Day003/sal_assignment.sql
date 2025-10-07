-- Write SQL statement for the following
-- 1. To find all managers with salary >1500

select * from emp where job = 'manager' and sal > 1500;


-- 2. list all employees with sal >1200 and < 2000

select * from emp where sal between 1200 and 2000;

-- 3. list all employees with sal is 1600 or sal is 800 or sal is 1900
select * from emp where sal in (1600,800,1900);

-- 4. list all employees with R at second last position in name
select * from emp where ename like '%R_';
-- 5. List all employees with name starts with A and ends with N

select * from emp where ename like 'A%N';








-- Q2. Solve following


-- 1. list all employees with salary > 1250 and dept no=30

    select * from emp  where sal > 1250 and deptno =30;

-- 2. list all employees with salary >=1250 and <= 3000
    select * from emp where sal between 1251 and 3000;

-- 3. list all employees with salary >1250 and < 3000
    select * from emp where sal between 1250 and 3000;

-- 4. list all employees with salary either equal to 3000 or 1250 or 2500
select * from emp where sal in (3000,1250,2500);

-- 5. list all employee with name=SMITH
select * from emp where ename = 'smith';
-- 6. list all employees with name starting with S
select * from emp where ename REGEXP '^S';
-- 7. list all employees with name ending with S
select * from emp where ename like '%S';
 
-- 8. list all employees with name contains I at 2nd position
select * from emp where ename like '_I%';

-- 9. list all employees with name starts with A ends witn N and somewhere in between L is there
select * from emp  where ename like 'A%L%N';

-- 10. list all employees with name starts with A and B at 3 rd position and P at second last position
select * from emp where ename like 'A_B%P_';

-- 11. List all employees with name starts with either A or starts with S or starts with W
select * from emp where ename like 'A%' or ename like  'S%' or ename like  'W%';
select * from emp where ename REGEXP '^[AS]';

-- 12. find max sal and min sal for each job
select job, max(sal),min(sal) from emp GROUP BY job;

-- 13. find how many employess have not received commission
select count(*) from emp where comm is null;


-- 14. find sum of sal of all employees working in dept no 10
select deptno,SUM(sal) from emp where deptno = 10;

-- 15. find maximum salary,average sal for each job in every department

    select job,MAX(sal), AVG(sal) from emp GROUP BY job;

-- 16. find max salary for every department if deptno is > 15 and arrange data in deptno order.
    select deptno, max(sal) from emp where deptno > 15 
    GROUP BY deptno
    ORDER BY deptno;

-- 17. find sum salary for every department if sum is > 3000
select deptno, sum(sal) from emp group by deptno HAVING SUM(sal) >3000;


-- 18. list all department which has minimum 5 employees
    select deptno, count(empno) from emp GROUP BY deptno
    HAVING count(empno) >5;

-- 19. count how many employees earn salary more than 2000 in each job
    select job ,count(empno) from 
    emp where  sal> 2000 GROUP BY job ;


-- 20. list all enames and jobs in small case letter
    select lower(ename),lower(job) from emp;

-- 21. list all names and jobs so that the length of name should be 15 if it is samller then add
-- spaces to left


    select LPAD(ename,15,'-') from emp;



-- 22. display min sal,max sal, average sal for all employees working under same manager

    select MIN(sal), MAX(sal) , AVG(sal) from emp group by mgr;


-- 23. find sum of total earnings(sal+comm), average of sal+comm for all employees who earn sal >-- 2000 and work in either dept no 10 or 20

    select SUM(sal+comm), AVG(sal+comm) from emp  where sal > 2000 and deptno in (10,20);


-- 24. list all employees who joined in Aug 1980 and salary is >1500 and < 2500

select date_format(curdate(),'%b');
    select * from emp where date_format(hiredate, '%b %Y') in( date_format('1981-09','%b %Y')) and salary between 1500 and 2500;

    -- 25. list all employees joined in either aug or may or dec

    select * from emp where date_format(hiredate, '%b') in ('Aug','May','Dec');


-- 26. display name and hiredate in dd/mm/yy format for all employees whose job is clerk and

-- they earn some commission
    select ename, date_format(hiredate,'%d/%m/%Y') from emp where job = 'clerk' and comm is null ;




-- 27. list empcode,empno,name and job for each employee. (note :empcode is 3 to 5 characters
-- from name and last 2 characters of job)
    select CONCAT(SUBSTR(ename,3,5),' ', right(job,2)) as EMPCODE ,ename ,job from emp;

-- 28. display thousand separator and $ symbol for commission if it is null then display it as 0 for all employees whose name starts with A and ends with N

    SELECT CONCAT('$', FORMAT(IFNULL(comm,0), 0)) as commision from EMP where ename like 'A%N';





-- 29. Display empid,name,sal,comm,remark Remark should base on following conditions
-- comm >= 600 "excellent Keep it up"
-- if it < 600 or not null "good"
-- otherwise "Need improvement"

select empno,ename ,sal , comm, 
CASE

 WHEN comm>= 600 THEN 'Excellent'
 WHEN comm < 600 or comm is not null then 'Good'
 ELSE 'Need improvement'
 END AS Remark
 FRom EMP;



-- 30. Display empid, name, deptno and department name by using following conditions.
-- dept 10 then "Hr"
-- if 20 then "Admin"
-- if 30 then "accounts"
-- otherwise purchase
select empno,ename,e.deptno ,dname ,
CASE
WHEN e.deptno = 10 then 'HR'
WHEN e.deptno= 20 then 'ADMIN'
WHEN e.deptno= 30 then 'accounts'
ELSE 'Purchase'
end as Remarks
from emp e inner join dept d on e.deptno=d.deptno;


-- 31. Practice creating following tables

-- create table mydept_DBDA
-- (deptid number primary key,dname varchar2(20) not null unique, dloc varchar2(20) )

create table mydept_DBDA(
    deptid int PRIMARY KEY,
    dname varchar(20) null unique,
    dloc varchar(20)
)

-- insert into mydept_DBDA values(30,'Purchase','Mumbai');
-- create table myemployee


-- ( empno number(5) primary key, fname varchar2(15) not null, mname varchar2(15),
--  lname varchar2(15) not null, sal number(9,2) check(sal >=1000), doj date default sysdate,
--  passportnum varchar2(15) unique,
--  deptno number constraint fk_deptno references mydept_DBDA(deptid) on delete cascade )
create Table myemployee (
    empno INT(5) PRIMARY key,
    fname varchar(15) not null,
    mname VARCHAR(15),
    lname VARCHAR(15) not null,
    sal DOUBLE(9,2) check(sal >=1000),
    doj date DEFAULT (curdate()),
    passportnum varchar(15) UNIQUE,
    deptno int ,
    constraint fk_deptno Foreign Key(deptno) REFERENCES DEPT(DEPTNO)
    on Delete CASCADE

);



-- 32. Create following tables Student, Course

-- Student (sid,sname) ---------------- sid ---primary key
create table Student (
    sid int PRIMARY KEY,
    sname VARCHAR(15)
);

-- Course(cid,cname)-------------- cid ---primary key
CREATE TABLE Course(
    cid int PRIMARY key,
    cname VARCHAR(15)
);
-- Marks(studid,coursed,marks)

-- create table marks(
-- studid number,
-- courseid number,
-- marks number,
-- constraint pk primary key(studid,courseid),
-- constraint fk_sid foreign key (studid) references student(sid) on delete set null,
-- constraint fk_cid foreign key (courseid) references course(cid)
-- )
CREATE Table Marks(
    studid int,
    courseid int,
    marks int,
    constraint pk PRIMARY KEY(studid,courseid),

    constraint fk_studid FOREIGN KEY(studid) REFERENCES Student(sid)
        on delete CASCADE
    ,
    constraint fk_courseId FOREIGN KEY(courseid) REFERENCES Course(cid)
);


-- Sample data for marks table
-- studid,courseid,marks
-- 1 1 99
-- 1 3 98
-- 2 1 95
-- 2 2 97




-- 33. Create empty table emp10 with table structure same as emp table.
-- create table emp10 as
(
select *
from emp
where 1=2;
)




-- 34. Solve following using alter table
-- add primary key constraint on emp,dept,salgrade
-- emp ---- empno
-- dept--- deptno
-- salgrade--- grade
-- add foreign key constarint in emp
-- deptno --->> dept(deptno)
-- add new column in emp table netsal with constraint default 1000






-- 35. Update employee sal ---- increase sal of each employee by 15 % sal +comm, change the job

-- to manager and mgr to 7777 for all employees in deptno 10.
UPDATE EMP
SET 
    sal = (sal + IFNULL(comm,0)) * 1.15,
    job = 'MANAGER',
    mgr = 7777
WHERE deptno = 10;




-- 36. change job of smith to senior clerk

update EMP SET
job = 'senior clerk'
where ename = 'SMITH';


-- 37. increase salary of all employees by 15% if they are earning some commission

UPDATE EMP SET
sal = sal * 1.15
where comm is not null and comm > 0;

-- 38. list all employees with sal>smith's sal
SELECT * FROM EMP where sal > (select sal from EMP where ename ='smith');


-- 39. list all employees who are working in smith's department

SELECT * from EMP where deptno = (select deptno from EMP where ename ='SMITH');

-- 40. list all employees with sal < rajan's sal and salary > revati's sal
SELECT * from EMP WHERE sal BETWEEN (select sal from EMP where ename = 'rajan') and (select sal from EMP where ename= 'revati');

-- 41. delete all employees working in alan's department

DELETE from EMP
where deptno in 
(select deptno from (select deptno from EMP where  ename = 'alan') as temp);



-- 42. change salary of Alan to the salary of Miller.
UPDATE EMP
set
sal =( select sal from (select sal from EMP where ename = 'miller') as temp)
WHERE ename = 'Allen';



-- 43. change salary of all emplees who working in Wall's department to the salary of Miller.
UPDATE
EMP
SET
sal = (select sal from (select sal from EMP where ename = 'miller') as temp)
where deptno in (select deptno from (select deptno from EMP where ename = 'wall') as temp2);
-- 44. list all employees with salary > either Smith's salary or alan's sal

UPDATE EMP
SET sal = ()

-- 45. list all employees who earn more than average sal of dept 10
select * from EMP where sal > (SELECT AVG(sal) from EMP where deptno=10);

-- 46. list all employees who earn more than average sal of Alan's department
SELECT * from EMP WHERE sal > (select AVG(sal) from EMP where deptno = (SELECT deptno FROM EMP where ename = "ALLEN"));

-- 47. list all employees who are working in purchase department
-- select * from EMP where deptno = (select deptno from DEPT where dname='PURCHASE');
select * from EMP where deptno = (select deptno from DEPT where dname='ACCOUNTING');

-- 48. list all employees who earn more than average salary of their own department
    SELECT * from EMP e WHERE e.sal > (select AVG(sal) from EMP e1 where e.deptno =e1.deptno);


-- 49. list all employees who earn sal < than their managers salary

    select * from EMP e where sal < (select sal from EMP e1 where e.mgr=e1.empno );


-- 50. list all employees who are earning more than average salary of their job
    select * from EMP e where sal > (select AVG(sal) from emp e1 where e.job =e1.job);


-- 51. display employee name and department

    select e.ename , d.dname from EMP e,DEPT d where e.deptno=d.deptno;

-- 52. display empno,name,department name and grade (use emp,dept and salgrade table)
    select e.empno , e.ename ,d.dname ,s.grade
    from EMP e inner join 
    DEPT d on e.deptno = d.deptno
    inner join salgrade s on e.sal between s.losal and s.hisal;
    
-- 53. list all employees number,name, mgrno and manager name
select e.empno,e.ename , e.mgr, m.ename from EMP e inner join emp m
on e.mgr = m.empno;


-- 54. create following tables and solve following questions(primary keys are marked in yellow)


-- foreign keys are marked in green

-- product(pid,pname,price,qty,cid,sid)

    create table product (
        pid int primary key,
        pname varchar(29),
        price double(9,2),
        qty int,
        cid int,
        sid int

        constaint fk_sid FOREIGN KEY(sid) references salesman(sid),
        constaint fk_cid FOREIGN KEY(cid) references category(cid)
);


-- salesman (sid,sname,address)

    create table salesman (
        sid int PRIMARY KEY,
        sname varchar(20),
        address varchar (30)
    );


-- category(cid,cnam,descritpion)
create table category(
    cid int PRIMARY KEY,
    cname VARCHAR(20),
    address VARCHAR(20)
);


-- 1. list all product name,their category name and name of a person, who sold that product

select pd.pname,ct.cname,s.sname from product pd  join Category ct on pd.cid = ct.cid join salesman s on pd.sid=s.sid;




-- 2. list all product name and salesman name for all salesman who stays in pune

    select p.pname,s.sname from product p , salesman s where  p.sid=s.sid and s.address='pune';


-- 3. list all product name and category name

    select pd.pname ,c.cname from product pd  inner join category c on pd.cid=c.cid;


-- 55. create following tables and solve following questions(primary keys are marked in yellow)
-- foreign keys are marked in green


-- faculty(fid,fname,sp.skill1,sp.skill2)

    create table faculty(
        fid int PRIMARY KEY,
        sname varchar(20),
        spskill1 varchar(20),
        spskill2 varchar(20),
    )


-- courses(cid,cname,rid,fid)

create table courses(
    cid int PRIMARY KEY,
    cname varchar(20),
    fid int,
    rid int,
    constraint fk_fid FOREIGN KEY(fid) REFERENCES faculty(fid),
    constraint fk_rid FOREIGN KEY(rid) REFERENCES room(rid)
);


-- room(roomid,rname,rloc)
create table room(
    roomid int PRIMARY KEY,
    rname VARCHAR(30),
    rloc VARCHAR(30)
);






-- 1. list all courses for which no room is assigned. And all rooms for which are
-- available

    (select * from courses c right join room r on  c.rid=r.rid where c.cid is null)
                    UNION

    (SELECT * FROM room r    LEFT JOIN courses c ON r.rid = c.rid where c.cid is not null);




-- 2. list all faculties who are not allocated to any course and rooms which are not
-- allocated to any course

        (select 'Faculty' AS type, f.fid AS id, f.fname AS name from faculty f left join courses c on f.fid =c.fid where c.cid is null)
        UNION

        (select 'Room' AS type, r.rid AS id, r.rname AS name from room r left join courses c on r.rid =c.rid where c.cid is null);



-- 3. list all rooms which are allocated or not allocated to any courses

    select * from room r left join courses c on r.rid=c.cid;

    
    -- 4. list all rooms which are not allocated to any courses

    select * from room r left join courses c on r.rid=c.rid  where c.cid is null;


-- 5. display courses and faculty assigned to those courses whose special skill is
-- database

select * from courses c inner join faculty f on c.fid=f.fid where spskill1 = 'database' or spskill2='database';


-- 6. display time table --- it should contain course details , faculty and room
-- details
    select * from courses s inner join faculty f on s.fid =s.fid inner join room r on s.rid =r.rid;




-- 56. create following tables with given constraints


-- product---- qty >0, default 20.00,pname not null and unique
-- prodid pname qty price catid sid
create table product (
    prodid int PRIMARY KEY,
    pname VARCHAR(30) NOT NULL UNIQUE,
    qty int,
    price DOUBLE(9,2),
    catid int ,
    sid int ,

    constraint fk_catid FOREIGN KEY(catid) REFERENCES category(catid),
    constraint fk_sid FOREIGN KEY (sid) REFERENCES salesman(sid)

);

-- saleman ----- sname -----not null
-- sid sname city
CREATE table salesman(
    sid int PRIMARY KEY,
    sname VARCHAR(30),
    city VARCHAR (30)
);

-- 11 Rahul Pune
-- 12 Kirti Mumbai
-- 13 Prasad Nashik
-- 14 Arnav Amaravati


-- category ---- cname unique and not null
-- cid cname description
CREATE TABLE category(
    catid int PRIMARY,
    cname VARCHAR(30),
    description VARCHAR(20)
);

-- 1 chips very crunchy
-- 2 chocolate very chocolaty
-- 3 snacks yummy
-- 4 cold drinks thanda thanda cool cool



-- 1. List all products with category chips

select * from product p inner join category c on p.catid=c.catid where c.cname ='Chips';
        
-- 2. display all products sold by kirti

    select * from product p inner join salesman s on p.sid=s.sid;

-- 3. display all salesman who do not sold any product
select s.* from salesman s left join product p on s.sid=p.pid where p.pid is null;

-- 4. display all category for which no product is there
    select c.* from product p left join category c on p.catid=c.catid where p.pid is null;


-- 5. display all products with no category assigned
select * from product where catid is null;


-- 6. list all salesman who stays in city with name starts with P or N

    select * from product p inner join salesman s on p.sid = s.sid where s.address like "P%" or s.address like "%N"

-- 7. add new column in salesman table by name credit limit
alter table salesman
add column creditlimit double(9,2);

-- ------------------------------