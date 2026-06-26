DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_accountID Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;

    v_fee NUMBER := 500;
BEGIN
    OPEN ApplyAnnualFee;

    LOOP
        FETCH ApplyAnnualFee
        INTO v_accountID, v_balance;

        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = v_accountID;

    END LOOP;

    CLOSE ApplyAnnualFee;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Annual maintenance fee applied successfully.');
END;
/