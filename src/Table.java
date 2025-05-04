/***********************************************************************
 * Module:  Table.java
 * Author:  AdMin
 * Purpose: Defines the Class Table
 ***********************************************************************/

/** @pdOid f27a1df2-6661-4435-acd2-51172ef6f470 */
public class Table {
    /** @pdOid 2ae2b149-7c8f-4622-88e2-0a388b61d774 */
    private int id;
    /** @pdOid 61526cd2-504c-49d0-85f7-e071a0017705 */
    private int capacite;
    /** @pdOid 0df8dee3-5d77-4bd1-bcca-317bcb419b69 */
    private String etat; // libre, occupée, réservée

    public Table(int id, int capacite,String nom) {
        this.id = id;
        this.capacite = capacite;
        this.etat = "Libre";
    }

    // Getters et Setters
    public int getId() {
        return id;
    }
    public int getCapacite() {
        return capacite;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }

    public boolean estDisponible() {
        return etat.equalsIgnoreCase("libre");
    }

}
