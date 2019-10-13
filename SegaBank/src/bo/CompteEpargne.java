package bo;

public class CompteEpargne extends Compte {

    private double tauxInteret;

    public CompteEpargne(){};

    public CompteEpargne(int id, double solde, int agenceID, double tauxInteret) {
        super(id, solde, agenceID);
        this.tauxInteret = tauxInteret;
    }

    public void calculInteret(){
        double interets = this.getSolde()*this.getTauxInteret()/100;
        this.setSolde(this.getSolde() + interets);
        System.out.println("La somme de " + interets + "€ a été ajoutée ce compte.");
        System.out.println("Solde actuel: " + this.getSolde() + "€.");
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public String toString() {
        return "Compte Epargne{" +
            "id=" + this.getId() +
                    ", solde=" + this.getSolde() +
                    ", agence=" + this.getAgenceID() +
                    ", taux intérêts=" + this.getTauxInteret() + "%" +
                    '}';
    }
}
