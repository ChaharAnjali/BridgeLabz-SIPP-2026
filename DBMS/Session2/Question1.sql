CREATE TABLE covid_cases (
    Country VARCHAR(100),
    Date DATE,
    Confirmed_Cases INT,
    Recovered_Cases INT,
    Deaths INT,
    PRIMARY KEY (Country, Date)
);