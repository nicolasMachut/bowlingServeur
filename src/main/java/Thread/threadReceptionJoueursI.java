package Thread;

import Ice.Current;
import Serveur.Equipe;
import Serveur.Joueur;
import receptionJoueurs._threadReceptionJoueursDisp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class threadReceptionJoueursI extends _threadReceptionJoueursDisp {
    private FileAttente fileAttente;
    
    public threadReceptionJoueursI(FileAttente fileAttente){
        super();
        this.fileAttente = fileAttente;
    }

	public String inscriptionJoueur(String[] maListe, Current __current) {
		Equipe equipe = new Equipe();
		List<Joueur> lesJoueurs = new ArrayList<Joueur>();
        for(String pseudo : maListe){
        	if (!pseudo.equals("")){
               Joueur unJoueur = new Joueur(pseudo);
               lesJoueurs.add(unJoueur);
            }
        }
        equipe.setJoueurs(lesJoueurs);
        return fileAttente.ajoutJoueursFileAttente(equipe) + "," + String.valueOf(equipe.getIdentifiant());
	}

	


}
