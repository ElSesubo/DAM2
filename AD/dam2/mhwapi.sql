CREATE DATABASE MHWapi CHARACTER SET UTF8;

USE MHWapi;

CREATE TABLE weapons(
id INT NOT NULL AUTO_INCREMENT,
ident INT NOT NULL,
nameW VARCHAR(100) NOT NULL,
typeW VARCHAR(100) NOT NULL,
rarity VARCHAR(10) NOT NULL,
damageType VARCHAR(20) NOT NULL,
elderSeal VARCHAR(50) NOT NULL,
image VARCHAR(1000) NOT NULL,
PRIMARY KEY (id));