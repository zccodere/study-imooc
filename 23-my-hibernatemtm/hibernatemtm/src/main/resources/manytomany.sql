create table project
(
	proid int primary key,
	proname varchar(20) not null
);

create table employee
(
	empid int primary key,
	empname varchar(20)
);

create table proemp
(
	rproid int,
	rempid int
);

alter table proemp add constraint fk_rproid 
	foreign key (rproid) references project(proid);
alter table proemp add constraint fk_rempid
	foreign key (rempid) references employee(empid);	
	
 