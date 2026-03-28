/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shafco
 */

public class Score {
    private String regNo;
    private String courseCode;
    private int cat;
    private int exam;

    public Score(String regNo, String courseCode, int cat, int exam) {
        this.regNo = regNo;
        this.courseCode = courseCode;
        this.cat = cat;
        this.exam = exam;
    }

    public int getTotal() { return cat + exam; }

    public String getGrade() {
        int total = getTotal();
        if (total >= 70) return "A";
        else if (total >= 60) return "B";
        else if (total >= 50) return "C";
        else if (total >= 40) return "D";
        else return "F";
    }
}