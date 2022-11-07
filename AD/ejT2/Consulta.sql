CREATE DATABASE dam2 CHARACTER SET UTF8;

USE dam2;

CREATE TABLE api(
id INT AUTO_INCREMENT NOT NULL,
correo VARCHAR(100) NOT NULL,
PRIMARY KEY(id));

CREATE TABLE Llibres(
id INT AUTO_INCREMENT,
titol VARCHAR(100) NOT NULL,
autor VARCHAR(100) NOT NULL,
anyNaixement YEAR NOT NULL,
anyPublicacio YEAR NOT NULL,
editorial VARCHAR(100) NOT NULL,
numPagines INT NOT NULL,
PRIMARY KEY(id));

INSERT INTO Llibres (titol, autor, anyNaixement, anyPublicacio, editorial, numPagines) VALUES ("asd","asdasd",1997,1998,"asd",2);