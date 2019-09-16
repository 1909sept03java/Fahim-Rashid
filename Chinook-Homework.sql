--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
------------------------------------------------------------------------------------------

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;
------------------------------------------------------------------------------------------

--2.3 INSERT INTO

--Task – Insert two new records into Genre table 
INSERT INTO GENRE VALUES (26,'Jingles');

INSERT INTO GENRE VALUES (27, 'Bollywood');

--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE VALUES (9, 'Bravo', 'Jhonny', 'Sales Manager', 2, '03-MAR-92', '05-JUL-02', '555 Cooper St', 'Houston', 'AB', 'Canada', 'T5K 2D4', '+1 (123) 456-7890','+1 (123) 456-7890', 'jhonny@chinookcorp.com');

INSERT INTO EMPLOYEE VALUES (10, 'Bing', 'Chandler', 'Sales Manager', 2, '11-JUN-86', '30-OCT-04', '666 Blecker St', 'Toronto', 'AB', 'Canada', 'T5K 2Y8', '+1 (123) 456-7890','+1 (123) 456-7890', 'bing@chinookcorp.com');

--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER VALUES (60, 'Tribbiani', 'Joey', null , '333 Amsterdam Ave','Amsterdam',null,'Holland', '1234', '+91 111 222 333', null,'tribbiani@yahoo.com',4);

INSERT INTO CUSTOMER VALUES (61, 'Geller', 'Monica', null , '555 Grand Ave','Brooklyn',null,'New York', '1234', '+91 111 222 333', null,'monica@yahoo.com',3);
------------------------------------------------------------------------------------------

--2.4 UPDATE

--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
------------------------------------------------------------------------------------------
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
------------------------------------------------------------------------------------------

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL >15 AND TOTAL <50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE > '01-JUN-03' AND HIREDATE < '01-MAR-04';
------------------------------------------------------------------------------------------

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICECUSTOMERID FOREIGN KEY(CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID) ON DELETE CASCADE;

ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID FOREIGN KEY(INVOICEID) REFERENCES INVOICE(INVOICEID) ON DELETE CASCADE;


DELETE FROM CUSTOMER WHERE LASTNAME = 'Walter' AND FIRSTNAME = 'Robert';
------------------------------------------------------------------------------------------

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION RET_CURR_TIME
RETURN CURRTIME 
IS CURR_SYSDATE CURRTIME;
BEGIN
SELECT CURR_SYSDATE
INTO CURRENTTIME
FROM DUAL;
RETURN (CURRENTTIME);
END;
------------------------------------------------------------------------------------------

--Task – create a function that returns the length of name in MEDIATYPE table 
CREAT OR REPLAE FUNCTION GET_NAME_LENGTH(MT_ID IN NUMBER, NAME_LENGTH OUT NUMBER)
RETURN NUMBER IS NAME_LENGTH NUMBER;
BEGIN
SELECT LEN(NAME) INTO NAME_LENGTH FROM MEDIATYPE WHERE MEDIATYPEID = MT_ID;
RETURN NAME_LENGTH;
END;
------------------------------------------------------------------------------------------


--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the most expensive track
CREAT OR REPLACE FUNCTION MOST_EXP_TRK
RETURN VARCHAR IS EXP_TRK VARCHAR;
BEGIN
    EXP_TRK := SELECT NAME FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRIE) FROM TRACK);
	RETURN EXP_TRK;
END;
------------------------------------------------------------------------------------------

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoice line items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INV
RETURN NUMBER AS TTL_AVG NUMBER;
BEGIN
SELECT AVG(TOTAL) INTO TTL_AVG FROM INVOICE;
RETURN TTL_AVG;
END;

DECLARE
X NUMBER;
BEGIN
X := AVG_INV;
DBMS_OUTPUT.PUT_LINE(X);
END;
------------------------------------------------------------------------------------------

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who were born after 1968.
CREATE OR REPLACE FUNCTION PRNT_EMP_1968
RETURN SYS_REFCURSOR
IS X SYS_REFCURSOR;
BEGIN
    OPEN X FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-68'; 
    RETURN X;
END;

DECLARE
X SYS_REFCURSOR;
FRST_NME EMPLOYEE.FIRSTNAME%TYPE;
LST_NME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    X := PRNT_EMP_1968;
    LOOP 
    FETCH X INTO FRST_NME, LST_NME;
    EXIT WHEN X%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FRST_NME || LST_NME);
    END LOOP;
    CLOSE X;
END;
------------------------------------------------------------------------------------------



--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE EMP_FIRSTNAME_LASTNAME
AS 
BEGIN
SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE;
END;

------------------------------------------------------------------------------
--4.2
--Task – Create a function that returns all employees who were born after 1968.
CREATE OR REPLACE FUNCTION PRNT_EMP_1968
RETURN SYS_REFCURSOR
IS X SYS_REFCURSOR;
BEGIN
    OPEN X FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-68'; 
    RETURN X;
END;

DECLARE
X SYS_REFCURSOR;
FRST_NME EMPLOYEE.FIRSTNAME%TYPE;
LST_NME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    X := PRNT_EMP_1968;
    LOOP 
    FETCH X INTO FRST_NME, LST_NME;
    EXIT WHEN X%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FRST_NME || LST_NME);
    END LOOP;
    CLOSE X;
END;
-----------------------------------------------------------------------------------

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_INFO (E_ID NUMBER, NEW_LASTNAME VARCHAR, NEW_FIRSTNAME VARCHAR, NEW_TITLE VARCHAR, NEW_REPORTSTO NUMBER, NEW_BIRTHDATE DATE, NEW_HIREDATE DATE, NEW_ADDRESS VARCHAR, NEW_CITY VARCHAR, NEW_STATE VARCHAR, NEW_COUNTRY VARCHAR, NEW_POSTALCODE VARCHAR, NEW_PHONE VARCHAR, NEW_FAX VARCHAR, NEW_EMAIL VARCHAR)
AS
BEGIN
UPDATE EMPLOYEE SET LASTNAME = NEW_LASTNAME, FIRSTNAME = NEW_FIRSTNAME, TITLE = NEW_TITLE, REPORTSTO = NEW_REPORTSTO, BIRTHDATE = NEW_BIRTHDATE, HIREDATE = NEW_HIREDATE, ADDRESS = NEW_ADDRESS, CITY = NEW_CITY, STATE = NEW_STATE, COUNTRY = NEW_COUNTRY, POSTALCODE = NEW_POSTALCODE, PHONE = NEW_PHONE, FAX = NEW_FAX, EMAIL = NEW_EMAIL WHERE EMPLOYEEID = E_ID;
END;

-------------------------------------------------------------------------------------------------------------------------------------------

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE SP_GET_MANAGER(E_ID IN NUMBER, FN OUT VARCHAR, LN OUT VARCHAR)
AS
BEGIN
SELECT FIRSTNAME INTO FN FROM EMPLOYEE WHERE EMPLOYEEID = (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = E_ID);
SELECT LASTNAME INTO LN FROM EMPLOYEE WHERE EMPLOYEEID = (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = E_ID);
END;
-------------------------------------------------------------------------------------------------------------------------------------------

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE SP_CUS_NAME_COMP(C_ID IN NUMBER, FN OUT VARCHAR, CN OUT VARCHAR)
AS
BEGIN
SELECT FIRSTNAME INTO FN FROM CUSTOMER WHERE CUSTOMERID = C_ID;
SELECT COMPANY INTO CN FROM CUSTOMER WHERE CUSTOMERID = C_ID;
END;


---------------------------------------------------------------------------------------------------------------
--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

CREATE OR REPLACE PROCEDURE SP_DELETE_INVOICE (INV_ID IN NUMBER)
AS
BEGIN
    ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
    ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICECUSTOMERID FOREIGN KEY(CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID) ON DELETE CASCADE;

    ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID
    ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID FOREIGN KEY(INVOICEID) REFERENCES INVOICE(INVOICEID) ON DELETE CASCADE;
    
    DELETE FROM INVOICE WHERE INVOICEID = INV_ID;
END;

--------------------------------------------------------------------------------------------------------------------
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_AFTER_INSERT_EMPL
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('ONE ROW HAS BEEN INSERTED INTO EMPLOYEE TABLE');  
END;

--------------------------------------------------------------------------------------------------------------------
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER TR_AFTER_INSERT_ALBUM
AFTER INSERT ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('ONE ROW HAS BEEN INSERTED INTO ALBUM TABLE');
END;

----------------------------------------------------------------------------------------------------------------------

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TR_AFTER_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
BEGIN
    DBMS_OUTPUT.PUT_LINE('ONE ROW HAS BEEN DELETED FROM THE CUSTOMER TABLE');
END;

------------------------------------------------------------------------------------------------------------------------
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT FIRSTNAME, LASTNAME, INVOICEID
FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL 
FROM CUSTOMER FULL OUTER JOIN INVOICE ON (CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID);

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE 
FROM ARTIST RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * 
FROM ARTIST CROSS JOIN ALBUM
ORDER BY ARTIST.NAME ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT E.FIRSTNAME AS EMPLOYEE, M.FIRSTNAME AS MANAGER
FROM            EMPLOYEE E
LEFT JOIN       EMPLOYEE M
ON E.REPORTSTO = M.EMPLOYEEID








