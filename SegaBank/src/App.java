import bo.*;
import dal.*;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        CompteSimpleDAL compteSimpleDAL = new CompteSimpleDAL();
        CompteEpargneDAL compteEpargneDAL = new CompteEpargneDAL();
        ComptePayantDAL comptePayantDAL = new ComptePayantDAL();
        CompteDetermineurDAL compteDetermineurDAL = new CompteDetermineurDAL();
        AgenceDAL agenceDAL = new AgenceDAL();

        System.out.println(" ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄    ▄ \n" +
                "▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░▌  ▐░▌\n" +
                "▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌▐░▌ ▐░▌ \n" +
                "▐░▌          ▐░▌          ▐░▌          ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌▐░▌  \n" +
                "▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌ ▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▌   ▐░▌▐░▌░▌   \n" +
                "▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌▐░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░░▌    \n" +
                " ▀▀▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░▌ ▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌   ▐░▌ ▐░▌▐░▌░▌   \n" +
                "          ▐░▌▐░▌          ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌▐░▌  \n" +
                " ▄▄▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░▌     ▐░▐░▌▐░▌ ▐░▌ \n" +
                "▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░▌      ▐░░▌▐░▌  ▐░▌\n" +
                " ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀   ▀         ▀  ▀        ▀▀  ▀    ▀ \n" +
                "                                                                                                   ");


        boolean arret = false;
        while (!arret) {
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            System.out.println("--- Menu ---");
            System.out.println("[1] - Créer un compte");
            System.out.println("[2] - Créer une agence");
            System.out.println("[3] - Effectuer des opérations sur un compte");
            System.out.println("[4] - Afficher toutes les agences");
            System.out.println("[5] - Exporter l'historique des opérations (Format CSV) [Pas encore implémenté]");
            System.out.println("[0] - Quitter");
            System.out.print("Votre choix: ");

            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            String choixMenuPrincipal = br1.readLine();
            switch (choixMenuPrincipal) {
                case "1": {
                    System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
                    System.out.println("--- Créer un compte ---");
                    System.out.println("Quel type de compte voulez-vous créer ?");
                    System.out.println("[1] - Compte Simple");
                    System.out.println("[2] - Compte Epargne");
                    System.out.println("[3] - Compte Payant");
                    System.out.println("[0] - Quitter");
                    System.out.print("Votre choix: ");
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                    String choixMenuComptes = br2.readLine();
                    switch (choixMenuComptes) {
                        case "1":
                            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
                            System.out.println("--- Créer un compte Simple ---");
                            System.out.print("Entrez le solde du compte: ");
                            Scanner sc1 = new Scanner(System.in);
                            double soldeChoisiCompteSimple = sc1.nextDouble();
                            System.out.print("Entrez l'id de l'agence s'occupant du compte: ");
                            int idAgenceChoisiCompteSimple = sc1.nextInt();
                            Long longIdAgenceChoisieCompteSimple = (long) idAgenceChoisiCompteSimple;
                            try {
                                agenceDAL.findById(longIdAgenceChoisieCompteSimple);
                                try {
                                    System.out.print("Entrez la valeur de découvert maximum autorisé: ");
                                    double decouvertChoisiCompteSimple = sc1.nextDouble();
                                    CompteSimple compteSimple = new CompteSimple(1, soldeChoisiCompteSimple, idAgenceChoisiCompteSimple, decouvertChoisiCompteSimple);
                                    compteSimpleDAL.create(compteSimple);
                                    System.out.println("Le compte a bien été créé");
                                    System.out.print("Veuillez noter votre numéro de compte: ");
                                    System.out.println(compteSimpleDAL.findLastInserted().getId());
                                } catch (Exception e) {
                                    System.out.println("Une erreur est survenue: l'id de l'agence entré n'existe pas.");
                                }
                            } catch (Exception e) {
                                System.out.println("Une erreur est survenue. Veuillez nous excuser pour la gêne occasionnée.");
                                e.printStackTrace();
                            }
                            break;
                        case "2":
                            System.out.println("--- Créer un compte Epargne ---");
                            System.out.print("Entrez le solde du compte: ");
                            Scanner sc2 = new Scanner(System.in);
                            double soldeChoisiCompteEpargne = sc2.nextDouble();
                            System.out.print("Entrez l'id de l'agence s'occupant du compte: ");
                            int idAgenceChoisiCompteEpargne = sc2.nextInt();
                            Long longIdAgenceChoisieCompteEpargne = (long) idAgenceChoisiCompteEpargne;
                            try {
                                agenceDAL.findById(longIdAgenceChoisieCompteEpargne);
                                try {
                                    System.out.print("Entrez la valeur de découvert maximum autorisé: ");
                                    double tauxInteret = sc2.nextDouble();
                                    CompteEpargne compteEpargne = new CompteEpargne(1, soldeChoisiCompteEpargne, idAgenceChoisiCompteEpargne, tauxInteret);
                                    compteEpargneDAL.create(compteEpargne);
                                    System.out.println("Le compte a bien été créé");
                                    System.out.print("Veuillez noter votre numéro de compte: ");
                                    System.out.println(compteEpargneDAL.findLastInserted().getId());
                                } catch (Exception e) {
                                    System.out.println("Une erreur est survenue: l'id de l'agence entré n'existe pas.");
                                }
                            } catch (Exception e) {
                                System.out.println("Une erreur est survenue. Veuillez nous excuser pour la gêne occasionnée.");
                                e.printStackTrace();
                            }
                            break;
                        case "3":
                            System.out.println("--- Créer un compte Payant ---");
                            System.out.print("Entrez le solde du compte: ");
                            Scanner sc3 = new Scanner(System.in);
                            double soldeChoisiComptePayant = sc3.nextDouble();
                            System.out.print("Entrez l'id de l'agence s'occupant du compte: ");
                            int idAgenceChoisiComptePayant = sc3.nextInt();
                            Long longIdAgenceChoisieComptePayant = (long) idAgenceChoisiComptePayant;
                            try {
                                agenceDAL.findById(longIdAgenceChoisieComptePayant);
                                try {
                                    ComptePayant comptePayant = new ComptePayant(1, soldeChoisiComptePayant, idAgenceChoisiComptePayant);
                                    comptePayantDAL.create(comptePayant);
                                    System.out.println("Le compte a bien été créé");
                                    System.out.print("Veuillez noter votre numéro de compte: ");
                                    System.out.println(comptePayantDAL.findLastInserted().getId());
                                } catch (Exception e) {
                                    System.out.println("Une erreur est survenue: l'id de l'agence entré n'existe pas.");
                                }
                            } catch (Exception e) {
                                System.out.println("Une erreur est survenue. Veuillez nous excuser pour la gêne occasionnée.");
                                e.printStackTrace();
                            }
                            break;
                        case "0":
                            arret = true;
                            break;
                        default:
                            System.out.println("Entrez un choix entre 1 et 3");
                            break;
                    }
                }
                break;
                case "2": {
                    System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
                    System.out.println("--- Créer une agence ---");
                    System.out.print("Entrez le code de l'agence: ");
                    Scanner sc1 = new Scanner(System.in);
                    int codeAgenceChoisi = sc1.nextInt();
                    System.out.print("Entrez l'adresse de l'agence: ");
                    String adresseAgenceChoisie = sc1.next();
                    try {
                        Agence agence = new Agence(1, codeAgenceChoisi, adresseAgenceChoisie);
                        agenceDAL.create(agence);
                        System.out.println("L'agence a bien été créée");
                        System.out.print("Veuillez noter le numéro d'agence (id): ");
                        System.out.println(agenceDAL.findLastInserted().getId());
                    } catch (Exception e) {
                        System.out.println("Une erreur est survenue. Veuillez nous excuser pour la gêne occasionnée.");
                        e.printStackTrace();
                    }
                    break;
                }
                case "3":
                    System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
                    System.out.print("Veuillez entrer votre numéro de compte: ");
                    Scanner sc = new Scanner(System.in);
                    int numCompteActif = sc.nextInt();
                    Long longNumCompteActif = (long) numCompteActif;

                    try {
                        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
                        System.out.println("Choisissez l'opération que vous souhaitez effectuer: ");
                        System.out.println("[1] - Effectuer un versement");
                        System.out.println("[2] - Effectuer un retrait");
                        System.out.println("[3] - Consulter le solde du compte");
                        System.out.println("[4] - Calculer les intérêts du compte");
                        System.out.println("[5] - Fermer ce compte");
                        System.out.println("[0] - Quitter");
                        System.out.print("Votre choix: ");
                        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                        String choixOperationCompte = br2.readLine();

                        try {
                            switch (choixOperationCompte) {
                                case "1":
                                    var compteVersement = compteDetermineurDAL.findById(longNumCompteActif);
                                    if (compteVersement.getDecouvert() == 0.0 && compteVersement.getTauxInteret() != 0.0) {
                                        CompteEpargne compteEpargne = new CompteEpargne(compteVersement.getId(), compteVersement.getSolde(), compteVersement.getAgenceID(), compteVersement.getTauxInteret());
                                        System.out.print("Entrez le montant que vous souhaitez verser sur ce compte: ");
                                        Scanner sc1 = new Scanner(System.in);
                                        double montantVersement = sc1.nextDouble();
                                        compteEpargne.versement(montantVersement);
                                        compteEpargneDAL.update(compteEpargne);
                                    } else if (compteVersement.getDecouvert() == 0.0 && compteVersement.getTauxInteret() == 0.0) {
                                        ComptePayant comptePayant = new ComptePayant(compteVersement.getId(), compteVersement.getSolde(), compteVersement.getAgenceID());
                                        System.out.print("Entrez le montant que vous souhaitez verser sur ce compte: ");
                                        Scanner sc1 = new Scanner(System.in);
                                        double montantVersement = sc1.nextDouble();
                                        comptePayant.versement(montantVersement);
                                        comptePayantDAL.update(comptePayant);
                                    } else if (compteVersement.getTauxInteret() == 0.0 && compteVersement.getDecouvert() != 0.0) {
                                        CompteSimple compteSimple = new CompteSimple(compteVersement.getId(), compteVersement.getSolde(), compteVersement.getAgenceID(), compteVersement.getDecouvert());
                                        System.out.print("Entrez le montant que vous souhaitez verser sur ce compte: ");
                                        Scanner sc1 = new Scanner(System.in);
                                        double montantVersement = sc1.nextDouble();
                                        compteSimple.versement(montantVersement);
                                        compteSimpleDAL.update(compteSimple);
                                    }

                                    break;
                                case "2":
                                    var compteRetrait = compteDetermineurDAL.findById(longNumCompteActif);
                                    if (compteRetrait.getDecouvert() == 0.0 && compteRetrait.getTauxInteret() != 0.0) {
                                        CompteEpargne compteEpargne = new CompteEpargne(compteRetrait.getId(), compteRetrait.getSolde(), compteRetrait.getAgenceID(), compteRetrait.getTauxInteret());
                                        System.out.print("Entrez le montant que vous souhaitez verser sur ce compte: ");
                                        Scanner sc1 = new Scanner(System.in);
                                        double montantRetrait = sc1.nextDouble();
                                        compteEpargne.retrait(montantRetrait);
                                        compteEpargneDAL.update(compteEpargne);
                                    } else if (compteRetrait.getDecouvert() == 0.0 && compteRetrait.getTauxInteret() == 0.0) {
                                        ComptePayant comptePayant = new ComptePayant(compteRetrait.getId(), compteRetrait.getSolde(), compteRetrait.getAgenceID());
                                        System.out.print("Entrez le montant que vous souhaitez verser sur ce compte: ");
                                        Scanner sc1 = new Scanner(System.in);
                                        double montantRetrait = sc1.nextDouble();
                                        comptePayant.retrait(montantRetrait);
                                        comptePayantDAL.update(comptePayant);
                                    } else if (compteRetrait.getTauxInteret() == 0.0 && compteRetrait.getDecouvert() != 0.0) {
                                        CompteSimple compteSimple = new CompteSimple(compteRetrait.getId(), compteRetrait.getSolde(), compteRetrait.getAgenceID(), compteRetrait.getDecouvert());
                                        System.out.print("Entrez le montant que vous souhaitez verser sur ce compte: ");
                                        Scanner sc1 = new Scanner(System.in);
                                        double montantRetrait = sc1.nextDouble();
                                        compteSimple.retrait(montantRetrait);
                                        compteSimpleDAL.update(compteSimple);
                                    }
                                    break;
                                case "3":
                                    CompteDetermineur compteSolde = compteDetermineurDAL.findById(longNumCompteActif);
                                    if (compteSolde.getDecouvert() == 0.0 && compteSolde.getTauxInteret() != 0.0) {
                                        CompteEpargne compteEpargne = new CompteEpargne(compteSolde.getId(), compteSolde.getSolde(), compteSolde.getAgenceID(), compteSolde.getTauxInteret());
                                        System.out.println(compteEpargne.toString());
                                    } else if (compteSolde.getDecouvert() == 0.0 && compteSolde.getTauxInteret() == 0.0) {
                                        ComptePayant comptePayant = new ComptePayant(compteSolde.getId(), compteSolde.getSolde(), compteSolde.getAgenceID());
                                        System.out.println(comptePayant.toString());
                                    } else if (compteSolde.getTauxInteret() == 0.0 && compteSolde.getDecouvert() != 0.0) {
                                        CompteSimple compteSimple = new CompteSimple(compteSolde.getId(), compteSolde.getSolde(), compteSolde.getAgenceID(), compteSolde.getDecouvert());
                                        System.out.println(compteSimple.toString());
                                    }
                                    break;
                                case "4":
                                    var compteTauxInteret = compteDetermineurDAL.findById(longNumCompteActif);
                                    if (compteTauxInteret.getTauxInteret() != 0.0 && compteTauxInteret.getDecouvert() == 0.0) {
                                        CompteEpargne compteEpargne = new CompteEpargne(compteTauxInteret.getId(), compteTauxInteret.getSolde(), compteTauxInteret.getAgenceID(), compteTauxInteret.getTauxInteret());
                                        compteEpargne.calculInteret();
                                        compteEpargneDAL.update(compteEpargne);
                                    } else {
                                        System.out.println("Ce service est réservé aux comptes épargne");
                                    }
                                    break;
                                case "5":
                                    System.out.println("Voulez-vous vraiment fermer définitivement ce compte (n/o) ?");
                                    System.out.print("Votre choix: ");
                                    BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
                                    String choixSuppressionCompte = br3.readLine();
                                    switch (choixSuppressionCompte) {
                                        case "n":
                                            System.out.println("Clôture du compte annulée");
                                            break;
                                        case "o":
                                            compteSimpleDAL.removeById(numCompteActif);
                                            System.out.println("Ce compte a bien été clôturé");
                                            break;
                                        default:
                                            System.out.println("Merci de choisir une option entre n/o");
                                    }
                                    break;
                                case "0":
                                    arret = true;
                                    break;
                                default:
                                    System.out.println("entrez un choix entre 1 et 3");
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("Une erreur est survenue: aucun compte n'a été trouvé avec ce numéro de compte");
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        System.out.println("Une erreur est survenue. Veuillez nous excuser pour la gêne occasionnée.");
                        e.printStackTrace();
                    }
                case "4":
                    System.out.println("--- Liste des agences ---");
                    for (Agence agence : agenceDAL.findAll()
                    ) {
                        System.out.println("Id: " + agence.getId() + "\nCode: " + agence.getCode() + "\nAdresse: " + agence.getAdresse() + "\n-------------------------------------------------------");
                    }

                    break;
                case "5":
                    //Fonction pas encore implémentée.
                    System.out.println("Désolé ce service n'est pas encore implémenté.");
                    break;
                case "0":
                    arret = true;
                    break;
                default:
                    System.out.println("entrez un choix entre 1 et 5");
                    break;
            }
        }
    }
}
