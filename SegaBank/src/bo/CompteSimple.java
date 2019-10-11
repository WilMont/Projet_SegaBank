package bo;

public class CompteSimple extends Compte {

    private double decouvert;

    public CompteSimple(int id, double solde, double decouvert) {
        super(id, solde);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public void retrait(double montant) {
        if(this.getSolde() - montant < (0 - decouvert)){
            System.out.println("OPERATION IMPOSSIBLE: La valeur de découvert autorisée serait dépassée.");
        } else
            if(this.getSolde() == (0 - decouvert)){
                System.out.println("OPERATION IMPOSSIBLE: La valeur de découvert est atteinte.");
            } else
                if(this.getSolde() >= (0 - decouvert)){
                    this.setSolde(this.getSolde() - montant);
                    System.out.println("La somme de " + montant + "€ a été débitée de ce compte.");
                    System.out.println("Solde actuel: " + this.getSolde() + "€.");
                }
    }
}
