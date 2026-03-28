University Management System
📖 Project Overview

This is a Java-based University Management System with a Swing GUI and MySQL database backend.
The system allows management of students, lecturers, courses, books, scores, borrowing, and reservations. It is designed to demonstrate full-stack database-driven Java applications using the MVC (Model-View-Controller) architecture.

The project is ideal for educational purposes, demonstrating how to combine Java GUI, database operations, and object-oriented programming.

src/app:
Contains MainApp.java, the entry point to launch the GUI.

src/gui:
All Swing GUI panels, one for each module: Student, Lecturer, Course, Book, Score, Borrow, Reservation, Person.
MainAppGUI.java contains the tabbed pane integrating all panels.

src/controller:
Handles business logic.
Calls DAOs to interact with the database.
Ensures GUI doesn’t directly talk to database.

src/database:
DBConnection.java: manages MySQL connection.
DAO classes: StudentDAO, LecturerDAO, etc., each responsible for CRUD operations on its table.

src/model:
Plain Java classes representing each table (Student, Course, Borrow, Reservation…).
Used to pass objects between controller, DAO, and GUI.

database:
SQL scripts to create database and tables.


I have also included the database code show how the tables in MySQL connect with DAO in java.
            Designed by JACKSON MUEMA
