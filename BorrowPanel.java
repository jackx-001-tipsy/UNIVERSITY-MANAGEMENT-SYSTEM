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
import controller.BorrowController;

public class BorrowPanel extends JPanel {

    private BorrowController borrowController;
    private JTable table;
    private DefaultTableModel tableModel;

    private JTextField regNoField, isbnField, borrowDateField, returnDateField;

    public BorrowPanel() {
        borrowController = new BorrowController();

        setLayout(new BorderLayout(10, 10));

        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Borrow Book"));

        regNoField = new JTextField();
        isbnField = new JTextField();
        borrowDateField = new JTextField();
        returnDateField = new JTextField();

        inputPanel.add(new JLabel("Student RegNo:"));
        inputPanel.add(regNoField);

        inputPanel.add(new JLabel("Book ISBN:"));
        inputPanel.add(isbnField);

        inputPanel.add(new JLabel("Borrow Date (YYYY-MM-DD):"));
        inputPanel.add(borrowDateField);

        inputPanel.add(new JLabel("Return Date (YYYY-MM-DD):"));
        inputPanel.add(returnDateField);

        add(inputPanel, BorderLayout.NORTH);

       
        tableModel = new DefaultTableModel(
                new String[]{"RegNo", "ISBN", "Borrow Date", "Return Date"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

       
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Borrow Book");
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

        
        addButton.addActionListener(e -> {
            try {
                String regNo = regNoField.getText();
                String isbn = isbnField.getText();
                String borrowDate = borrowDateField.getText();
                String returnDate = returnDateField.getText();

                
                if (regNo.isEmpty() || isbn.isEmpty() || borrowDate.isEmpty() || returnDate.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields are required!");
                    return;
                }

                boolean success = borrowController.borrowBook(regNo, isbn, borrowDate, returnDate);

                if (success) {
                    tableModel.addRow(new Object[]{regNo, isbn, borrowDate, returnDate});

                    regNoField.setText("");
                    isbnField.setText("");
                    borrowDateField.setText("");
                    returnDateField.setText("");

                    JOptionPane.showMessageDialog(this, "Book borrowed successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Borrowing failed (already borrowed or error)");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }
}