CREATE TABLE covid_cases (
    Country VARCHAR(100),
    Date DATE,
    Confirmed_Cases INT,
    Recoveries INT DEFAULT 0,
    Deaths INT,
    Last_Updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);