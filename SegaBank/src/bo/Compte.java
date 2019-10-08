package bo;

public class Compte {

    private int id;
    private double solde;

    public Compte(int id, double solde) {
        this.id = id;
        this.solde = solde;
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
                "id= " + id +
                ", solde= " + solde +
                '}';
    }

    public double versement(double montant){
        this.setSolde(this.solde += montant);
        return this.solde += montant;
    }

    public double retrait(double montant){
        this.setSolde(this.solde -= montant);
        return this.solde -= montant;
    }
}
