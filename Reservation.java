/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shafco
 */

import java.util.Date;

public class Reservation {
    private int reservationID;
    private String regNo;
    private String isbn;
    private Date reservationDate;

    public Reservation(int reservationID, String regNo, String isbn, Date reservationDate) {
        this.reservationID = reservationID;
        this.regNo = regNo;
        this.isbn = isbn;
        this.reservationDate = reservationDate;
    }

    public int getReservationID() { return reservationID; }
    public String getRegNo() { return regNo; }
    public String getIsbn() { return isbn; }
    public Date getReservationDate() { return reservationDate; }
}