/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author shafco
 */

import database.CourseDAO;
import java.util.List;
import model.Course;

public class CourseController {

    private CourseDAO courseDAO;

    public CourseController() {
        courseDAO = new CourseDAO();
    }

    
    public boolean addCourse(String courseCode, String courseName, String lecturerID) {
        return courseDAO.addCourse(courseCode, courseName, lecturerID);
    }

    
    public void addCourses(String[] courseCodes, String[] courseNames, String[] lecturerIDs) {
        courseDAO.addCourses(courseCodes, courseNames, lecturerIDs);
    }

    public String getCourseName(String courseCode) {
        return courseDAO.getCourseName(courseCode);
    }

    public List<String> getAllCourseCodes() {
        return courseDAO.getAllCourseCodes();
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }
}