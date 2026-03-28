/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author shafco
 */


import database.BorrowDAO;

public class BorrowController {

    private BorrowDAO borrowDAO;

    public BorrowController() {
        borrowDAO = new BorrowDAO();
    }

    public boolean borrowBook(String regNo, String isbn, String borrowDate, String returnDate) {

        if (regNo == null || isbn == null || borrowDate.isEmpty() || returnDate.isEmpty()) {
            System.out.println("All fields are required!");
            return false;
        }

        return borrowDAO.addBorrow(regNo, isbn, borrowDate, returnDate);
    }
}