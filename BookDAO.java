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

public class BookDAO {

    public boolean addBook(String ISBN, String title, String edition, String version, int year, int totalCopies) {
        String check = "SELECT ISBN FROM Book WHERE ISBN = ?";
        String insert = "INSERT INTO Book(ISBN, title, edition, version, yearPublished, totalCopies) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection()) {

            try (PreparedStatement pst = conn.prepareStatement(check)) {
                pst.setString(1, ISBN);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) return false;
            }

            try (PreparedStatement pst = conn.prepareStatement(insert)) {
                pst.setString(1, ISBN);
                pst.setString(2, title);
                pst.setString(3, edition);
                pst.setString(4, version);
                pst.setInt(5, year);
                pst.setInt(6, totalCopies);
                pst.executeUpdate();
            }

            return true;

        } catch (SQLException e) {
            System.err.println("Error adding book: " + e.getMessage());
            return false;
        }
    }
}
