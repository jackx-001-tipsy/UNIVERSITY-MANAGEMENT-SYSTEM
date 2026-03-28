
DROP DATABASE IF EXISTS UniversitySystemDB;
CREATE DATABASE UniversitySystemDB;


USE UniversitySystemDB;

CREATE TABLE Student (
    regNo VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50),
    programme VARCHAR(50)
);

CREATE TABLE Lecturer (
    lecturerID VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50)
);


CREATE TABLE Course (
    courseCode VARCHAR(10) PRIMARY KEY,
    courseName VARCHAR(50),
    lecturerID VARCHAR(10),
    FOREIGN KEY (lecturerID) REFERENCES Lecturer(lecturerID)
);


CREATE TABLE Score (
    regNo VARCHAR(10),
    courseCode VARCHAR(10),
    cat INT,
    exam INT,
    PRIMARY KEY (regNo, courseCode),
    FOREIGN KEY (regNo) REFERENCES Student(regNo),
    FOREIGN KEY (courseCode) REFERENCES Course(courseCode)
);


CREATE TABLE Book (
    ISBN VARCHAR(20) PRIMARY KEY,
    title VARCHAR(100),
    edition VARCHAR(20),
    version VARCHAR(20),
    yearPublished INT,
    totalCopies INT
);

CREATE TABLE Borrow (
    regNo VARCHAR(10),
    ISBN VARCHAR(20),
    borrowDate DATE,
    dueDate DATE,
    returnDate DATE,
    PRIMARY KEY (regNo, ISBN),
    FOREIGN KEY (regNo) REFERENCES Student(regNo),
    FOREIGN KEY (ISBN) REFERENCES Book(ISBN)
);

CREATE TABLE Reservation (
    regNo VARCHAR(10),
    ISBN VARCHAR(20),
    reserveDate DATE,
    PRIMARY KEY (regNo, ISBN),
    FOREIGN KEY (regNo) REFERENCES Student(regNo),
    FOREIGN KEY (ISBN) REFERENCES Book(ISBN)
);