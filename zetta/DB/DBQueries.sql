create sequence emp_seq owned by zemployees.employeeid;

alter table zemployees alter column employeeid set default nextval('emp_seq');

select * from zemployees;

select * from zemployees where emp_card_no='898' and password='qwer';

alter table zemployees add column role character varying(15);

alter table zemployees drop column login_type;

create table admin_register(
admin_id serial PRIMARY KEY,
admin_card_no VARCHAR(10) UNIQUE NOT NULL,
admin_name CHARACTER(30),
dob DATE ,
department VARCHAR(50) ,
designation VARCHAR(50) ,
email VARCHAR(50) UNIQUE ,
mobile NUMERIC(20,0) ,
location VARCHAR(50) ,
role CHARACTER(20) ,
password1 VARCHAR(50) 
);

SELECT * FROM admin_register where admin_card_no='H021';  

UPDATE admin_register SET column name 

create table employee_register(
employee_id serial PRIMARY KEY,
emp_card_no VARCHAR(10) UNIQUE NOT NULL,
name CHARACTER(30),
dob DATE ,
department VARCHAR(50) ,
designation VARCHAR(50) ,
email VARCHAR(50) UNIQUE ,
mobile NUMERIC(20,0) ,
location VARCHAR(50) 
);

select * from admin_register;

Select * from employee_register; 

select * from employee_register where dob >= CURRENT_DATE AND dob < CURRENT_DATE + INTERVAL '1 DAY'
					
select * from org_chart;
  
CREATE TABLE org_chart(
org_id serial PRIMARY KEY,
title CHARACTER(30),
orgfile bytea
);

CREATE TABLE announcement(
announce_id serial PRIMARY KEY,
title CHARACTER VARYING(100),
announcement CHARACTER VARYING(200),
date TIMESTAMP WITH TIME ZONE
);

SELECT * FROM announcement;

Drop table org_chart;

CREATE TABLE policycontainer(
policy_id serial PRIMARY KEY,
title CHARACTER(30),
policy bytea
);

SELECT * FROM policycontainer;

CREATE TABLE file_upload(
id SERIAL PRIMARY KEY,
title VARCHAR(255),
filename VARCHAR(255),
path VARCHAR(255)
);

SELECT * FROM file_upload;

DROP table file_upload;

SELECT * FROM admin_register WHERE admin_card_no='H021' and password1='Ze88@0ne'

CREATE TABLE knowledgebase(
knowledge_id serial PRIMARY KEY,
category CHARACTER VARYING(100),
topic CHARACTER VARYING(200),
subject CHARACTER VARYING,
date TIMESTAMP WITH TIME ZONE
);

Select * from knowledgebase;

select * from employee_register where dob = now() - interval '1 year';

SELECT * FROM employee_register  
WHERE
    DATE_PART('day', dob) = date_part('day', CURRENT_DATE)
AND
    DATE_PART('month', dob) = date_part('month', CURRENT_DATE);
