--Scenario 1: Discount on Loan Interest Rate

--The bank wants to provide a 1% discount on loan interest rates for customers who are more than 60 years old.
--A FOR LOOP is used to go through all customers. If a customer's age is greater than 60, the loan interest rate is reduced by 1%.

BEGIN
    FOR c IN (
        SELECT CustomerID, DOB
        FROM Customers
    ) LOOP
        IF FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

--Scenario 2: Promote Customers to VIP

--Customers with a balance greater than $10,000 are promoted to VIP status.
--The program checks each customer's account balance and updates the IsVIP field to TRUE if the balance meets the required condition.

BEGIN
    FOR c IN (
        SELECT CustomerID, Balance
        FROM Customers
    ) LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
/

--Scenario 3: Loan Reminder

--The bank needs to remind customers whose loan due date is within the next 30 days.
--The PL/SQL block retrieves all such customers and prints a reminder message using DBMS_OUTPUT.PUT_LINE.

BEGIN
    FOR l IN (
        SELECT c.Name, LoanID, EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            l.Name || ' - Loan ' || l.LoanID ||
            ' due on ' || TO_CHAR(l.EndDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/
