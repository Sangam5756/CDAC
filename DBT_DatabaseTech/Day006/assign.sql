-- Create a table
-- Location(loc_id, lname,address)
CREATE TABLE location (
    loc_id int primary key not null auto_increment,
    lname varchar(20),
    address varchar(20)
);

-- Server (sid,sname,configuration,lid, adminid)
CREATE TABLE server (
    sid int primary key not null,
    sname varchar(20),
    configuration varchar(28),
    lid int,
    adminid int,
    constraint fk_lid foreign key(lid) references location(loc_id)
    on delete cascade
    on update cascade,
    constraint fk_adminid foreign key(adminid) references admin(adminid)
);



-- Admin(adminid,username,password,mobile,name)
CREATE TABLE admin (
    adminid int primary key not null,
    username varchar(20),
    password varchar(20),
    mobile varchar(10),
    name varchar(10)
);

-- 1. display all server-name, location of the server
SELECT s.sname, l.lname from server s, location l
WHERE l.loc_id = s.sid;
-- 2. display all server-name, admin-name, admin mobile
SELECT s.sname, a.name, a.mobile
from server s 
inner join admin a on a.adminid = s.adminid;

-- 3. display all server which are managed by admin rohit
SELECT * from server
where adminid in (SELECT adminid from admin where name = 'Rohit');

-- 4. display all server and the locations,for which admin is rohit
SELECT s.sname, l.lname from server s
inner join location l
on s.lid = l.loc_id
WHERE s.adminid in (SELECT adminid from admin WHERE name = 'Rohit');

-- 5. display all admins, for whome no server is assigned
SELECT * from admin a
left join server s
on a.adminid = s.adminid
where s.adminid is null;

-- 6. display all servers and admin details, and also display admins for whom no server is assigned
SELECT * from server s
right join admin a
on s.adminid = a.adminid
where s.adminid is null

UNION

SELECT * from admin a
left join server s
on a.adminid = s.adminid
where s.adminid is null;


-- 7. display  servers, admins and location of the server


-- 8. to display all admins for whom no server is assigned also display locations at which no server is placed
SELECT * from admin a
left join server s
on a.adminid = s.adminid
where s.adminid is null;

-- 9. display all servers for which no location is assigned

-- 10. display all servers, for which no location is assigned, whose admin is namrata
