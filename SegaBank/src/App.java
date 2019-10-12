import bo.*;
import dal.AgenceDAL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        AgenceDAL agenceDAL = new AgenceDAL();
        Agence agence = new Agence(1, 5520, "Nantes");
        agenceDAL.create(agence);
        agenceDAL.findAll();

        List<Compte> listeComptes = new ArrayList<>();

        CompteSimple compteSimple = new CompteSimple(1, 100 ,100, 10);
        CompteEpargne compteEpargne = new CompteEpargne(2, 100, 1, 10);
        ComptePayant comptePayant = new ComptePayant(3, 100, 1);

        listeComptes.add(compteSimple);
        listeComptes.add(compteEpargne);
        listeComptes.add(comptePayant);

        try{
            Agence agence1 = new Agence(1, 452, "Paris");

        } catch (Exception SQLe){
            SQLe.printStackTrace();
        }




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

        int compteActif = 0;

        if (compteActif == 0) {
            System.out.print("Bonjour \n Entrez votre numéro de compte: ");
            Scanner sc1 = new Scanner(System.in);
            try {
                compteActif = sc1.nextInt();
            } catch (Exception e) {
                System.out.println("Une erreur est survenue. Avez-vous bien entré un numéro ?");
            } finally {
                sc1.close();
            }

        }

        /*
        if (compteActif != 0) {

            System.out.println("Choisissez l'opération que vous souhaitez effectuer: ");
            System.out.println("");
            System.out.println("[1] Effectuer un versement");
            System.out.println("");
            System.out.println("[2] Effectuer un retrait");
            System.out.println("");
            System.out.println("[3] Consulter le solde du compte");
            System.out.println("");



            try {

                System.out.print("Votre choix: ");
                Scanner sc2 = new Scanner(System.in);
                int choix = sc2.nextInt();
                sc2.close();

                switch (choix) {
                    case 1:
                        for (Compte compte : listeComptes
                        ) {
                            if (compte.getId() == compteActif) {
                                System.out.print("Entrez le montant du versement: ");
                                Scanner sc3 = new Scanner(System.in);
                                double montantVersement = sc3.nextDouble();
                                sc3.close();
                                compte.versement(montantVersement);
                            }
                        }
                        break;
                    case 2:
                        for (Compte compte : listeComptes
                        ) {
                            if (compte.getId() == compteActif) {
                                System.out.print("Entrez le montant du débitement: ");
                                Scanner sc4 = new Scanner(System.in);
                                double montantDebitement = sc4.nextDouble();
                                sc4.close();
                                compte.versement(montantDebitement);
                            }
                        }
                        break;
                    default:
                        break;
                }

            } catch (Exception ex) {
                System.out.println("Une erreur est survenue.");
                ex.printStackTrace();
            }

        }   */

    }

}
