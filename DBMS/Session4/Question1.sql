SELECT country, deaths
FROM covid_data
WHERE deaths > (
    SELECT AVG(deaths)
    FROM covid_data
);