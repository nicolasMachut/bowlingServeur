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
        System.out.println("ok1");
        FileAttente waitingList = new FileAttente(bowling);
        System.out.println("ok2");
        waitingList.start();
        System.out.println("ok3");
        threadReceptionJoueur receptionJoueur = new threadReceptionJoueur(waitingList,bowling);
        System.out.println("ok4");
        receptionJoueur.start();
        System.out.println("ok5");
    }
}
