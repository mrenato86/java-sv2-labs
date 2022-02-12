SELECT * 
FROM naplo
WHERE naplo.id=diak.naplo_id;

SELECT * 
FROM naplo
/*LEFT/RIGHT*/JOIN diak ON naplo.id=diak.naplo_id;

SELECT * FROM naplo
JOIN diak ON naplo.id = diak.naplo_id
JOIN jegy ON diak.id = jegy.diak_id;

CREATE VIEW suli.temp 
AS SELECT * FROM diak;

SELECT * FROM temp
WHERE temp.id = 1;

-- változó deklarálás
SELECT @diak_id := MAX(id) FROM diak;
INSERT INTO diak VALUES((@diak_id +1),'Kiss Anna','2010-06-06',1);

-- változó törlés
SET @diak_id = NULL;