/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author shafco
 */



import database.StudentDAO;
import java.util.List;

public class StudentController {
    private StudentDAO studentDAO;

    public StudentController() {
        studentDAO = new StudentDAO();
    }

    public void addStudent(String regNo, String name, String programme) {
        studentDAO.addStudent(regNo, name, programme);
    }

    public String getStudentName(String regNo) {
        return studentDAO.getStudentName(regNo);
    }

    public List<String> getAllRegNos() {
        return studentDAO.getAllRegNos();
    }
}