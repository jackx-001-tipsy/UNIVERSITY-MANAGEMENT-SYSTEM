/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author shafco
 */


import database.BookDAO;

public class BookController {
    private BookDAO bookDAO;

    public BookController() {
        bookDAO = new BookDAO();
    }

    public void addBook(String ISBN, String title, String edition, String version, int year, int totalCopies) {
        bookDAO.addBook(ISBN, title, edition, version, year, totalCopies);
    }
}
