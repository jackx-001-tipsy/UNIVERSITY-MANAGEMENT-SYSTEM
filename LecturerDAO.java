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
import database.DBConnection;

public class LecturerDAO {

    public boolean addLecturer(String lecturerID, String name, String dept) {
        String check = "SELECT lecturerID FROM Lecturer WHERE lecturerID = ?";
        String insert = "INSERT INTO Lecturer(lecturerID, name, department) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection()) {

            try (PreparedStatement pst = conn.prepareStatement(check)) {
                pst.setString(1, lecturerID);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) return false; // already exists
            }

            try (PreparedStatement pst = conn.prepareStatement(insert)) {
                pst.setString(1, lecturerID);
                pst.setString(2, name);
                pst.setString(3, dept);
                pst.executeUpdate();
            }

            return true;

        } catch (SQLException e) {
            System.err.println("Error adding lecturer: " + e.getMessage());
            return false;
        }
    }
}