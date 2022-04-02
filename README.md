# Car_Inspector
Demo application for a car garage
The Car_Inspector application is a practice exercise that could respond to the request of a Garage owner that needs a tool that gives the employees the possibility to record and track the evidence of the cars that were repaired or cleaned or whatever was the actions that was doing in the garage. 
All the PC’s that uses this application should be linked to the same server, were the database should be configured. The next queries should be used to define the database: 

-- Create Database 
CREATE DATABASE testDB;

-- Creaate Employees table ( contains the authorized persons to access CarInspector ) 
CREATE TABLE Employees (
    PersonID int Primary key,
    UserName varchar(255),
    UserPassword varchar(255),
    AccountStatus char(1),
    ConnectAttempts int(1),
    BlockingTime TIMESTAMP    
);

-- Creaate CarInspector table ( contains the client informations ) 
CREATE TABLE CarInspector (
    CarID int NOT NULL AUTO_INCREMENT Primary key,
    OwnerLastName varchar(255),
    OwnerFirstName varchar(255),
    OwnerAddress varchar(255),
    OwnerCarType varchar(255),
    TotalToPay DECIMAL(6,2),
    Payed DECIMAL(6,2),
    DateCre TIMESTAMP
);


The authorized employees to access this application should be added in the Employees table. 
For connecting to database, in the Functions.java file the next parameters should also be configured according to the database definition: 

String driver = "com.mysql.cj.jdbc.Driver";

String url = "jdbc:mysql://localhost:3306/testdb";

String username = "root";

String password = "mysql1";



