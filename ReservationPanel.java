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
import controller.ReservationController;

public class ReservationPanel extends JPanel {

    private ReservationController reservationController;
    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField regNoField, isbnField, dateField;

    public ReservationPanel() {
        reservationController = new ReservationController();

        setLayout(new BorderLayout(10, 10));

        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Reserve Book"));

        regNoField = new JTextField();
        isbnField = new JTextField();
        dateField = new JTextField();

        inputPanel.add(new JLabel("Student RegNo:"));
        inputPanel.add(regNoField);

        inputPanel.add(new JLabel("Book ISBN:"));
        inputPanel.add(isbnField);

        inputPanel.add(new JLabel("Reservation Date (YYYY-MM-DD):"));
        inputPanel.add(dateField);

        add(inputPanel, BorderLayout.NORTH);

      
        tableModel = new DefaultTableModel(
                new String[]{"RegNo", "ISBN", "Reservation Date"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Reserve Book");
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

       
        addButton.addActionListener(e -> {
            try {
                String regNo = regNoField.getText();
                String isbn = isbnField.getText();
                String date = dateField.getText();

              
                if (regNo.isEmpty() || isbn.isEmpty() || date.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields are required!");
                    return;
                }

                boolean success = reservationController.reserveBook(regNo, isbn, date);

                if (success) {
                    tableModel.addRow(new Object[]{regNo, isbn, date});

                    regNoField.setText("");
                    isbnField.setText("");
                    dateField.setText("");

                    JOptionPane.showMessageDialog(this, "Book reserved successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Reservation failed (already reserved or error)");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }
}

