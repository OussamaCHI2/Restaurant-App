import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    /** @pdOid d7a8f48e-4fc2-498f-874a-4e8204702104 */
    private String nom;
    /** @pdOid 37a1476d-0f36-4e29-873b-9e3c91f84a7d */
    private String email;
    /** @pdOid dc388748-98fb-4dfd-ae26-cba1c91d28a0 */
    private String motDePasse;
    final String role ="admin" ;

    public Admin(String nom, String email, String motDePasse) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // ================== Gestion des plats ==================
    /** @pdOid fdd07af9-e430-40cf-ae22-43b191d01f37 */
    public void ajouterPlat(String nomPlat, double prix, String type, byte[] image) {
        String query = "INSERT INTO plats (nom, prix, type, image) VALUES (?, ?, ?, ?)";
        try (Connection conn = Db_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nomPlat);
            stmt.setDouble(2, prix);
            stmt.setString(3, type);
            stmt.setBytes(4, image); // Ajout de l'image
            stmt.executeUpdate();
            System.out.println("Plat ajouté : " + nomPlat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /** @pdOid 326d9584-8cf1-4049-9833-d7ffe2d7e0fe */

    public void supprimerPlat(String nomPlat) {
        String query = "DELETE FROM plats WHERE nom = ?";
        try (Connection conn = Db_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nomPlat);
            stmt.executeUpdate();
            System.out.println("Plat supprimé : " + nomPlat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /** @pdOid 8f0af657-d86f-4789-acfe-443b6bcbc123 */
    public void modifierPlat(int platId, String newName, double newPrix) {
        String query = "UPDATE plats SET nom = ?, prix = ? WHERE PlatID = ?";
        try (Connection conn = Db_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the values for the query parameters
            stmt.setString(1, newName);
            stmt.setDouble(2, newPrix);
            stmt.setInt(3, platId);

            // Execute the update
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Plat modifié avec succès.");
            } else {
                System.out.println("Erreur lors de la modification du plat.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de base de données lors de la modification du plat.");
        }
    }

    // ================== Gestion des serveurs ==================
    /** @pdOid 6624ed6b-976d-4f8f-b943-bd9c3813f671 */
    public void ajouterServeur(String nom, String email, String telephone,String password) {
        String query = "INSERT INTO serveurs (nom, email, telephone,password) VALUES (?, ?, ?,?)";
        try (Connection conn = Db_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nom);
            stmt.setString(2, email);
            stmt.setString(3, telephone);
            stmt.setString(4,password);
            stmt.executeUpdate();
            System.out.println("Serveur ajouté : " + nom);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /** @pdOid f180fd7b-5ee7-4515-8c39-cc91053ac097 */

    public void supprimerServeur(String nom) {
        String query = "DELETE FROM serveurs WHERE nom = ?";
        String query2 = "DELETE FROM users WHERE username = ?";
        try (Connection conn = Db_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nom);
            stmt.executeUpdate();
            System.out.println("Serveur supprimé : " + nom);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = Db_connection.getConnection();
             PreparedStatement stmt2 = conn.prepareStatement(query2)) {
            stmt2.setString(1, nom);
            stmt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // ================== Gestion des Table ==================
    /** @pdOid 71ed9e95-9739-4b90-b4ad-c245803f545e */
    public void ajouterTable(int capacite, String etat) {
        String query = "INSERT INTO tables (capacite,etat) VALUES (?, ?)";
        try (Connection conn = Db_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1,capacite);
            stmt.setString(2, etat);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /** @pdOid 4ada51c1-a0cd-4bce-b556-c50f3a40764b */
    public void supprimerTable(int id) {
            String query = "DELETE FROM tables WHERE TableID = ?";
            try (Connection conn = Db_connection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Table supprimé " );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    /** @pdOid b3dccb61-5871-4e1b-8d78-f9234d8c4a45 */
    public float CalculerChifreDafaireMensuel() {
        // TODO: implement
        return 0;
    }

    /** @pdOid 2d7f44a1-cbc2-49b7-b233-bfdd1a0522ac */
    public double CalculerChifreDafaireQuotidien() {
        // TODO: implement
        return 0;
    }

}
