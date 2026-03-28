/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author shafco
 */


import java.sql.*;

public class ScoreDAO {
    private StudentDAO studentDAO = new StudentDAO();
    private CourseDAO courseDAO = new CourseDAO();

    public boolean addScore(String regNo, String courseCode, int cat, int exam) {
        try (Connection conn = DBConnection.getConnection()) {

            
            studentDAO.addStudent(regNo, "Unknown Student", "Unknown Programme");

          
            courseDAO.addCourse(courseCode, "Unknown Course", "L001"); 

            
            LecturerDAO lecturerDAO = new LecturerDAO();
            lecturerDAO.addLecturer("L001", "Unknown Lecturer", "Unknown Dept");

            
            String insert = "INSERT INTO Score(regNo, courseCode, cat, exam) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(insert)) {
                pst.setString(1, regNo);
                pst.setString(2, courseCode);
                pst.setInt(3, cat);
                pst.setInt(4, exam);
                pst.executeUpdate();
            }

            return true;

        } catch (SQLException e) {
            System.err.println("Error adding score: " + e.getMessage());
            return false;
        }
    }
}