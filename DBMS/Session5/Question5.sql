DELIMITER //

CREATE TRIGGER Before_Covid_Update
BEFORE UPDATE ON covid_cases
FOR EACH ROW
BEGIN
    INSERT INTO covid_cases_audit(
        case_id,
        country,
        old_confirmed_cases,
        new_confirmed_cases,
        old_deaths,
        new_deaths,
        old_recoveries,
        new_recoveries,
        changed_at
    )
    VALUES(
        OLD.case_id,
        OLD.country,
        OLD.confirmed_cases,
        NEW.confirmed_cases,
        OLD.deaths,
        NEW.deaths,
        OLD.recoveries,
        NEW.recoveries,
        NOW()
    );
END //

DELIMITER ;