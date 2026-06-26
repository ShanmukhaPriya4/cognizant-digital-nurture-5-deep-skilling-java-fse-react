CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_empID NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    );

    PROCEDURE UpdateEmployee(
        p_empID NUMBER,
        p_salary NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_empID NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    -- Hire Employee
    PROCEDURE HireEmployee(
        p_empID NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER,
        p_department VARCHAR2
    )
    IS
    BEGIN
        INSERT INTO Employees(EmployeeID, Name, Salary, Department)
        VALUES(p_empID, p_name, p_salary, p_department);

        COMMIT;
    END HireEmployee;

    -- Update Employee
    PROCEDURE UpdateEmployee(
        p_empID NUMBER,
        p_salary NUMBER
    )
    IS
    BEGIN
        UPDATE Employees
        SET Salary = p_salary
        WHERE EmployeeID = p_empID;

        COMMIT;
    END UpdateEmployee;

    -- Annual Salary
    FUNCTION CalculateAnnualSalary(
        p_empID NUMBER
    )
    RETURN NUMBER
    IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_empID;

        RETURN v_salary * 12;
    END CalculateAnnualSalary;

END EmployeeManagement;
/