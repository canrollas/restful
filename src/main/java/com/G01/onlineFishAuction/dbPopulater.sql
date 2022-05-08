-- Note that this sql script is only for populating the local db machine.
CREATE DATABASE fish;
USE fish;

CREATE TABLE customer
(
    address  VARCHAR(255) NOT NULL,
    mail     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    name     VARCHAR(255) NOT NULL,
    surname  VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
);
CREATE TABLE cooperativehead
(
    mail     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
);
CREATE TABLE cooperativemember
(
    mail     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
);
CREATE TABLE fisherman
(
    mail     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    Iban     VARCHAR(255) NOT NULL,
    owner    VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
);
INSERT INTO customer
VALUES ("Iyte Bilgisayar", "canrollas@gmail.com", "canrollas", "Can", "Rollas", "123can123");
INSERT INTO customer
VALUES ("randomAddress", "random@gmail.com", "randomUser", "cagatay", "iba", "random_psw_123");
INSERT INTO cooperativemember
VALUES ("member234@email.com", "Member_123", "random_psw_234");
INSERT INTO customer
VALUES ("randomAddress", "random@gmail.com", "randomUser", "cagatay", "iba", "random_psw_123");
INSERT INTO fisherman
VALUES ("randomFm@gmail.com", "Ali_Kaptan", "random_psw_567", "11111111111111111111111111", "ali kuscu");
INSERT INTO cooperativehead
VALUES ("admin@gmail.com", "Admin", "lorem_ipsum");