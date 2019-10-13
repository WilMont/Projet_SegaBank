package bo;

public class CompteDetermineur extends Compte {

    private double decouvert;
    private double tauxInteret;

    public CompteDetermineur(){};

    public CompteDetermineur(int id, double solde, int agenceID, double decouvert, double tauxInteret) {
        super(id, solde, agenceID);
        this.decouvert = decouvert;
        this.tauxInteret = tauxInteret;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
