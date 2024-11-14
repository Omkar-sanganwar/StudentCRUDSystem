# StudentCRUDSystem

## Overview
StudentCRUDSystem is a Java-based console application that provides CRUD (Create, Read, Update, Delete) functionality for managing student records. This system utilizes JDBC for database interactions and follows a layered architecture with entity, service, DAO, controller, and client layers. The project is built with Maven for dependency management.

## Project Structure
The project follows a structured Java package format:
- **com.tka.client**: Contains the main class to run the application.
- **com.tka.controller**: Manages user input and displays the menu for CRUD operations.
- **com.tka.dao**: Handles direct database interactions using JDBC.
- **com.tka.entity**: Defines the `Student` entity class.
- **com.tka.service**: Contains the service class for business logic.
- **com.tka.utility**: Provides the `DBUtil` class for database connection.

## Technologies Used
- **Java**: Core programming language used for development.
- **JDBC**: Java Database Connectivity for database interaction.
- **MySQL**: Database management system used to store student data.
- **Maven**: Dependency management and build tool.

## Prerequisites
- **Java** 8 or higher
- **Maven** installed for project dependencies
- **MySQL** running on localhost (default port: `3307`)
- **MySQL Database and Table Setup**:
  - Database: `advjava193`
  - Table: `students` with columns `roll_no (int)`, `name (varchar)`, and `marks (int)`

## Database Setup
1. Start your MySQL server.
2. Create the database and table by running:
    ```sql
    CREATE DATABASE advjava193;
    USE advjava193;
    CREATE TABLE students (
        roll_no INT PRIMARY KEY,
        name VARCHAR(50),
        marks INT
    );
  

## Configuration
Database connection details are specified in `DBUtil.java`. Make sure the URL, username, and password match your MySQL setup:
```java
String url = "jdbc:mysql://localhost:3307/advjava193";
String user = "root";
String password = "root";


Features:-
1) Add Student: Adds a new student with roll number, name, and marks.
2) View Students: Displays a list of all students.
3) Update Student: Updates the name and marks of an existing student based on roll number.
4) Delete Student: Deletes a student record by roll number.
5) Exit: Exits the application.

Maven Dependencies:-
The pom.xml file includes dependencies for:
1) MySQL Connector: To connect Java to MySQL.
2) JUnit (Optional): For unit testing.

code:-
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>

 

