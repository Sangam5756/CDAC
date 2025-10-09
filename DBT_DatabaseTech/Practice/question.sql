
-- **Q.1]** Consider the following schema for `Rno_name_Feb25` Database. Here Rno is your rollno and your name should be used to create the database. Consider required constraints for given tables while creating it.

create database 258072_sangam_mundhe_Feb25;
-- **Tables:**
-- * `Author(AuthorId (PK), AuthorName, BirthDate, Nationality)`

CREATE TABLE   Author(
    authorId int PRIMARY KEY,
    authorname varchar(20),
    birthDate date,
    nationality varchar(30)
);

-- * `BOOK(BookID (pk), title, genere, price, publicationDate, AuthorID (fk))`
  CREATE TABLE Book (
        bookid int primary key,
        title varchar(30),
        genere varchar(30),
        price double(9,2),
        publicationDate date,
        authorId int,
        constraint fk_authorId foreign key(authorId) references Author(authorId)
    );


-- **Write SQL queries to generate the following reports:**


-- 1.  Find the Authors all details who were Born Before 1980.
select * from Author where Year(birthdate) < 1980;
-- 2.  Display the Details of the Most Expensive Book.
select * from book where price  = select max(price) from Book;
-- 3.  Display Books and Author Details for Books Whose Price is Less Than 750.
select * from Book b join  Author a on b.authorid=a.authorid where b.price < 750;
-- 4.  Display author-wise total price that is greater than 800.
select * from author join book
-- 5.  Display All Books Whose Author is Not "Alice".
select * from book b left join author a on b.authorid=a.authorid where a.authorname not in('Alice');

-- 6.  Find the Most Recent Book Published.
select * from book where publicationDate = (select MAX(publiccationDate) from book);
-- 7.  Find Books With the Same Price.
select * from book  where price in ( select price from book group by price having count(*)>1) order by price;




-- **Q.2]**
-- **a)** Write a function to calculate simple interest. The function will accept the principal amount, no of years, and rate of interest. Calculate the proper simple interest and return simple interest. Give the function the name `rollno_simple_interest` and use that function to display the proper simple interest.

DELIMITER //
create function 258072_simpleInterest( amount int, years int, roi double(9,2))
returns DECIMAL(10,2)
DETERMINISTIC
begin 
declare cal DECIMAL(10,2);

    set cal = (amount*years*roi)/100;

    return cal;
        
end; //
DELIMITER ;





-- **b)** Create a trigger that logs any changes to the Price of a book in a separate `PriceChangeLog` table, which stores the `BookID`, `old_price`, `new_price`, `current_user_name`, and the `change_timestamp`.