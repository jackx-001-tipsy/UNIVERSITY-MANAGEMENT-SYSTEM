/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author shafco
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.DBConnection;

public class PersonDAO {

    public void addPerson(String personID, String name, String role) {
        String sql = "INSERT INTO Person(personID, name, role) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, personID);
            pst.setString(2, name);
            pst.setString(3, role); 

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
