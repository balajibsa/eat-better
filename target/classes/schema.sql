drop table productCategory;
drop table productTimes;
drop table product;
drop table times;
drop table currency;
drop table category;
drop table message;
drop table image;
drop table reservation;

CREATE TABLE category (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name varchar(50) NOT NULL
);

CREATE TABLE currency (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
code varchar(10) NOT NULL,
name varchar(30) not null
);

CREATE TABLE image (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
uri varchar(256) NOT NULL
);

CREATE TABLE times (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name varchar(50) NOT NULL,
days varchar(50) NOT NULL,
time varchar(50) NOT NULL,
image_id int(6) NOT NULL
);

CREATE TABLE product (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
descrition VARCHAR(256) NOT NULL,
image_id int(6) NOT NULL,
currency_id int(6) NOT NULL
price double(5,2) NOT NULL
);

CREATE TABLE productTimes (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
product_id  int(6) NOT NULL,
times_id int(6) NOT NULL
);

CREATE TABLE productCategory (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
product_id  int(6) NOT NULL,
category_id int(6) NOT NULL
);

CREATE TABLE message (
id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
message VARCHAR(1000),
date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE reservation (
id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
lname VARCHAR(100) NOT NULL,
phone VARCHAR(15) NOT NULL,
email VARCHAR(100) NOT NULL,
noOfGuests int(3) NOT NULL,
date datetime NOT NULL,
occasion varchar(100),
comment VARCHAR(1000)
);


