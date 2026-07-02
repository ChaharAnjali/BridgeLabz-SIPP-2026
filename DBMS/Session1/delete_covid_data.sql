-- Delete incorrect country name
DELETE FROM covid_cases
WHERE Country = 'IN';

-- Delete duplicate record for a specific country and date
DELETE FROM covid_cases
WHERE Country = 'India'
AND Date = '2021-02-01'
LIMIT 1;