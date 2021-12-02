import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("MV Boli", Font.BOLD, 25);
    double num1, num2, result = 0;
    char operator;

    Calculator() {
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBounds(0, 0, 410, 530);
        label.setBackground(Color.black);

        frame = new JFrame("CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(410, 530));
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(true);
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.yellow);
        textField.setForeground(Color.yellow);

        addButton = new JButton("+");
        addButton.setForeground(Color.yellow);
        addButton.setBackground(Color.black);
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);

        subButton = new JButton("-");
        subButton.setForeground(Color.yellow);
        subButton.setBackground(Color.black);
        subButton.setOpaque(true);
        subButton.setBorderPainted(false);

        mulButton = new JButton("*");
        mulButton.setForeground(Color.yellow);
        mulButton.setBackground(Color.black);
        mulButton.setOpaque(true);
        mulButton.setBorderPainted(false);

        divButton = new JButton("/");
        divButton.setForeground(Color.yellow);
        divButton.setBackground(Color.black);
        divButton.setOpaque(true);
        divButton.setBorderPainted(false);

        decButton = new JButton(".");
        decButton.setForeground(Color.yellow);
        decButton.setBackground(Color.black);
        decButton.setOpaque(true);
        decButton.setBorderPainted(false);

        equButton = new JButton("=");
        equButton.setForeground(Color.yellow);
        equButton.setBackground(Color.black);
        equButton.setOpaque(true);
        equButton.setBorderPainted(false);

        delButton = new JButton("DEL");
        delButton.setForeground(Color.yellow);
        delButton.setBackground(Color.black);
        delButton.setOpaque(true);
        delButton.setBorderPainted(false);

        clrButton = new JButton("CLEAR");
        clrButton.setForeground(Color.yellow);
        clrButton.setBackground(Color.black);
        clrButton.setOpaque(true);
        clrButton.setBorderPainted(false);

        negButton = new JButton("(-)");
        negButton.setForeground(Color.yellow);
        negButton.setBackground(Color.black);
        negButton.setOpaque(true);
        negButton.setBorderPainted(false);

        functions[0] = addButton;
        functions[1] = subButton;
        functions[2] = mulButton;
        functions[3] = divButton;
        functions[4] = decButton;
        functions[5] = equButton;
        functions[6] = delButton;
        functions[7] = clrButton;
        functions[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functions[i].addActionListener(this);
            functions[i].setFont(myFont);
            functions[i].setFocusable(false);//gets rid of outline of button
        }

        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
            numbers[i].setFocusable(false);
            numbers[i].setForeground(Color.yellow);
            numbers[i].setBackground(Color.black);
            numbers[i].setOpaque(true);
            numbers[i].setBorderPainted(false);
        }

        negButton.setBounds(25, 430, 85, 50);
        delButton.setBounds(120, 430, 100, 50);
        clrButton.setBounds(230, 430, 150, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.black);

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addButton);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subButton);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numbers[0]);
        panel.add(equButton);
        panel.add(divButton);

        label.add(panel);
        label.add(negButton);
        label.add(clrButton);
        label.add(delButton);
        label.add(textField);
        frame.add(label);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < 10; i++) {
            if (event.getSource() == numbers[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (event.getSource() == decButton) {
            textField.setText(textField.getText().concat(String.valueOf(".")));
        }

        if (event.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (event.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (event.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (event.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (event.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (event.getSource() == clrButton) {
            textField.setText("");
        }

        if (event.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        if (event.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
