Create a table Location(loc_id, lname,address)

create table location(
    loc_id int PRIMARY KEY auto_increment,
    lname varchar(20),
    address varchar(30)

);
-- Admin(adminid,username,password,mobile,name)
create table Admin(
    adminid int PRIMARY KEY auto_increment;
    username varchar(30),
    password varchar (30),
    mobile int(10),
    name varchar (10)
);
-- Server (sid,sname,configuration,lid, adminid)
create table Server(
    sid int primary key auto_increment,
    sname varchar (20) NOT NULL
    ,configuration varchar(10),
    lid int,
    adminid int,
    constraint fk_lid foreign key(lid) REFERENCES location(loc_id),
    constraint fk_adminid foreign key(adminid) references admin(adminid)
);

-- Insert Locations
INSERT INTO Location (lname, address) VALUES
('LocA', '123 Main St'),
('LocB', '456 Elm St'),
('LocC', '789 Oak St');

-- Insert Admins
INSERT INTO Admin (adminId,username, password, mobile, name) VALUES
(1,'rohit01', 'pass123', '9876543210', 'rohit'),
(2,'namrata01', 'pass456', '9123456789', 'namrata'),
(3,'raj01', 'pass789', '9988776655', 'raj'),
(4,'alice01', 'pass000', '9000000000', 'alice');

-- Insert Servers
INSERT INTO Server (sid,sname, configuration, lid, adminid) VALUES
(101,'Server1', 'config1', 1, 1),  -- rohit, LocA
(102,'Server2', 'config2', 2, 2),  -- namrata, LocB
(103,'Server3', 'config3', NULL, 1), -- rohit, no location
(104,'Server4', 'config4', 3, NULL), -- no admin, LocC
(105,'Server5', 'config5', NULL, NULL); -- no admin, no location


-- 1. display all server-name, location of the server
    select s.sname , l.address from Server s
    ,location l where l.loc_id = s.lid;
    


-- 2. display all server-name, admin-name, admin mobile

select s.sname, a.name , a.mobile from server s ,location l, admin a;




-- 3. display all server which are managed by admin rohit

select * from server s 
where s.adminid = (select adminId from admin where name = 'Rohit');

-- 4. display all server and the locations, for which admin is rohit
select * from server s inner join location l on s.lid = l.loc_id where s.adminid = (select adminid from admin where name = 'Rohit');
-- OR
select * from server s , location l
where s.lid = l.loc_id and s.adminid in (select adminId from admin where name ='Rohit');

-- 5. display all admins, for whome no server is assigned
    select * from admin a left join server s on 
    a.adminid = s.adminid where s.sid is null;

-- or
select * from admin 
where not EXISTS (select adminid from server where admin.adminId = server.adminId);




-- 6. display all servers and admin details, and also display admins for whom no server is assigned
select * from server s inner join admin a 
on
s.adminid = a.adminid;



-- 7. display  servers, admins and location of the server
select * from server s 
join admin a
on
s.adminId=a.adminid 
join location l on s.lid=l.loc_id;



-- 8. to display all admins for whom no server is assigned also display locations at which no server is placed
select * from admin a LEFT JOIN 
server s on a.adminId =s.adminid 
where s.sid is null;
UNION 
SELECT l.*
FROM location l
LEFT JOIN server s ON l.loc_id = s.lid
WHERE s.sid IS NULL;

-- 9. display all servers for which no location is assigned

select * from server s left join location ln on s.lid = ln.loc_id 
where ln.loc_id is null; 



-- 10. display all servers, for which no location is assigned,
-- whose admin is namrata

select * from server s left join
location ln on s.lid =ln.loc_id where ln.loc_id is null and s.adminId = (select a.adminid from admin a where a.name='Namrata');


