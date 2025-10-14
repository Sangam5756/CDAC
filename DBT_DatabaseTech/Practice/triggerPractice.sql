CREATE TABLE Employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50) NOT NULL,
    department VARCHAR(30),
    salary DECIMAL(10,2),
    hire_date DATE
);


CREATE TABLE Department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(30),
    location VARCHAR(50)
);




-- create the procedure to updare the employeed dept
DELIMITER //
CREATE procedure updateEmpDept(in pempno int,in pdeptno int )
BEGIN
    UPDATE employee 
        SET deptno = pdeptno
            WHERE empno=pempno; 

END;
//
DELIMITER ;


-- step 1 wanna create the trigger to log when the emp table wil change the deptno


-- create the trigger to log when dept is changed;
DELIMITER //
create trigger logdept
after update on employee
for each row
begin
    if old.deptno <> new.deptno 
    then insert into deptlog(empno,olddeptno,newdeptno) values (old.empno,old.deptno,new.deptno);
    end if;
end; //
DELIMITER ;


-- create the table for loggin information
create table deptlog(
    logid int  auto_increment PRIMARY key,
    empno int,
    olddeptno int,
    newdeptno int,
    updatetime DATETIME
);

-- time to test the table log

update employee
set deptno = 4
where empno = 2;



-- steps to create the trigger
-- first what we want to log
-- second create the table for that log
-- thir create trigger for that 
-- then check log table



-- trigget two to log the updates in the salary
-- what to log salary update

-- create the table logempsalary where constinat will logid,empno,oldsal,newsal,timestamp

create table logsalary(
    logid int PRIMARY key auto_increment,
    empno int,
    oldsal int,
    newsal int,
    updatetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- now create the trigger on table employe to log when any thing change

delimiter //
create trigger logsalaryemp
after update on employee
for each row
begin
if old.salary <> new.salary then 
    insert into logsalary(empno,oldsal,newsal) values(old.empno,old.salary,new.salary);
end if;
end; //
delimiter ;


-- now test the trigger by updateing the eployee salary
update employee
set salary = 30000 where empno=5;   // it works



-- now will create the triiger to delte the when empno is deleted
 
--  first create the log table for delteemp
create table logemp(
    logid int PRIMARY KEY auto_increment,
    empno int,
    empname varchar(30),
    salary int,
    hire_date date,
    deptno int,
    updatetime timestamp Default current_timestamp
);
-- create the trigger to log deleted emp
-- when delete no need to see add any condition
delimiter //
create trigger logdeleteemp
before delete on employee
for each row
begin
        
        insert into logemp(empno,empname,salary,hire_date,deptno)
        values (old.empno,old.emp_name,old.salary,old.hire_date,old.deptno);
        
end; //
delimiter ;



--  now test it now its work
delete from employee
    -> where empno =5;

-- create the trigger to before insert check the values
DELIMITER //
create trigger checksal
before insert on employee
for each row
BEGIN
        if new.salary < 0 then
      signal  SQLSTATE  '45000'
        set MESSAGE_TEXT = 'salary can not be negative';
        end if;

end; //
DELIMITER ;



-- create the trigger deptno canont be null

delimiter //
create trigger deptnocheck
before insert on employee
for each row
begin
        if new.deptno is null
        then signal SQLSTATE '45000'
        set MESSAGE_TEXT = 'deptno cannot be null';
        end if;
end; //
delimiter ;


-- 



-- trigger what to do
--  change the empnaem trigger
-- first craete logable
-- then craete teigger
-- then test it



create table logname(
    logid int PRIMARY key auto_increment,
    empno int,
    oldname varchar(30),
    newname varchar(30),
    updatetime TIMESTAMP default CURRENT_TIMESTAMP
);


delimiter //
create trigger logempname
after update on employee
for each row
begin
        if old.emp_name <> new.emp_name
        then 
        insert into logname(empno,oldname,newname) values 
        (old.empno,old.emp_name,new.emp_name);
        end if;

end;//
delimiter;

update employe
set emp_name = 


select * from department d left join
employee e on d.dept_id=e.deptno 
where e.deptno is null;



