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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import controller.ScoreController;
import controller.StudentController;
import controller.CourseController;
import java.util.List;

public class ScorePanel extends JPanel {

    private ScoreController scoreController;
    private JComboBox<String> cbStudent, cbCourse;
    private JTextField txtCAT, txtExam;

    private JTable table;
    private DefaultTableModel tableModel;

    public ScorePanel() {
        scoreController = new ScoreController();
        setLayout(new BorderLayout(10, 10));

        
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Score Details"));

        cbStudent = new JComboBox<>();
        cbStudent.setEditable(true); 
        cbCourse = new JComboBox<>();
        cbCourse.setEditable(true); 

        txtCAT = new JTextField();
        txtExam = new JTextField();

        inputPanel.add(new JLabel("Student RegNo:"));
        inputPanel.add(cbStudent);

        inputPanel.add(new JLabel("Course Code:"));
        inputPanel.add(cbCourse);

        inputPanel.add(new JLabel("CAT (Max 30):"));
        inputPanel.add(txtCAT);

        inputPanel.add(new JLabel("Exam (Max 70):"));
        inputPanel.add(txtExam);

        add(inputPanel, BorderLayout.NORTH);

        
        tableModel = new DefaultTableModel(
                new String[]{"RegNo", "Course", "CAT", "Exam", "Total"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

       
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Add Score");
        buttonPanel.add(btnAdd);
        add(buttonPanel, BorderLayout.SOUTH);

        
        loadStudents();
        loadCourses();

        
        btnAdd.addActionListener(e -> {
            try {
                String regNo = ((String) cbStudent.getEditor().getItem()).trim();
                String courseCode = ((String) cbCourse.getEditor().getItem()).trim();

                if (regNo.isEmpty() || courseCode.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter/select student and course!");
                    return;
                }

                int cat = Integer.parseInt(txtCAT.getText());
                int exam = Integer.parseInt(txtExam.getText());

                if (cat < 0 || cat > 30 || exam < 0 || exam > 70) {
                    JOptionPane.showMessageDialog(this, "Invalid marks! CAT ≤ 30, Exam ≤ 70");
                    return;
                }

               
                scoreController.addScore(regNo, courseCode, cat, exam);

                int total = cat + exam;

                
                tableModel.addRow(new Object[]{regNo, courseCode, cat, exam, total});

              
                txtCAT.setText("");
                txtExam.setText("");

                JOptionPane.showMessageDialog(this, "Score added successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid numbers for CAT and Exam!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }

    
    private void loadStudents() {
        try {
            StudentController sc = new StudentController();
            List<String> students = sc.getAllRegNos();

            cbStudent.removeAllItems();
            for (String s : students) {
                cbStudent.addItem(s);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load students!");
        }
    }

 
    private void loadCourses() {
        try {
            CourseController cc = new CourseController();
            List<String> courses = cc.getAllCourseCodes();

            cbCourse.removeAllItems();
            for (String c : courses) {
                cbCourse.addItem(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load courses!");
        }
    }
}