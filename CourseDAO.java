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
import java.util.ArrayList;
import java.util.List;
import model.Course;

public class CourseDAO {

    private LecturerDAO lecturerDAO = new LecturerDAO();

   
    public boolean addCourse(String courseCode, String courseName, String lecturerID) {
        try (Connection conn = DBConnection.getConnection()) {

          
            lecturerDAO.addLecturer(lecturerID, "Unknown Lecturer", "Unknown Dept");

            
            String check = "SELECT courseCode FROM Course WHERE courseCode = ?";
            try (PreparedStatement pst = conn.prepareStatement(check)) {
                pst.setString(1, courseCode);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) return false; // already exists
            }

           
            String insert = "INSERT INTO Course(courseCode, courseName, lecturerID) VALUES (?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(insert)) {
                pst.setString(1, courseCode);
                pst.setString(2, courseName);
                pst.setString(3, lecturerID);
                pst.executeUpdate();
            }

            return true;

        } catch (SQLException e) {
            System.err.println("Error adding course: " + e.getMessage());
            return false;
        }
    }

   
    public void addCourses(String[] courseCodes, String[] courseNames, String[] lecturerIDs) {
        for (int i = 0; i < courseCodes.length; i++) {
            addCourse(courseCodes[i], courseNames[i], lecturerIDs[i]);
        }
    }

    
    public String getCourseName(String courseCode) {
        String sql = "SELECT courseName FROM Course WHERE courseCode = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, courseCode);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) return rs.getString("courseName");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   
    public List<String> getAllCourseCodes() {
        List<String> codes = new ArrayList<>();
        String sql = "SELECT courseCode FROM Course";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                codes.add(rs.getString("courseCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return codes;
    }

    
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Course";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Course c = new Course();
                c.setCourseCode(rs.getString("courseCode"));
                c.setCourseName(rs.getString("courseName"));
                c.setLecturerID(rs.getString("lecturerID"));
                courses.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}