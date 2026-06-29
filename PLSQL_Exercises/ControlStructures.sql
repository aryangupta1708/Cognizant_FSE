--Scenario 1: Discount on Loan Interest Rate

--The bank wants to provide a 1% discount on loan interest rates for customers who are more than 60 years old.
--A FOR LOOP is used to go through all customers. If a customer's age is greater than 60, the loan interest rate is reduced by 1%.

SET SERVEROUTPUT ON;

BEGIN
    FOR c IN (
        SELECT CustomerID
        FROM Customers
        WHERE Age > 60
    ) LOOP

        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = c.CustomerID;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Loan interest updated successfully.');

END;
/

--Scenario 2: Promote Customers to VIP

--Customers with a balance greater than $10,000 are promoted to VIP status.
--The program checks each customer's account balance and updates the IsVIP field to TRUE if the balance meets the required condition.

SET SERVEROUTPUT ON;

BEGIN

    FOR c IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    ) LOOP

        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = c.CustomerID;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');

END;
/

--Scenario 3: Loan Reminder

--The bank needs to remind customers whose loan due date is within the next 30 days.
--The PL/SQL block retrieves all such customers and prints a reminder message using DBMS_OUTPUT.PUT_LINE.

SET SERVEROUTPUT ON;

BEGIN

    FOR l IN (

        SELECT c.Name,
               l.LoanID,
               l.DueDate

        FROM Customers c
        JOIN Loans l

        ON c.CustomerID = l.CustomerID

        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30

    ) LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || l.Name ||
            ', your Loan ID ' || l.LoanID ||
            ' is due on ' || l.DueDate
        );

    END LOOP;

END;
/

