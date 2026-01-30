select e.emp_name,d.dept_name from employee  e 
left join department d on e.dept_id=d.dept_id where d.dept_id is NULL;





Find employees who are not assigned to any valid department
(including NULL dept_id and non-existing dept_id).

select e.emp_name,d.dept_name from employee e 
right join department d  on e.dept_id=d.dept_id where  d.dept_id is null;


Find departments that currently have no employees.
sql> select d.dept_name from department d  left join employee e on d.dept_id=e.dept_id where e.emp_id is null;
+-----------+
| dept_name |
+-----------+
| Finance   |
| Admin     |
+-----------+


5.Display employee name and department name, but exclude employees without a department.

mysql> select e.emp_name,d.dept_name  from employee e join department d on e.dept_id=d.dept_id;


6.Using LEFT JOIN, write a query that behaves exactly like an INNER JOIN.

select e.emp_name , d.dept_name from employee e join department d  e.dept_id=d.dept_id;


7Rewrite this query without using RIGHT JOIN:

SELECT e.emp_name, d.dept_name
FROM employee e
RIGHT JOIN department d
ON e.dept_id = d.dept_id;


SELECT e.emp_name, d.dept_name
FROM employee e
left JOIN department d
ON e.dept_id = d.dept_id where d.dept_id is not null;



Count the number of employees per department, including departments with zero employees.

select count(*) as empcount from employee GROUP BY dept_id; 


Which employees will disappear if this query is executed?

SELECT e.emp_name, d.dept_name
FROM employee e
LEFT JOIN department d
ON e.dept_id = d.dept_id
WHERE d.dept_name = 'IT';

ans all employees except the it   




select d.dept_name ,count(e.emp_id) as emp_count from department d 
left join  employee e on d.dept_id=e.dept_id GROUP BY d.dept_name;

-- add this as groupby when name is duplicated
d.dept_id, d.dept_name


--  having claus

-- Show only departments that have at least one employee.
select d.dept_name , count(e.emp_id) as count from employee e 
join department d on e.dept_id=d.dept_id GROUP BY d.dept_name  having count(*) =1;


Show departments that have MORE THAN 1 employee.
select d.dept_name , count(e.emp_id) from employee e join department d on e.dept_id=d.dept_id group by d.dept_name having count(*)>1;


-- Find departments that have ZERO employees
select d.dept_name , count(e.emp_id) from department d left join employee e on d.dept_id=e.dept_id  group by d.dept_name having count(*)=-1;


-- List employees along with department name.
select e.emp_name, ISNULL(d.dept_name,'not assigned') deptname from employee e
left join department d on e.dept_id=d.dept_id;



deptcont exclude the emplo dept is null
mysql> select d.dept_name, count(e.emp_id) from department d left join employee e on d.dept_id=e.dept_id group by d.dept_name;