CREATE VIEW Latest_COVID_Data AS
SELECT 
    country,
    date,
    confirmed_cases,
    deaths,
    recoveries
FROM COVID_DATA c1
WHERE date = (
    SELECT MAX(date)
    FROM COVID_DATA c2
    WHERE c1.country = c2.country
);