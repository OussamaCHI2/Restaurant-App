import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HomePage {
    public static void main(String[] args) {
        // Create the frame for the home page
        JFrame homeFrame = new JFrame("Restaurant Home");
        homeFrame.setSize(600, 400);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setLocationRelativeTo(null); // Center the frame

        // Create the panel with background image
        JPanel panel = new JPanel() {
            private Image backgroundImage;

            // Load the background image
            {
                try {
                    backgroundImage = ImageIO.read(new File("C:\\Users\\OUSSAMA\\Desktop\\Restaurent10.6\\Restaurent10.6\\Restaurent\\src\\bakc.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panel.setLayout(null);

        // Add a header label
        JLabel headerLabel = new JLabel("Gourmet Delight");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setBounds(150, 30, 300, 50);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setForeground(Color.LIGHT_GRAY); // Chocolate color
        panel.add(headerLabel);

        // Add a welcome label
        JLabel welcomeLabel = new JLabel("Delicious food, great atmosphere, unforgettable experience.");
        welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        welcomeLabel.setBounds(60, 100, 500, 30);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(new Color(85, 107, 47)); // Olive green
        panel.add(welcomeLabel);

        // Add a login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250, 200, 100, 40);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        loginButton.setBackground(new Color(85, 107, 47)); // Olive green
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        panel.add(loginButton);

        // Add action listener to navigate to the login page
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.dispose(); // Close the home page
                LOG.Login_page.main(null); // Open the login page (or the login frame)
            }
        });

        // Add the panel to the frame
        homeFrame.add(panel);

        // Make the frame visible
        homeFrame.setVisible(true);
    }
}
