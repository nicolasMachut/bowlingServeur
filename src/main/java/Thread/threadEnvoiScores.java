package Thread;

import envoiScores._threadEnvoiScoresDisp;
import Ice.Current;
import Serveur.Bowling;
import Serveur.Joueur;
import Serveur.Piste;

public class threadEnvoiScores extends _threadEnvoiScoresDisp {

	private Bowling bowling;

	public threadEnvoiScores(Bowling bowling){
		super();
		this.bowling = bowling;
	}
	public String getScores(int identifiantEquipe, Current __current) {
		String scores = null;
		for (Piste piste : this.bowling.getPistes()){
			if(piste.getEquipe().getIdentifiant() == identifiantEquipe){
				for (Joueur joueur : piste.getJoueurs()){
					scores = joueur.getPseudo() + ":" + joueur.getScoreCourant() + ",";				}
			}
			else{
				scores = "0";
			}
		}
		return scores;
	}

}
