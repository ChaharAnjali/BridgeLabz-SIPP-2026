SELECT country,
       vaccinated AS population_count,
       'Vaccinated' AS status
FROM covid_data

UNION

SELECT country,
       unvaccinated AS population_count,
       'Unvaccinated' AS status
FROM covid_data;