
-- allowes to 
-- set global log_bin_trust_function_creators=1;
-- to print n numbers

DELIMITER //
create procedure whileprintn(in n int)
BEGIN   
    DECLARE i int DEFAULT 1;
    while i < n do
        SELECT i;
        set i = i+1;
    end while;


END
//
DELIMITER ;

-- repeat loop

DELIMITER //
create procedure repeatloop(in n int)

BEGIN
        DECLARE i int DEFAULT 0;

        repeat_loop: REPEAT
            SELECT i;
            set i = i+1;
        until i > n
        end repeat;
end;
//
DELIMITER ;


--  to print the even number

DELIMITER //

create procedure repeateven (in n int)
BEGIN
        DECLARE i int DEFAULT 1;

        repeat_loop:repeat
        set i = i +1;
        if MOD(i,2) = 0 then select "even number" ,i; 
        else select 'odd number ' ,i;
        end if;
        until i > n
        end repeat;
END;
//
DELIMITER ;