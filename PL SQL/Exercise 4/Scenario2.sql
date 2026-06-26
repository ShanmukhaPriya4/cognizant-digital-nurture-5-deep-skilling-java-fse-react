CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loanAmount IN NUMBER,
    p_interestRate IN NUMBER,
    p_years IN NUMBER
)
RETURN NUMBER
IS
    v_monthlyRate NUMBER;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN
    v_monthlyRate := (p_interestRate / 12) / 100;
    v_months := p_years * 12;

    v_emi := (p_loanAmount * v_monthlyRate *
             POWER(1 + v_monthlyRate, v_months))
             /
             (POWER(1 + v_monthlyRate, v_months) - 1);

    RETURN ROUND(v_emi, 2);
END;
/