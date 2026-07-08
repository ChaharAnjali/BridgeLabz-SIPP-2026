CREATE TABLE covid_cases (
    Country VARCHAR(100),
    Date DATE,
    Confirmed_Cases INT,
    Recoveries INT,
    Deaths INT,
    CONSTRAINT uq_country_date UNIQUE (Country, Date)
);