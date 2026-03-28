/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shafco
 */

public class Lecturer extends Person {
    private String department;

    public Lecturer(String lecturerID, String name, String department) {
        super(lecturerID, name);
        this.department = department;
    }

    public String getDepartment() { return department; }
}
