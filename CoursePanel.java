/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author shafco
 */



import controller.CourseController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.Course;

public class CoursePanel extends JPanel {

    private CourseController courseController;
    private JTable table;
    private DefaultTableModel tableModel;

    private JComboBox<String> codeCombo; 
    private JTextField nameField, lecturerField;

    public CoursePanel() {
        courseController = new CourseController();
        setLayout(new BorderLayout(10, 10));

      
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Fill Course Info"));

        codeCombo = new JComboBox<>();
        codeCombo.setEditable(true); 
        nameField = new JTextField(10);
        lecturerField = new JTextField(10);

        inputPanel.add(new JLabel("Code:"));
        inputPanel.add(codeCombo);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Lecturer:"));
        inputPanel.add(lecturerField);

        add(inputPanel, BorderLayout.NORTH);

        
        tableModel = new DefaultTableModel(new String[]{"Code", "Name", "Lecturer"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

       
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Course");
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadCourses(); 

        
        addButton.addActionListener(e -> {
            String code = ((String) codeCombo.getEditor().getItem()).trim(); 
            String name = nameField.getText().trim();
            String lecturer = lecturerField.getText().trim();

            if (code.isEmpty() || name.isEmpty() || lecturer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            courseController.addCourse(code, name, lecturer);
            loadCourses(); 

            nameField.setText("");
            lecturerField.setText("");
        });
    }

    
    private void loadCourses() {
        tableModel.setRowCount(0);
        codeCombo.removeAllItems();

        List<Course> courses = courseController.getAllCourses();
        for (Course c : courses) {
            tableModel.addRow(new Object[]{c.getCourseCode(), c.getCourseName(), c.getLecturerID()});
            codeCombo.addItem(c.getCourseCode());
        }
    }
}