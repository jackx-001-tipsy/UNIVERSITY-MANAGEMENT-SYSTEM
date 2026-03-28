/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shafco
 */


public class Student extends Person {
    private String programme;

    public Student(String regNo, String name, String programme) {
        super(regNo, name);
        this.programme = programme;
    }

    public String getProgramme() { return programme; }
}
