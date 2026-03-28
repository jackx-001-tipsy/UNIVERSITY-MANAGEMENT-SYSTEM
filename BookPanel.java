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
import controller.BookController;

public class BookPanel extends JPanel {

    private BookController bookController;
    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField isbnField, titleField, editionField, versionField, yearField, copiesField;

    public BookPanel() {
        bookController = new BookController();
        
        setLayout(new BorderLayout(10, 10));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Fill Book Info"));

        isbnField = new JTextField();
        titleField = new JTextField();
        editionField = new JTextField();
        versionField = new JTextField();
        yearField = new JTextField();
        copiesField = new JTextField();

        inputPanel.add(new JLabel("ISBN:"));
        inputPanel.add(isbnField);

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Edition:"));
        inputPanel.add(editionField);

        inputPanel.add(new JLabel("Version:"));
        inputPanel.add(versionField);

        inputPanel.add(new JLabel("Year Published:"));
        inputPanel.add(yearField);

        inputPanel.add(new JLabel("Total Copies:"));
        inputPanel.add(copiesField);

        add(inputPanel, BorderLayout.NORTH);

       
        tableModel = new DefaultTableModel(
                new String[]{"ISBN", "Title", "Edition", "Version", "Year", "Copies"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Book");
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

        
        addButton.addActionListener(e -> {
            try {
                String isbn = isbnField.getText();
                String title = titleField.getText();
                String edition = editionField.getText();
                String version = versionField.getText();
                String yearText = yearField.getText();
                String copiesText = copiesField.getText();

                
                if (isbn.isEmpty() || title.isEmpty() || edition.isEmpty() ||
                    version.isEmpty() || yearText.isEmpty() || copiesText.isEmpty()) {

                    JOptionPane.showMessageDialog(this, "All fields are required!");
                    return;
                }

                int year = Integer.parseInt(yearText);
                int copies = Integer.parseInt(copiesText);

                
                bookController.addBook(isbn, title, edition, version, year, copies);

                
                tableModel.addRow(new Object[]{isbn, title, edition, version, year, copies});

                
                isbnField.setText("");
                titleField.setText("");
                editionField.setText("");
                versionField.setText("");
                yearField.setText("");
                copiesField.setText("");

                JOptionPane.showMessageDialog(this, "Book added successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Year and Copies must be numbers!");
            }
        });
    }
}