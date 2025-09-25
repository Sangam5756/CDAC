 
-- 1. Write a query to display the first day of the month (in datetime format) three months before the current month.   
-- Sample current date : 2014-09-03 
-- Expected result : 2014-06-01 

SELECT date_sub(date_sub(curdate(), interval 3 month), interval day(curdate() - 1 ) day );


-- SELECT date_add(date_sub(date_sub(curdate(), interval 3 month), interval day(curdate()) day ), interval 1 day);



--  2. Write a query to display the last day of the month (in datetime format) three months before the current month. 
SELECT date_sub(date_sub(curdate(), interval 2 month), interval day(curdate() - 1 ) day );



-- 3. Write a query to get the distinct Mondays from hiredate in emp tables.
SELECT empno ,ename  , date_format(hiredate,'%W')  from emp
where  date_format(hiredate,'%W') ='Monday';

-- 4. Write a query to get the first day of the current year.   
        -- SELECT date_sub(curdate(), interval month(curdate()) month );
        SELECT date_sub((date_sub(curdate(), interval month(curdate())-1 month )), interval day(curdate() )-1 day);



--  5. Write a query to get the last day of the current year. 
-- SELECT last_day(date(curdate()))
        SELECT date_sub((date_sub(curdate(), interval month(curdate())-1 month )), interval day(curdate() )-1 day);

--  6. Write a query to calculate your age in year.  
 SELECT timestampdiff(YEAR, '2001-08-30', curdate());


--  7. Write a query to get the current date in the following format.   
-- Sample date : 04-sep-2014 
-- Output : September 4, 2014 
SELECT date_format(date(curdate()), ' %M %d, %Y');

--  8. Write a query to get the current date in Thursday September 2014 format.   
--  Thursday September 2014 
SELECT date_format(date(curdate()), '%W %M %Y');


--  9. Write a query to extract the year from the current date.
SELECT year(date(curdate()));

--  10. Write a query to get the first name and hire date from employees table where hire date between '1987-06-01' and '1987-07-30'   
SELECT ename, hiredate  from emp 
WHERE hiredate between '1980-06-01'and '1987-07-30';

--  11. Write a query to display the current date in the following format.   
-- Sample output: Thursday 4th September 2014 00:00:00 

SELECT date_format(curdate(), '%W %d %M %Y %T ') ;

--  12. Write a query to display the current date in the following format.   
-- Sample output: 05/09/2014 
SELECT date_format(curdate(), ' %d / %m / %y  ') ;


--  13. Write a query to display the current date in the following format.   
-- Sample output: 12:00 AM Sep 5, 2014 
SELECT date_format(curdate(), ' %r %b %d , %Y  ') ;


--  14. Write a query to get the employees who joined in the month of June.

SELECT empno, ename ,date_format(hiredate,'%M') from emp
where date_format(hiredate,'%M') = 'June';



-- 15. Write a query to get the years in which more than 10 employees joined.

    SELECT count(date_format(hiredate,'%Y')) from emp
    where count(date_format(hiredate,'%Y')) > 10;
    
SELECT
    YEAR(hiredate) AS hire_year,
    COUNT(empno) AS number_of_employees
FROM emp
GROUP BY hire_year
HAVING number_of_employees > 10;

-- 16. Write a query to get first name of employees who joined in 1987.  
    SELECT ename hiredate FROM emp WHERE date_format(hiredate,"%Y")= '1987'  ;

    

-- 17. Write a query to get employees whose experience is more than 5 years. 

    SELECT  ename, hiredate ,( date_format(curdate(),'%Y') - date_format(hiredate,'%Y')) as experience  from emp WHERE ( date_format(curdate(),'%Y') - date_format(hiredate,'%Y')) > 5 ;

-- 18. Write a query to get employee ID, last name, and date of first salary of the employees.
    SELECT empno, ename , hiredate, date_add(hiredate,interval 1 month) as first_SalDate from emp   ;
    

-- 19. Write a query to get first name, hire date and experience of the employees.   
-- Sample table: employees 
    SELECT ename , hiredate ,  (date_format (curdate(), '%Y') - date_format(hiredate , '%Y') ) as experience  from emp;

-- 20. Write a query to get the department ID, year, and number of employees joined.   

  
 
