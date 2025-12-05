-- 2.1. Display all the information of the EMP table?

select * from emp;


-- 2.2. Display unique Jobs from EMP table?

select distinct job from emp;

-- 2.3. List the emps in the asc order of their Salaries?

select * from emp order by salary;


-- 2.4. List the details of the emps in asc order of the Dptnos and desc of
-- Jobs?

select * from emp order by deptno, desc jobs;



-- 2.5. Display all the unique job groups in the descending order?

select distinct from emp  group by jobs order by desc;


-- 2.6. Display all the details of all ‘Mgrs’
    select * from emp where mgrs is not null;


-- 2.7. List the emps who joined before 1981.

select * from emp YEAR(hiredate) < '1981'


-- 2.8. List the Empno, Ename, Sal, Daily sal of all emps in the asc order of
-- Annsal.

select Empno,ename,sal,Daily sal from emp order by annsal;


-- 2.9. Display the Empno, Ename, job, Hiredate, Exp of all Mgrs
select empno,ename,job, hiredate date_diff(exp - curr_date()) from emp;


-- 2.10. List the Empno, Ename, Sal, Exp of all emps working for Mgr 7369.
select empno, ename ,sal, timeStampDiff(sal,curr_date) from emp where mgr =7369


-- 2.11. Display all the details of the emps whose Comm. Is more than their Sal.
select * from emp where commistion > sal;



-- 2.12. List the emps in the asc order of Designations of those joined after the
-- second half of 1981.

-- 2.13. List the emps along with their Exp and Daily Sal is more than Rs.100.

-- 2.14. List the emps who are either ‘CLERK’ or ‘ANALYST’ in the Desc
-- order.

-- 2.15. List the emps who joined on 1-MAY-81,3-DEC-81,17-DEC-81,19-JAN80 in asc order of seniority.

-- 2.16. List the emp who are working for the Deptno 10 or20.

-- 2.17. List the emps who are joined in the year 81.

-- 2.18. List the emps who are joined in the month of Aug 1980.

-- 2.19. List the emps Who Annual sal ranging from 22000 and 45000.

-- 2.20. List the Enames those are having five characters in their Names.

-- 2.21. List the Enames those are starting with ‘S’ and with five characters.

-- 2.22. List the emps those are having four chars and third character must be ‘r’.

-- 2.23. List the Five character names starting with ‘S’ and ending with ‘H’.

-- 2.24. List the emps who joined in January.

-- 2.25. List the emps who joined in the month of which second character is ‘a’.

-- 2.26. List the emps whose Sal is four digit number ending with Zero.

-- 2.27. List the emps whose names having a character set ‘ll’ together.

-- 2.28. List the emps those who joined in 80’s.

-- -- 2.29. List the emps who does not belong to Deptno 20.

-- -- 2.30. List all the emps except ‘PRESIDENT’ & ‘MGR” in asc order of Salaries.
-- -- 2.31. List all the emps who joined before or after 1981.