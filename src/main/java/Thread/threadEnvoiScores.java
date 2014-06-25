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
		String scores = "0";
		for (Piste piste : this.bowling.getPistes()){
			if (!piste.estLibre()){
				if(piste.getEquipe().getIdentifiant() == identifiantEquipe){
					scores = "";
					System.out.println("passe" + scores);
					for (Joueur joueur : piste.getJoueurs()){
						scores = scores + joueur.getPseudo() + ": " + joueur.getScoreCourant() + " point(s),";				}
				}
				else{
					System.out.println("passe pas" + scores);
				}
			}
		}
		return scores;
	}

}
