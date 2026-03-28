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

public class Borrow {
    private int borrowID;
    private String regNo;
    private String isbn;
    private Date borrowDate;
    private Date returnDate;

    public Borrow(int borrowID, String regNo, String isbn, Date borrowDate, Date returnDate) {
        this.borrowID = borrowID;
        this.regNo = regNo;
        this.isbn = isbn;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getBorrowID() { return borrowID; }
    public String getRegNo() { return regNo; }
    public String getIsbn() { return isbn; }
    public Date getBorrowDate() { return borrowDate; }
    public Date getReturnDate() { return returnDate; }
}
