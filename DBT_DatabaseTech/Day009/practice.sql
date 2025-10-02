
-- procedure loop 1
DELIMITER //

CREATE PROCEDURE loop_test()
BEGIN
    DECLARE vcount INT DEFAULT 0;
    label1: LOOP
        SELECT vcount;
        SET vcount = vcount + 1;
        IF (vcount > 6) THEN 
            LEAVE label1;
        END IF;
    END LOOP;
END;
//

DELIMITER ;

-- procedure loop 3

DELIMITER //

CREATE PROCEDURE print_hello()
BEGIN 
    SELECT 'Hello World';

END;
//
DELIMITER ;

--  Using Variables
DELIMITER //
CREATE PROCEDURE usevariable()
BEGIN
    DECLARE vnumber int DEFAULT 10;
    DECLARE vname varchar(30) DEFAULT 'Sangam Mundhe ';

    SELECT vnumber as number , vname name ;
END
//
DELIMITER ;

-- if else in the sql

DELIMITER //
CREATE PROCEDURE check_number(in n int)
BEGIN
    if( n > 0) THEN SELECT 'Positive Number ';
    ELSEIF n < 0 THEN SELECT 'negative number';
    ELSE SELECT 'zero';
    END IF;
END;
//
DELIMITER ;

-- for loop

DELIMITER //
CREATE PROCEDURE use_loop1(in n int)

BEGIN
    DECLARE vcount int DEFAULT 1;
    DECLARE counts varchar(20) DEFAULT '';
    label1:loop
        set counts = CONCAT(counts,vcount,' ');
    
        set vcount = vcount +1;
        if( vcount > n) THEN LEAVE label1;
        END IF;
    END LOOP label1;

    SELECT  counts;

END;
//
DELIMITER ;

-- print even number till n using loop
DELIMITER //
create procedure even(in n int)

BEGIN
        DECLARE veven int ;
        DECLARE vcount int DEFAULT 1;
        label1:loop
            if(vcount > n) then LEAVE label1 ;
            END IF;
        SET veven = MOD(vcount,2);    
            if( veven = 0) THEN
                SELECT 'Prime Number is ',vcount;
            end if;

        SET vcount = vcount+1;
        END LOOP label1;

END;
//
DELIMITER ;

-- 

-- print odd number

DELIMITER //

create procedure printodd(in n  int)
BEGIN
    DECLARE vcount int DEFAULT 0;
    DECLARE oddnum int ;

    label1:loop
        IF vcount > n then
            LEAVE label1;
        end if;
        SET oddnum = MOD(vcount,2);
        if oddnum !=0 then
            SELECT vcount ;
        end if;
        set vcount = vcount+1;
    end loop label1;

END;
//
DELIMITER ;

-- using concat
DELIMITER //

create procedure printoddstr(in n  int)
BEGIN
    DECLARE vcount int DEFAULT 0;
    DECLARE oddnum int ;
    DECLARE oddnumstr varchar(100) DEFAULT '';
    label1:loop
        IF vcount > n then
            LEAVE label1;
        end if;
        SET oddnum = MOD(vcount,2);
        if oddnum !=0 then
        SET oddnumstr = CONCAT(oddnumstr,vcount,'');
            -- SELECT vcount ;
        end if;
        set vcount = vcount+1;
    end loop label1;
    SELECT oddnumstr;

END;
//
DELIMITER ;

-- print the star pattern using loop

-- *
-- **
-- ***
---****
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

-- muliplication practice the nested loop

DELIMITER //

CREATE PROCEDURE printtables(in n int )
BEGIN
    DECLARE vi int DEFAULT 1;
    DECLARE vj int DEFAULT 1;
    

    innerloop:loop
        if(vj > n) then
        LEAVE innerloop;
        end if;
        -- here multiplication should happen
        SELECT (n*vj);
        SET vj = vj+1;

    END LOOP innerloop;
END;
//
DELIMITER ;

-- 


-- substr(name,1,3) substr(right(ename,3)),"@mycompany.com";

