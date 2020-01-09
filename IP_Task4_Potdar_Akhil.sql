DROP TABLE IF EXISTS Updates, Records, Cost_Transactions
DROP TABLE IF EXISTS Assembly_account, Process_account, Department_account
DROP TABLE IF EXISTS Account
DROP PROCEDURE IF EXISTS assembly_account_entry,department_account_entry,process_account_entry
DROP TABLE IF EXISTS Fit_Job, Paint_Job, Cut_Job, Fit_Process, Paint_Process, Cut_Process
DROP TABLE IF EXISTS Assigned, Job, Assembly, Process
DROP TABLE IF EXISTS Customer,Department
DROP PROCEDURE IF EXISTS job_entry,assembly_entry,process_entry;
DROP PROCEDURE IF EXISTS customer_entry,department_entry;
DROP PROCEDURE IF EXISTS account_entry, labor_time_retrieve;
DROP PROCEDURE IF EXISTS fit_job_completion, paint_job_completion, cut_job_completion, retrieve_process
drop PROCEDURE if exists cost_transaction_entry, record_entry, updates_entry, cost_assembly_retrieve
drop PROCEDURE if exists fit_job_retrieve,paint_job_retrieve, cut_job_retrieve,customer_retrieve
drop PROCEDURE if exists cut_job_deletion,color_change, cost_transaction_record_entry


CREATE TABLE Customer(
Name varchar(25) PRIMARY KEY,
Address varchar(25),
Category int not null check (Category between 0 and 10),
);
create index c on Customer(Category)

CREATE TABLE Department (
Dept_Number int PRIMARY KEY,
Data varchar(25));

CREATE TABLE Assembly (
Assembly_ID varchar(25) PRIMARY KEY,
Date_ordered DATE,
Assembly_details varchar(25),
Name varchar(25),
FOREIGN KEY(Name) REFERENCES Customer,
);
create index d on Assembly(Assembly_ID)

CREATE TABLE Process (
Process_ID varchar(25) PRIMARY KEY,
Process_data varchar(25),
Dept_Number int,
FOREIGN KEY(Dept_Number) REFERENCES Department,
);
create index e on process(process_ID)

CREATE TABLE Account (
Account_no int PRIMARY KEY,
Date_of_establishment DATE,
);

Create index f on Account(Account_no)

CREATE TABLE Assembly_account (
Account_no int PRIMARY KEY,
cost int,
Assembly_ID VARCHAR(25),
FOREIGN KEY(Account_no) REFERENCES Account,
FOREIGN KEY(Assembly_ID) REFERENCES Assembly,
);
create index g on Assembly_account(Assembly_ID)

CREATE TABLE Department_account (
Account_no int PRIMARY KEY,
cost int,
Dept_Number int,
FOREIGN KEY(Account_no) REFERENCES Account,
FOREIGN KEY(Dept_Number) REFERENCES Department,
);
create index h on Department_account(Dept_Number)

CREATE TABLE Process_account (
Account_no int PRIMARY KEY,
cost int,
Process_ID VARCHAR(25),
FOREIGN KEY(Account_no) REFERENCES Account,
FOREIGN KEY(Process_ID) REFERENCES Process,
);
create index i on Process_account(Process_ID)

CREATE TABLE Job (
Job_number int PRIMARY KEY,
date_commencement DATE);

CREATE TABLE Assigned (
Job_number int,
Assembly_ID varchar(25),
Process_ID varchar(25),
FOREIGN KEY(Job_number) REFERENCES Job,
FOREIGN KEY(Assembly_ID) REFERENCES Assembly,
FOREIGN KEY(Process_ID) REFERENCES Process,
PRIMARY KEY(Job_number,Assembly_ID,Process_ID),
);
create index j on Assigned(Assembly_ID)

CREATE TABLE [Fit_Job]
(
    [Job_number] INT Primary Key, -- Primary Key column
    [Labor_time] TIME NOT NULL,
    [date_completion] DATE,
    FOREIGN KEY(Job_number) REFERENCES Job,
    index name(Job_Number)
);

CREATE TABLE [Paint_Job]
(
    [Job_number] INT Primary Key, -- Primary Key column
    [Color] NVARCHAR(50) NOT NULL,
    [Volume] NUMERIC NOT NULL,
    [Labor_time] TIME NOT NULL,
    [date_completion] DATE,
    FOREIGN KEY(Job_number) REFERENCES Job,
    index name(Job_Number)
);

CREATE TABLE [Cut_Job]
(
    [Job_number] INT Primary Key, -- Primary Key column
    [Type_machine_used] NVARCHAR(50) NOT NULL,
    [Amt_time_machine_used] TIME NOT NULL,
    [Material_used] NVARCHAR(50) NOT NULL,
    [Labor_time] TIME NOT NULL,
    [date_completion] DATE,
    FOREIGN KEY(Job_number) REFERENCES Job
);
    Create Index a on Cut_Job(Job_Number)


CREATE TABLE Cost_Transactions
(
    [Transaction_number] INT NOT NULL PRIMARY KEY, -- Primary Key column
    [sup_cost] int NOT NULL
);

CREATE TABLE [Records]
(
    [Transaction_number] INT NOT NULL Primary Key, 
    [Job_number] INT NOT NULL,
    FOREIGN KEY(Transaction_number) REFERENCES Cost_Transactions,
    FOREIGN KEY(Job_number) REFERENCES Job,

);
CREATE INDEX b on Records(Transaction_number)

CREATE TABLE Updates
(
    [Transaction_number] INT NOT NULL, 
    [Account_no] int NOT NULL,
    FOREIGN KEY(Transaction_number) REFERENCES Cost_Transactions,
    FOREIGN KEY(Account_no) REFERENCES Account,
    Primary Key(Transaction_number,Account_no)
);

CREATE TABLE [Fit_Process]
(
    [Process_ID]  varchar(25) Primary Key, -- Primary Key column
    [Fit_type] varchar(25) NOT NULL,
    FOREIGN KEY(Process_ID) REFERENCES Process
);

CREATE TABLE [Paint_Process]
(
    [Process_ID] varchar(25) Primary Key, -- Primary Key column
    [Type] varchar(25) NOT NULL,
    [Method] NUMERIC NOT NULL,
    FOREIGN KEY(Process_ID) REFERENCES Process
);

CREATE TABLE [Cut_Process]
(
    [Process_ID] varchar(25) Primary Key, -- Primary Key column
    [Cutting_Type] varchar(25) NOT NULL,
    [Machine_type] varchar(25) NOT NULL,
    FOREIGN KEY(Process_ID) REFERENCES Process
);



GO
CREATE PROCEDURE customer_entry
  @name varchar(25),
  @add varchar(25),
  @cat int
AS
BEGIN
INSERT INTO Customer(Name, Address, Category)
VALUES (@name, @add, @cat)
END



-- Query 2 --
-- Creating a Department table
GO
CREATE PROCEDURE department_entry
  @num int,
  @data varchar(25)
AS
BEGIN
INSERT INTO Department(Dept_Number,[Data])
VALUES (@num, @data)
END

-- Query 3 --
-- Creating a Assembly table
GO
CREATE PROCEDURE assembly_entry
  @id varchar(25),
  @date DATE,
  @details varchar(25),
  @name varchar(25)
AS
BEGIN
INSERT INTO Assembly(Assembly_ID,[Date_ordered],Assembly_details,Name)
VALUES (@id, @date, @details, @name)
END


-- Query 4 --
-- Creating a Process table

GO
CREATE PROCEDURE process_entry
  @id varchar(25),
  @details varchar(25),
  @num int
AS
BEGIN
INSERT INTO Process(Process_ID,Process_data,Dept_Number)
VALUES (@id,@details, @num)
END

GO
EXEC process_entry @id = 'P1', @details='Cutting car doors', @num=101 
EXEC process_entry @id = 'P2', @details='Glazing car doors', @num=201
EXEC process_entry @id = 'P3', @details='Creating moulds for cars', @num=301

-- Query 5 --

GO
CREATE PROCEDURE account_entry
  @num int,
  @date DATE  
AS
BEGIN
INSERT INTO Account (Account_no, Date_of_establishment)
VALUES (@num,@date)
END



GO
CREATE PROCEDURE assembly_account_entry
  @num int,
  @cost int,
  @a_ID VARCHAR(25) 
AS
BEGIN
INSERT INTO Assembly_account (Account_no,cost,Assembly_ID)
VALUES (@num,@cost,@a_ID)
END

GO
CREATE PROCEDURE department_account_entry
  @num int,
  @cost int,
  @d_num int  
AS
BEGIN
INSERT INTO Department_account (Account_no, cost,Dept_Number)
VALUES (@num,@cost,@d_num)
END

GO
CREATE PROCEDURE process_account_entry
  @num int,
  @cost int,
  @p_ID VARCHAR(25)  
AS
BEGIN
INSERT INTO Process_account (Account_no, cost,Process_ID)
VALUES (@num,@cost,@p_ID)
END

--Query 6 --
-- Creating a Job table

-- Creating a Assigned table
GO
CREATE PROCEDURE job_entry
  @num int,
  @date DATE,
  @a_id VARCHAR(25),
  @p_id VARCHAR(25)
AS
BEGIN
INSERT INTO Job(Job_number,date_commencement)
VALUES (@num,@date)
INSERT INTO Assigned(Job_number,Assembly_ID,Process_ID)
VALUES (@num,@a_id,@p_id)
END


--Query 7--
-- Create the table in the specified schema

GO
CREATE PROCEDURE fit_job_completion
  @num int,
  @l_time TIME,
  @date DATE
AS
BEGIN
INSERT INTO Fit_Job(Job_number,Labor_time,date_completion)
VALUES (@num,@l_time,@date)
END

GO
CREATE PROCEDURE paint_job_completion
  @num int,
  @col VARCHAR(25),
  @vol NUMERIC,
  @l_time TIME,
  @date DATE  
AS
BEGIN
INSERT INTO Paint_Job(Job_number,Color,Volume,Labor_time,date_completion)
VALUES (@num,@col,@vol,@l_time,@date)
END

GO
CREATE PROCEDURE cut_job_completion
  @num int,
  @typ VARCHAR(25),
  @a_time TIME,
  @mat VARCHAR(25),
  @l_time TIME,
  @date DATE
AS
BEGIN
INSERT INTO Cut_Job(Job_number,Type_machine_used,Amt_time_machine_used,
    Material_used,Labor_time,date_completion)
VALUES (@num,@typ,@a_time,@mat,@l_time,@date)
END
--Query 8--

GO
CREATE PROCEDURE cost_transaction_record_entry
  @t_num int,
  @s_cost int,
  @j_num int
AS
BEGIN
INSERT INTO Cost_Transactions(Transaction_number,sup_cost)
VALUES (@t_num,@s_cost)
INSERT INTO Records(Transaction_number,Job_number)
VALUES (@t_num,@j_num)
END



GO
CREATE PROCEDURE updates_entry
  @t_num int
AS
BEGIN
--Retrieving Process account number 
DECLARE @p_acc int
SET @p_acc = (SELECT P.Account_no
from Process_account P
where Process_ID in 
  (SELECT Process_ID 
    From Assigned
    Where Job_Number in
    (select Job_number from Records
    where Transaction_number = @t_num)))

DECLARE @a_acc int
SET @a_acc =(SELECT A.Account_no
from Assembly_account A
Where Assembly_ID in 
  (SELECT Assembly_ID 
    From Assigned
    Where Job_Number in
    (select Job_number from Records
    where Transaction_number = @t_num)))

DECLARE @d_acc int
SET @d_acc = (SELECT Distinct D.Account_no
from Department_account D  
Where Dept_Number IN
  (SELECT Dept_Number
  From Process 
  where Process_ID IN
  (Select Process_ID 
    From Assigned
    Where Job_Number in
    (select Job_number from Records
    where Transaction_number = @t_num))))

INSERT INTO Updates(Transaction_number,Account_no)
VALUES (@t_num,@p_acc)
INSERT INTO Updates(Transaction_number,Account_no)
VALUES (@t_num,@a_acc)
INSERT INTO Updates(Transaction_number,Account_no)
VALUES (@t_num,@d_acc)

DECLARE @s_cost int
SET @s_cost = (SELECT sup_cost FROM Cost_Transactions where Transaction_number=@t_num)

--SELECT sup_cost FROM Cost_Transactions where Transaction_number=1

update Assembly_account
set cost = cost + @s_cost
where Account_no=@a_acc

update Department_account
set cost = cost + @s_cost
where Account_no=@d_acc

update Process_account
set cost = cost + @s_cost
where Account_no=@p_acc
END



-- Query 9

GO
CREATE PROCEDURE cost_assembly_retrieve
  @a_id VARCHAR(25)
AS
BEGIN
SELECT cost 
from Assembly_account
where Assembly_ID = @a_id
END



--Query 10
drop PROCEDURE if exists labor_time_retrieve
GO
CREATE PROCEDURE labor_time_retrieve
  @end DATE,
  @dept int
AS
BEGIN
-- Searching for fit_job
DECLARE @fit int
SET @fit = 0
SET @fit = (SELECT SUM(DATEDIFF(MINUTE, '0:00:00', Labor_time)) 
from Fit_job where date_completion=@end and Job_number in(SELECT Job_number
from Assigned
WHERE Process_ID in (select Process_ID
from Process
where Dept_Number=@dept)))
PRINT @fit
--Seaching for paint_job
DECLARE @paint int
SET @paint = 0
SET @paint = (SELECT SUM(DATEDIFF(MINUTE, '0:00:00', Labor_time)) 
from Paint_job where date_completion='2019-02-01' and Job_number in(SELECT Job_number
from Assigned
WHERE Process_ID in (select Process_ID
from Process
where Dept_Number=201)))
PRINT @paint
--Select for cut_job
DECLARE @cut int
SET @cut = 0
SET @cut = (SELECT SUM(DATEDIFF(MINUTE, '0:00:00', Labor_time)) 
from Cut_job where date_completion='2019-02-01' and Job_number in(SELECT Job_number
from Assigned
WHERE Process_ID in (select Process_ID
from Process
where Dept_Number=201)))
PRINT @cut
DECLARE @tot int 
SET @tot = @fit+@cut+@paint
DECLARE @total TABLE
( final int Not NULL)

INSERT INTO @total(final)
VALUES(@tot)

Select * from @total
--Print (@tot)
END


--Query 11

GO
CREATE PROCEDURE retrieve_process
    @a_id VARCHAR(25)
AS
BEGIN
select P.Process_id, P.Dept_Number, J.date_commencement
from Process P,Job J,Assigned AA
where J.Job_number = AA.Job_number and AA.Process_ID = P.Process_ID and P.Process_id in 
(select A.Process_ID
from Assigned A
where A.Assembly_ID='a_id')
order by J.date_commencement
END


select distinct P.Process_id, P.Dept_Number, J.date_commencement
from Process P,Job J
where P.Process_id in 
(select distinct A.Job_number
from Assigned A
where A.Assembly_ID='A2')
order by J.date_commencement

select distinct J.Job_number,J.date_commencement
from Process P,Job J
where P.Process_ID in
(select distinct A.Process_ID
from Assigned A
where A.Assembly_ID='A2') AND
J.Job_number in 
(select distinct A.Job_number
from Assigned A
where A.Assembly_ID='A2')
order by J.date_commencement;



--Query 12
/* Retrieve the jobs (together with their type information and assembly-id)
completed during a given date in a given department (20/day) */

GO
CREATE PROCEDURE fit_job_retrieve
  @end DATE,
  @dept int
AS
BEGIN
SELECT distinct F.*,A.Assembly_ID
from Fit_Job F, Assigned A 
where F.date_completion=@end and 
F.Job_number in
    (SELECT A.Job_number
    from Assigned A
    WHERE A.Process_ID in 
        (select P.Process_ID
        from Process P
        where P.Dept_Number=@dept
        )
    ) AND
A.Assembly_ID in 
    (SELECT A.Assembly_ID
    from Assigned A
    WHERE A.Process_ID in 
        (select P.Process_ID
        from Process P
        where P.Dept_Number=@dept
        ) AND
    A.Job_number = F.Job_number
    )
END

GO
CREATE PROCEDURE paint_job_retrieve
  @end DATE,
  @dept int
AS
BEGIN
SELECT distinct F.*,A.Assembly_ID
from Paint_Job F, Assigned A 
where F.date_completion=@end and 
F.Job_number in
    (SELECT A.Job_number
    from Assigned A
    WHERE A.Process_ID in 
        (select P.Process_ID
        from Process P
        where P.Dept_Number=@dept
        )
    ) AND
A.Assembly_ID in 
    (SELECT A.Assembly_ID
    from Assigned A
    WHERE A.Process_ID in 
        (select P.Process_ID
        from Process P
        where P.Dept_Number=@dept
        ) AND
    A.Job_number = F.Job_number
    )
END

GO
CREATE PROCEDURE cut_job_retrieve
  @end DATE,
  @dept int
AS
BEGIN
SELECT distinct F.*,A.Assembly_ID
from Cut_Job F, Assigned A 
where F.date_completion=@end and 
F.Job_number in
    (SELECT A.Job_number
    from Assigned A
    WHERE A.Process_ID in 
        (select P.Process_ID
        from Process P
        where P.Dept_Number=@dept
        )
    ) AND
A.Assembly_ID in 
    (SELECT A.Assembly_ID
    from Assigned A
    WHERE A.Process_ID in 
        (select P.Process_ID
        from Process P
        where P.Dept_Number=@dept
        ) AND
    A.Job_number = F.Job_number
    )
END


--Query 13
GO
CREATE PROCEDURE customer_retrieve
  @start int,
  @end int
AS
BEGIN
select *
from Customer
where Category >=@start and Category<=@end
order by Name
END

go
EXECUTE customer_retrieve @start=1, @end=5
select * from Customer
--Query 14
GO
CREATE PROCEDURE cut_job_deletion
  @start int,
  @end int
AS
BEGIN
delete from Cut_Job
where Job_number>=@start and Job_number<=@end
END

go
--EXECUTE cut_job_deletion @start=4, @end=7
select * from Cut_Job

--Query 15
GO
CREATE PROCEDURE color_change
  @col NVARCHAR(50),
  @num int
AS
BEGIN
update Paint_Job
set Color=@col
where Job_number=@num
END


GO
EXEC customer_entry @name = 'Naveen', @add = 'Norman', @cat = 1;
EXEC customer_entry @name = 'Taras', @add = 'Dallas', @cat = 3;
EXEC customer_entry @name = 'Ryan', @add = 'OKC', @cat = 5;
EXEC customer_entry @name = 'Jack', @add = 'Chicago', @cat = 8;
EXEC customer_entry @name = 'Bryan', @add = 'SFO', @cat = 6;
EXEC customer_entry @name = 'Akhil', @add = 'Norman', @cat = 8;

GO
EXEC department_entry @num = 101, @data = 'Soldering';
EXEC department_entry @num = 201, @data = 'Smelting';
EXEC department_entry @num = 301, @data = 'Forging';
EXEC department_entry @num = 401, @data = 'Artistic';
EXEC department_entry @num = 501, @data = 'Hydraulic';
EXEC department_entry @num = 601, @data = 'Repairs';

GO
EXEC assembly_entry @id = 'A1', @date='1-AUG-17', @details='Ordered a big assembly',
     @name='Naveen'
EXEC assembly_entry @id = 'A2', @date='1-June-18', @details='To get car doors',
     @name='Taras'
EXEC assembly_entry @id='A3', @date='08-01-18', @details='Smelting unit',
      @name='Akhil'


GO
EXEC account_entry @num=1001, @date='1-Aug-17'
EXEC account_entry @num=1002, @date='1-Oct-17'
EXEC account_entry @num=1003, @date='1-Nov-17'
EXEC account_entry @num=1004, @date='12-1-17'
EXEC account_entry @num=1005, @date='01-01-18'
EXEC account_entry @num=1006, @date='02-01-18'
EXEC account_entry @num=1007, @date='03-01-18'
EXEC account_entry @num=1008, @date='04-01-18'
EXEC account_entry @num=1009, @date='05-01-18'


GO
EXEC assembly_account_entry @num=1001, @cost=50, @a_id='A1'
EXEC assembly_account_entry @num=1005, @cost=35, @a_id='A2'
EXEC assembly_account_entry @num=1008, @cost=65, @a_id='A3'
EXEC department_account_entry @num=1002, @cost=10,@d_num=101
EXEC department_account_entry @num=1006, @cost=10,@d_num=201
EXEC department_account_entry @num=1007, @cost=10,@d_num=301
EXEC process_account_entry @num=1003, @cost=25, @p_ID='P1'
EXEC process_account_entry @num=1004, @cost=15, @p_ID='P2'
EXEC process_account_entry @num=1009, @cost=45, @p_ID='P3'


GO
EXEC job_entry @num=1,@date='1-Oct-2018',@a_id='A2',@p_id='P1'
EXEC job_entry @num=2,@date='1-Nov-2018',@a_id='A2',@p_id='P2'
EXEC job_entry @num=3,@date='1-Dec-2018',@a_id='A1',@p_id='P2'
EXEC job_entry @num=4,@date='01-01-2019',@a_id='A1',@p_id='P1'
EXEC job_entry @num=5,@date='02-01-2019',@a_id='A3',@p_id='P3'
EXEC job_entry @num=6,@date='03-01-2019',@a_id='A3',@p_id='P1'
EXEC job_entry @num=7,@date='03-01-2019',@a_id='A3',@p_id='P2'
EXEC job_entry @num=8,@date='04-01-2019',@a_id='A1',@p_id='P3'

GO
EXEC fit_job_completion @num=1,@l_time='1:30',@date='1-Jan-2019'
EXEC fit_job_completion @num=5,@l_time='2:30',@date='1-Feb-2019'
EXEC paint_job_completion @num=2,@col='Black',
    @vol=50,@l_time='2:30',@date='1-Feb-2019'
EXEC paint_job_completion @num=6,@col='Yellow',
    @vol=50,@l_time='4:00',@date='04-01-2019'
EXEC paint_job_completion @num=8,@col='Red',
    @vol=30,@l_time='2:00',@date='05-01-2019'
EXEC cut_job_completion @num=3,@typ='Cutter',
    @a_time='2:50',@mat='iron sheet',@l_time='2:30',@date='2-March-2019'
EXEC cut_job_completion @num=4,@typ='Cutting bumpers',@a_time="1:30",
    @mat='Coated steel',@l_time='3:00',@date='04-01-2019'
EXEC cut_job_completion @num=7,@typ='Cutting tyres',@a_time="2:30",
    @mat='Vulcanized Rubber',@l_time='2:50',@date='05-01-2019'


GO
EXEC cost_transaction_record_entry @t_num=1, @s_cost=10, @j_num=1
EXEC cost_transaction_record_entry @t_num=2, @s_cost=20, @j_num=2
EXEC cost_transaction_record_entry @t_num=3, @s_cost=15, @j_num=3

Go 
EXEC retrieve_process @a_id='A2'

GO
EXECUTE updates_entry @t_num='1'
EXECUTE updates_entry @t_num='2'
EXECUTE updates_entry @t_num='3'

Go 
EXECUTE cost_assembly_retrieve @a_id='A2'

GO
EXECUTE labor_time_retrieve @end='2019-02-01',@dept=201


GO
EXECUTE fit_job_retrieve @end='2019-01-01',@dept=101
EXECUTE paint_job_retrieve @end='2019-02-01',@dept=201
EXECUTE cut_job_retrieve @end='2019-03-02', @dept= 201

go
EXECUTE color_change @col='Green', @num=2
select * from Paint_Job
