import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel inputLabel = new JLabel("Input:");
        inputLabel.setBounds(30, 20, 60, 25);
        panel.add(inputLabel);

        String[] options = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> input = new JComboBox<>(options);
        input.setBounds(90, 20, 150, 25);
        panel.add(input);

        JTextField inputField = new JTextField(10);
        inputField.setBounds(250, 20, 80, 25);
        panel.add(inputField);

        JLabel resultLabel = new JLabel("Output:");
        resultLabel.setBounds(30, 100, 60, 25);
        panel.add(resultLabel);

        JComboBox<String> output = new JComboBox<>(options);
        output.setBounds(90, 100, 150, 25);
        panel.add(output);

        JTextField resultField = new JTextField(10);
        resultField.setBounds(250, 100, 80, 25);
        resultField.setEditable(false);
        panel.add(resultField);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 150, 100, 25);
        panel.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputTemp = Double.parseDouble(inputField.getText());
                    String selectedInput = (String) input.getSelectedItem();
                    String selectedOutput = (String) output.getSelectedItem();
                    double x = switch (selectedInput) {
                        case "Celcius" -> 5;
                        case "Fahrenheit" -> 9;
                        case "Kelvin" -> 5;
                        default -> throw new IllegalStateException("Unexpected value: " + selectedInput);
                    };
                    double a = switch (selectedInput) {
                        case "Celcius" -> 0;
                        case "Fahrenheit" -> 32;
                        case "Kelvin" -> 273.15;
                        default -> throw new IllegalStateException("Unexpected value: " + selectedInput);
                    };
                    double y = switch (selectedOutput) {
                        case "Celcius" -> 5;
                        case "Fahrenheit" -> 9;
                        case "Kelvin" -> 5;
                        default -> throw new IllegalStateException("Unexpected value: " + selectedOutput);
                    };
                    double b = switch (selectedOutput) {
                        case "Celcius" -> 0;
                        case "Fahrenheit" -> 32;
                        case "Kelvin" -> 273.15;
                        default -> throw new IllegalStateException("Unexpected value: " + selectedOutput);
                    };

                    double convertedTemp = (inputTemp - a) / x * y + b;
                    resultField.setText(String.format("%.2f", convertedTemp));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
