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
import controller.LecturerController;

public class LecturerPanel extends JPanel {

    private LecturerController lecturerController;
    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField idField, nameField, deptField;

    public LecturerPanel() {
        lecturerController = new LecturerController();
        setLayout(new BorderLayout(10, 10));

        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Fill Lecturer Info"));

        idField = new JTextField();
        nameField = new JTextField();
        deptField = new JTextField();

        inputPanel.add(new JLabel("Lecturer ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Department:"));
        inputPanel.add(deptField);

        add(inputPanel, BorderLayout.NORTH);

        
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Department"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Lecturer");
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

        
        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String dept = deptField.getText();

            
            if (id.isEmpty() || name.isEmpty() || dept.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!");
                return;
            }

            
            lecturerController.addLecturer(id, name, dept);

          
            tableModel.addRow(new Object[]{id, name, dept});

            
            idField.setText("");
            nameField.setText("");
            deptField.setText("");

            JOptionPane.showMessageDialog(this, "Lecturer added successfully!");
        });
    }
}