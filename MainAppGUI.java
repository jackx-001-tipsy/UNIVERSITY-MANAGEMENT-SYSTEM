/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author shafco
 */




import javax.swing.*;
import java.awt.*;

// Import all your panels
import gui.StudentPanel;
import gui.CoursePanel;
import gui.LecturerPanel;
import gui.BookPanel;
import gui.ScorePanel;
import gui.PersonPanel;
import gui.BorrowPanel;
import gui.ReservationPanel;

public class MainAppGUI extends JFrame {

    public MainAppGUI() {
        setTitle("University Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // 🔹 ADD ALL TABS
        tabbedPane.addTab("Student", safePanel(createPanel("StudentPanel")));
        tabbedPane.addTab("Course", safePanel(createPanel("CoursePanel")));
        tabbedPane.addTab("Lecturer", safePanel(createPanel("LecturerPanel")));
        tabbedPane.addTab("Book", safePanel(createPanel("BookPanel")));
        tabbedPane.addTab("Score", safePanel(createPanel("ScorePanel")));
        tabbedPane.addTab("Person", safePanel(createPanel("PersonPanel")));
        tabbedPane.addTab("Borrow", safePanel(createPanel("BorrowPanel")));
        tabbedPane.addTab("Reservation", safePanel(createPanel("ReservationPanel")));

        add(tabbedPane);
    }

    // 🔹 CREATE PANEL BASED ON NAME
    private JPanel createPanel(String panelName) {
        try {
            switch (panelName) {
                case "StudentPanel": return new StudentPanel();
                case "CoursePanel": return new CoursePanel();
                case "LecturerPanel": return new LecturerPanel();
                case "BookPanel": return new BookPanel();
                case "ScorePanel": return new ScorePanel();
                case "PersonPanel": return new PersonPanel();
                case "BorrowPanel": return new BorrowPanel();
                case "ReservationPanel": return new ReservationPanel();
                default: return placeholderPanel(panelName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return placeholderPanel(panelName);
        }
    }

    // 🔹 PLACEHOLDER PANEL
    private JPanel placeholderPanel(String name) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel("Panel \"" + name + "\" not implemented yet.", SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(lbl, BorderLayout.CENTER);
        return panel;
    }

    // 🔹 SAFE PANEL METHOD
    private JPanel safePanel(JPanel panel) {
        return panel;
    }
}