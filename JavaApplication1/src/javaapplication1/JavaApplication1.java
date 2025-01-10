package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaApplication1 {
    public static void main(String[] args) {
        // Create the Frame
        JFrame frame = new JFrame("Pizza Cafe");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        // Labels and Fields
        JLabel lblCustomerName = new JLabel("Customer Name");
        lblCustomerName.setBounds(20, 20, 120, 20);
        JTextField txtCustomerName = new JTextField();
        txtCustomerName.setBounds(150, 20, 120, 20);

        JLabel lblPizzaRate = new JLabel("Pizza rate");
        lblPizzaRate.setBounds(20, 50, 120, 20);
        JTextField txtPizzaRate = new JTextField();
        txtPizzaRate.setBounds(150, 50, 120, 20);
        txtPizzaRate.setEditable(false);

        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(20, 80, 120, 20);
        JTextField txtQuantity = new JTextField();
        txtQuantity.setBounds(150, 80, 120, 20);

        JLabel lblCostOfToppings = new JLabel("Cost of Toppings");
        lblCostOfToppings.setBounds(20, 110, 120, 20);
        JTextField txtCostOfToppings = new JTextField();
        txtCostOfToppings.setBounds(150, 110, 120, 20);
        txtCostOfToppings.setEditable(false);

        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setBounds(20, 140, 120, 20);
        JTextField txtAmount = new JTextField();
        txtAmount.setBounds(150, 140, 120, 20);
        txtAmount.setEditable(false);

        // Radio Buttons for Pizza Type
        JLabel lblPizzaType = new JLabel("Select Pizza Type");
        lblPizzaType.setBounds(300, 20, 120, 20);
        JRadioButton rbtnRegular = new JRadioButton("Regular");
        rbtnRegular.setBounds(300, 40, 80, 20);
        JRadioButton rbtnPan = new JRadioButton("Pan");
        rbtnPan.setBounds(300, 60, 80, 20);
        ButtonGroup pizzaTypeGroup = new ButtonGroup();
        pizzaTypeGroup.add(rbtnRegular);
        pizzaTypeGroup.add(rbtnPan);

        // Checkboxes for Toppings
        JLabel lblToppings = new JLabel("Select Toppings");
        lblToppings.setBounds(300, 90, 120, 20);
        JCheckBox chkCheese = new JCheckBox("Cheese");
        chkCheese.setBounds(300, 110, 80, 20);
        JCheckBox chkCapsicum = new JCheckBox("Capsicum");
        chkCapsicum.setBounds(300, 130, 80, 20);
        JCheckBox chkPepperoni = new JCheckBox("Pepperoni");
        chkPepperoni.setBounds(300, 150, 80, 20);

        // Buttons
        JButton btnCalculate = new JButton("CALCULATE");
        btnCalculate.setBounds(80, 200, 120, 30);

        JButton btnQuit = new JButton("QUIT");
        btnQuit.setBounds(220, 200, 80, 30);

        // Add components to frame
        frame.add(lblCustomerName);
        frame.add(txtCustomerName);
        frame.add(lblPizzaRate);
        frame.add(txtPizzaRate);
        frame.add(lblQuantity);
        frame.add(txtQuantity);
        frame.add(lblCostOfToppings);
        frame.add(txtCostOfToppings);
        frame.add(lblAmount);
        frame.add(txtAmount);

        frame.add(lblPizzaType);
        frame.add(rbtnRegular);
        frame.add(rbtnPan);

        frame.add(lblToppings);
        frame.add(chkCheese);
        frame.add(chkCapsicum);
        frame.add(chkPepperoni);

        frame.add(btnCalculate);
        frame.add(btnQuit);

        // Button Actions
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rate = 0;

                // Determine Pizza Rate
                if (rbtnRegular.isSelected()) {
                    rate = 60;
                } else if (rbtnPan.isSelected()) {
                    rate = 80;
                }
                txtPizzaRate.setText(String.valueOf(rate));

                // Calculate Cost of Toppings
                int toppingsCost = 0;
                if (chkCheese.isSelected()) toppingsCost += 10;
                if (chkCapsicum.isSelected()) toppingsCost += 10;
                if (chkPepperoni.isSelected()) toppingsCost += 10;
                txtCostOfToppings.setText(String.valueOf(toppingsCost));

                // Calculate Total Amount
                try {
                    int quantity = Integer.parseInt(txtQuantity.getText());
                    int totalAmount = (rate + toppingsCost) * quantity;
                    txtAmount.setText(String.valueOf(totalAmount));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid quantity!");
                }
            }
        });

        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the application
                System.exit(0);
            }
        });

        // Show the Frame
        frame.setVisible(true);
    }
}
