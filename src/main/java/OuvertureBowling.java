import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Thread.threadReceptionJoueur;

/**
 * Created by nicolas on 24/03/14.
 */
public class OuvertureBowling {
	
    public static void main(String[] args) {
    	threadReceptionJoueur unThread = new threadReceptionJoueur();
    	unThread.start();
        Bowling bowling = new Bowling();

        Stack<List<Joueur>> fileAttente = new Stack<List<Joueur>>();

        List<Joueur> equipe1 = new ArrayList<Joueur>();
        List<Joueur> equipe2 = new ArrayList<Joueur>();

        fileAttente.add(equipe1);
        fileAttente.add(equipe2);

        try {
            bowling.getPistes()[1].NouvellePartie();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < bowling.getPistes().length; i++)
        {
            System.out.println("Piste n° "+ (i+1) +" : "+bowling.getPistes()[i].estLibre());
        }
    }
}
