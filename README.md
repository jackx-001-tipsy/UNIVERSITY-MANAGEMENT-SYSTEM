University Management System
📖 Project Overview

This is a Java-based University Management System with a Swing GUI and MySQL database backend.
The system allows management of students, lecturers, courses, books, scores, borrowing, and reservations. It is designed to demonstrate full-stack database-driven Java applications using the MVC (Model-View-Controller) architecture.

The project is ideal for educational purposes, demonstrating how to combine Java GUI, database operations, and object-oriented programming.
PROJECT STRUCTURE:
UniversityManagementSystem/
│
├── src/
│   ├── app/
│   │   └── MainApp.java                  
│   │
│   ├── gui/                               
│   │   ├── MainAppGUI.java
│   │   ├── StudentPanel.java
│   │   ├── LecturerPanel.java
│   │   ├── CoursePanel.java
│   │   ├── BookPanel.java
│   │   ├── ScorePanel.java
│   │   ├── BorrowPanel.java
│   │   ├── ReservationPanel.java
│   │   └── PersonPanel.java
│   │
│   ├── controller/                        
│   │   ├── StudentController.java
│   │   ├── LecturerController.java
│   │   ├── CourseController.java
│   │   ├── BookController.java
│   │   ├── ScoreController.java
│   │   ├── BorrowController.java
│   │   └── ReservationController.java
│   │
│   ├── database/                          
│   │   ├── DBConnection.java
│   │   ├── StudentDAO.java
│   │   ├── LecturerDAO.java
│   │   ├── CourseDAO.java
│   │   ├── BookDAO.java
│   │   ├── ScoreDAO.java
│   │   ├── BorrowDAO.java
│   │   └── ReservationDAO.java
│   │
│   └── model/                            
│       ├── Student.java
│       ├── Lecturer.java
│       ├── Course.java
│       ├── Book.java
│       ├── Score.java
│       ├── Borrow.java
│       └── Reservation.java
│
├── database/                         
│   └── UniversitySystemDB.sql  




















I have also included the database code show how the tables in MySQL connect with DAO in java.
            Designed by JACKSON MUEMA
