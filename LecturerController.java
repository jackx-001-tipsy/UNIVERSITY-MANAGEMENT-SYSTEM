/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author shafco
 */


import database.LecturerDAO;

public class LecturerController {
    private LecturerDAO lecturerDAO;

    public LecturerController() {
        lecturerDAO = new LecturerDAO();
    }

    public void addLecturer(String lecturerID, String name, String department) {
        lecturerDAO.addLecturer(lecturerID, name, department);
    }
}
