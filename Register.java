import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;

class Register extends JFrame implements ActionListener {
    JButton submitButton;
    JPanel panel;
    JLabel headingLabel, empIdLabel, nameLabel, deptLabel, phoneLabel, dobLabel, addressLabel, usernameLabel, passwordLabel, confirmPasswordLabel;
    JTextField empIdField, nameField, phoneField, addressField, usernameField;
    JPasswordField passwordField, confirmPasswordField;
    JComboBox<String> deptComboBox;
    Image backgroundImage;

    // Font Styles and Sizes
    Font labelFont = new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20);
    Font headingFont = new Font("Franklin Gothic Demi Cond", Font.BOLD, 35);

    public Register() {
        try {
            backgroundImage = ImageIO.read(new File("Employee/src/Coffee.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create heading label
        headingLabel = new JLabel("Employee Registration");
        headingLabel.setFont(headingFont);
        headingLabel.setForeground(Color.WHITE);

        // Create other labels
        empIdLabel = new JLabel("Employee ID:");
        empIdLabel.setFont(labelFont);
        empIdLabel.setForeground(Color.WHITE);

        nameLabel = new JLabel("Employee Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.WHITE);

        deptLabel = new JLabel("Department:");
        deptLabel.setFont(labelFont);
        deptLabel.setForeground(Color.WHITE);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(labelFont);
        phoneLabel.setForeground(Color.WHITE);

        addressLabel = new JLabel("Address:");
        addressLabel.setFont(labelFont);
        addressLabel.setForeground(Color.WHITE);

        // Create new labels for username, password, and confirm password
        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(Color.WHITE);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(Color.WHITE);

        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(labelFont);
        confirmPasswordLabel.setForeground(Color.WHITE);

        // Create input fields
        empIdField = new JTextField(15);
        nameField = new JTextField(15);
        phoneField = new JTextField(15);
        addressField = new JTextField(15);
        usernameField = new JTextField(15);

        // Create password fields
        passwordField = new JPasswordField(15);
        confirmPasswordField = new JPasswordField(15);

        // Department combo box
        deptComboBox = new JComboBox<>(new String[] {"HR", "Engineering", "Sales", "Finance", "Marketing"});

        // Create Submit button
        submitButton = new JButton("Submit");
        submitButton.setFont(labelFont);
        submitButton.setForeground(Color.BLACK);
        submitButton.setBackground(Color.WHITE);

        // Create panel and set GridBagLayout
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Add components to the panel with GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(headingLabel, gbc);

        gbc.gridwidth = 1; // Reset gridwidth for other components

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(empIdLabel, gbc);
        gbc.gridx = 1;
        panel.add(empIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(deptLabel, gbc);
        gbc.gridx = 1;
        panel.add(deptComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        panel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(addressLabel, gbc);
        gbc.gridx = 1;
        panel.add(addressField, gbc);

        // Adding new username, password, and confirm password fields
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(confirmPasswordLabel, gbc);
        gbc.gridx = 1;
        panel.add(confirmPasswordField, gbc);

        // Submit button at the bottom
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(submitButton, gbc);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);

        // Set frame properties
        setTitle("Employee Registration");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the input values
        String empId = empIdField.getText();
        String name = nameField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String dept = (String) deptComboBox.getSelectedItem();
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        char[] confirmPassword = confirmPasswordField.getPassword();

        // Convert char[] to String for comparison
        String passwordStr = new String(password);
        String confirmPasswordStr = new String(confirmPassword);

        // Check if any field is empty
        if (empId.isEmpty() || name.isEmpty() || phone.isEmpty() || address.isEmpty() || username.isEmpty() || passwordStr.isEmpty() || confirmPasswordStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!passwordStr.equals(confirmPasswordStr)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Display the input details in a confirmation dialog
            String message = "Employee ID: " + empId + "\n" +
                             "Name: " + name + "\n" +
                             "Phone: " + phone + "\n" +
                             "Department: " + dept + "\n" +
                             "Address: " + address + "\n" +
                             "Username: " + username;

            int confirm = JOptionPane.showConfirmDialog(this, message, "Confirm Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

            // If the user clicks OK
            if (confirm == JOptionPane.OK_OPTION) {
                Registration registration = new Registration(username, confirmPasswordStr, empId,name,dept,phone,address);
                registration.register();
                JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                CreateLoginForm loginForm = new CreateLoginForm();
                loginForm.showPage();
                setVisible(false);
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Register().setVisible(true);
        });
    }
}
