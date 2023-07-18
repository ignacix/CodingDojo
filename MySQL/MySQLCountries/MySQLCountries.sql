/*1*/
SELECT countries.name, languages.language, languages.percentage
FROM countries
JOIN languages ON countries.id = languages.country_id
WHERE languages.language = 'Slovene'
ORDER BY languages.percentage DESC;
/*2*/
SELECT countries.name, COUNT(cities.country_id) AS numero_de_ciudades
FROM countries
JOIN cities ON countries.id = cities.country_id
GROUP BY countries.id
ORDER BY numero_de_ciudades DESC;
/*3*/
SELECT cities.name, cities.population
FROM countries
JOIN cities ON countries.id = cities.country_id
WHERE countries.name = 'Mexico' AND cities.population >500000;
/*4*/
SELECT countries.name AS country, languages.language, languages.percentage
FROM countries 
JOIN languages ON countries.id = languages.country_id
WHERE languages.percentage >89
ORDER BY languages.percentage DESC, countries.name ;
/*5*/
SELECT countries.name, countries.surface_area, countries.population
FROM countries 
WHERE countries.surface_area < 501 AND countries.population > 100000;
/*6*/
SELECT countries.name, countries.government_form, countries.capital, countries.life_expectancy
FROM countries
WHERE government_form = 'Constitutional Monarchy' AND capital>200 AND life_expectancy > 75;
/*7*/
SELECT countries.name, cities.name, cities.district, cities.population
FROM countries
JOIN cities ON countries.id = cities.country_id
WHERE countries.name = 'Argentina' AND cities.district = 'Buenos Aires' AND cities.population>500000;
/*8*/
SELECT countries.region, COUNT(countries.region) AS numero_de_paises
FROM countries
GROUP BY countries.region
ORDER BY numero_de_paises DESC;
