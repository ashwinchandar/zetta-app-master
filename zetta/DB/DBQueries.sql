
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

CREATE TABLE announcement(
announce_id serial PRIMARY KEY,
title CHARACTER VARYING(100),
announcement CHARACTER VARYING(200),
date TIMESTAMP WITH TIME ZONE
);

CREATE TABLE knowledgebase(
knowledge_id serial PRIMARY KEY,
name CHARACTER VARYING(30),
category CHARACTER VARYING(100),
topic CHARACTER VARYING(200),
subject CHARACTER VARYING,
created_date TIMESTAMP WITH TIME ZONE,
created_by CHARACTER VARYING(30),
updated_date TIMESTAMP WITH TIME ZONE,
updated_by CHARACTER VARYING(30)
);

create table fileupload(
file_id serial primary key,
filename character varying(50),
filepath character varying,
created_date TIMESTAMP WITH TIME ZONE,
created_by CHARACTER VARYING(30),
updated_date TIMESTAMP WITH TIME ZONE,
updated_by CHARACTER VARYING(30)
);

CREATE TABLE public.role
(
  role_id integer NOT NULL DEFAULT nextval('role_role_id_seq'::regclass),
  role character varying(30),
  access character varying(50),
  CONSTRAINT role_pkey PRIMARY KEY (role_id)
);

create table orgupload(
org_id serial primary key,
orgfilename character varying(50),
orgfilepath character varying,
created_date TIMESTAMP WITH TIME ZONE,
created_by CHARACTER VARYING(30),
updated_date TIMESTAMP WITH TIME ZONE,
updated_by CHARACTER VARYING(30)
);

create table knowledge_reply(
topic_id INTEGER,
topic CHARACTER VARYING(200),
reply CHARACTER VARYING,
created_date TIMESTAMP WITH TIME ZONE,
created_by CHARACTER VARYING(30),
updated_date TIMESTAMP WITH TIME ZONE,
updated_by CHARACTER VARYING(30)
);