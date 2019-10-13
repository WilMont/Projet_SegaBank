package bo;

public class Compte {

    private int id;
    private double solde;
    private int agenceID;

    public Compte(){};

    public Compte(int id, double solde, int agenceID) {
        this.id = id;
        this.solde = solde;
        this.agenceID = agenceID;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAgenceID() {
        return agenceID;
    }

    public void setAgenceID(int agenceID) {
        this.agenceID = agenceID;
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
}
