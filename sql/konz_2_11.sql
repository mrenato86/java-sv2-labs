-- -- első sessionből:
-- SELECT @@autocommit;
-- SET @@autocommit = 0;
-- 
-- START TRANSACTION;
-- 
-- DELETE FROM orszagok; -- orszagok ures
-- 
-- -- másik sessionből:
-- SELECT COUNT(*) FROM orszagok; -- 194
-- 
-- -- első sessionből:
-- ROLLBACK;
-- 
-- SELECT COUNT(*) FROM orszagok; -- 194
-- 
-- SELECT @@autocommit;
-- SET @@autocommit = 1;
-- -- -------------------------------------------------

SELECT diak.nev, ROUND(AVG(jegy.ertek),2)
FROM diak
JOIN jegy ON diak.id = jegy.diak_id
GROUP BY diak.nev
HAVING AVG(jegy.ertek) < 4;

-- constraints
ALTER TABLE diak
MODIFY taj VARCHAR(9) CHECK (CHAR_LENGTH(taj) = 9);

INSERT INTO diak (`nev`,`szuldatum`,`naplo_id`,`taj`)
VALUES ('Kiss Anna','2010-12-12',1,'123456'); -- HIBA

INSERT INTO diak (`nev`,`szuldatum`,`naplo_id`,`taj`)
VALUES ('Kiss Anna','2010-12-12',1,'123456789'); -- Jó

-- reguláris kifejezéssel
ALTER TABLE diak
MODIFY taj VARCHAR(9) CHECK (taj RLIKE '^[0-9]{9}$');
