package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class Main {
public static class CalculatorGUI extends JFrame implements ActionListener {
    private static JTextField textField;
    // ... existing code ...

    static {
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(280, 40));
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
    }
    public JButton[] numberButtons;
    public JButton[] operatorButtons;
    public JButton equalsButton;
    public JButton deleteButton;
    public JButton clearButton;
    private JPanel panel;

    private double num1, num2, result;
    private String operator;


    public CalculatorGUI() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(280, 40));
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");

        equalsButton = new JButton("=");
        deleteButton = new JButton("DEL");
        clearButton = new JButton("C");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(operatorButtons[0]);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(operatorButtons[1]);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(operatorButtons[2]);

        panel.add(new JLabel()); // Placeholder for empty grid cell
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(operatorButtons[3]);

        panel.add(deleteButton);
        panel.add(clearButton);

        setLayout(new FlowLayout());
        add(textField);
        add(panel);

        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(this);
        }

        for (JButton operatorButton : operatorButtons) {
            operatorButton.addActionListener(this);
        }

        equalsButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getText();

        if (buttonText.matches("[0-9]")) {
            String currentText = textField.getText();
            textField.setText(currentText + buttonText);
        } else if (buttonText.equals(".")) {
            String currentText = textField.getText();
            if (!currentText.contains(".")) {
                textField.setText(currentText + buttonText);
            }
        } else if (buttonText.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(textField.getText());
            operator = buttonText;
            textField.setText("");
        } else if (buttonText.equals("=")) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: Cannot divide by zero");
                    }
                    break;
            }

            textField.setText(String.valueOf(result));
        } else if (buttonText.equals("DEL")) {
            String currentText = textField.getText();
            if (!currentText.isEmpty()) {
                textField.setText(currentText.substring(0, currentText.length() - 1));
            }
        } else if (buttonText.equals("C")) {
            textField.setText("");
        }
    }
    public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculator = new CalculatorGUI();
            calculator.setVisible(true);
        });
        JOptionPane.showMessageDialog(null, "Calculator started.");
    }
    }
}
