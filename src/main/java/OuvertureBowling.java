import Thread.*;
import Serveur.Bowling;
/**
 * Created by nicolas on 24/03/14.
 */
public class OuvertureBowling {
	
    public static void main(String[] args) {

        Bowling bowling = new Bowling();
        FileAttente fileAttente = new FileAttente(bowling);
        fileAttente.start();
        threadReceptionJoueur receptionJoueur = new threadReceptionJoueur(fileAttente);

    }
}
