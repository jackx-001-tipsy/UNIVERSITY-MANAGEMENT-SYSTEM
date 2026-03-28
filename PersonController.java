/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author shafco
 */


import database.PersonDAO;

public class PersonController {
    private PersonDAO personDAO;

    public PersonController() {
        personDAO = new PersonDAO();
    }

    public void addPerson(String personID, String name, String role) {
        personDAO.addPerson(personID, name, role);
    }
}
