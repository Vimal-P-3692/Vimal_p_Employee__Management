import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Choose extends JFrame {

    JButton register, view;
    JPanel newPanel;
    JLabel headingLabel;
    Image backgroundImage;
    JFrame frame;

    public Choose(String useString,String passString) {
        try {
            // Load the background image (ensure the file path is correct)
            backgroundImage = ImageIO.read(new File("Employee/src/Coffee.jpg"));  // Make sure 'Image1.jpg' is in the correct directory
        } catch (IOException e) {
            e.getMessage();  // Handle the exception (print the error if the image is not found)
        }

        // Font Styles and Size
        Font timesFont = new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20);
        Font headingFont = new Font("Franklin Gothic Demi Cond", Font.BOLD, 35);

        // Set up the frame
        frame = new JFrame("EMPLOYEES REGISTER AND VIEWING");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Register Button
        register = new JButton("Register Employee");
        register.setFont(timesFont);
        register.setForeground(Color.BLACK);
        register.setBackground(Color.WHITE);

        // View Details Button
        view = new JButton("View Employee");
        view.setFont(timesFont);
        view.setForeground(Color.BLACK);
        view.setBackground(Color.WHITE);

        // Heading Label
        headingLabel = new JLabel("Employee Details");
        headingLabel.setFont(headingFont);
        headingLabel.setForeground(Color.WHITE);

        // Create a panel with GridBagLayout to center everything
        newPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);  // Scale the background image
                }
            }
        };

        // GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.anchor = GridBagConstraints.CENTER;

        // Add Heading Label to the panel
        newPanel.add(headingLabel, gbc);

        // Add Register Button
        gbc.gridy = 2;
        newPanel.add(register, gbc);

        // Add View Button
        gbc.gridy = 3;
        newPanel.add(view, gbc);

        // Add the panel to the frame
        frame.add(newPanel, BorderLayout.CENTER);

        // Actions When the button is Clicked
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Open RegistrationForm
                Register register = new Register();
                register.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Employee_Details employee_Details = new Employee_Details(useString,passString);
                employee_Details.setVisible(true);
                frame.setVisible(false);
                frame.dispose();
            }
        });
    }

    public void showPage() {
        frame.setVisible(true);  // Make the frame visible
    }

    
}
