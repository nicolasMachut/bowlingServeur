package Serveur;

import Thread.FileAttente;
import Thread.threadReceptionJoueur;

/**
 * Created by nicolas on 24/03/14.
 */

public class OuvertureBowling {
	
    public static void main(String[] args) {
    	//threadReceptionJoueur unThread = new threadReceptionJoueur();
    	//unThread.start();
        Bowling bowling = new Bowling();
        FileAttente waitingList = new FileAttente(bowling);
        threadReceptionJoueur receptionJoueur = new threadReceptionJoueur(waitingList);
    }
}
