CREATE TABLE Employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50) NOT NULL,
    deptno int,
    salary DECIMAL(10,2),
    hire_date DATE

    constraint fk_depno foreign key(deptno) references  Department(dept_id);
);


CREATE TABLE Department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(30),
    location VARCHAR(50)
);


-- create the function to  get employee salary by id

delimiter //
create function getsalary(pempno int)
returns double(9,2)
DETERMINISTIC
begin

    declare empsal double(9,2);
    select salary into empsal from employee where empno = pempno;

return empsal;
end;//
delimiter ;


-- create the function to get the experience of employee

delimiter //
create function getEmpExp(pempno int)
returns int
deterministic
begin

    declare exp int;

    select TIMESTAMPDIFF(year,curdate(),hire_date)as empexp into exp from employee where empno =pempno limit 1;
    
    return abs(exp);

    
end;//
delimiter ;

select emp_name,  getEmpExp(empno) as exp from employee;



-- Check Bonus Eligibility

-- Return 'YES' if salary > 30,000, otherwise 'NO'.
delimiter //
create function checkisBonuseligible(pempno int)
returns varchar(10)
DETERMINISTIC
begin
        declare result varchar(10);
        declare esal  double(9,2);

        select salary into esal from employee where
        empno = pempno;

        if esal > 30000
        then set result = 'YES';
        else 
        set result = 'NO';
        end if;

        return result;

end;//
delimiter ;


-- get the department name by employee no

delimiter //
create function getDepartmentName(pempno int)
returns varchar(20)
deterministic
begin

        declare dname varchar(20);
        -- select d.dept_name into dname from employee e,department d
        -- where e.empno = pempno;
        select d.dept_name into dname from employee e join department d
        on e.deptno=d.dept_id where e.empno =pempno;

        return dname;
        

end;
//
delimiter ;