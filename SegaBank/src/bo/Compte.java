package bo;

public class Compte {

    private int id;
    private double solde;
    private double agenceID;

    public Compte(int id, double solde, int agenceID) {
        this.id = id;
        this.solde = solde;
        this.agenceID = agenceID;
    }

    public int getId() {
        return id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", solde=" + solde +
                ", agence=" + agenceID +
                '}';
    }

    public void versement(double montant){
        this.setSolde(this.solde += montant);
        System.out.println("La somme de " + montant + "€ a été versée sur ce compte.");
    }

    public void retrait(double montant){
        this.setSolde(this.solde -= montant);
        System.out.println("La somme de " + montant + "€ a été débitée de ce compte.");
    }

    public double getAgence() {
        return agenceID;
    }

    public void setAgence(double agence) {
        this.agenceID = agenceID;
    }
}
