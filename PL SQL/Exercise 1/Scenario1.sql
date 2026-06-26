BEGIN
    FOR cust IN (
        SELECT c.CustomerID, l.LoanID, l.InterestRate,
               FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS Age
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
    )
    LOOP
        IF cust.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = cust.LoanID;
        END IF;
    END LOOP;

    COMMIT;
END;
/