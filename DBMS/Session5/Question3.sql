DELIMITER //

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_confirmed_cases INT,
    IN p_deaths INT,
    IN p_recoveries INT
)
BEGIN
    START TRANSACTION;

    UPDATE COVID_DATA
    SET 
        confirmed_cases = p_confirmed_cases,
        deaths = p_deaths,
        recoveries = p_recoveries
    WHERE country = p_country
      AND date = p_date;

    COMMIT;
END //

DELIMITER ;