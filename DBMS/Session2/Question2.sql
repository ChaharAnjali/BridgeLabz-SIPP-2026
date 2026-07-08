CREATE TABLE countries (
    Country VARCHAR(100) PRIMARY KEY,
    Continent VARCHAR(50),
    Population BIGINT
);

CREATE TABLE covid_cases (
    Country VARCHAR(100),
    Date DATE,
    Confirmed_Cases INT,
    Recovered_Cases INT,
    Deaths INT,
    PRIMARY KEY (Country, Date),
    FOREIGN KEY (Country) REFERENCES countries(Country)
);