import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;


public class LOG {
    public static class Login_page extends JFrame {
    public static int idServeur = 0;
    public static String nomServeur = null;
         JButton jButton1;
         JLabel jLabel1;
         JLabel jLabel2;
         JLabel jLabel3;
         JLabel jLabel4;
         JLabel jLabel5;
         JPanel jPanel1;
         JPanel jPanel2;
         JPasswordField jPasswordField1;
         JTextField jTextField1;

        public Login_page() {
            initComponents();
            setLocationRelativeTo(null);
        }

        private void initComponents() {

            jPanel1 = new JPanel();
            jLabel5 = new JLabel();
            jLabel1 = new JLabel();
            jPanel2 = new JPanel();
            jLabel2 = new JLabel();
            jLabel3 = new JLabel();
            jTextField1 = new JTextField();
            jLabel4 = new JLabel();
            jPasswordField1 = new JPasswordField();
            jButton1 = new JButton();

            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            jPanel1.setBackground(new Color(119, 2, 29));

            jLabel5.setFont(new Font("Sitka Text", 3, 30));
            jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel5.setText("Gourment Delight");
            jLabel5.setForeground(new Color(246, 179, 57));

            setTitle("Gourment Delight");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(440, 500);
            setLocationRelativeTo(null);

            // Create an ImageIcon from the image file
            ImageIcon backgroundImage = new ImageIcon("C:\\Users\\OUSSAMA\\Desktop\\Restaurent10.6\\Restaurent10.6\\Restaurent\\src\\Images\\Logo.png");

            // Create a JLabel and set the image as its icon
            JLabel labelWithImage = new JLabel(backgroundImage);


            // Add the label to the frame
            add(labelWithImage);

            setVisible(true);


            jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(57, 57, 57)
                                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(43, Short.MAX_VALUE))
            );

            jLabel2.setFont(new Font("Unispace", 0, 36));
            jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel2.setText("Login");

            jLabel3.setFont(new Font("Segoe UI Black", 0, 16));
            jLabel3.setText("Username :");

            jTextField1.setBackground(new Color(242, 242, 242));

            jLabel4.setFont(new Font("Segoe UI Black", 0, 16));
            jLabel4.setText("Password :");

            jPasswordField1.setBackground(new Color(242, 242, 242));

            jButton1.setBackground(new Color(218, 123, 39));
            jButton1.setFont(new Font("Segoe UI Light", 3, 18));
            jButton1.setText("Se Connecter");
            jButton1.setForeground(Color.white);
            jButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            jButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = jTextField1.getText();
                    String password = new String(jPasswordField1.getPassword());

                    if (isAuthenticated(username, password)) {
                        String role = getRole(username, password);
                        if ("admin".equals(role)) {
                            // Open Admin interface
                            dispose();

                            AdminGUI.main(null);// Implement AdminGUI
                        } else if ("serveur".equals(role)) {
                            // Open Server interface
                            dispose();
                            ServeurGUI.main(null); // Implement ServerInterface
                        } else {
                            JOptionPane.showMessageDialog(Login_page.this, "Role not recognized.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(Login_page.this, "Invalid username or password.");
                    }
                }
            });

            GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                                    .addGap(130, 130, 130)
                                                                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                                    .addContainerGap()
                                                                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                                    .addContainerGap()
                                                                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(0, 153, Short.MAX_VALUE))
                                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jPasswordField1)
                                                            .addComponent(jTextField1))))
                                    .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
            );

            pack();
        }

        private static boolean isAuthenticated(String username, String password) {
            Connection conn = Db_connection.getConnection();
            if (conn != null) {
                try {
                    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();
                    return rs.next();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();
                    idServeur = rs.getInt("ServeurID");
                    nomServeur = rs.getString("nom");
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
            return false;
        }

        private static String getRole(String username, String password) {
            Connection conn = Db_connection.getConnection();
            if (conn != null) {
                try {
                    String query = "SELECT role FROM users WHERE username = ? AND password = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, username);
                    stmt.setString(2, password);

                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        return rs.getString("role");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Login_page().setVisible(true);
                }
            });
        }
    }

    static class AdminGUI {
        private JFrame frame;
        private JTable platsTable;
        private JTable serveursTable;
        private JTable menusTable;
        private JTable tablesTable;
        private DefaultTableModel platsModel;
        private DefaultTableModel serveursModel;
        private DefaultTableModel menusModel;
        private DefaultTableModel tablesModel;
        private Admin admin;

        public AdminGUI() {
            admin = new Admin("Admin", "admin@example.com", "password"); // Example admin user
            initialize();
        }

        private void initialize() {
            frame = new JFrame("Admin Panel");
            frame.setBounds(100, 100, 900, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Initialize tables
            platsTable = new JTable();
            serveursTable = new JTable();
            menusTable = new JTable();
            tablesTable = new JTable();

            // Setup models
            platsModel = new DefaultTableModel(new Object[]{"ID", "Nom", "Prix","Type"}, 0);
            serveursModel = new DefaultTableModel(new Object[]{"ID", "Nom", "Email", "Téléphone"}, 0);
            menusModel = new DefaultTableModel(new Object[]{"ID", "Nom"}, 0);
            tablesModel = new DefaultTableModel(new Object[]{"id", "Capacité", "État"}, 0);

            platsTable.setModel(platsModel);
            Tabledesigne(platsTable);

            serveursTable.setModel(serveursModel);
            Tabledesigne(serveursTable);

            menusTable.setModel(menusModel);
            Tabledesigne(menusTable);

            tablesTable.setModel(tablesModel);
            Tabledesigne(tablesTable);

            // Adding tables to scroll panes
            JScrollPane tablesScrollPane = new JScrollPane(tablesTable);
            JScrollPane platsScrollPane = new JScrollPane(platsTable);
            JScrollPane serveursScrollPane = new JScrollPane(serveursTable);

            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Plats", platsScrollPane);
            tabbedPane.addTab("Serveurs", serveursScrollPane);
            tabbedPane.addTab("Tables", tablesScrollPane); // Added Tables Tab
            tabbedPane.setBackground(Color.CYAN);
            tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));
            frame.add(tabbedPane, BorderLayout.CENTER);

            // Buttons for actions
            JPanel panel = new JPanel();
            frame.add(panel, BorderLayout.SOUTH);

            JButton addPlatButton = new JButton("Ajouter Plat");
            styleButton(addPlatButton);
            JButton deletePlatButton = new JButton("Supprimer Plat");
            styleButton(deletePlatButton);
            JButton modifyPlatButton = new JButton("Modifier Plat");
            styleButton(modifyPlatButton);
            JButton addServeurButton = new JButton("Ajouter Serveur");
            styleButton(addServeurButton);
            JButton deleteServeurButton = new JButton("Supprimer Serveur");
            styleButton(deleteServeurButton);
            JButton addTableButton = new JButton("Ajouter Table");
            styleButton(addTableButton);
            JButton deleteTableButton = new JButton("Supprimer Table");
            styleButton(deleteTableButton);

            panel.add(addPlatButton);
            panel.add(deletePlatButton);
            panel.add(modifyPlatButton);
            panel.add(addServeurButton);
            panel.add(deleteServeurButton);
            panel.add(addTableButton);
            panel.add(deleteTableButton);

            // Action listeners for buttons
            addPlatButton.addActionListener(e -> ajouterPlatAction());
            deletePlatButton.addActionListener(e -> supprimerPlatAction());
            modifyPlatButton.addActionListener(e -> modifierPlatAction());
            addServeurButton.addActionListener(e -> ajouterServeurAction());
            deleteServeurButton.addActionListener(e -> supprimerServeurAction());
            addTableButton.addActionListener(e -> ajouterTableAction());
            deleteTableButton.addActionListener(e -> supprimerTableAction());


            AfficherPlatsTable();
            AfficherServeursTable();
            AfficherTablesTable();

            frame.setVisible(true);
        }
        public void styleButton(JButton button) {
            // Appliquer les styles au bouton
            button.setFont(new Font("STIXGeneral", Font.BOLD, 14));
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setVerticalAlignment(SwingConstants.CENTER);
            button.setBackground(new Color(70, 130, 180)); // Couleur bleu acier
            button.setForeground(Color.WHITE); // Texte blanc
            button.setBorder(new LineBorder(new Color(35, 35, 35), 2, true)); // Bordure arrondie

            // Ajouter les effets de survol
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                private Timer hoverTimer;
                private Timer exitTimer;

                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    if (exitTimer != null && exitTimer.isRunning()) {
                        exitTimer.stop();
                    }
                    hoverTimer = new Timer(20, e -> {
                        Color currentColor = button.getBackground(); // Utilisation correcte de l'objet 'button'
                        if (!currentColor.equals(new Color(94, 227, 5))) {
                            button.setBackground(blendColors(currentColor, new Color(255, 0, 46), 0.1f));
                        } else {
                            ((Timer) e.getSource()).stop();
                        }
                    });
                    hoverTimer.start();
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    if (hoverTimer != null && hoverTimer.isRunning()) {
                        hoverTimer.stop();
                    }
                    exitTimer = new Timer(15, e -> {
                        Color currentColor = button.getBackground(); // Utilisation correcte de l'objet 'button'
                        if (!currentColor.equals(new Color(70, 130, 180))) {
                            button.setBackground(blendColors(currentColor, new Color(70, 130, 180), 0.1f));
                        } else {
                            ((Timer) e.getSource()).stop();
                        }
                    });
                    exitTimer.start();
                }
            });
        }
        private static Color blendColors(Color c1, Color c2, float ratio) {
            int red = (int) (c1.getRed() * (1 - ratio) + c2.getRed() * ratio);
            int green = (int) (c1.getGreen() * (1 - ratio) + c2.getGreen() * ratio);
            int blue = (int) (c1.getBlue() * (1 - ratio) + c2.getBlue() * ratio);
            return new Color(red, green, blue);
        }

        public void Tabledesigne(JTable Table){
            Table.setFont(new Font("Arial", Font.PLAIN, 14));
            Table.setRowHeight(30);
            Table.setGridColor(Color.GRAY);
            Table.setSelectionBackground(Color.CYAN);
            Table.setForeground(Color.BLACK);
            JTableHeader header = Table.getTableHeader();
            header.setFont(new Font("Segoe UI", Font.BOLD, 20)); // Bold header font
            header.setBackground(new Color(34, 45, 50)); // Header background color
            header.setForeground(Color.WHITE); // Header text color
        }
        private void AfficherPlatsTable() {
            platsModel.setRowCount(0);
            try (Connection conn = Db_connection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM plats");
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("PlatID"));
                    row.add(rs.getString("nom"));
                    row.add(rs.getDouble("prix"));
                    row.add(rs.getString("type"));
                    platsModel.addRow(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Populate Tables Table
        private void AfficherTablesTable() {
            tablesModel.setRowCount(0);  // Clear the existing rows in the table
            try (Connection conn = Db_connection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tables");
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("TableID"));
                    row.add(rs.getString("capacite"));
                    row.add(rs.getString("etat"));
                    tablesModel.addRow(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();  // Handle SQL exceptions
            }
        }

        // Populate Serveurs Table
        private void AfficherServeursTable() {
            serveursModel.setRowCount(0);  // Clear the table model

            try (Connection conn = Db_connection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM serveurs");
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    // Instantiate Serveur object and set its properties
                    Serveur serveur = new Serveur();
                    serveur.setId(rs.getInt("ServeurID"));
                    serveur.setNom(rs.getString("nom"));
                    serveur.setEmail(rs.getString("email"));
                    serveur.setNumerotelephone(rs.getString("telephone"));
                    serveur.setPassword(rs.getString("password"));

                    // Add the data to the JTable
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("ServeurID"));
                    row.add(rs.getString("nom"));
                    row.add(rs.getString("email"));
                    row.add(rs.getString("telephone"));
                    row.add("********");
                    serveursModel.addRow(row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void insertServeurIntoUsersTable(Serveur serveur) {
            String sql = "INSERT INTO users (UserID,username, password , role) VALUES (?,?, ?, ?)";
            try (Connection conn = Db_connection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, serveur.getId());
                stmt.setString(2, serveur.getNom());
                stmt.setString(3, serveur.getPassword());
                stmt.setString(4, "serveur");
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        // Action for adding a plat
        private void ajouterPlatAction() {
            try {
                // Saisie des informations du plat
                String nomPlat = JOptionPane.showInputDialog("Nom du plat:");
                String prixPlatStr = JOptionPane.showInputDialog("Prix du plat:");
                double prixPlat = Double.parseDouble(prixPlatStr);
                String[] options = {"Entrée", "Plat Principal", "Dessert", "Boisson"};

                // Create the JComboBox
                JComboBox<String> comboBox = new JComboBox<>(options);

                // Show the JComboBox in a JOptionPane
                int resulta = JOptionPane.showConfirmDialog(
                        null,
                        comboBox,
                        "Sélectionnez le type du plat:",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                // Sélection de l'image
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Sélectionnez une image pour le plat");
                int result = fileChooser.showOpenDialog(null);

                byte[] imageBytes = null; // Initialisation de l'image

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    imageBytes = Files.readAllBytes(selectedFile.toPath()); // Conversion en tableau de bytes
                }

                if (imageBytes != null) {
                    // Appel à la méthode d'ajout avec l'image
                    admin.ajouterPlat(nomPlat, prixPlat, (String) comboBox.getSelectedItem() , imageBytes);
                    JOptionPane.showMessageDialog(null, "Plat ajouté avec succès !");
                } else {
                    JOptionPane.showMessageDialog(null, "Aucune image sélectionnée. Le plat n'a pas été ajouté.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Le prix doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erreur lors de la lecture de l'image.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Action for deleting a plat
        private void supprimerPlatAction() {
            int selectedRow = platsTable.getSelectedRow();
            if (selectedRow != -1) {
                int idPlat = (int) platsModel.getValueAt(selectedRow, 0);
                String nomPlat = (String) platsModel.getValueAt(selectedRow, 1);
                admin.supprimerPlat(nomPlat);
                AfficherPlatsTable();
            }
        }

        private void modifierPlatAction() {
            int selectedRow = platsTable.getSelectedRow();
            if (selectedRow != -1) {
                // Get current values of the selected plat
                int platId = (int) platsModel.getValueAt(selectedRow, 0);
                String platNom = (String) platsModel.getValueAt(selectedRow, 1);
                double platPrix = (double) platsModel.getValueAt(selectedRow, 2);

                // Show input dialogs to modify plat details
                String newNom = JOptionPane.showInputDialog(frame, "Modifier le nom du plat:", platNom);
                String newPrixStr = JOptionPane.showInputDialog(frame, "Modifier le prix du plat:", platPrix);
                double newPrix = 0;
                try {
                    newPrix = Double.parseDouble(newPrixStr); // Parse price input
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Prix invalide!");
                    return;
                }

                // Update the plat :
                if (newNom != null && !newNom.trim().isEmpty()) {
                        admin.modifierPlat(platId,newNom,newPrix);
                        AfficherPlatsTable();
                        JOptionPane.showMessageDialog(frame, "Plat modifié avec succès.");
                }

            }
            else {
                JOptionPane.showMessageDialog(frame, "Selectionner un Plat a modifier.");
            }
        }
        // Action for adding a serveur
        private void ajouterServeurAction() {

            String nomServeur = JOptionPane.showInputDialog("Nom du serveur:");
            String emailServeur = JOptionPane.showInputDialog("Email du serveur:");
            String telephoneServeur = JOptionPane.showInputDialog("Téléphone du serveur:");
            String password = JOptionPane.showInputDialog("Password:");

            Serveur serveur = new Serveur(nomServeur,emailServeur,telephoneServeur,password);

            admin.ajouterServeur(nomServeur, emailServeur, telephoneServeur, password);
            AfficherServeursTable();
            insertServeurIntoUsersTable(serveur);
        }

        // Action for deleting a serveur
        private void supprimerServeurAction() {
            int selectedRow = serveursTable.getSelectedRow();
            if (selectedRow != -1) {
                int idServeur = (int) serveursModel.getValueAt(selectedRow, 0);
                String nomServeur = (String) serveursModel.getValueAt(selectedRow, 1);
                admin.supprimerServeur(nomServeur); // Assurez-vous que la méthode `supprimerServeur` est implémentée dans `Admin`
                AfficherServeursTable();
            } else {
                JOptionPane.showMessageDialog(frame, "Veuillez sélectionner une serveur à supprimer.");
            }
        }

        private void ajouterTableAction() {
            // Prompt for the capacity of the table
            String capaciteStr = JOptionPane.showInputDialog("Capacité de la table:");
            // Prompt for the capacity of the table
            String[] etats = {"Libre","Occuper","Reserver"};

            // Créer un JComboBox avec les options
            JComboBox<String> comboBox = new JComboBox<>(etats);

            // Afficher le JComboBox dans un JOptionPane
            int result = JOptionPane.showConfirmDialog(
                    null,
                    comboBox,
                    "Sélectionner l'etat de la table",
                    JOptionPane.OK_CANCEL_OPTION
            );

            // Gérer la réponse de l'utilisateur
            if (result == JOptionPane.OK_OPTION) {
                String selectedCapacity = (String) comboBox.getSelectedItem();
                System.out.println("Capacité sélectionnée : " + selectedCapacity);
            } else {
                System.out.println("Aucune capacité sélectionnée.");
            }
            String etat = (String) comboBox.getSelectedItem();

            // If the capacity is valid (not null and can be parsed to an integer)
            if (capaciteStr != null && !capaciteStr.trim().isEmpty()) {
                try {
                    int capacite = Integer.parseInt(capaciteStr);

                        // Call the ajouterTable method
                        admin.ajouterTable(capacite, etat);

                        // Notify the admin about the successful table creation
                        JOptionPane.showMessageDialog(frame, "Table créée avec succès avec une capacité de " + capacite + " personnes.");

                        // Refresh the list of tables
                        AfficherTablesTable();

                } catch (NumberFormatException e) {
                    // Show error if the input is not a valid integer
                    JOptionPane.showMessageDialog(frame, "Veuillez entrer une capacité valide.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "La capacité ne peut pas être vide.");
            }
        }


        // Action for deleting a table
        private void supprimerTableAction() {
            int selectedRow = tablesTable.getSelectedRow();
            if (selectedRow != -1) {
                int idTable = (int) tablesModel.getValueAt(selectedRow, 0); // Assuming first column is ID

                // Confirm suppression :
                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Êtes-vous sûr de vouloir supprimer la table avec ID: " + idTable + "?",
                        "Confirmer la suppression",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    // Call admin method to delete table
                    admin.supprimerTable(idTable);

                    // Refresh the tables list
                    AfficherTablesTable();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Veuillez sélectionner une table à supprimer.");
            }
        }


        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new AdminGUI());
        }
    }

    //===================== GUI SERVEUR ========================================
    public static class ServeurGUI extends JFrame {
        JPanel contentPanel;
        CardLayout cardLayout;
        ArrayList<String> orderList;
        JTable platsTable;
        DefaultTableModel platsModel;
        DefaultTableModel platsModels;
        JFrame frame;
        Serveur s = new Serveur(2, "ou");
        Plat P = new Plat();
        public static int idc = 0;


        public ServeurGUI(Serveur serveur) {
            platsTable = new JTable();
            platsModels = new DefaultTableModel(new Object[]{"ID", "Nom", "Prix", "type","CommandePlatID"}, 0);
            platsModel = new DefaultTableModel(new Object[]{"ID", "Nom", "Prix"}, 0);
            platsTable.setModel(platsModel);

            JScrollPane platsScrollPane = new JScrollPane(platsTable);


            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Plats", platsScrollPane);
            setTitle("Restaurant Management");
            setSize(800, 600);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            orderList = new ArrayList<>();

            setLayout(new BorderLayout());

            // Create the main content area for the menu screen
            contentPanel = new JPanel();
            cardLayout = new CardLayout();
            contentPanel.setLayout(cardLayout);



            JPanel mainMenuPanel = new JPanel();
            mainMenuPanel.setLayout(null);
            mainMenuPanel.setBackground(new Color(184, 203, 208));
            mainMenuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the panel

            // Buttons (Tables, Orders, Payments,)


            JButton manageTablesButton = new JButton("Gestion des Tables");
            manageTablesButton.setBounds(60, 240, 220, 60);
            styleButton(manageTablesButton);

            ImageIcon backgroundImage = new ImageIcon("C:\\Users\\OUSSAMA\\Desktop\\Restaurent10.6\\Restaurent10.6\\Restaurent\\src\\Images\\reserved.png");
            JLabel labelWithImage = new JLabel(backgroundImage);
            labelWithImage.setBounds(60, 100, 220, 120);
            mainMenuPanel.add(labelWithImage);

            JButton manageOrdersButton = new JButton("Gestion des Commandes");
            manageOrdersButton.setBounds(295, 240, 220, 60);
            styleButton(manageOrdersButton);

            ImageIcon order = new ImageIcon("C:\\Users\\OUSSAMA\\Desktop\\Restaurent10.6\\Restaurent10.6\\Restaurent\\src\\Images\\order.png");
            JLabel ordere = new JLabel(order);
            ordere.setBounds(295, 100, 220, 120);
            mainMenuPanel.add(ordere);

            JButton managePaymentsButton = new JButton("Gestion des Paiements");
            managePaymentsButton.setBounds(530, 240, 220, 60);
            styleButton(managePaymentsButton);
            ImageIcon payer = new ImageIcon("C:\\Users\\OUSSAMA\\Desktop\\Restaurent10.6\\Restaurent10.6\\Restaurent\\src\\Images\\payment.png");
            JLabel payere = new JLabel(payer);
            payere.setBounds(530, 100, 220, 120);
            mainMenuPanel.add(payere);

            JButton StatistiqueButton = new JButton("Verification des Statistique");
            StatistiqueButton.setBounds(60, 375, 220, 60);
            styleButton(StatistiqueButton);
            setVisible(true);
            ImageIcon stat = new ImageIcon("C:\\Users\\OUSSAMA\\Desktop\\Restaurent10.6\\Restaurent10.6\\Restaurent\\src\\Images\\statistiques.png");
            JLabel Statlabel = new JLabel(stat);
            Statlabel.setBounds(295, 330, 220, 120);
            mainMenuPanel.add(Statlabel);

            manageTablesButton.addActionListener(e -> showGestionTables());
            manageOrdersButton.addActionListener(e -> showGestionCommandes());
            managePaymentsButton.addActionListener(e -> showGestionPaiements());
            StatistiqueButton.addActionListener(e -> showstatistique());

            // Add buttons to the main menu panel
            mainMenuPanel.add(manageTablesButton);
            mainMenuPanel.add(manageOrdersButton);
            mainMenuPanel.add(managePaymentsButton);
            mainMenuPanel.add(StatistiqueButton);

            // Add the main menu panel to the content panel
            contentPanel.add(mainMenuPanel, "Menu");

            // Create panels for the other management areas (Tables, Orders, Payments)
            JPanel gestionTablesPanel = createGestionTablesPanel();
            JPanel gestionCommandesPanel = createGestionCommandesPanel();
            JPanel gestionPaiementsPanel = createGestionPaiementsPanel();
            JPanel gestionStatistiquePanel = createGestionStatistiquePanel();

            // Add the management panels to the content panel
            contentPanel.add(gestionTablesPanel, "Gestion des Tables");
            contentPanel.add(gestionCommandesPanel, "Gestion des Commandes");
            contentPanel.add(gestionPaiementsPanel, "Gestion des Paiements");
            contentPanel.add(gestionStatistiquePanel, "Statistique");

            // Add content panel to the frame
            add(contentPanel, BorderLayout.CENTER);

            // Show the main menu by default
            cardLayout.show(contentPanel, "Menu");
        }
        public void styleButton(JButton button) {
            // Appliquer les styles au bouton
            button.setFont(new Font("STIXGeneral", Font.BOLD, 14));
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setVerticalAlignment(SwingConstants.CENTER);
            button.setBackground(new Color(70, 130, 180)); // Couleur bleu acier
            button.setForeground(Color.WHITE); // Texte blanc
            button.setBorder(new LineBorder(new Color(35, 35, 35), 2, true)); // Bordure arrondie

            // Ajouter les effets de survol
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                private Timer hoverTimer;
                private Timer exitTimer;

                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    if (exitTimer != null && exitTimer.isRunning()) {
                        exitTimer.stop();
                    }
                    hoverTimer = new Timer(10, e -> {
                        Color currentColor = button.getBackground(); // Utilisation correcte de l'objet 'button'
                        if (!currentColor.equals(new Color(94, 227, 5))) {
                            button.setBackground(blendColors(currentColor, new Color(255, 0, 46), 0.1f));
                        } else {
                            ((Timer) e.getSource()).stop();
                        }
                    });
                    hoverTimer.start();
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    if (hoverTimer != null && hoverTimer.isRunning()) {
                        hoverTimer.stop();
                    }
                    exitTimer = new Timer(10, e -> {
                        Color currentColor = button.getBackground(); // Utilisation correcte de l'objet 'button'
                        if (!currentColor.equals(new Color(70, 130, 180))) {
                            button.setBackground(blendColors(currentColor, new Color(70, 130, 180), 0.1f));
                        } else {
                            ((Timer) e.getSource()).stop();
                        }
                    });
                    exitTimer.start();
                }
            });
        }

        // Méthode pour mélanger deux couleurs
        private static Color blendColors(Color c1, Color c2, float ratio) {
            int red = (int) (c1.getRed() * (1 - ratio) + c2.getRed() * ratio);
            int green = (int) (c1.getGreen() * (1 - ratio) + c2.getGreen() * ratio);
            int blue = (int) (c1.getBlue() * (1 - ratio) + c2.getBlue() * ratio);
            return new Color(red, green, blue);
        }


        // Method to display the "Gestion des Tables" panel
        private void showGestionTables() {
            cardLayout.show(contentPanel, "Gestion des Tables");
        }

        // Method to display the "Gestion des Commandes" panel
        private void showGestionCommandes() {
            cardLayout.show(contentPanel, "Gestion des Commandes");
        }

        // Method to display the "Gestion des Paiements" panel
        private void showGestionPaiements() {
            cardLayout.show(contentPanel, "Gestion des Paiements");
        }

        private void showstatistique() {
            cardLayout.show(contentPanel, "Statistique");
        }
//======================================== Gestion de commandes =============================================

        // Create and return the "Gestion des Tables" panel
        private JPanel createGestionTablesPanel() {
            JPanel gestionTablesPanel = new JPanel();
            gestionTablesPanel.setLayout(null);
            JLabel titredepage = new JLabel();

            titredepage.setText("Gestion des Tables");
            titredepage.setBounds(245,20,300,90);
            titredepage.setForeground(new Color(52, 77, 89));
            titredepage.setVerticalAlignment(SwingConstants.CENTER);
            titredepage.setHorizontalAlignment(SwingConstants.CENTER);
            titredepage.setOpaque(true);
            titredepage.setFont(new Font("Arial", Font.BOLD, 28));
            titredepage.setBackground(new Color(184, 203, 208));
            setVisible(true);
            gestionTablesPanel.add(titredepage);

            // Button to handle table reservation
            JButton reserveButton = new JButton("Réserver une Table");
            reserveButton.setBounds(295, 240, 220, 60);
            reserveButton.addActionListener(e -> ouvrirDialogReservation());
            styleButton(reserveButton);
            gestionTablesPanel.add(reserveButton);

            // Add "Retour" (Back) button to return to the main menu
            JButton backButton = new JButton("Retour");
            backButton.setBounds(295, 500, 220, 50);
            styleButton(backButton);
            backButton.addActionListener(e -> cardLayout.show(contentPanel, "Menu"));
            gestionTablesPanel.add(backButton);
            gestionTablesPanel.setBackground(new Color(184, 203, 208));

            return gestionTablesPanel;
        }

        // Create and return the "Gestion des Commandes" panel
        private JPanel createGestionCommandesPanel() {
            JPanel gestionCommandesPanel = new JPanel();
            gestionCommandesPanel.setLayout(null);
            JLabel titredepage = new JLabel();

            titredepage.setText("Gestion des commandes");
            titredepage.setBounds(215,20,350,90);
            titredepage.setForeground(new Color(52, 77, 89));
            titredepage.setVerticalAlignment(SwingConstants.CENTER);
            titredepage.setHorizontalAlignment(SwingConstants.CENTER);
            titredepage.setOpaque(true);
            titredepage.setFont(new Font("Arial", Font.BOLD, 28));
            titredepage.setBackground(new Color(184, 203, 208));
            setVisible(true);
            gestionCommandesPanel.add(titredepage);
            // Button to Cree La commande :
            JButton createOrderButton = new JButton("Créer la Commande");
            styleButton(createOrderButton);
            createOrderButton.setBounds(185,240,200,50);
            createOrderButton.addActionListener(e -> {
                try {
                    String idtableString = JOptionPane.showInputDialog("Le numero de la table:");
                    int idtable = Integer.parseInt(idtableString);
                    // Ouvrir la fenêtre de gestion des commandes
                    Commande c = s.creerCommande(Db_connection.getConnection(),idtable);
                    idc = c.getId();
                    openOrderManagementWindow();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Table occuper  ou n'existe pas: "+ JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            });
            gestionCommandesPanel.add(createOrderButton);


            JButton AfficherCom = new JButton("Afficher Les Commandes");
            AfficherCom.setBounds(415,240,200,50);
            AfficherCom.addActionListener(e -> {
                AfficherCommandes();
            });
            styleButton(AfficherCom);


            // Add buttons panel to the gestionCommandesPanel
            gestionCommandesPanel.add(AfficherCom);

            // Add "Retour" (Back) button to return to the main menu
            JButton backButton = new JButton("Retour");
            backButton.setBounds(295,500,200,40);
            backButton.addActionListener(e -> cardLayout.show(contentPanel, "Menu"));
            styleButton(backButton);
            gestionCommandesPanel.add(backButton);
            gestionCommandesPanel.setBackground(new Color(184, 203, 208));

            return gestionCommandesPanel;
        }

        // ====================== Window OrderManager1 ====================================

        private void openOrderManagementWindow() {

            JDialog orderDialog = new JDialog(this, "Gestion de la Commande", true);
            orderDialog.setSize(800, 600);
            orderDialog.setLayout(new BorderLayout());
            orderDialog.setLocationRelativeTo(this);

            // Panel to display the plat cards
            JPanel platPanel = new JPanel();
            platPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Display in two columns
            platPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            try {
                String query = "SELECT * FROM plats";  // Example query to get plats
                try (Connection conn = Db_connection.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(query);
                     ResultSet rs = stmt.executeQuery()) {

                    while (rs.next()) {
                        int id = rs.getInt("PlatID");
                        String name = rs.getString("nom");
                        double price = rs.getDouble("prix");
                        byte[] imageBytes = rs.getBytes("image");

                        JPanel platCard = createPlatCard1(id, name, price, imageBytes);
                        platPanel.add(platCard);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erreur de récupération des plats", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

            // Add the plat panel to the dialog
            orderDialog.add(platPanel, BorderLayout.CENTER);

            // Add "Valider la Commande" button
            JButton validateButton = new JButton("Valider la Commande");
            validateButton.addActionListener(e ->{
                // Créer la commande dans la base de données
                try {
                    orderDialog.dispose();
                    JOptionPane.showMessageDialog(this, "Commande créée avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } finally {

                }
            });
            orderDialog.add(validateButton,BorderLayout.SOUTH);

            orderDialog.setVisible(true);
        }

        // Afficher La carte de chaque plat :

        private JPanel createPlatCard1(int id, String nom, double prix, byte[] imageBytes) {
            // Main panel with BorderLayout
            JPanel platCard = new JPanel(new BorderLayout());
            platCard.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            platCard.setPreferredSize(new Dimension(300, 150)); // Adjust size as needed
            Plat Pe = new Plat();

            // Panel for the image on the left
            JPanel imagePanel = new JPanel();
            imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
            imagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Padding around the image

            JLabel imageLabel = new JLabel();
            if (imageBytes != null) {
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
            } else {
                imageLabel.setText("Aucune image");
                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            }
            imagePanel.add(imageLabel);

            // Panel for the text and button on the right
            JPanel textButtonPanel = new JPanel();
            textButtonPanel.setLayout(new BoxLayout(textButtonPanel, BoxLayout.Y_AXIS));
            textButtonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Padding around the text and button

            // Name label at the top
            JLabel platNameLabel = new JLabel(nom);
            platNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
            platNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            textButtonPanel.add(platNameLabel);

            // Spacer to push the price and button to the bottom
            textButtonPanel.add(Box.createVerticalGlue());

            // Price label
            JLabel platPriceLabel = new JLabel("Prix: " + prix + " MAD");
            platPriceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            platPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            textButtonPanel.add(platPriceLabel);

            // Button at the bottom
            JButton addButton = new JButton("Ajouter à la Commande");
            styleButton(addButton);
            addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            addButton.addActionListener(e -> {
                try {
                    Pe.setId(id);
                    Pe.setNom(nom);
                    Pe.setPrix(prix);
                    // Ajouter le plat à la commande dans la base de données
                    s.ajouterPlatACmd(Db_connection.getConnection(),Pe,idc);
                    JOptionPane.showMessageDialog(null, "Plat ajouté à la commande : " + Pe.getNom(), "Succès", JOptionPane.INFORMATION_MESSAGE);
                    orderList.add(Pe.getNom());
                } catch (SQLException ex) {
                    // Gérer les exceptions SQL
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du plat à la commande : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            });
            textButtonPanel.add(addButton);

            // Add components to the main panel
            platCard.add(imagePanel, BorderLayout.WEST);
            platCard.add(textButtonPanel, BorderLayout.CENTER);

            return platCard;
        }

        //=================== Window OrderManager1 =======================

        private void openOrderManagementWindow(int idcommande) {

            JDialog orderDialog = new JDialog(this, "Modifier la Commande", true);
            orderDialog.setSize(800, 600);
            orderDialog.setLayout(new BorderLayout());
            orderDialog.setLocationRelativeTo(this);

            // Panel to display the plat cards
            JPanel platPanel = new JPanel();
            platPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Display in two columns
            platPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            try {
                String query = "SELECT * FROM plats";  // Example query to get plats
                try (Connection conn = Db_connection.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(query);
                     ResultSet rs = stmt.executeQuery()) {

                    while (rs.next()) {
                        int id = rs.getInt("PlatID");
                        String name = rs.getString("nom");
                        double price = rs.getDouble("prix");
                        byte[] imageBytes = rs.getBytes("image");

                        JPanel platCard = createPlatCard(id, name, price, imageBytes,idcommande);
                        platPanel.add(platCard);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erreur de récupération des plats", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

            // Add the plat panel to the dialog
            orderDialog.add(platPanel, BorderLayout.CENTER);

            // Add "Valider la Commande" button
            JButton validateButton = new JButton("Valider la Commande");
            validateButton.addActionListener(e ->{
                // Créer la commande dans la base de données
                try {
                    orderDialog.dispose();
                    JOptionPane.showMessageDialog(this, "Commande créée avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                } finally {

                }
            });
            orderDialog.add(validateButton,BorderLayout.SOUTH);

            orderDialog.setVisible(true);
        }

        // Afficher La carte de chaque plat lors la modification:
        private JPanel createPlatCard(int id, String nom, double prix, byte[] imageBytes,int commandeID) {
            // Main panel with BorderLayout
            JPanel platCard = new JPanel(new BorderLayout());
            platCard.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            platCard.setPreferredSize(new Dimension(300, 150)); // Adjust size as needed
            Plat Pe = new Plat();

            // Panel for the image on the left
            JPanel imagePanel = new JPanel();
            imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
            imagePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Padding around the image

            JLabel imageLabel = new JLabel();
            if (imageBytes != null) {
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaledImage));
            } else {
                imageLabel.setText("Aucune image");
                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            }
            imagePanel.add(imageLabel);

            // Panel for the text and button on the right
            JPanel textButtonPanel = new JPanel();
            textButtonPanel.setLayout(new BoxLayout(textButtonPanel, BoxLayout.Y_AXIS));
            textButtonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Padding around the text and button

            // Name label at the top
            JLabel platNameLabel = new JLabel(nom);
            platNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
            platNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            textButtonPanel.add(platNameLabel);

            // Spacer to push the price and button to the bottom
            textButtonPanel.add(Box.createVerticalGlue());

            // Price label
            JLabel platPriceLabel = new JLabel("Prix: " + prix + " MAD");
            platPriceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            platPriceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            textButtonPanel.add(platPriceLabel);

            // Button at the bottom
            JButton addButton = new JButton("Ajouter à la Commande");
            styleButton(addButton);
            addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            addButton.addActionListener(e -> {
                try {
                    Pe.setId(id);
                    Pe.setNom(nom);
                    Pe.setPrix(prix);
                    // Ajouter le plat à la commande dans la base de données
                    s.ajouterPlatACmd(Db_connection.getConnection(),Pe,commandeID);
                    JOptionPane.showMessageDialog(null, "Plat ajouté à la commande : " + Pe.getNom(), "Succès", JOptionPane.INFORMATION_MESSAGE);
                    orderList.add(Pe.getNom());
                } catch (SQLException ex) {
                    // Gérer les exceptions SQL
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout du plat à la commande : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            });
            textButtonPanel.add(addButton);

            // Add components to the main panel
            platCard.add(imagePanel, BorderLayout.WEST);
            platCard.add(textButtonPanel, BorderLayout.CENTER);

            return platCard;
        }

        // Afficher Une Table Des commandes Pour la Controler les commandes :

        public void AfficherCommandes() {
            // Créer une nouvelle fenêtre
            JFrame commandesFrame = new JFrame("Liste des Commandes");
            commandesFrame.setSize(800, 600);
            commandesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Créer un modèle de table
            DefaultTableModel commandesModel = new DefaultTableModel();
            commandesModel.setColumnIdentifiers(new Object[]{"CommandeID", "DateCommande", "Total", "Statut","TableID"});

            JTable commandesTable = new JTable(commandesModel);
            commandesTable.setFont(new Font("Arial", Font.PLAIN, 14));
            commandesTable.setRowHeight(30);
            commandesTable.setGridColor(Color.GRAY);
            commandesTable.setSelectionBackground(Color.CYAN);
            commandesTable.setForeground(Color.BLACK);
            JTableHeader header = commandesTable.getTableHeader();
            header.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Bold header font
            header.setBackground(new Color(34, 45, 50)); // Header background color
            header.setForeground(Color.WHITE); // Header text color
            JScrollPane scrollPane = new JScrollPane(commandesTable);

            // Ajouter le tableau dans la fenêtre
            commandesFrame.add(scrollPane, BorderLayout.CENTER);

            // Charger les données des commandes
            String query = "SELECT * FROM commandes";
            try (Connection conn = Db_connection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("CommandeID"));
                    row.add(rs.getTimestamp("DateCommande"));
                    row.add(rs.getDouble("Total"));
                    row.add(rs.getString("Statut"));
                    row.add(rs.getInt("TableID"));
                    commandesModel.addRow(row);
                }

                // Vérifier si aucune commande n'a été trouvée
                if (commandesModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(commandesFrame, "Il n'existe aucune commande.");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(commandesFrame, "Erreur lors du chargement des commandes : " + e.getMessage(),
                        "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            // Ajouter un bouton pour afficher ou ajouter des plats
            JButton modifyButton = new JButton("Modifier la Commande");
            modifyButton.addActionListener(e -> {
                commandesFrame.dispose();
                int selectedRow = commandesTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(commandesFrame, "Veuillez sélectionner une commande à modifier.");
                    return;
                }

                // Récupérer l'ID de la commande sélectionnée
                int commandeId = (int) commandesModel.getValueAt(selectedRow, 0);

                // Ouvrir une boîte de dialogue pour choisir l'action
                JDialog modifyDialog = new JDialog(commandesFrame, "Modifier la Commande", true);
                modifyDialog.setSize(300, 200);
                modifyDialog.setLayout(new GridLayout(3, 1));

                JButton viewPlatsButton = new JButton("Supprimer un plat du commande");
                viewPlatsButton.addActionListener(event -> {
                    AfficherPlatsCommande(commandeId);
                    modifyDialog.dispose();
                });

                JButton addPlatButton = new JButton("Ajouter un plat à la commande");
                addPlatButton.addActionListener(event -> {
                    openOrderManagementWindow(commandeId);
                    modifyDialog.dispose();
                    AfficherCommandes();
                });

                modifyDialog.add(viewPlatsButton);
                modifyDialog.add(addPlatButton);

                JButton cancelButton = new JButton("Annuler");
                cancelButton.addActionListener(event -> modifyDialog.dispose());
                modifyDialog.add(cancelButton);

                modifyDialog.setVisible(true);
            });

            // Ajouter un bouton pour supprimer une commande
            JButton deleteButton = new JButton("Supprimer la Commande");
            deleteButton.addActionListener(e -> {
                int selectedRow = commandesTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(commandesFrame, "Veuillez sélectionner une commande à supprimer.");
                    return;
                }

                // Récupérer l'ID de la commande sélectionnée
                int commandeId = (int) commandesModel.getValueAt(selectedRow, 0);

                // Confirmation avant suppression
                int confirm = JOptionPane.showConfirmDialog(commandesFrame, "Êtes-vous sûr de vouloir supprimer cette commande ?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                        try (Connection conn = Db_connection.getConnection()) {
                        s.supprimerCommande(conn, commandeId); // Appel à votre méthode existante

                        // Supprimer la ligne du modèle après une suppression réussie
                        commandesModel.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(commandesFrame, "Commande supprimée avec succès.");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(commandesFrame, "Erreur lors de la suppression : " + ex.getMessage(),
                                "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });



            // Ajouter le bouton à la fenêtre
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(modifyButton);
            buttonPanel.add(deleteButton);
            commandesFrame.add(buttonPanel, BorderLayout.SOUTH);

            // Afficher la fenêtre
            commandesFrame.setVisible(true);
        }

        // Afficher Une Table Des Plats Pour la Controler les Plats :
        public void AfficherPlatsCommande(int commandeId) {
            SwingUtilities.invokeLater(() -> {
                JFrame PlatFrame = new JFrame("Liste des Plats de la Commande");
                PlatFrame.setSize(800, 600);
                PlatFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                DefaultTableModel platsModel = new DefaultTableModel();
                platsModel.addColumn("Plat ID");
                platsModel.addColumn("Nom");
                platsModel.addColumn("Prix");
                platsModel.addColumn("Type");
                platsModel.addColumn("CommandePlatID");

                JTable platsTable = new JTable(platsModel);
                platsTable.setFont(new Font("Arial", Font.PLAIN, 14));
                platsTable.setRowHeight(30);
                platsTable.setGridColor(Color.GRAY);
                platsTable.setSelectionBackground(Color.CYAN);
                platsTable.setForeground(Color.BLACK);
                JTableHeader header = platsTable.getTableHeader();
                header.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Bold header font
                header.setBackground(new Color(34, 45, 50)); // Header background color
                header.setForeground(Color.WHITE); // Header text color
                JScrollPane scrollPane = new JScrollPane(platsTable);

                PlatFrame.add(scrollPane, BorderLayout.CENTER);

                Connection conn = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;

                try {
                    conn = Db_connection.getConnection();
                    String query = "SELECT PlatID, nom, prix, type,CommandeplatID " +
                            "FROM commandeplat cp " +
                            "JOIN plats p ON cp.Plat_ID = p.PlatID " +
                            "WHERE cp.Commande_ID = ?";
                    stmt = conn.prepareStatement(query);
                    stmt.setInt(1, commandeId);
                    rs = stmt.executeQuery();

                    platsModel.setRowCount(0);

                    while (rs.next()) {
                        Vector<Object> row = new Vector<>();
                        row.add(rs.getInt("PlatID"));
                        row.add(rs.getString("nom"));
                        row.add(rs.getDouble("prix"));
                        row.add(rs.getString("type"));
                        row.add(rs.getInt("CommandePlatID"));
                        platsModel.addRow(row);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                JButton supprimerPlatButton = new JButton("Supprimer le Plat");
                supprimerPlatButton.addActionListener(e -> supprimerPlatDeCommande(commandeId, platsTable, platsModel));
                JPanel buttonPanel = new JPanel(new FlowLayout());
                buttonPanel.add(supprimerPlatButton);
                PlatFrame.add(buttonPanel, BorderLayout.SOUTH);

                PlatFrame.setVisible(true);
            });
        }

        // Annulation des Commande :
        private void supprimerPlatDeCommande(int commandeId, JTable platsTable, DefaultTableModel platsModel) {
            int selectedRow = platsTable.getSelectedRow();
            if (selectedRow != -1) {
                int platId = (int) platsModel.getValueAt(selectedRow, 0);
                int CommandePlatID =(int) platsModel.getValueAt(selectedRow,4);
                s.supprimerPlatDeCommande(Db_connection.getConnection(), commandeId, platId,CommandePlatID);
                platsModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Plat supprimé de la commande avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un plat à supprimer.", "Avertissement", JOptionPane.WARNING_MESSAGE);
            }
        }

        //====================== Gestion des paiements ===============================

            // Create and return the "Gestion des Paiements" panel
        private JPanel createGestionPaiementsPanel() {
                JPanel gestionPaiementsPanel = new JPanel();
                gestionPaiementsPanel.setLayout(null);
            JLabel titredepage = new JLabel();

            titredepage.setText("Gestion des Paiements");
            titredepage.setBounds(215,20,350,90);
            titredepage.setForeground(new Color(52, 77, 89));
            titredepage.setVerticalAlignment(SwingConstants.CENTER);
            titredepage.setHorizontalAlignment(SwingConstants.CENTER);
            titredepage.setOpaque(true);
            titredepage.setFont(new Font("Arial", Font.BOLD, 28));
            titredepage.setBackground(new Color(184, 203, 208));
            setVisible(true);
            gestionPaiementsPanel.add(titredepage);

                // Button to process payment
                JButton processPaymentButton = new JButton("Effectuer le Paiement");
                processPaymentButton.setBounds(295, 240, 220, 70);
                styleButton(processPaymentButton);
                processPaymentButton.addActionListener(e -> {
                    AfficherCommandesEnCours();
                });

                gestionPaiementsPanel.add(processPaymentButton, BorderLayout.CENTER);

                // Add "Retour" (Back) button to return to the main menu
                JButton backButton = new JButton("Retour");
                styleButton(backButton);
                backButton.setBounds(295, 500, 220, 50);
                backButton.addActionListener(e -> cardLayout.show(contentPanel, "Menu"));
                gestionPaiementsPanel.add(backButton, BorderLayout.SOUTH);
                gestionPaiementsPanel.setBackground(new Color(184, 203, 208));

                return gestionPaiementsPanel;
            }

        private void loadReservations(JTable table) {
            // Database connection
            String query = "SELECT r.reservation_id, r.reservation_time, t.id AS table_id, r.customer_name, s.serveur_name " +
                    "FROM Reservations r " +
                    "JOIN Tables t ON r.tableId = t.id " +
                    "JOIN Serveurs s ON r.serveurID = s.serveurID";

            try (Connection conn = Db_connection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                // Initialize vectors for columns and data
                Vector<String> columnNames = new Vector<>();
                columnNames.add("ID Réservation");
                columnNames.add("Date et Heure");
                columnNames.add("ID Table");
                columnNames.add("Nom Client");
                columnNames.add("Serveur");

                Vector<Vector<Object>> data = new Vector<>();

                // Fill the data vector with rows
                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("reservation_id"));
                    row.add(rs.getTimestamp("reservation_time"));
                    row.add(rs.getInt("table_id"));
                    row.add(rs.getString("customer_name"));
                    row.add(rs.getString("serveur_name"));
                    data.add(row);
                }

                // Set the table model
                DefaultTableModel model = new DefaultTableModel(data, columnNames);
                table.setModel(model);

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des réservations : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }


        public void AfficherCommandesEnCours() {
            Paiement paiement = new Paiement();

            // Créer une nouvelle fenêtre
            JFrame commandesFrame = new JFrame("Liste des Commandes");
            commandesFrame.setSize(800, 600);
            commandesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Créer un modèle de table
            DefaultTableModel commandesModel = new DefaultTableModel();
            commandesModel.setColumnIdentifiers(new Object[]{"CommandeID", "DateCommande", "Total", "Statut"});

            JTable commandesTable = new JTable(commandesModel);
            commandesTable.setFont(new Font("Arial", Font.PLAIN, 14));
            commandesTable.setRowHeight(30);
            commandesTable.setGridColor(Color.GRAY);
            commandesTable.setSelectionBackground(Color.CYAN);
            commandesTable.setForeground(Color.BLACK);
            JTableHeader header = commandesTable.getTableHeader();
            header.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Bold header font
            header.setBackground(new Color(34, 45, 50)); // Header background color
            header.setForeground(Color.WHITE); // Header text color
            JScrollPane scrollPane = new JScrollPane(commandesTable);

            // Ajouter le tableau dans la fenêtre
            commandesFrame.add(scrollPane, BorderLayout.CENTER);

            // Charger les données des commandes (filtrer par statut si nécessaire)
            String query = "SELECT * FROM commandes ";
            try (Connection conn = Db_connection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Vector<Object> row = new Vector<>();
                    row.add(rs.getInt("CommandeID"));
                    row.add(rs.getTimestamp("DateCommande"));
                    row.add(rs.getDouble("Total"));
                    row.add(rs.getString("Statut"));
                    commandesModel.addRow(row);
                }

                // Vérifier si aucune commande n'a été trouvée
                if (commandesModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(commandesFrame, "Il n'existe aucune commande en cours.");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(commandesFrame, "Erreur lors du chargement des commandes : " + e.getMessage(),
                        "Erreur", JOptionPane.ERROR_MESSAGE);
            }

            // Ajouter un bouton pour afficher ou ajouter des plats
            JButton modifyButton = new JButton("Modifier la Commande");
            modifyButton.addActionListener(e -> {
                int selectedRow = commandesTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(commandesFrame, "Veuillez sélectionner une commande à modifier.");
                    return;
                }

                // Récupérer l'ID de la commande sélectionnée


                // Ouvrir une boîte de dialogue pour choisir l'action
                JDialog modifyDialog = new JDialog(commandesFrame, "Modifier la Commande", true);
                modifyDialog.setSize(300, 200);
                modifyDialog.setLayout(new GridLayout(3, 1));

                JButton Payer = new JButton("Effectuer le paiement");
                Payer.addActionListener(event -> {
                    commandesFrame.dispose();
                    try {
                        int commandeId = (int) commandesModel.getValueAt(selectedRow, 0);

                        // Assuming the 'payment' object is created correctly before this point
                        boolean success = s.effectuerPaiement(Db_connection.getConnection(), paiement, commandeId);
                        if (success) {
                            JOptionPane.showMessageDialog(this, "Paiement effectué avec succès!");
                        } else {
                            JOptionPane.showMessageDialog(this, "Erreur lors du paiement.");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Erreur lors du paiement : " + ex.getMessage(),
                                "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                    modifyDialog.dispose();
                });
                JButton genererecu = new JButton("Imprimer un recu");
                genererecu.addActionListener(event -> {
                    try {
                        int commandeId = (int) commandesModel.getValueAt(selectedRow, 0);

                        String cheminFichier = "C:\\Users\\OUSSAMA\\Desktop\\Restaurent10.6\\Restaurent10.6\\Restaurent\\Recu ";
                         s.creerFichierRecu(Db_connection.getConnection(),commandeId,paiement,cheminFichier);
                        }
                    catch (SQLException | IOException ex) {
                        JOptionPane.showMessageDialog(this, "Erreur lors du Generation : " + ex.getMessage(),
                                "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                    modifyDialog.dispose();
                });

                modifyDialog.add(Payer);

                modifyDialog.add(genererecu);

                JButton cancelButton = new JButton("Annuler");
                cancelButton.addActionListener(event -> modifyDialog.dispose());
                modifyDialog.add(cancelButton);
                modifyDialog.setVisible(true);
            });

            // Ajouter le bouton à la fenêtre
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(modifyButton);
            commandesFrame.add(buttonPanel, BorderLayout.SOUTH);

            // Afficher la fenêtre
            commandesFrame.setVisible(true);
        }

        //============================== Gestion des Reservations ==============================

        // Method to handle reservation (opens a dialog)
            private void ouvrirDialogReservation() {
                // Champs de saisie
                JTextField tableField = new JTextField(10);
                JTextField ClientField = new JTextField(10);
                tableField.setSize(100, 90);
                ClientField.setSize(100, 90);

                // Sélecteur de date
                JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
                dateSpinner.setSize(100, 90);
                JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy/MM/dd HH:mm");
                dateSpinner.setEditor(dateEditor); // Définit la valeur par défaut sur la date actuelle
                dateSpinner.setValue(new java.util.Date());

                // Créer le panneau de dialogue
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 3, 7, 10)); // Espacement entre les champs
                panel.add(new JLabel("Numéro de Table:"));
                panel.add(tableField);

                panel.add(new JLabel("Nom de Client:"));
                panel.add(ClientField);

                panel.add(new JLabel("Date et Heure de Réservation:"));
                panel.add(dateSpinner);

                // Afficher le dialogue
                int option = JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "Réserver une Table",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

                if (option == JOptionPane.OK_OPTION) {
                    String nomClient = ClientField.getText();
                    String tableNumber = tableField.getText();

                    java.util.Date selectedDate = (java.util.Date) dateSpinner.getValue();

                    // Convert java.util.Date to String
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                    String formattedDate = sdf.format(selectedDate);
                    System.out.println("Formatted Date: " + formattedDate); // Print formatted date string

                    // Convert the formatted string to LocalDateTime
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                    LocalDateTime localDateTime = LocalDateTime.parse(formattedDate, formatter);


                    if (!tableNumber.isEmpty() && isInteger(tableNumber)) {
                        int tableId = Integer.parseInt(tableNumber);

                        try {
                            // Appeler la méthode pour ajouter une réservation
                            boolean success = s.ajouterReservation(Db_connection.getConnection(), tableId,localDateTime,nomClient);

                            if (success) {
                                JOptionPane.showMessageDialog(
                                        this,
                                        "Table " + tableNumber + " réservée pour le " + formattedDate + ".",
                                        "Réservation Confirmée",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                            } else {
                                JOptionPane.showMessageDialog(this, "La réservation a échoué.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(this, "Erreur lors de l'accès à la base de données : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Veuillez entrer un numéro de table valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        // Méthode utilitaire pour valider les entiers
        private boolean isInteger(String str) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        //===================== Gestion de Statistique ==========================================

        private JPanel createGestionStatistiquePanel() {
            // Create a new panel for statistiques
            JPanel StatistiquePanel = new JPanel();
            StatistiquePanel.setLayout(null);  // Use null layout for absolute positioning
            StatistiquePanel.setPreferredSize(new Dimension(800, 600)); // Set preferred size
            JLabel titredepage = new JLabel();

            titredepage.setText("Statistique");
            titredepage.setBounds(215,20,350,90);
            titredepage.setForeground(new Color(52, 77, 89));
            titredepage.setVerticalAlignment(SwingConstants.CENTER);
            titredepage.setHorizontalAlignment(SwingConstants.CENTER);
            titredepage.setOpaque(true);
            titredepage.setFont(new Font("Arial", Font.BOLD, 28));
            titredepage.setBackground(new Color(184, 203, 208));
            setVisible(true);
            StatistiquePanel.add(titredepage);

            // Create and style the buttons
            JButton calculateButton = new JButton("Chiffre d'Affaire d'Année");
            calculateButton.setBounds(60, 240, 220, 60);  // Set button position and size
            styleButton(calculateButton); // Style the button
            calculateButton.addActionListener(e -> ouvrirDialogStatistiqueYearly());

            JButton calculateButtonMonth = new JButton("Chiffre d'Affaire Mois");
            calculateButtonMonth.setBounds(295, 240, 220, 60); // Set button position and size
            styleButton(calculateButtonMonth); // Style the button
            calculateButtonMonth.addActionListener(e -> ouvrirDialogStatistiqueMonthly());

            JButton Topseller = new JButton("Les Plats Frequent");
            Topseller.setBounds(295, 310, 220, 60); // Set button position and size
            styleButton(Topseller); // Style the button

            Topseller.addActionListener(e -> {
                s.determinerTopPlats(Db_connection.getConnection());
            });

            JButton calculateButtonDaily = new JButton("Chiffre d'Affaire Jour");
            calculateButtonDaily.setBounds(530, 240, 220, 60); // Set button position and size
            styleButton(calculateButtonDaily); // Style the button
            calculateButtonDaily.addActionListener(e -> ouvrirDialogStatistiqueDaily());

            // Add "Retour" (Back) button to return to the main menu
            JButton backButton = new JButton("Retour");
            backButton.setBounds(295, 500, 220, 50); // Set button position and size
            styleButton(backButton); // Style the button
            backButton.addActionListener(e -> cardLayout.show(contentPanel, "Menu"));

            // Add buttons to the panel
            StatistiquePanel.add(calculateButton);
            StatistiquePanel.add(Topseller);
            StatistiquePanel.add(calculateButtonMonth);
            StatistiquePanel.add(calculateButtonDaily);
            StatistiquePanel.add(backButton);
            StatistiquePanel.setBackground(new Color(184, 203, 208));

            // Set title of the window and close operation

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            return StatistiquePanel;
        }

        private void ouvrirDialogStatistiqueYearly() {
            // Champs de saisie
            JTextField tableField = new JTextField(10);
            JTextField ClientField = new JTextField(10);
            tableField.setSize(100, 90);
            ClientField.setSize(100, 90);

            // Sélecteur de date
            JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
            dateSpinner.setSize(100, 90);
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy/MM/dd HH:mm");
            dateSpinner.setEditor(dateEditor); // Définit la valeur par défaut sur la date actuelle
            dateSpinner.setValue(new java.util.Date());

            // Créer le panneau de dialogue
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 3, 7, 10)); // Espacement entre les champs


            panel.add(new JLabel("L'année a calculer son chiffre:"));
            panel.add(dateSpinner);

            // Afficher le dialogue
            int option = JOptionPane.showConfirmDialog(
                    this,
                    panel,
                    "Statistique",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (option == JOptionPane.OK_OPTION) {

                java.util.Date selectedDate = (java.util.Date) dateSpinner.getValue();

                // Convert java.util.Date to String
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                String formattedDate = sdf.format(selectedDate);
                System.out.println("Formatted Date: " + formattedDate); // Print formatted date string

                // Convert the formatted string to LocalDateTime
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                LocalDateTime localDateTime = LocalDateTime.parse(formattedDate, formatter);

                try {
                    s.calculerChiffreAffaireParAn(Db_connection.getConnection(),localDateTime);

                }
                finally {

                }
            }
        }
        private void ouvrirDialogStatistiqueMonthly() {
            // Champs de saisie
            JTextField tableField = new JTextField(10);
            JTextField ClientField = new JTextField(10);
            tableField.setSize(100, 90);
            ClientField.setSize(100, 90);

            // Sélecteur de date
            JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
            dateSpinner.setSize(100, 90);
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy/MM/dd HH:mm");
            dateSpinner.setEditor(dateEditor); // Définit la valeur par défaut sur la date actuelle
            dateSpinner.setValue(new java.util.Date());

            // Créer le panneau de dialogue
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 3, 7, 10)); // Espacement entre les champs


            panel.add(new JLabel("Entre la Date pour calculer son chiffre:"));
            panel.add(dateSpinner);

            // Afficher le dialogue
            int option = JOptionPane.showConfirmDialog(
                    this,
                    panel,
                    "Statistique",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (option == JOptionPane.OK_OPTION) {

                java.util.Date selectedDate = (java.util.Date) dateSpinner.getValue();

                // Convert java.util.Date to String
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                String formattedDate = sdf.format(selectedDate);
                System.out.println("Formatted Date: " + formattedDate); // Print formatted date string

                // Convert the formatted string to LocalDateTime
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                LocalDateTime localDateTime = LocalDateTime.parse(formattedDate, formatter);

                try {
                    s.calculerChiffreAffaireParMois(Db_connection.getConnection(),localDateTime);

                }
                finally {

                }
            }
        }
        private void ouvrirDialogStatistiqueDaily() {


            // Sélecteur de date
            JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
            dateSpinner.setSize(100, 90);
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy/MM/dd HH:mm");
            dateSpinner.setEditor(dateEditor); // Définit la valeur par défaut sur la date actuelle
            dateSpinner.setValue(new java.util.Date());

            // Créer le panneau de dialogue
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 3, 7, 10)); // Espacement entre les champs


            panel.add(new JLabel("jour pour calculer son chiffre :"));
            panel.add(dateSpinner);

            // Afficher le dialogue
            int option = JOptionPane.showConfirmDialog(
                    this,
                    panel,
                    "Statistique",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (option == JOptionPane.OK_OPTION) {

                java.util.Date selectedDate = (java.util.Date) dateSpinner.getValue();

                // Convert java.util.Date to String
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                String formattedDate = sdf.format(selectedDate);
                System.out.println("Formatted Date: " + formattedDate); // Print formatted date string

                // Convert the formatted string to LocalDateTime
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                LocalDateTime localDateTime = LocalDateTime.parse(formattedDate, formatter);

                try {
                    s.calculerChiffreAffaireParJour(Db_connection.getConnection(),localDateTime);

                }
                finally {

                }
            }
        }


     public static void main(String[] args) {
                // Create Serveur object (the server)
                Serveur serveur = new Serveur();
                // Initialize and display the GUI
                ServeurGUI serveurGUI = new ServeurGUI(serveur);
                serveurGUI.setVisible(true);
            }
        }
}
