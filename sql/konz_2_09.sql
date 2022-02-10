--M betűvel kezdődő országok
SELECT * FROM orszagok
WHERE orszag LIKE 'm%';

--M betűvel kezdődő országok száma
SELECT COUNT(*) AS 'M-el kezdődő országok' 
FROM orszagok
WHERE orszag LIKE 'm%';

--M betűvel kezdődő országok csökkenő sorrendben
SELECT * FROM orszagok
WHERE orszag LIKE 'm%'
ORDER BY orszag DESC;

--M betűvel kezdődő országok fővárosait
SELECT fovaros FROM orszagok
WHERE orszag LIKE 'm%';

--M betűsök sorban területileg vagy lakosságilag
SELECT orszag, terulet FROM orszagok
WHERE orszag LIKE 'm%'
ORDER BY terulet;

SELECT orszag, nepesseg FROM orszagok
WHERE orszag LIKE 'm%'
ORDER BY nepesseg DESC;

--államformák / országok száma
SELECT allamforma, COUNT(*)
FROM orszagok
GROUP BY allamforma;

--mennyi az országok átlagterülete / átlaglakossága
SELECT AVG(terulet) AS atlag_terulet ,AVG(nepesseg) AS atlag_nepesseg
FROM orszagok;

--hányféle államforma van
SELECT COUNT(DISTINCT allamforma) AS kulonbozo_allaformak_szama
FROM orszagok;

--melyik a legritkábban / legsűrűbben lakott ország
SELECT orszag ,nepesseg/terulet AS arany FROM orszagok
WHERE nepesseg/terulet = (SELECT MAX(nepesseg/terulet) FROM orszagok)
	OR nepesseg/terulet = (SELECT MIN(nepesseg/terulet) FROM orszagok);

--melyik a legnagyobb,legkissebb ország területre, lakosságra
SELECT orszag, terulet, nepesseg FROM orszagok
WHERE nepesseg = (SELECT MIN(nepesseg) FROM orszagok)
	OR nepesseg = (SELECT MAX(nepesseg) FROM orszagok)
	OR terulet = (SELECT MIN(terulet) FROM orszagok)
	OR terulet = (SELECT MAX(terulet) FROM orszagok);

-melyik az a 3 ország amely területében legközelebb van Mo területéhez
SELECT orszag, ABS(terulet - (SELECT terulet FROM orszagok WHERE orszag = 'Magyarország')) AS elteres
FROM orszagok
WHERE orszag<>'Magyarország'
ORDER BY elteres
LIMIT 3

--Legközelebbi területeltérésű ország
SELECT orszag FROM orszagok
WHERE ABS(terulet - (SELECT terulet FROM orszagok WHERE orszag = 'Magyarország')) =
(SELECT MIN(ABS(terulet - (SELECT terulet FROM orszagok WHERE orszag = 'Magyarország'))) 
FROM orszagok WHERE orszag <> 'Magyarország');
