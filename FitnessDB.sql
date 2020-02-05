CREATE database IF NOT exists FitnessDB;

use FitnessDB;

DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS instructors;
DROP TABLE IF EXISTS classes;


CREATE TABLE instructors (
	instructor_ID int(6) auto_increment NOT NULL,
	instructor_FN varchar(15) NOT NULL,
	instructor_LN varchar(20) NOT NULL,
	class_taught varchar(255) NOT NULL,
	pay_rate double(6, 2),
	PRIMARY KEY (instructor_ID)
	
);

CREATE TABLE classes (
	class_ID int(4) auto_increment NOT NULL,
	class_type varchar(15) NOT NULL,
	date_and_time varchar(25) NOT NULL, 
	instructor_ID int(6),
	FOREIGN KEY (instructor_ID) REFERENCES instructors (instructor_ID),
	PRIMARY KEY (class_ID)

);

CREATE TABLE clients (
	client_ID int(7) NOT NULL auto_increment,
	client_FN varchar(15) NOT NULL,
	client_LN varchar(20) NOT NULL,
	birthdate date NOT NULL,
	class_id int(4),
	FOREIGN KEY (class_id) REFERENCES classes (class_id),
	PRIMARY KEY (client_id)

);



	
