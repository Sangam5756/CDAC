-- print all employees using the cursor

delimiter ;


    delimiter //
    create procedure listEmployees()
    begin

        declare done int default 0;
        declare ename varchar(30);
        declare cur cursor for select emp_name from employee;
        declare continue handler for not found set done =1;

        open cur;
        for_loop:loop
            fetch cur into ename;
            if done then leave for_loop;
            end if;
            select ename as employeename;
        end loop;
        close cur;
    end;
    //
    delimiter ;



    -- like to create the cursor to update the salary of employee by 20% if they exp of > 2year

    delimiter //
    create procedure updatesalary1(in increment double)
    begin
            declare empsal double(9,2);
            declare empid int;
            declare done int default 0;
            declare empcur cursor for select empno,salary from employee;
            declare continue handler for not found set done  = 1;

            open empcur;
            forloop:loop
            fetch empcur into empid,empsal;
            if done then leave forloop;
            end if;
            select empid,empsal ;
            update employee 
            set salary = (empsal*increment)
            where empno=empid;        
            end loop;
            close empcur;
        
    end;//
    delimiter ;

    

    delimiter //
    create procedure updateexpsalary(in increment double(9,2))
    begin
        declare vempsal  double(9,2);
        declare vempno int;
        declare vhiredate date;
        declare done int default 0;
        declare empcur cursor for select empno,salary,hiredate from employee;
        declare cont

        forloop:loinue handler for not found set done =1;
        open empcur;op
        fetch empcur into vempno,vempsal,vhiredate;
        if done then leave forloop;
        end if;

        if TIMESTAMPDIFF(year,curdate(),vhiredate) > 2
        then update employee
        set salary = empsal*increment
        where empno=vempno; 
        end if;
        end loop;
        close empcur;

    end;//
    delimiter ;



    -- cursor want to creat the process

delimiter //
create procedure updatebonus()
begin
    declare vsal double (9,2);
    declare vempno int;
    declare done int default 0;
    declare empcur cursor for select empno,salary from employee;
    declare continue  handler for not found set done = 1;
    open empcur;
    
    forloop:loop
        fetch empcur into vempno,vsal;
        if done then leave forloop;
        end if;

        if vsal > 2000 then
        update employee 
        set bonus = 20
        where empno = vempno;
        end if;
        
     end loop;   
     close empcur;


end;//
delimiter ;


-- updatr the when exper 3 

delimiter //
create procedure updatebonusexp()
begin
    declare vempsal double(9,2);
    declare vempno int;
    declare vhiredate date;
    declare done int default 0;
    declare empcur cursor for select empno,salary,hire_date from employee;
    declare continue handler for not found set done =1;

    open empcur;
    forloop:loop
    fetch empcur into vempno,vempsal,vhiredate;
    if done then leave forloop;
    end if;

    if TIMESTAMPDIFF(year,vhiredate, curdate()) > 2
    then update employee
    set bonus = 30
    where empno =vempno;
    end if;
    end loop;
    close empcur;



end;//
delimiter ;