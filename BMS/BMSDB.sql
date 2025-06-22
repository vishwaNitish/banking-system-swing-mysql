create database bankmanagementsystem;
show databases;

use bankmanagementsystem;

CREATE TABLE signup (
    formno VARCHAR(20),
    name VARCHAR(20),
    fname VARCHAR(20),
    dob VARCHAR(20),
    gender VARCHAR(20),
    email VARCHAR(30),
    marital_status VARCHAR(20),
    address VARCHAR(40),
    city VARCHAR(25),
    state VARCHAR(25),
    pincode VARCHAR(20),
);

Show tables;

select * from signup;

CREATE TABLE signupTwo (
    formno VARCHAR(20),
    religion VARCHAR(50),
    category VARCHAR(50),
    income VARCHAR(50),
    education VARCHAR(50),
    occupation VARCHAR(50),
    pan VARCHAR(20),
    adhar VARCHAR(20),
    seniorCitizen VARCHAR(10),
    existingAccount VARCHAR(10)
);

Show tables;
select * from signuptwo;
