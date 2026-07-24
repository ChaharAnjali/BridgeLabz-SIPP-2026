DELIMITER //

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(100),
    p_date DATE
)
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE mortality_rate DECIMAL(5,2);

    SELECT (deaths / confirmed_cases) * 100
    INTO mortality_rate
    FROM COVID_DATA
    WHERE country = p_country
      AND date = p_date;

    RETURN mortality_rate;
END //

DELIMITER ;