CREATE SEQUENCE IF NOT EXISTS hiem_sequence START WITH 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS USER_TABLE
	(id integer, 
	birth_date date not null, 
	country_of_residence varchar(50) not null, 
	gender varchar(6), 
	user_name varchar(50) not null, 
	phone_number varchar(13), 
	primary key (id));