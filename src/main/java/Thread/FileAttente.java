package Thread;

import Serveur.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

            Joueur ownSstick = new Joueur("Nicolas");
            Joueur laTruelle = new Joueur("AlexBrbz");
            Joueur meph = new Joueur("Johan");

            Joueur crymx = new Joueur("AlexSt");
            Joueur liquitheory = new Joueur("Edouard");

            List<Joueur> equipe1 = new ArrayList<Joueur>();
            equipe1.add(ownSstick);
            equipe1.add(laTruelle);
            equipe1.add(meph);

            waitingQueue.add(equipe1);

            List<Joueur> equipe2 = new ArrayList<Joueur>();
            equipe2.add(crymx);
            equipe2.add(liquitheory);

            waitingQueue.add(equipe2);

            while(waitingQueue.size()>0){
                List<Joueur> uneEquipe = waitingQueue.peek();
                waitingQueue.poll();

            }
            try {
                bowling.getPistes()[1].NouvellePartie();
                bowling.getPistes()[1].ajoutDesJoueurs(equipe1);
                bowling.getPistes()[1].JouerPartie();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void ajoutJoueursFileAttente(List<Joueur> team){
        waitingQueue.add(team);
    }
}
