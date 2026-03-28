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
import controller.PersonController;

public class PersonPanel extends JPanel {

    private PersonController personController;
    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField idField, nameField;
    private JComboBox<String> roleBox;

    public PersonPanel() {
        personController = new PersonController();
        setLayout(new BorderLayout(10, 10));

        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Fill Person Info"));

        idField = new JTextField();
        nameField = new JTextField();

        roleBox = new JComboBox<>();
        roleBox.addItem("Student");
        roleBox.addItem("Lecturer");

        inputPanel.add(new JLabel("Person ID:"));
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Role:"));
        inputPanel.add(roleBox);

        add(inputPanel, BorderLayout.NORTH);

        
        tableModel = new DefaultTableModel(
                new String[]{"ID", "Name", "Role"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Person");
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

        
        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String role = (String) roleBox.getSelectedItem();

            
            if (id.isEmpty() || name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!");
                return;
            }

            
            personController.addPerson(id, name, role);

            
            tableModel.addRow(new Object[]{id, name, role});

           
            idField.setText("");
            nameField.setText("");

            JOptionPane.showMessageDialog(this, "Person added successfully!");
        });
    }
}