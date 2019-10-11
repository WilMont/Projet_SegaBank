package bo;

public class ComptePayant extends Compte {

    public ComptePayant(int id, double solde) {
        super(id, solde);
    }

    @Override
    public void versement(double montant) {
        this.setSolde(this.getSolde() + montant - (montant * 5 / 100));
        System.out.println("La somme de " + montant + "€ a été versée sur ce compte.");
    }

    @Override
    public void retrait(double montant) {
        this.setSolde(this.getSolde() - montant - (montant * 5 / 100));
        System.out.println("La somme de " + montant + "€ a été débitée de ce compte.");
    }
}
