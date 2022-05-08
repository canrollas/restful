-- Note that this sql script is only for populating the local db machine.
CREATE
    DATABASE FISHAUCTION;
USE
    FISHAUCTION;

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
CREATE TABLE cooperativeHead
(
    mail     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
);
CREATE TABLE cooperativeMember
(
    mail     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
);
CREATE TABLE fisherMan
(
    mail     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    Iban     VARCHAR(255) NOT NULL,
    owner    VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
);
INSERT INTO Customer
VALUES ("Iyte Bilgisayar", "canrollas@gmail.com", "canrollas", "Can", "Rollas", "123can123");