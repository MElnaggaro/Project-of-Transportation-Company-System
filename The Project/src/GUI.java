import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    // SSaGUI components
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton loginButton;
    private JCheckBox employeeCheckbox, passengerCheckbox;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JTextField UsernameField;
    private JPasswordField PasswordField;

    // Flag to track user type selection (initially not selected)
    private boolean isEmployeeSelected = false;
    private boolean isPassengerSelected = false;

    public GUI() {
        setTitle("tms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 1920);
        setLocationRelativeTo(null);
        setLayout(null);

        // Initialize SSaGUI elements
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        registerButton = new JButton("Register");
        loginButton = new JButton("Login"); // New login button
        employeeCheckbox = new JCheckBox("Employee");
        passengerCheckbox = new JCheckBox("Passenger");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        confirmPasswordLabel = new JLabel("Confirm Password:");
        UsernameLabel = new JLabel("Username:");
        PasswordLabel = new JLabel("Password:");
        UsernameField = new JTextField();
        PasswordField = new JPasswordField();


        // Set bounds for each element
        usernameLabel.setBounds(20, 120, 80, 20);
        usernameField.setBounds(100, 120, 180, 20);
        passwordLabel.setBounds(20, 150, 80, 20);
        passwordField.setBounds(100, 150, 180, 20);
        confirmPasswordLabel.setBounds(20, 180, 120, 20); // Extended the label width for better alignment
        confirmPasswordField.setBounds(140, 180, 140, 20); // Adjusted the text field position
        registerButton.setBounds(20, 250, 120, 20); // Reduced the width for better alignment
        loginButton.setBounds(800, 250, 120, 20); // Positioned login button below
        employeeCheckbox.setBounds(20, 220, 100, 20);
        passengerCheckbox.setBounds(120, 220, 100, 20);
        UsernameField.setBounds(800, 120, 180, 20);
        UsernameLabel.setBounds(730, 120, 80, 20);
        PasswordLabel.setBounds(730, 150, 80, 20);
        PasswordField.setBounds(800, 150, 180, 20);



        // Add elements to the frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(registerButton);
        add(loginButton); // Added login button
        add(employeeCheckbox);
        add(passengerCheckbox);
        add(UsernameLabel);
        add(UsernameField);
        add(PasswordLabel);
        add(PasswordField);

        // Initially disable username, password and confirm password fields
        usernameField.setEnabled(true);
        passwordField.setEnabled(true);
        confirmPasswordField.setEnabled(true);

        // Add action listener for buttons
        registerButton.addActionListener(this);
        loginButton.addActionListener(this); // Added ActionListener for login button
        employeeCheckbox.addActionListener(this);
        passengerCheckbox.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.loadFromFilePassenger();
        Main.loadFromFileEmployee();
        if (e.getSource() == employeeCheckbox) {
            isEmployeeSelected = employeeCheckbox.isSelected();
            isPassengerSelected = false;
            passengerCheckbox.setSelected(false); // Deselect passenger checkbox if employee is selected
        } else if (e.getSource() == passengerCheckbox) {
            isPassengerSelected = passengerCheckbox.isSelected();
            isEmployeeSelected = false;
            employeeCheckbox.setSelected(false); // Deselect employee checkbox if passenger is selected
        } else if (e.getSource() == registerButton) {
            if (!isEmployeeSelected && !isPassengerSelected) {

                ///

//                Main.saveToFileAssign();

                // Handle the case where no user type is selected
                // You can display an error message or disable the register button
                // until a user type is chosen.
                return;
            }

            // Handle Register button click based on selected user type (employee/passenger)
            usernameField.setEnabled(true);
            passwordField.setEnabled(true);
            confirmPasswordField.setEnabled(true);
        } else if (e.getSource() == loginButton) {

        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
