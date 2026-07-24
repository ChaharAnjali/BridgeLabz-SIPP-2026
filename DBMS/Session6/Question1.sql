

-- Composite Index on Country and Date columns
CREATE INDEX idx_country_date
ON covid_cases(Country, Date);

-- Single Column Index on Date column
CREATE INDEX idx_date
ON covid_cases(Date);

-- Verify indexes
SHOW INDEXES FROM covid_cases;