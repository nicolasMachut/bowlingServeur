package Serveur;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nicolas on 24/03/14.
 */

public class OuvertureBowling {
	
    public static void main(String[] args) {
    	//threadReceptionJoueur unThread = new threadReceptionJoueur();
    	//unThread.start();
        Bowling bowling = new Bowling();

        Stack<List<Joueur>> fileAttente = new Stack<List<Joueur>>();

        List<Joueur> equipe1 = new ArrayList<Joueur>();
        List<Joueur> equipe2 = new ArrayList<Joueur>();
        //equipe1.add();

        Joueur joueur1 = new Joueur("Nicolas");
        Joueur joueur2 = new Joueur("Edouard");

        equipe1.add(joueur1);
        equipe1.add(joueur2);

        fileAttente.add(equipe1);
        fileAttente.add(equipe2);



        try {
            bowling.getPistes()[1].NouvellePartie();
            bowling.getPistes()[1].ajoutDesJoueurs(equipe1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
