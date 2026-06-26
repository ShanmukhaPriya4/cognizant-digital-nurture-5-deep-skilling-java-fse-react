CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customerID IN NUMBER,
    p_name IN VARCHAR2,
    p_balance IN NUMBER
)
IS
BEGIN
    INSERT INTO Customers(CustomerID, Name, Balance)
    VALUES(p_customerID, p_name, p_balance);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/