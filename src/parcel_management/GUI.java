package parcel_management;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private ParcelController controller;

    // Panels
    private JTextArea customerPanel;
    private JTextArea feePanel;
    private JTextArea processingPanel;
    private JTextArea parcelPanel;
    private JTextArea logPanel;

    public GUI(ParcelController controller) {
        this.controller = controller;

        // Create the main frame
        setTitle("Parcel Depot Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());

        // Left Column: Customer Panel and Fee Panel
        JPanel leftColumn = new JPanel(new GridLayout(2, 1));
        leftColumn.setPreferredSize(new Dimension(300, 600));
        customerPanel = new JTextArea("Customer Queue:\n");
        customerPanel.setEditable(false);
        feePanel = new JTextArea("Fees Collected:\n$0.00");
        feePanel.setEditable(false);
        leftColumn.add(new JScrollPane(customerPanel));
        leftColumn.add(new JScrollPane(feePanel));

        // Middle Column: Currently Processing Panel
        processingPanel = new JTextArea("Currently Processing:\n");
        processingPanel.setEditable(false);

        // Right Column: Parcel Panel and Log Panel
        JPanel rightColumn = new JPanel(new GridLayout(2, 1));
        rightColumn.setPreferredSize(new Dimension(300, 600));
        parcelPanel = new JTextArea("Uncollected Parcels:\n");
        parcelPanel.setEditable(false);
        logPanel = new JTextArea("Log:\n");
        logPanel.setEditable(false);
        rightColumn.add(new JScrollPane(parcelPanel));
        rightColumn.add(new JScrollPane(logPanel));

        // Bottom Panel: Buttons
        JPanel buttonPanel = new JPanel();
        JButton addCustomerButton = new JButton("Add Customer");
        JButton addParcelButton = new JButton("Add Parcel");
        JButton nextCustomerButton = new JButton("Next Customer");
        buttonPanel.add(addCustomerButton);
        buttonPanel.add(addParcelButton);
        buttonPanel.add(nextCustomerButton);

        // Add components to the frame
        add(leftColumn, BorderLayout.WEST);
        add(new JScrollPane(processingPanel), BorderLayout.CENTER);
        add(rightColumn, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event Listeners
        addCustomerButton.addActionListener(e -> handleAddCustomer());
        addParcelButton.addActionListener(e -> handleAddParcel());
        nextCustomerButton.addActionListener(e -> handleNextCustomer());

        // Show the frame
        setVisible(true);
    }

    private void handleAddCustomer() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Customer ID:"));
            String name = JOptionPane.showInputDialog(this, "Enter Customer Name:");
            String parcelId = JOptionPane.showInputDialog(this, "Enter Parcel ID:");
            controller.addCustomer(id, name, parcelId);
            updatePanels();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Customer ID must be a number.");
        }
    }

    private void handleAddParcel() {
        try {
            String id = JOptionPane.showInputDialog(this, "Enter Parcel ID:");
            double weight = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter Parcel Weight:"));
            double length = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter Parcel Length:"));
            double width = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter Parcel Width:"));
            double height = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter Parcel Height:"));
            String description = JOptionPane.showInputDialog(this, "Enter Description:");
            controller.addParcel(id, weight, length, width, height, description);
            updatePanels();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers for dimensions and weight.");
        }
    }

    private void handleNextCustomer() {
        String result = controller.processNextCustomer();
        processingPanel.setText("Currently Processing:\n" + result);
        updatePanels();
    }

    private void updatePanels() {
        customerPanel.setText(controller.getCustomerQueue());
        parcelPanel.setText(controller.getParcelList());
        feePanel.setText("Fees Collected:\n$" + controller.getTotalFeesCollected());
        logPanel.setText("Log:\n" + controller.getLog());
    }
}