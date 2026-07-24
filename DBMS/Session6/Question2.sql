
CREATE INDEX idx_infection_rate_covering
ON covid_cases(Country, infection_rate);


SELECT Country, infection_rate
FROM covid_cases
ORDER BY infection_rate DESC
LIMIT 10;


SHOW INDEXES FROM covid_cases;