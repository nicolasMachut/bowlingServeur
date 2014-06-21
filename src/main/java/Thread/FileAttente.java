package Thread;

import Serveur.Bowling;
import Serveur.Joueur;
import Serveur.Piste;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Created by edouard on 21/06/14.
 */
public class FileAttente extends Thread {
        private Queue<List<Joueur>> waitingQueue = new ArrayDeque<List<Joueur>>();
        private Bowling bowling;

    public FileAttente(Bowling bowling) {
        super();
        this.bowling = bowling;
    }

    public void run(){
        while (true){
            Piste unePiste = bowling.getMeilleurePiste();
            if(unePiste.estLibre()){
                try {
                    unePiste.NouvellePartie();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    unePiste.ajoutDesJoueurs(waitingQueue.peek());
                    waitingQueue.poll();
                    unePiste.JouerPartie();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void ajoutJoueursFileAttente(List<Joueur> team){
        waitingQueue.add(team);
    }
}
