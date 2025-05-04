
/***********************************************************************
 * Module:  Plat.java
 * Author:  AdMin
 * Purpose: Defines the Class Plat
 ***********************************************************************/
public class Plat {
    /** @pdOid 15fdb18f-df83-407b-b971-6a3558aa178a */
    private int id;
    /** @pdOid 68651907-1787-4e76-b0c4-6b76ef006c19 */
    private String nom;
    /** @pdOid a6ff07fc-7b87-472c-afae-cdca0a5772bb */
    private double prix;
    /** @pdOid 88a3d373-fe62-484b-a5d5-dc33409738e4 */
    private String type; // entrée, plat principal, dessert, boisson
    /** @pdOid 3fd1b4cd-570e-4380-848f-2b18c64c0adb */
    private byte[] imageBytes;

    public Plat() {
    }


    // Getters et Setter

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
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

    public double getPrix() {

        return prix;
    }

    public void setPrix(double prix) {

        this.prix = prix;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
