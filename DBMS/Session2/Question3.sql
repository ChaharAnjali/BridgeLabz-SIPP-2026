CREATE TABLE covid_cases (
    Country VARCHAR(100) NOT NULL,
    Date DATE NOT NULL,
    Confirmed_Cases INT NOT NULL,
    Recovered_Cases INT,
    Deaths INT,
    PRIMARY KEY (Country, Date),
    CHECK (Deaths <= Confirmed_Cases)
);