/***********************************************************************
 * Module:  Commande.java
 * Author:  AdMin
 * Purpose: Defines the Class Commande
 ***********************************************************************/

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
/** @pdOid 50155a32-698d-4acc-b6e7-98906dc3c58b */
public class Commande {
    /** @pdOid abe85d5c-601f-41d3-a7a4-66e123ef6f83 */
    private static int id;
    static {
        try (Connection conn = Db_connection.getConnection()) {
            id = getLatestCommandeId(conn) ;
            if(id==0){
                try {
                    resetAutoIncrement(Db_connection.getConnection());
                }
                catch (SQLException f){
                    f.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /** @pdOid c17f3ad5-b2f5-4b64-8b6e-2f11aeac6cca */
    private double prix;
    /** @pdOid 8b5ab46e-d21f-4e46-9e24-71419b29aaf0 */
    private String statut;
    /** @pdRoleInfo migr=no name=Plat assc=Contient coll=java.util.Collection impl=java.util.HashSet mult=1..* */
    private List<Plat> plats;
    /** @pdOid 2c1cf87a-fa07-4a02-a7e5-5ffe2bb043e8 */
    private Table T;
    /** @pdOid e530657a-9644-4cf7-a663-675ce6a7dfe1 */
    private LocalDateTime time;


    // Constructeur



    public Commande(double prix, String statut) {
        id++;
        this.prix = prix;
        this.statut = statut;
        time=LocalDateTime.now();
    }


    // Getters et Setters


    public Table getT() {
        return T;
    }

    public void setT(Table t) {
        T = t;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setPlats(List<Plat> plats) {
        this.plats = plats;
    }

    public double getPrix() {
        return prix;
    }

    public String getStatut() {
        return statut;
    }

    public List<Plat> getPlats() {
        return plats;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    public static int getLatestCommandeId(Connection conn) throws SQLException {
        String sql = "SELECT MAX(CommandeID) AS latestId FROM commandes";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("latestId");
            } else {
                return -1; // Indicates no records found
            }
        }
    }
    public static void resetAutoIncrement(Connection conn) throws SQLException {
        String sql = "ALTER TABLE commandes AUTO_INCREMENT = 1"; // For MySQL/MariaDB
        // For PostgreSQL, use: ALTER SEQUENCE commandes_CommandeID_seq RESTART WITH 1;
        // For SQLite, use: DELETE FROM sqlite_sequence WHERE name='commandes';

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        }
    }
}
