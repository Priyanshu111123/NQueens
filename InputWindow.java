import javax.swing.*;

public class InputWindow extends JFrame {
    private JTextField textField;
    private JButton submitButton;

    public InputWindow() {
        super("Enter the value of n");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        textField = new JTextField(10);
        submitButton = new JButton("Submit");
        panel.add(new JLabel("Enter value of n:"));
        panel.add(textField);
        panel.add(submitButton);
        add(panel);

        submitButton.addActionListener(e -> {
            try {
                int n = Integer.parseInt(textField.getText());
                N_Queens.setN(n); // Set the value of n in N_Queens class
                setVisible(false); // Hide the input window
                N_Queens.startApplication(); // Start the main application
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            }
        });

        setVisible(true);
    }
}