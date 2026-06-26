CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    -- Add Customer
    PROCEDURE AddCustomer(
        p_customerID NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Customers(CustomerID, Name, Balance)
        VALUES(p_customerID, p_name, p_balance);

        COMMIT;
    END AddCustomer;

    -- Update Customer
    PROCEDURE UpdateCustomer(
        p_customerID NUMBER,
        p_name VARCHAR2
    )
    IS
    BEGIN
        UPDATE Customers
        SET Name = p_name
        WHERE CustomerID = p_customerID;

        COMMIT;
    END UpdateCustomer;

    -- Get Customer Balance
    FUNCTION GetCustomerBalance(
        p_customerID NUMBER
    )
    RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customerID;

        RETURN v_balance;
    END GetCustomerBalance;

END CustomerManagement;
/