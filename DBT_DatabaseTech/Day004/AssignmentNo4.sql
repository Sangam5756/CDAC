-- Following are the tables:
-- BRANCH (BID INTEGER, BRNAME CHAR (30), BRCITY CHAR (10))

    CREATE TABLE Branch(
        bid INT,
        brname VARCHAR(30),
        brcity VARCHAR(10)
    );


-- CUSTOMER (CNO INTEGER, CNAME CHAR (20), CADDR CHAR (35), CITY
-- CHAR(20))
    CREATE Table Customer(
        cno INT,
        cname VARCHAR(30),
        caddr VARCHAR(35),
        city VARCHAR(20)
    );


-- LOAN_APPLICATION (LNO INTEGER, LAMTREQUIRED MONEY, LAMTAPPROVED
-- MONEY, L_DATE DATE)
CREATE TABLE loan_application(
    lno int,
    lamtrequired DECIMAL(12,2),
    lamtapproved DECIMAL(12,2),
    l_date DATE,cno INT,
    bid INT,
    Foreign Key (cno) REFERENCES Customer(cno),
    Foreign Key (bid) REFERENCES branch(bid)

);

-- The relationship is as follows:
-- BRANCH, CUSTOMER, LOAN_APPLICATION are related with ternary relationship.
-- TERNARY (BID INTEGER, CNO INTEGER, LNO INTEGER).
-- Branches

INSERT INTO Branch (bid, brname, brcity) VALUES
(1, 'Aundh', 'Pune'),
(2, 'Deccan', 'Pune'),
(3, 'M.G.ROAD', 'Pune');

-- Customers
INSERT INTO Customer (cno, cname, caddr, city) VALUES
(101, 'Ravi Kumar', 'Street 1', 'Pune'),
(102, 'Sneha Patil', 'Street 2', 'Pune'),
(103, 'Amit Sharma', 'Street 3', 'Mumbai'),
(104, 'Priya Singh', 'Street 4', 'Pune');

-- Loan Applications
INSERT INTO loan_application (lno, lamtrequired, lamtapproved, l_date, cno, bid) VALUES
(1001, 50000, 40000, '2025-09-10', 101, 1),  -- Aundh, Ravi
(1002, 60000, 60000, '2025-09-15', 102, 2),  -- Deccan, Sneha
(1003, 70000, 50000, '2025-08-20', 103, 3),  -- MG Road, Amit
(1004, 45000, 30000, '2025-09-25', 104, 1),  -- Aundh, Priya
(1005, 55000, 55000, '2025-07-05', 101, 2);  -- Deccan, Ravi




-- Solve the Queries
-- 1. Find the names of the customers for the “Aundh” branch.

select c.cname from Customer c
JOIN loan_application ln on c.cno = ln.cno join Branch bd
on ln.bid = bd.bid
where bd.brname = 'Aundh';


-- 2. List the names of the customers who have received loan less than their requirement.
select c.cname from Customer c
Join loan_application ln on c.cno = ln.cno 
where ln.lamtapproved < ln.lamtrequired;

-- 3. Find the maximum loan amount approved.
select max(lamtapproved) loanapproved from LOAN_APPLICATION;


-- 4. Find out the total loan amount sanctioned by “Deccan “branch.
select sum(lamtapproved) 
from loan_application ln 
join
Branch bd on ln.bid=bd.bid where bd.brname = 'Deccan';


-- 5. Count the number of loan applications received by “M.G.ROAD” branch.

select count(*) as applicationreceived from loan_application ln
join branch b on ln.bid = b.bid where b.brname='M.G.ROAD';




-- 6. List the names of the customer along with the branch names who have applied for
-- loan in the month of September.

select c.cname , br.brname from Customer c 
join loan_application ln on c.cno =ln.cno
JOIN Branch br 
on ln.bid = br.bid
where date_format(ln.l_date,'%M') = 'September';

