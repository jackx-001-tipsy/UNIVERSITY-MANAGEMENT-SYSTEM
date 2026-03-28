/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author shafco
 */


import database.ReservationDAO;

public class ReservationController {
    private ReservationDAO reservationDAO;

    public ReservationController() {
        reservationDAO = new ReservationDAO();
    }

    
    public boolean reserveBook(String regNo, String isbn, String reservationDate) {

        if (regNo == null || isbn == null || reservationDate.isEmpty()) {
            System.out.println("All fields are required!");
            return false;
        }

        return reservationDAO.addReservation(regNo, isbn, reservationDate);
    }
}