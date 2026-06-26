DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT CustomerID,
               TransactionID,
               TransactionType,
               Amount,
               TransactionDate
        FROM Transactions
        WHERE TRUNC(TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');

    v_customerID Transactions.CustomerID%TYPE;
    v_transactionID Transactions.TransactionID%TYPE;
    v_transactionType Transactions.TransactionType%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transactionDate Transactions.TransactionDate%TYPE;

BEGIN
    OPEN GenerateMonthlyStatements;

    LOOP
        FETCH GenerateMonthlyStatements
        INTO v_customerID, v_transactionID,
             v_transactionType, v_amount, v_transactionDate;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID: ' || v_customerID ||
            ' | Transaction ID: ' || v_transactionID ||
            ' | Type: ' || v_transactionType ||
            ' | Amount: ' || v_amount ||
            ' | Date: ' || TO_CHAR(v_transactionDate, 'DD-MON-YYYY')
        );
    END LOOP;

    CLOSE GenerateMonthlyStatements;
END;
/