CREATE DATABASE COVID_DB;
USE COVID_DB;

-- Table: covid_cases
CREATE TABLE covid_cases (
    Country VARCHAR(100),
    Date DATE,
    Confirmed_Cases INT,
    Recoveries INT,
    Population BIGINT
);

-- Table: covid_deaths
CREATE TABLE covid_deaths (
    Country VARCHAR(100),
    Date DATE,
    Deaths INT,
    Population BIGINT
);

-- Table: covid_vaccines
CREATE TABLE covid_vaccines (
    Country VARCHAR(100),
    Date DATE,
    Total_Vaccinated BIGINT,
    Fully_Vaccinated BIGINT,
    Booster_Doses BIGINT,
    Population BIGINT
);