
SELECT 
    c.Country,
    c.Date,
    c.confirmed_cases,
    d.population
FROM covid_cases c
JOIN country_details d
ON c.Country = d.Country
WHERE c.Date = '2022-01-01';



CREATE INDEX idx_country
ON country_details(Country);


CREATE INDEX idx_cases_date
ON covid_cases(Date);


SHOW INDEXES FROM covid_cases;
SHOW INDEXES FROM country_details;