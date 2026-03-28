/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author shafco
 */


import database.ScoreDAO;

public class ScoreController {
    private ScoreDAO scoreDAO;

    public ScoreController() {
        scoreDAO = new ScoreDAO();
    }

    public void addScore(String regNo, String courseCode, int cat, int exam) {
        scoreDAO.addScore(regNo, courseCode, cat, exam);
    }
}