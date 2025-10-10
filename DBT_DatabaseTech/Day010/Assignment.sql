-- -- User defined functions in Mysql
-- When to write function
-- 1. When you want to return single value
-- 2. These functions we can call from select statement
-- Syntax for writing function
-- CREATE FUNCTION func_name (parameters)
-- RETURNS return_type
-- BEGIN
-- statements
-- END//


-- To see the list of all functions
-- show function status where db='test';
-- or
-- SELECT
-- routine_schema AS "Database",
-- routine_name
-- FROM
-- information_schema.ROUTINES
-- WHERE
-- routine_type = 'FUNCTION'
-- ORDER BY
-- routine_schema ASC, routine_name ASC;

-- In PLSQL, if you want to return single value as output,then use function
-- to write functions, it is necessary to assign following variable
-- set global log_bin_trust_function_creators=1;
-- 1. write a function to generate email, by concatenating first 3 letters of name and last 3
-- letters of job and concatenate ‘@mycompany.com'.
-- delimiter //
-- create function generateEmail(nm varchar(20),
-- ejob varchar(20)) returns varchar(30)
-- begin
-- declare vem varchar(30);

-- set vem=concat(substr(nm,1,3),’.’,
-- right(ejob,3),'@mycompany.com');
-- return vem;
-- end//
-- to use function
-- select empno,ename,job, generateEmail(ename,job)
-- from emp;

-- 2. calculate experience of a employee
-- delimiter //
-- create function calcexp(edate date) returns int
-- begin
-- declare vexp int;
-- set vexp=timestampdiff(year,edate,curdate());
-- return vexp;
-- end//
-- delimiter ;

-- 3. write a function to calculate discount rate for room
-- delimiter //
-- create function calcDiscount(prloc varchar(20),prate double(9,2))
-- returns double(9,2)
-- begin
-- declare vdiscount double(9,2) default 0;
-- if prloc="seaview" then
-- set vdiscount=prate*0.10;
-- elseif prloc="hill side" then
-- set vdiscount= prate*0.15;
-- else

-- set vdiscount=prate*0.08;

-- end if;
-- return vdiscount;
-- end//
-- delimiter ;
-- Exception Handling

-- Handling exceptions
-- There are 2 types of exception handlers_action
-- continue resume the code after handling the exception
-- exit stop the code after handling the exception

-- syntax
-- declare <handler_action> handler for <exception> statements

-- <exception>
-- 1. SQLEXCEPTION
-- 2. mysqlerror code
-- 3. SQLSTATE value
-- 4. NOT FOUND

-- create procedure insdeptrec(did int,dname varchar(20),dloc varchar(20))
-- delimiter //
-- create procedure insdeptrec(did int,pdname varchar(20),pdloc varchar(20))
-- begin
-- declare exit handler for SQLEXCEPTION select "error occured";
-- insert into dept values(did,pdname,pdloc);
-- select did,pdname,pdloc;
-- end//
-- delimiter ;

-- 3. Using user defined exception
-- 1. Declare user defined exception
-- declare category_exists condition for SQLSTATE '45000';
-- 2. Declare handle for the user defined exception
-- declare exit handler for category_exists
-- begin
-- select "Error:duplicate category name" errormsg;
-- end;
-- 3. Based on condition raise the user defined exception, signal statement will raise
-- exception explicitly
-- if exists (select * from category where cname=pcnam) then
-- signal category_exists set MESSAGE_TEXT ="The given category name exists";

-- delimiter //
-- create procedure insertcategory(pcno int,pcnam varchar(20),pcdesc varchar(20))
-- begin
-- declare category_exists condition for SQLSTATE '45000';
-- declare exit handler for category_exists
-- begin
-- select "Error:duplicate category name" errormsg;
-- end;
-- if exists (select * from category where cname=pcnam) then

-- signal category_exists set MESSAGE_TEXT ="The given category name exists";
-- else

-- insert into category values(pcno,pcnam,pcdesc);
-- select "category record inserted";

-- end if;
-- end//
-- delimiter ;

-- to see the definition of the procedure
-- select ROUTINE_DEFINITION
-- -> from information_schema.Routines
-- -> where specific_name='getremark1'
-- -> ;
-- to see the list of procedures in the databse
-- show procedure status where db=’iacsd0925’
-- to see the list of functions in the databse
-- show function status where db=’iacsd0925’