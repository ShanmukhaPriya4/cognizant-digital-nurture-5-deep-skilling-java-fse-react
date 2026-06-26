CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountID NUMBER,
        p_customerID NUMBER,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_accountID NUMBER
    );

    FUNCTION GetTotalBalance(
        p_customerID NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    -- Open Account
    PROCEDURE OpenAccount(
        p_accountID NUMBER,
        p_customerID NUMBER,
        p_balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Accounts(AccountID, CustomerID, Balance)
        VALUES(p_accountID, p_customerID, p_balance);

        COMMIT;
    END OpenAccount;

    -- Close Account
    PROCEDURE CloseAccount(
        p_accountID NUMBER
    )
    IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_accountID;

        COMMIT;
    END CloseAccount;

    -- Total Balance
    FUNCTION GetTotalBalance(
        p_customerID NUMBER
    )
    RETURN NUMBER
    IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customerID;

        RETURN NVL(v_total, 0);
    END GetTotalBalance;

END AccountOperations;
/