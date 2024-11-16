import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;

class CreateLoginForm extends JFrame implements ActionListener {
    // Creating Objects
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel, headingLabel;
    final JTextField textField1, textField2;
    JFrame frame;
    Image backgroundImage;

    CreateLoginForm() {
        try {
            backgroundImage = ImageIO.read(new File("Employee/src/Coffee.jpg"));
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }

        // Font Styles and Size
        Font timesFont = new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20); 
        Font headingFont = new Font("Franklin Gothic Demi Cond", Font.BOLD, 35);

        // Window properties
        frame = new JFrame("LOGIN");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Heading
        headingLabel = new JLabel("Login");
        headingLabel.setFont(headingFont); 
        headingLabel.setForeground(Color.WHITE); 

        // Register Number
        userLabel = new JLabel("User Name");
        userLabel.setFont(timesFont);
        userLabel.setForeground(Color.WHITE); 

        textField1 = new JTextField(15);
        textField1.setFont(timesFont);
        textField1.setForeground(Color.BLACK); 
        textField1.setBackground(Color.WHITE); 

        // Password
        passLabel = new JLabel("Password");
        passLabel.setFont(timesFont);
        passLabel.setForeground(Color.WHITE);

        textField2 = new JPasswordField(15);
        textField2.setFont(timesFont);
        textField2.setForeground(Color.BLACK); 
        textField2.setBackground(Color.WHITE); 

        // Submit Button
        b1 = new JButton("SUBMIT");
        b1.setFont(timesFont); 
        b1.setForeground(Color.BLACK); 
        b1.setBackground(Color.WHITE); 

        // Create panel to put form elements, using GridBagLayout to center components
        newPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Background image not found.");
                }
            }
        };

        newPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Center the components
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  
        gbc.insets = new Insets(20, 20, 20, 20); // Add more space around components

        newPanel.add(headingLabel, gbc);

        gbc.gridwidth = 1;  // Reset to default value (just one column)
        gbc.gridx = 0;
        gbc.gridy = 1;
        newPanel.add(userLabel, gbc);
        gbc.gridx = 1;
        newPanel.add(textField1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        newPanel.add(passLabel, gbc);
        gbc.gridx = 1;
        newPanel.add(textField2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        newPanel.add(b1, gbc);
        frame.setContentPane(newPanel);
        b1.addActionListener(this);
    }

    // After the button is clicked
    public void actionPerformed(ActionEvent ae) {
        String userValue = textField1.getText().trim(); 
        String passValue = textField2.getText().trim(); 
        App app = new App(userValue, passValue);
        boolean result = app.authenticateStudent();

        if (userValue.trim().isEmpty() || passValue.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (result) {
            Choose choose = new Choose(userValue,passValue);
            choose.showPage();
            frame.setVisible(false);
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showPage() {
        frame.setVisible(true);
    }
}

// Main class
class LoginForm {
    public static void main(String arg[]) {
        try {
            CreateLoginForm form = new CreateLoginForm();
            form.showPage();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
