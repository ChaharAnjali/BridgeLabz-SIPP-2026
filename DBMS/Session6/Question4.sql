
START TRANSACTION;


INSERT INTO vaccine_distribution
(Vaccine_ID, Country, Date, Doses_Distributed)
VALUES
(101, 'India', '2022-01-01', 50000);

INSERT INTO vaccine_distribution
(Vaccine_ID, Country, Date, Doses_Distributed)
VALUES
(102, 'USA', '2022-01-01', 75000);



COMMIT;


ROLLBACK;