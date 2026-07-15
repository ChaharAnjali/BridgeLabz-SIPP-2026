SELECT country
FROM covid_data
WHERE country IN (
    SELECT country
    FROM covid_data
    GROUP BY country
    HAVING MAX(confirmed_cases) > 1000000
);