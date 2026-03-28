/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shafco
 */


public class Course {
    private String courseCode;
    private String courseName;
    private String lecturerID;

    
    public Course() { }

    
    public Course(String courseCode, String courseName, String lecturerID) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.lecturerID = lecturerID;
    }

    
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public String getLecturerID() { return lecturerID; }

  
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setLecturerID(String lecturerID) { this.lecturerID = lecturerID; }
}