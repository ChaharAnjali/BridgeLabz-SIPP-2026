SELECT 
    d.country,
    d.report_date,
    d.total_deaths,
    v.total_vaccinations,
    v.people_vaccinated
FROM covid_deaths d
LEFT JOIN covid_vaccines v
ON d.country = v.country
AND d.report_date = v.report_date;