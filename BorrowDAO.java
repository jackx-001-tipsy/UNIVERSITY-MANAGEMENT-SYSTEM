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

public class BorrowDAO {

    public boolean addBorrow(String regNo, String isbn, String borrowDate, String returnDate) {

        String check = "SELECT * FROM Borrow WHERE regNo = ? AND isbn = ? AND returnDate IS NULL";
        String insert = "INSERT INTO Borrow(regNo, isbn, borrowDate, returnDate) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {

            
            try (PreparedStatement pst = conn.prepareStatement(check)) {
                pst.setString(1, regNo);
                pst.setString(2, isbn);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) return false;
            }

        
            try (PreparedStatement pst = conn.prepareStatement(insert)) {
                pst.setString(1, regNo);
                pst.setString(2, isbn);
                pst.setString(3, borrowDate);
                pst.setString(4, returnDate);

                pst.executeUpdate();
            }

            return true;

        } catch (SQLException e) {
            System.err.println("Error borrowing book: " + e.getMessage());
            return false;
        }
    }
}