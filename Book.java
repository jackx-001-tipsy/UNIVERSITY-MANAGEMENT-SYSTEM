/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shafco
 */

public class Book {
    private String ISNN, title;
    private int totalCopies;

    public Book(String ISNN, String title, int totalCopies) {
        this.ISNN = ISNN;
        this.title = title;
        this.totalCopies = totalCopies;
    }

    public String getISNN() { return ISNN; }
    public String getTitle() { return title; }
    public int getTotalCopies() { return totalCopies; }
}
