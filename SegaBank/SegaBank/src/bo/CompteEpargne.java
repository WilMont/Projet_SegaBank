package bo;

public class CompteEpargne extends Compte {

    private double tauxInteret;

    public CompteEpargne(int id, double solde, int agenceID, double tauxInteret) {
        super(id, solde, agenceID);
        this.tauxInteret = tauxInteret;
    }

    public void calculInteret(){
        double interets = this.getSolde()/tauxInteret;
        this.setSolde(this.getSolde() + interets);
        System.out.println("La somme de " + interets + "€ a été ajoutée ce compte.");
        System.out.println("Solde actuel: " + this.getSolde() + "€.");
    }

}
