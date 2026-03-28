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

public class ReservationDAO {

    public boolean addReservation(String regNo, String isbn, String reserveDate) {

        String check = "SELECT * FROM Reservation WHERE regNo = ? AND isbn = ?";
        String insert = "INSERT INTO Reservation(regNo, isbn, reserveDate) VALUES (?, ?, ?)";

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
                pst.setString(3, reserveDate);

                pst.executeUpdate();
            }

            return true;

        } catch (SQLException e) {
            System.err.println("Error reserving book: " + e.getMessage());
            return false;
        }
    }
}