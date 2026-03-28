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
import database.DBConnection;

public class StudentDAO {

  
    public void addStudent(String regNo, String name, String programme) {
        String sql = "INSERT INTO Student(regNo, name, programme) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, regNo);
            pst.setString(2, name);
            pst.setString(3, programme);

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getStudentName(String regNo) {
        String sql = "SELECT name FROM Student WHERE regNo = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, regNo);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<String> getAllRegNos() {
        List<String> regNos = new ArrayList<>();
        String sql = "SELECT regNo FROM Student";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                regNos.add(rs.getString("regNo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return regNos;
    }
}