package Thread;

import Serveur.Bowling;
import Serveur.Equipe;
import Serveur.Piste;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by edouard on 21/06/14.
 */
public class FileAttente extends Thread {
        private Queue<Equipe> waitingQueue = new ArrayDeque<Equipe>();
        private Bowling bowling;
        private int tempsAttenteFile = 0;
        final int tempsJeuJoueur = 15 * 60;
    public FileAttente(Bowling bowling) {
        super();
        this.bowling = bowling;
    }

    public void run(){
        while (true){
            Piste unePiste = bowling.getMeilleurePiste();
            if(unePiste.estLibre() && !waitingQueue.isEmpty()){
                try {
                    unePiste.ajoutEquipe(waitingQueue.peek());
                    waitingQueue.poll();
                    unePiste.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String ajoutJoueursFileAttente(Equipe equipe){
    	int tempsAttenteEstime = 0;
    	int numeroPiste;
        waitingQueue.add(equipe);
        if(bowling.getMeilleurePiste().getTempsAttente() > 0){
        	tempsAttenteEstime =  this.tempsAttenteFile + bowling.getMeilleurePiste().getTempsAttente();
        }
        this.tempsAttenteFile += calculTempsJeuEstimeEquipe(equipe);
        return String.valueOf(tempsAttenteEstime) + "," + String.valueOf(bowling.getMeilleurePiste().getNumero());
       
    }
    
    private int calculTempsJeuEstimeEquipe (Equipe equipe){
    	return tempsJeuJoueur * equipe.getJoueurs().size();
    }
}
