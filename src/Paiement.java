import java.time.LocalDateTime;

public class Paiement {
    private static int id;
    private int commandeId;
    private double montant;
    private String modePaiement;
    private LocalDateTime datePaiement;

    public Paiement(int id, int commandeId, double montant, String modePaiement) {
        id++;
        this.commandeId = commandeId;
        this.montant = montant;
        this.modePaiement = modePaiement;
        this.datePaiement = LocalDateTime.now();
    }

    public Paiement() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }
}
