/***********************************************************************
 * Module:  Serveur.java
 * Author:  AdMin
 * Purpose: Defines the Class Serveur
 ***********************************************************************/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
/** @pdOid d2cf9d5a-9082-4bc7-9673-a69015f62e8a */
public class Serveur {
   /** @pdOid 0607ef27-5ac0-4113-bb83-2a621dfec463 */
   private int id;
   /** @pdOid 640dbdf4-cf1a-4482-99cd-782b6531f93f */
   private String nom;
   /** @pdOid df19bb23-66dc-4187-8311-b76a18cf3a4b */
   private String email;
   /** @pdOid 58f8007d-8eb7-4f19-8471-3b939cd2d239 */
   private String password;
   /** @pdOid d7c960b9-b621-40ef-a7a3-fc38ce45fb26 */
   private String numerotelephone;
   public final String role = "serveur";
   private Connection conn;
   /** @pdOid 2cdd20f3-afb6-4b5d-8984-61a9644a1dc0 */
   private Reservation R;

   public Serveur(String nom, String email, String numerotelephone, String password) {
      this.nom = nom;
      this.email = email;
      this.password = password;
      this.numerotelephone = numerotelephone;
   }

   public Serveur(int id, String nom) {
      this.id = id;
      this.nom = nom;
   }

   public Reservation getR() {
      return R;
   }

   public Serveur(int id, String nom, String email, String numerotelephone) {
      this.id = id;
      this.nom = nom;
      this.email = email;
      this.numerotelephone = numerotelephone;
   }

   public Serveur() {
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNom() {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getNumerotelephone() {
      return numerotelephone;
   }


   public void setNumerotelephone(String numerotelephone) {
      this.numerotelephone = numerotelephone;
   }

   public String getRole() {
      return role;
   }

   public Connection getConn() {
      return conn;
   }

   public void setConn(Connection conn) {
      this.conn = conn;
   }

   public Serveur(Connection conn) {
      this.conn = conn;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
   // ================== Gestion des commandes ==================

   // Methode 1:
   /** @pdOid c80c611a-d721-43c7-b278-dc2442540df4 */
   public Commande creerCommande(Connection conn, int id) throws SQLException {
      Commande C = new Commande(0, "En Cours");
      String sql = "INSERT INTO commandes (DateCommande, Statut,Total,TableId) VALUES (?,?,?,?)";
      if(verifierDisponibiliteTable(conn,id)) {
         try (
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setTimestamp(1, Timestamp.valueOf(C.getTime()));
            stmt.setDouble(3, C.getPrix());
            stmt.setString(2, C.getStatut());
            stmt.setInt(4, id);
            stmt.executeUpdate();
         }
         String sql2 = "UPDATE Tables SET etat ='Occupée' WHERE TableID = ?;";
         try (
                 PreparedStatement stmt = conn.prepareStatement(sql2)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
         }
         return C;
      }
      else {
         return  null;

      }
   }

   //Methode 2:
   /** @pdOid 257ab119-a82c-4f20-91fd-9219567c1f13 */

   public void ajouterPlatACmd(Connection conn, Plat plat, int idc) throws SQLException {
      String sql = "INSERT INTO CommandePlat (Commande_ID, Plat_ID) VALUES (?, ?)";
      String sql2 = "UPDATE commandes SET Total = Total + ? WHERE CommandeID = ? ";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
         // Set the parameters (commande_id and plat_id)
         stmt.setInt(1, idc);    // Set the ID of the commande
         stmt.setInt(2, plat.getId()); // Set the ID of the plat

         // Execute the insert operation
         stmt.executeUpdate();
      }
      try (PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
         stmt2.setDouble(1, plat.getPrix());    // Set the PrixPlat
         stmt2.setInt(2, idc); // Set the ID Commande
         stmt2.executeUpdate();
      }
   }

   //Methode 3 :
   public static void supprimerPlatDeCommande(Connection conn, int commandeId, int platId,int CommandePlatID) {
      // SQL pour supprimer la ligne spécifique dans la table commandeplat
      String sql = "DELETE FROM commandeplat WHERE Commande_ID = ? AND Plat_ID = ? AND CommandeplatID = ?";
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
         // Définir les paramètres de la requête
         stmt.setInt(1, commandeId);
         stmt.setInt(2, platId);
         stmt.setInt(3, CommandePlatID);

         // Exécuter la requête de suppression
         int rowsAffected = stmt.executeUpdate();

         if (rowsAffected > 0) {
            System.out.println("Plat supprimé de la commande avec succès.");
         } else {
            System.out.println("Aucun plat trouvé pour cette commande.");
         }
      } catch (SQLException e) {
         System.out.println("Erreur lors de la suppression du plat de la commande : " + e.getMessage());
      }
      String getPriceQuery = "SELECT Prix FROM plats WHERE PlatID = ?";

      try (PreparedStatement stmtGetPrice = conn.prepareStatement(getPriceQuery)) {
         stmtGetPrice.setInt(1, platId);  // Set the PlatID

         try (ResultSet rs = stmtGetPrice.executeQuery()) {
            if (rs.next()) {
               double prixPlat = rs.getDouble("Prix"); // Get the price of the dish

               // Now, update the total price in the commandes table
               String updateQuery = "UPDATE commandes SET Total = Total - ? WHERE CommandeID = ?";
               try (PreparedStatement stmtUpdate = conn.prepareStatement(updateQuery)) {
                  stmtUpdate.setDouble(1, prixPlat);  // Set the PrixPlat (price of the dish)
                  stmtUpdate.setInt(2, commandeId);   // Set the CommandeID
                  stmtUpdate.executeUpdate();         // Execute the update query
               }
            }
         }
      } catch (SQLException ex) {
         ex.printStackTrace();
      }
   }

   //Methode 4 :
   /** @pdOid ce1b1a33-b602-411e-80f7-b0c81da122dd */

   public void supprimerCommande(Connection conn, int commandeId) throws SQLException {
      String sql = "DELETE FROM commandes WHERE CommandeID = ?";

      try (
              PreparedStatement stmt = conn.prepareStatement(sql)) {
         stmt.setInt(1, commandeId);
         int rowsAffected = stmt.executeUpdate();

         if (rowsAffected > 0) {
            System.out.println("Commande supprimée avec succès.");
         } else {
            System.out.println("Aucune commande trouvée avec cet ID.");
         }
      }
   }

   // ================== Gestion des Paiments ==================

   //Methode 1:
   /** @pdOid 86926ebb-fba6-4605-97fc-856916dcac74 */

   public boolean effectuerPaiement(Connection conn, Paiement paiement, int idcommande) throws SQLException {

      // Définir les constantes
      final String STATUT_PAYEE = "Payée";
      final String STATUT_EN_COURS = "En cours";
      final String ETAT_LIBRE = "Libre";

      // Requêtes SQL
      String insertPaiementSql = "INSERT INTO paiements (CommandeID, Montant, DatePaiement) VALUES (?, ?, ?)";
      String updateCommandeSql = "UPDATE commandes SET Statut = ? WHERE CommandeID = ? AND Statut = ?";
      String sqlTable = "SELECT TableID FROM commandes WHERE CommandeID = ?";
      String updateTableSql = "UPDATE tables SET Etat = ? WHERE TableID = ?";
      String getcommande = "SELECT Total FROM commandes WHERE CommandeID = ?";

      try {
         int montant;
         try(PreparedStatement montantajouter=conn.prepareStatement(getcommande)){
            montantajouter.setInt(1,idcommande);
            try (ResultSet rs1 = montantajouter.executeQuery()) {
               if (rs1.next()) {
                  montant = rs1.getInt("Total");
               } else {
                  throw new SQLException("Aucune Commande");
               }
            }
         }
         // 1. Insérer le paiement
         try (PreparedStatement insertStmt = conn.prepareStatement(insertPaiementSql)) {
            insertStmt.setInt(1, idcommande);
            insertStmt.setDouble(2, montant);
            insertStmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted == 0) {
               throw new SQLException("Échec de l'insertion du paiement.");
            }
         }

         // 2. Mettre à jour le statut de la commande
         try (PreparedStatement updateStmt = conn.prepareStatement(updateCommandeSql)) {
            updateStmt.setString(1, "Payée");
            updateStmt.setInt(2, idcommande);
            updateStmt.setString(3, "En cours");

            int rowsUpdated = updateStmt.executeUpdate();
            if (rowsUpdated == 0) {
               throw new SQLException("La commande n'a pas été trouvée ou n'est pas dans le statut '" + STATUT_EN_COURS + "'.");
            }
         }

         // 3. Récupérer l'ID de la table associée à la commande
         int tableId;
         try (PreparedStatement tableStmt = conn.prepareStatement(sqlTable)) {
            tableStmt.setInt(1, idcommande);
            try (ResultSet rs = tableStmt.executeQuery()) {
               if (rs.next()) {
                  tableId = rs.getInt("TableID");
               } else {
                  throw new SQLException("Aucune table associée à la commande.");
               }
            }
         }

         // 4. Mettre à jour l'état de la table
         try (PreparedStatement updateTableStmt = conn.prepareStatement(updateTableSql)) {
            updateTableStmt.setString(1, "Libre");
            updateTableStmt.setInt(2, tableId);
            int rowsUpdated = updateTableStmt.executeUpdate();
            if (rowsUpdated == 0) {
               throw new SQLException("Échec de la mise à jour de l'état de la table.");
            }
         }

         return true;

      } catch (SQLException e) {
         throw new SQLException("Erreur lors du traitement du paiement : " + e.getMessage(), e);
      }
   }


   //Methode 2 :
   public void creerFichierRecu(Connection conn, int idcommande, Paiement paiement, String dossier) throws SQLException, IOException {
      // Générer le reçu
      String recu = genererRecu(conn, idcommande, paiement);

      // Vérifier et créer le dossier s'il n'existe pas
      File dossierFichiers = new File(dossier);
      if (!dossierFichiers.exists()) {
         if (!dossierFichiers.mkdirs()) {
            throw new IOException("Impossible de créer le dossier : " + dossier);
         }
      }

      // Générer un nom de fichier unique
      String nomFichier = "recu " + idcommande + "_" + ".txt";
      String cheminFichier = dossier + File.separator + nomFichier;

      // Enregistrer le reçu dans le fichier spécifié
      try (FileWriter writer = new FileWriter(cheminFichier)) {
         writer.write(recu);
         writer.write("\n\n"); // Séparation pour chaque reçu
      }

      System.out.println("Reçu enregistré dans le fichier : " + cheminFichier);
   }

   //Methode 3:
   private String genererRecu(Connection conn, int idcommande, Paiement paiement) throws SQLException {
      String selectCommandeSql = "SELECT CommandeID, Total, DateCommande FROM commandes WHERE CommandeID = ?";

      try (PreparedStatement stmt = conn.prepareStatement(selectCommandeSql)) {
         stmt.setInt(1, idcommande);
         try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
               // Récupérer les détails de la commande
               int commandeId = rs.getInt("CommandeID");
               double montantTotal = rs.getDouble("Total");
               Timestamp dateCommande = rs.getTimestamp("DateCommande");

               // Créer le texte du reçu
               StringBuilder recu = new StringBuilder();
               recu.append("====================================\n");
               recu.append("          Gourmet Delight\n");
               recu.append("====================================\n");
               recu.append("          Reçu de Paiement\n");
               recu.append("Commande ID: ").append(commandeId).append("\n");
               recu.append("Date de la commande: ").append(dateCommande.toLocalDateTime().toLocalDate()).append("\n");
               recu.append("Montant total de la commande: ").append(montantTotal).append(" MAD\n");
               recu.append("Date de paiement: ").append(LocalDateTime.now().toLocalDate()).append("\n");
               recu.append("Statut de la commande: Payée\n");
               recu.append("====================================\n");
               recu.append("          Au Revoir \n");
               return recu.toString();
            } else {
               throw new SQLException("Commande introuvable avec l'ID: " + idcommande);
            }
         }
      }
   }

   // ================== Gestion des Tables ==================
   //methode 1:
   public boolean ajouterReservation(Connection conn, int tableId, LocalDateTime reservationTime, String Client) throws SQLException {
      String insertQuery = "INSERT INTO Reservations ( TableId,serveurID, customer_name,reservation_time) VALUES (?, ?, ?, ?)";
      String updateQuery = "UPDATE Tables SET Etat = 'Reserver' WHERE TableID = ?";
if(verifierDisponibiliteTable(Db_connection.getConnection(),tableId)){
      // Utilisation de "try-with-resources" pour fermer automatiquement les PreparedStatement
      try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
           PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

         // Ajouter la réservation
         insertStmt.setInt(1, tableId);    // ID de la table
         insertStmt.setInt(2, id);  // ID du serveur
         insertStmt.setString(3, Client);  // Nom du client
         insertStmt.setTimestamp(4, Timestamp.valueOf(reservationTime));
         updateStmt.setInt(1,tableId);
         updateStmt.executeUpdate();
         insertStmt.executeUpdate();
      }
}else {
   throw new SQLException("Table inexistante");
}
      return true;
   }

   //methode 2:
   /** @pdOid f3802653-5576-4826-bdda-790c90652745 */
   public boolean AnnulerReservation(Connection conn, int reservationId, int tableId) throws SQLException {
      // Définir la requête pour supprimer la réservation de la table reservations
      String deleteQuery = "DELETE FROM Reservations WHERE reservation_id = ?";

      // Définir la requête pour mettre à jour le statut de la table à "Libre"
      String updateQuery = "UPDATE Tables SET status = 'Libre' WHERE id = ?";

      try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
           PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

         // Supprimer la réservation en fonction de l'ID de réservation
         deleteStmt.setInt(1, reservationId);
         int rowsDeleted = deleteStmt.executeUpdate();

         // Si la suppression est réussie, mettre à jour le statut de la table
         if (rowsDeleted > 0) {
            updateStmt.setInt(1, tableId);
            updateStmt.executeUpdate();
            return true; // Suppression réussie et table mise à jour
         } else {
            return false; // Aucune réservation trouvée avec cet ID
         }
      } catch (SQLException e) {
         // Gérer l'exception SQL
         e.printStackTrace();
         throw new SQLException("Erreur lors de la suppression de la réservation et de la mise à jour du statut de la table.", e);
      }
   }

   //Methode 3:
   public boolean verifierDisponibiliteTable(Connection conn, int tableId) throws SQLException {
   // Vérification de l'état de la table
   String checkStateQuery = "SELECT Etat FROM tables WHERE TableID = ?";
   try (PreparedStatement stmt = conn.prepareStatement(checkStateQuery)) {
      stmt.setInt(1, tableId);

      try (ResultSet rs = stmt.executeQuery()) {
         if (rs.next()) {
            String etatTable = rs.getString("Etat");

            // Si la table est occupée, retourner false immédiatement
            if ("Occupée".equals(etatTable) || "Resever".equals(etatTable)) {
               return false;
            }
         }
      }
   }

   return true; // Si la table est Libre
}

   public boolean verifierTable(Connection conn, int tableId) throws SQLException {
      // Vérification si la table existe
      String checkTableExistsQuery = "SELECT COUNT(*) FROM Tables WHERE tables = ?";
      try (PreparedStatement stmtExists = conn.prepareStatement(checkTableExistsQuery)) {
         stmtExists.setInt(1, tableId);

         try (ResultSet rsExists = stmtExists.executeQuery()) {
            if (rsExists.next() && rsExists.getInt(1) == 0) {
               return false;
            }
         }
      }
      return true;
   }
   //========================= Statistique ===================================

   // Calcule de chiffre d'affaire :
   public void calculerChiffreAffaireParAn(Connection conn, LocalDateTime date) {
      // calculer(chiffre d'affaires)  year
      String query = "SELECT SUM(Total) AS chiffreAffaire FROM commandes WHERE YEAR(DateCommande) = ?";

      try (
              PreparedStatement statement = conn.prepareStatement(query)
      ) {
         // Set the year parameter in the query
         statement.setInt(1, date.getYear());

         // Execute the query and get the result
         try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
               double chiffreAffaire = resultSet.getDouble("chiffreAffaire");
               JOptionPane.showMessageDialog(null,
                       "Chiffre d'affaires pour l'année " + date.getYear() + " : " + chiffreAffaire + " MAD",
                       "Statistiques",
                       JOptionPane.INFORMATION_MESSAGE);
            } else {
               JOptionPane.showMessageDialog(null, "Aucun chiffre d'affaires trouvé pour l'année " + date.getYear(), "Statistiques", JOptionPane.INFORMATION_MESSAGE);
            }
         }
      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Erreur lors du calcul du chiffre d'affaires: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
      }
   }

   //calcule de chiffre d'affaire par mois :
   public void calculerChiffreAffaireParMois(Connection conn, LocalDateTime date) {
      // calculer (chiffre d'affaires) month of the year
      String query = "SELECT MONTH(DateCommande) AS mois, SUM(Total) AS chiffreAffaire FROM commandes " +
              "WHERE YEAR(DateCommande) = ? AND MONTH(DateCommande) = ? " +
              "GROUP BY MONTH(DateCommande)";

      try (
              PreparedStatement statement = conn.prepareStatement(query)
      ) {

         statement.setInt(1, date.getYear());
         statement.setInt(2, date.getMonthValue());


         try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
               double chiffreAffaire = resultSet.getDouble("chiffreAffaire");


               DecimalFormat df = new DecimalFormat("#,##0.00");
               String formattedChiffreAffaire = df.format(chiffreAffaire);


               String message = String.format("Le chiffre d'affaires total pour le mois %d/%d est de %s MAD.",
                       date.getMonthValue(), date.getYear(), formattedChiffreAffaire);


               JOptionPane.showMessageDialog(null, message, "Statistiques - Chiffre d'affaires", JOptionPane.INFORMATION_MESSAGE);
            } else {

               JOptionPane.showMessageDialog(null,
                       "Aucun chiffre d'affaires enregistré pour le mois " + date.getMonthValue() + "/" + date.getYear(),
                       "Statistiques",
                       JOptionPane.INFORMATION_MESSAGE);
            }
         }
      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,
                 "Erreur lors du calcul du chiffre d'affaires: " + e.getMessage(),
                 "Erreur",
                 JOptionPane.ERROR_MESSAGE);
      }
   }

   //calcule de chiffre d'affaire par Jour :
   public void calculerChiffreAffaireParJour(Connection conn, LocalDateTime date) {

      String query = "SELECT DAY(DateCommande) AS jour, SUM(Total) AS chiffreAffaire FROM commandes " +
              "WHERE YEAR(DateCommande) = ? AND MONTH(DateCommande) = ? " +
              "GROUP BY DAY(DateCommande) ORDER BY jour";

      try (
              PreparedStatement statement = conn.prepareStatement(query)
      ) {
         // Set the year and month parameters in the query
         statement.setInt(1, date.getYear());
         statement.setInt(2, date.getMonthValue());

         // Execute the query and get the result
         try (ResultSet resultSet = statement.executeQuery()) {
            boolean dataFound = false;
            while (resultSet.next()) {
               int jour = resultSet.getInt("jour");
               double chiffreAffaire = resultSet.getDouble("chiffreAffaire");

               // Format the chiffreAffaire value to 2 decimal places
               DecimalFormat df = new DecimalFormat("#,##0.00");
               String formattedChiffreAffaire = df.format(chiffreAffaire);

               // Improved message display for each day
               String message = String.format("Le chiffre d'affaires pour le %d/%d/%d est de %s MAD.",
                       jour, date.getMonthValue(), date.getYear(), formattedChiffreAffaire);

               // Display the message for each day
               JOptionPane.showMessageDialog(null, message, "Statistiques - Chiffre d'affaires par jour", JOptionPane.INFORMATION_MESSAGE);
               dataFound = true;
            }

            if (!dataFound) {
               JOptionPane.showMessageDialog(null,
                       "Aucun chiffre d'affaires enregistré pour le mois " + date.getMonthValue() + "/" + date.getYear(),
                       "Statistiques", JOptionPane.INFORMATION_MESSAGE);
            }
         }
      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,
                 "Erreur lors du calcul du chiffre d'affaires: " + e.getMessage(),
                 "Erreur", JOptionPane.ERROR_MESSAGE);
      }
   }

   // plats Fréquent :=========================================================
   public void determinerTopPlats(Connection conn) {

      String query = "SELECT p.nom AS Plat, COUNT(*) AS totalDemandes, SUM(p.prix) AS chiffreAffaireTotal " +
              "FROM CommandePlat cp " +
              "JOIN Plats p ON cp.Plat_ID = p.PlatID " +
              "JOIN Commandes c ON cp.Commande_ID = c.CommandeID " +
              "GROUP BY p.PlatID " +
              "ORDER BY totalDemandes DESC ";

      try (PreparedStatement statement = conn.prepareStatement(query);
           ResultSet resultSet = statement.executeQuery()) {


         DecimalFormat df = new DecimalFormat("#,##0.00");


         DefaultTableModel model = new DefaultTableModel();
         model.addColumn("Plat");
         model.addColumn("Nombre total de demandes");
         model.addColumn("Chiffre d'affaire total (MAD)");


         while (resultSet.next()) {
            String plat = resultSet.getString("Plat");
            int totalDemandes = resultSet.getInt("totalDemandes");
            double chiffreAffaireTotal = resultSet.getDouble("chiffreAffaireTotal");


            String formattedChiffreAffaire = df.format(chiffreAffaireTotal);


            model.addRow(new Object[]{plat, totalDemandes, formattedChiffreAffaire});
         }

         // Create a JTable to display the data
         JTable table = new JTable(model);

         // Customize the JTable for a better look
         table.setFont(new Font("Segoe UI", Font.PLAIN, 14));  // Change font style and size
         table.setRowHeight(30);  // Set row height for better visibility
         table.setSelectionBackground(new Color(0, 120, 215)); // Highlight selected rows with a blue color
         table.setSelectionForeground(Color.WHITE); // Set text color of selected rows
         table.setGridColor(new Color(200, 200, 200));  // Set gridline color
         table.setShowGrid(true); // Show grid lines
         table.setAutoCreateRowSorter(true); // Enable sorting by clicking headers
         table.setFillsViewportHeight(true); // Make sure the table fills the scroll pane

         // Customize the table header
         JTableHeader header = table.getTableHeader();
         header.setFont(new Font("Segoe UI", Font.BOLD, 16)); // Bold header font
         header.setBackground(new Color(34, 45, 50)); // Header background color
         header.setForeground(Color.WHITE); // Header text color

         // Adjust column widths
         table.getColumnModel().getColumn(0).setPreferredWidth(200); // Plat column width
         table.getColumnModel().getColumn(1).setPreferredWidth(180); // Total demandes column width
         table.getColumnModel().getColumn(2).setPreferredWidth(220); // Chiffre d'affaire column width

         // Set the table in a JScrollPane
         JScrollPane scrollPane = new JScrollPane(table);

         // Create a new JFrame to display the table
         JFrame tableFrame = new JFrame("Les plats les plus demandés");
         tableFrame.setSize(700, 400);  // Resize the frame to fit the table nicely
         tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensure correct frame closing behavior
         tableFrame.add(scrollPane);
         tableFrame.setLocationRelativeTo(null); // Center the window on the screen
         tableFrame.setVisible(true);

      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,
                 "Erreur lors de la récupération des données: " + e.getMessage(),
                 "Erreur", JOptionPane.ERROR_MESSAGE);
      }
   }

}
