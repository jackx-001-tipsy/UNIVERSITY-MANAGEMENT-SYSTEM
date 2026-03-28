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
import controller.StudentController;

public class StudentPanel extends JPanel {
    private StudentController studentController;
    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField idField, nameField, courseField;

    public StudentPanel() {
        studentController = new StudentController();
        setLayout(new BorderLayout(10, 10));

        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Fill Student Info"));

      
        idField = new JTextField();
        nameField = new JTextField();
        courseField = new JTextField();

        
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Course:"));
        inputPanel.add(courseField);

        add(inputPanel, BorderLayout.NORTH);

        
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Course"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

       
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Student");
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

       
        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String course = courseField.getText();

            
            studentController.addStudent(id, name, course);

         
            tableModel.addRow(new Object[]{id, name, course});

           
            idField.setText("");
            nameField.setText("");
            courseField.setText("");
        });
    }
}

