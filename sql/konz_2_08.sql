CREATE DATABASE suli;
CREATE TABLE jegy (
	id INT NOT NULL AUTO_INCREMENT,
	ertek INT,
	leiras VARCHAR(10),
	datum DATE,
	PRIMARY KEY(id)
);
CREATE TABLE diak(
	id INT NOT NULL AUTO_INCREMENT,
	nev VARCHAR(30),
	szuldatum DATE,
	PRIMARY KEY(id)
);
CREATE TABLE naplo(
	id INT NOT NULL AUTO_INCREMENT,
	leiras VARCHAR(10),
	PRIMARY KEY(id)
);
ALTER TABLE jegy
ADD COLUMN diak_id INT NOT NULL;
ALTER TABLE diak
ADD COLUMN naplo_id INT NOT NULL;