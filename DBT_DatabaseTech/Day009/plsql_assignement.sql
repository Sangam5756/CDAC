1. Print the following patterns using loop : 


-- a.
/* 
    * 
    ** 
    *** 
    ****
*/
DELIMITER //
create procedure printstar(in n int)
BEGIN   
    DECLARE vcount int DEFAULT 1;
    DECLARE vstar  varchar(5) DEFAULT '*';
    DECLARE pattern varchar(100) DEFAULT '';
    -- one loop count values = star
    label1:loop
        if(vcount > n)
        then LEAVE label1;
        end if;
        SET pattern = CONCAT(pattern,repeat(vstar,vcount),'\n');

        set vcount = vcount+1;
    END loop label1;
    SELECT pattern;
end;
//
DELIMITER ;




-- b. 
--      *                    
--     ***                
--    ***** 
--     ***  
--      *   

DELIMITER //

CREATE PROCEDURE printpatternb(in n int)
BEGIN
    -- print the star
    DECLARE star varchar(1) DEFAULT '*';
    DECLARE i int DEFAULT 0;
    DECLARE j int DEFAULT 0;
    DECLARE result varchar(255);

    set i =1;
    top_loop:loop
        if i > n then
            LEAVE top_loop;
        end if;

        SET result = '';

        -- space
        set j = 1;
        space_loop : loop

            if( j > n -i) then
            LEAVE space_loop;
            end if;
            set result = CONCAT(result,' ');
            set j=j+1;

        end loop space_loop;

        -- start
        set j =1;
        star_loop : loop
        if( j > 2*i - 1) then

        LEAVE star_loop;
        end if;
        set result = concat(result,star);
        set j = j+1;

        end loop star_loop;

        select result as pattern;
        set i = i+1;
    end loop top_loop;

    set  i = n-1;
    bt_loop:loop
    if( i < 1) then LEAVE bt_loop;
    end if;

        set result = '';

        -- space
        set j =1;
        space_loop2:loop
        if j > (n - i) then
        LEAVE space_loop2;
        end if;

        set result = concat (result,' ');
        set j = j+1;

end loop space_loop2; 



         set j =1;
        star_loop2 : loop
        if( j > 2*i - 1) then

        LEAVE star_loop2;
        end if;
        set result = concat(result,star);
        set j = j+1;

        end loop star_loop2;
        
SELECT result AS pattern;
        SET i = i - 1;

    end loop bt_loop;

    -- space is equal to the n - i - 1
    -- star is i =1 then +2 
    -- then reverse of above

    --  first space
    -- then star
    


END;
//
DELIMITER ;





-- c.      even =0 odd =1    1 2 3 4 5 6 7
-- 1010101           n = 7   1 0 1 0 1 0 1    
--  10101            n = 7-2= 5
--   101            n = 5-2 = 3
--    1             n = 5-2 = 1
DELIMITER //

CREATE PROCEDURE printpatternc(IN n INT)
BEGIN
    DECLARE i INT;
    DECLARE j INT;
    DECLARE k INT;
    DECLARE result VARCHAR(255);

    SET i = n;

    outer_loop: LOOP
        IF i < 1 THEN 
            LEAVE outer_loop;
        END IF;

        SET result = '';

        -- add spaces
        SET j = 1;
        spaceloop: LOOP
            IF j > (n - i)/2 THEN
                LEAVE spaceloop;
            END IF;
            SET result = CONCAT(result, ' ');
            SET j = j + 1;
        END LOOP spaceloop;

        -- add alternating 1/0
        SET k = 1;
        number_loop: LOOP
            IF k > i THEN 
                LEAVE number_loop;
            END IF;
            IF MOD(k,2) = 1 THEN
                SET result = CONCAT(result,'1');
            ELSE
                SET result = CONCAT(result,'0');
            END IF;
            SET k = k + 1;
        END LOOP number_loop;

        SELECT result AS pattern;

        SET i = i - 2; -- shrink row length
    END LOOP outer_loop;

END;
//
DELIMITER ;





-- d.  
-- 1  
-- 1 2  
-- 1 2 3  
-- 1 2 3 4  
-- 1 2 3 4 5 


DELIMITER //
create procedure printpatternd(in n int)
BEGIN 
    DECLARE vcount int DEFAULT 1;
    DECLARE i int DEFAULT 1;
    DECLARE j int;
    DECLARE result text DEFAULT '';
    
    outerloop:loop
    if( i > n) THEN
    LEAVE outerloop;
    end if;

    SET result = '';     
    set vcount =1;

    innerloop:loop
    if(vcount > i) then
    LEAVE innerloop;
    end if;
    set result = concat(result,vcount,' ');

    set vcount = vcount+1;
    end loop innerloop;

    select result as pattern;
    set i = i +1;

    end loop outerloop;


end; //
DELIMITER ;

-- 


-- 2. write a procedure to insert record into employee table. 
-- the procedure should accept empno, ename, sal, job, hiredate as input parameter 
-- write insert statement inside procedure insert_rec to add one record into table 
 
DELIMITER //

create procedure insert_rec(peno int,pnm varchar(20),psal decimal(9,2),pjob 
varchar(20),phiredate date) 
begin 
     insert into emp(empno,ename,sal,job,hiredate) 
values(peno,pnm,psal,pjob,phiredate) 
end// 

DELIMITER ; 



-- 3. write a procedure to delete record from employee table. 
-- the procedure should accept empno as input parameter. 
-- write delete  statement inside procedure delete_emp to delete one record from emp 
-- table 
DELIMITER //
CREATE PROCEDURE deleteRecord(vempno varchar(20))
BEGIN

    DELETE from EMP where empno = vempno;

END;
//
DELIMITER ;


-- 4. write a procedure to display empno,ename,deptno,dname for all employees with sal 
-- > given salary. pass salary as a parameter to procedure 
DELIMITER //
CREATE PROCEDURE dispEmp(vsal double(9,2))
begin
    select * from EMP
    where sak > vsal;

end;
//
DELIMITER ;




-- 5. write a procedure to find min,max,avg of salary and number of employees in the 
-- given deptno. 
-- deptno --→ in parameter  
-- min,max,avg and count ---→ out type parameter 
-- execute procedure and then display values min,max,avg and count 

DELIMITER //
CREATE PROCEDURE dispAggregation( IN vdeptno INT,OUT vmin DECIMAL(10,2),OUT vmax DECIMAL(10,2),OUT vavg DECIMAL(10,2),OUT vcount INT)
begin
        select MAX(sal), MIN(sal),AVG(sal) into vmax,vmin,vavg,vcount from EMP
        where deptno = vdeptno;

end; //
DELIMITER ;

-- 6. write a procedure to display all pid,pname,cid,cname and salesman name(use 
-- product,category and salesman table) 

DELIMITER //
CREATE PROCEDURE displayAllProduct()
BEGIN
        select p.pid,p.pname,c.catid,c.cname,s.sname from product p join category c on p.cid=c.catid join salesman s
        on p.sid=s.sid;    
END;
// DELIMITER ;





-- 7. write a procedure to display all vehicles bought by a customer. pass customer name 
-- as a parameter.(use vehicle,salesman,custome and relation table) 

mysql> select * from cust_vehicle;
+--------+------+------+-----------+
| custid | vid  | sid  | buy_price |
+--------+------+------+-----------+
|      1 |    1 |   10 |  75000.00 |
|      1 |    2 |   10 | 790000.00 |
|      2 |    3 |   11 |  80000.00 |
|      3 |    3 |   11 |  75000.00 |
|      3 |    2 |   10 | 800000.00 |
+--------+------+------+-----------+

DELIMITER //
create procedure displayAllsaledVehicle(in vname varchar(20))
begin
        select * from cust_vehicle cv  join vehicle v on cv.vid=v.vid join salesman s on cv.sid=s.sid;
end;
//
DELIMITER ;


-- 8. Write a procedure that displays the following information of all emp 
-- Empno,Name,job,Salary,Status,deptno 
-- Note: - Status will be (Greater, Lesser or Equal) respective to average salary of their own 
-- department. Display an error message Emp  table is empty if there is no matching 
-- record. 

DELIMITER //
create procedure displayEmpInfo()
BEGIN
        -- first take what we need
        select e.empno,e.ename,e.job,e.sal,d.deptno,
        CASE
        WHEN e.sal > avg_sal then "GREATER"
        WHEN e.sal < avg_sal then "LESSER"
        ELSE 'EQUAL'
        END as STATUS from emp e join (select deptno,avg(sal) as avg_sal from emp GROUP BY deptno)as d on e.deptno=d.deptno;
        
END ;
//
DELIMITER ;



-- 9. Write  a procedure to update salary in emp table based on following rules. 
-- Exp< =35 then no Update 
-- Exp> 35 and <=38 then 20% of salary 
-- Exp> 38 then 25% of salary 
 
 DELIMITER //
 create procedure updateSalary()
begin
        update  emp
        SET sal = CASE
        
        when TIMESTAMPDIFF(YEAR,hiredate,curdate()) BETWEEN 35 and 38 then sal * 1.20
        when TIMESTAMPDIFF(YEAR,hiredate,curdate()) > 38 then sal * 1.25
        END
        where TIMESTAMPDIFF(YEAR,hiredate,curdate()) > 35;
        
end; //
DELIMITER ;




-- 10. Write a procedure and a function. 
-- Function: write a function to calculate number of years of experience of employee.(note: 
-- pass hiredate as a parameter) 
 
-- Procedure: Capture the value returned by the above function to calculate the additional 
-- allowance for the emp based on the experience. 
-- Additional Allowance = Year of experience x 3000 
-- Calculate the additional allowance  
 
-- and store Empno, ename,Date of Joining, and Experience in 
-- years and additional allowance in Emp_Allowance table. 
-- create table emp_allowance( 
-- empno int, 
-- ename varchar(20), 
-- hiredate date, 
-- experience int, 
-- allowance decimal(9,2)); 
 



-- 11. Write a function to compute the following. Function should take sal and hiredate 
-- as i/p  and return the cost to company. 
-- DA = 15% Salary, HRA= 20% of Salary, TA= 8% of Salary. 
-- Special Allowance will be decided based on the service in the company. 
-- < 1 Year Nil 
-- >=1 Year< 2 Year 10% of Salary 
-- >=2 Year< 4 Year 20% of Salary 
-- >4 Year 30% of Salary 
 



-- 12.  Write query to display empno,ename,sal,cost to company for all employees(note: 
-- use function written in question 10) 
 
 


-- Q2. Write trigger 
-- 1. Write a tigger to store the old salary details in Emp _Back (Emp _Back has the 
-- same structure as emp table without any 
-- constraint) table.  
-- (note :create emp_back table before writing trigger) 
-- ----- to create emp_back table 
 
-- create table emp_back( 
--  empno int, 
-- ename varchar(20), 
-- oldsal decimal(9,2), 
-- newsal decimal(9,2) 
-- ) 
-- (note : 
-- execute procedure written in Q8 and  
-- check the entries in EMP_back table after execution of the procedure) 
 
 
-- 2. Write a trigger which add entry in audit table when user tries to insert or delete 
-- records in employee table  store empno,name,username and date on which 
-- operation performed and which action is done insert or delete. in emp_audit table. 
-- create table before writing trigger. 
-- create table empaudit( 
--     empno int; 
--     ename  varchar(20), 
--     username varchar(20); 
--     chdate date; 
--     action varchar(20) 
-- ); 
-- 3. Create table vehicle_history. Write a trigger to store old vehicleprice and new vehicle 
-- price in history table before you update price in vehicle table 
-- (note: use vehicle table). 
-- create table vehicle_history( 
-- vno int, 
-- vname varchar(20), 
-- oldprice decimal(9,2), 
-- newprice decimal(9,2), 
-- chdate date, 
-- username varchar(20) 
-- ); 
 
 
 
 