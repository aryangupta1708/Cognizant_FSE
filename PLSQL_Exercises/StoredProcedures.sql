--Scenario 1: Process Monthly Interest

--The bank wants to add monthly interest to all savings accounts.
--A stored procedure named ProcessMonthlyInterest is created to calculate 1% interest on the current balance and update the account balance automatically.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');

END;
/

--Scenario 2: Update Employee Bonus

--The bank provides bonuses to employees based on their department and performance.
--The procedure UpdateEmployeeBonus accepts the department name and bonus percentage as parameters. It increases the salary of all employees in the specified department.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(

    p_Department IN VARCHAR2,
    p_Bonus IN NUMBER

)
AS
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * p_Bonus / 100)
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee bonus updated successfully.');

END;
/

--Scenario 3: Transfer Funds

--Customers should be able to transfer money from one account to another.
--The procedure TransferFunds checks whether the sender has enough balance before transferring the amount. If the balance is sufficient, the amount is deducted from the sender's account and added to the receiver's account.

CREATE OR REPLACE PROCEDURE TransferFunds(

    p_FromAccount IN NUMBER,
    p_ToAccount IN NUMBER,
    p_Amount IN NUMBER

)
AS

    v_Balance NUMBER;

BEGIN

    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    IF v_Balance >= p_Amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Fund transferred successfully.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance.');

    END IF;

END;
/
