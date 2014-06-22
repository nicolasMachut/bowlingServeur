package Thread;

import Ice.Current;
import Serveur.Joueur;
import receptionJoueurs._threadReceptionJoueursDisp;

import java.util.ArrayList;
import java.util.List;

public class threadReceptionJoueursI extends _threadReceptionJoueursDisp {
    private FileAttente fileAttente;

    public threadReceptionJoueursI(FileAttente fileAttente){
        super();
        this.fileAttente = fileAttente;
    }

	public String inscriptionJoueur(String[] maListe, Current __current) {
        List<Joueur> uneEquipe = new ArrayList<Joueur>();
        for(String pseudo : maListe){
               Joueur unJoueur = new Joueur(pseudo);
               uneEquipe.add(unJoueur);
            }
        
        return fileAttente.ajoutJoueursFileAttente(uneEquipe);
	}

	


}
