SELECT state,
       date,
       confirmed_cases
FROM covid_data c1
WHERE state = 'Mumbai'
AND confirmed_cases = (
    SELECT MAX(c2.confirmed_cases)
    FROM covid_data c2
    WHERE c2.state = c1.state
);