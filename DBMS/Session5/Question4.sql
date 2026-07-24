DELIMITER //

CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(100)
)
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE recovery_rate DECIMAL(5,2);

    SELECT (recoveries / confirmed_cases) * 100
    INTO recovery_rate
    FROM COVID_DATA
    WHERE country = p_country
    ORDER BY date DESC
    LIMIT 1;

    RETURN recovery_rate;
END //

DELIMITER ;