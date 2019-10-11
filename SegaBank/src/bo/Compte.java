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

    public void versement(double montant){
        this.setSolde(this.solde += montant);
        System.out.println("La somme de " + montant + "€ a été versée sur ce compte.");
    }

    public void retrait(double montant){
        this.setSolde(this.solde -= montant);
        System.out.println("La somme de " + montant + "€ a été débitée de ce compte.");
    }
}
