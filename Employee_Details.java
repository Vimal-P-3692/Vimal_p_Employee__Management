import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

class Employee_Details extends JFrame {
    // Employee details labels and values
    JLabel empIdLabel, empNameLabel, departmentLabel, phoneLabel, addressLabel;
    JLabel empIdValue, empNameValue, departmentValue, phoneValue, addressValue;
    Image backgroundImage; 

    Employee_Details(String username,String password) {
        try {
            backgroundImage = ImageIO.read(new File("Employee/src/Coffee.jpg"));
        } catch (Exception e) {
            e.getMessage();
        }

        // Font Styles and Sizes
        Font timesFont = new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20); 
        Font headingFont = new Font("Franklin Gothic Demi Cond", Font.BOLD, 35); 

        // Heading:
        JLabel detailsLabel = new JLabel("Employee Details");
        detailsLabel.setFont(headingFont);
        detailsLabel.setForeground(Color.WHITE);

        Details objDetails = new Details(username,password);
        String[] info = objDetails.details(); 
        // Employee's details:
        empIdLabel = new JLabel("Employee ID: ");
        empIdLabel.setFont(timesFont);
        empIdLabel.setForeground(Color.WHITE);

        empIdValue = new JLabel(info[0]);
        empIdValue.setFont(timesFont);
        empIdValue.setForeground(Color.WHITE);

        empNameLabel = new JLabel("Employee Name: ");
        empNameLabel.setFont(timesFont);
        empNameLabel.setForeground(Color.WHITE);

        empNameValue = new JLabel(info[1]);
        empNameValue.setFont(timesFont);
        empNameValue.setForeground(Color.WHITE);

        departmentLabel = new JLabel("Department: ");
        departmentLabel.setFont(timesFont);
        departmentLabel.setForeground(Color.WHITE);

        departmentValue = new JLabel(info[2]);
        departmentValue.setFont(timesFont);
        departmentValue.setForeground(Color.WHITE);

        phoneLabel = new JLabel("Phone Number: ");
        phoneLabel.setFont(timesFont);
        phoneLabel.setForeground(Color.WHITE);

        phoneValue = new JLabel(info[3]);
        phoneValue.setFont(timesFont);
        phoneValue.setForeground(Color.WHITE);

        addressLabel = new JLabel("Address: ");
        addressLabel.setFont(timesFont);
        addressLabel.setForeground(Color.WHITE);

        addressValue = new JLabel(info[4]);
        addressValue.setFont(timesFont);
        addressValue.setForeground(Color.WHITE);

        // Create panel to put form elements, using GridBagLayout to center components
        JPanel newPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        newPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Center the components in the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        newPanel.add(detailsLabel, gbc);

        gbc.gridwidth = 1; // Reset to default gridwidth for other components
        gbc.gridx = 0;
        gbc.gridy = 1;
        newPanel.add(empIdLabel, gbc);
        gbc.gridx = 1;
        newPanel.add(empIdValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        newPanel.add(empNameLabel, gbc);
        gbc.gridx = 1;
        newPanel.add(empNameValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        newPanel.add(departmentLabel, gbc);
        gbc.gridx = 1;
        newPanel.add(departmentValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        newPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        newPanel.add(phoneValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        newPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        newPanel.add(addressValue, gbc);

        // Add the panel to the JFrame and center it
        add(newPanel, BorderLayout.CENTER);

        // Set window properties
        setTitle("Employee Information");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
