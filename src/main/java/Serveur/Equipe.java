package Serveur;

import java.util.List;

public class Equipe {
	private List<Joueur> joueurs;
	static int identifiantGlobal = 0;
	private int identifiant;

	public Equipe(){
		this.identifiant = Equipe.identifiantGlobal;
		Equipe.identifiantGlobal++;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public int getIdentifiant(){
		return this.identifiant;
	}
}
