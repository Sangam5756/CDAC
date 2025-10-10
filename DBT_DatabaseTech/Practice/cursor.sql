-- print all employees using the cursor

delimiter //
create procedure listemployee()
begin
    declare done int default 0;
    declare name varchar(50);
    declare cur cursor for
    select emp_name from employee;
    declare continue handler for not found set done =1;

    open cur;

    read_loop:loop
        fetch cur into name;
        if done then
            leave read_loop;
        end if;

        select name as employee_name;
    end loop;
    close cur;


end; //
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