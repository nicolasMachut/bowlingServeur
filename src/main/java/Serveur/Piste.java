package Serveur;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by nicolas on 23/03/14.
 */
public class Piste extends Thread{
	private Queue<Equipe> waitingQueue = new ArrayDeque<Equipe>();
	private static int numeroEnCours = 0;
	private int numero;
	private Equipe equipe;
	final int dureePartieJoueur = 15 * 60;
	private int tempsAttenteFile = 0;
	final int tempsParlancer = 80;
	private boolean libre;

	public Equipe getEquipe(){
		return this.equipe;
	}
	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	private List<Joueur> joueurs;

	public Piste()
	{
		this.libre = true;
		this.joueurs = new ArrayList<Joueur>();
		numeroEnCours += 1;
		this.numero = numeroEnCours;

	}

	public int getNumero(){
		return this.numero;
	}

	/*public void NouvellePartie() throws Exception{
		if(this.libre)
		{
			this.libre = false;
			this.JouerPartie();
		}
		else
			throw new Exception("La piste est déjà occupée.");
	}*/

	public void NouvellePartie(){

	}

	@Override
	public void run()

	{
		while(true){
			if(this.libre)
			{
				if(!this.waitingQueue.isEmpty()){
					this.equipe = this.waitingQueue.peek();
					this.waitingQueue.poll();
					this.joueurs = this.equipe.getJoueurs();
					this.tempsAttenteFile -= this.equipe.getJoueurs().size() * this.dureePartieJoueur;
					this.libre = false;
				

				for(int i = 0; i < 10; i++)
				{
					for(Joueur unJoueur : this.joueurs)
					{
						unJoueur.jouerSonTour();
					}
				}
				for(Joueur unJoueur : this.joueurs)
				{
					System.out.println("score "+unJoueur.getPseudo()+" : "+unJoueur.score());
				}
				this.libre = true;
				}
			}

			//	this.joueurs = null;
			//this.equipe = null;
		}
	}

	public int nombreDeJoueurs()
	{
		return this.joueurs.size();
	}

	public String ajoutEquipe(Equipe equipe) throws Exception {
		String tempsAttente = null;
		if (equipe.getJoueurs().size() > Bowling.nombreDeJoueursParPartie)
		{
			throw new Exception("Trop de joueurs sur cette piste, " + Bowling.nombreDeJoueursParPartie  +" au maximum.");
		}
		this.tempsAttenteFile += equipe.getJoueurs().size() * this.dureePartieJoueur;
		if (this.waitingQueue.size() == 0){
			tempsAttente = String.valueOf(calculTempsAttente());
		}
		else{
			tempsAttente = String.valueOf(this.getTempsAttente());
		}
		this.waitingQueue.add(equipe);	
		return tempsAttente;
	}



	public boolean estLibre() {
		return this.libre;
	}

	public void CloturerPartie() {
		this.libre = true;
	}

	public int getTempsAttente()
	{
		int tempsAttente = 0;
		if (this.waitingQueue.size() > 0) {
			tempsAttente =  this.calculTempsAttente() + this.tempsAttenteFile;
		}
		else{
			tempsAttente = this.calculTempsAttente();
		}
		return tempsAttente;
	}

	private int calculTempsAttente()
	{
		int total = 0;
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (this.joueurs.size() > 0){
			for(int i  = 0; i < this.joueurs.size(); i++)
			{
				for(int j = 0; j < 20 - this.joueurs.get(i).getLanceCourant(); j++)
				{
					total += tempsParlancer;
				}
			}
		}
		return total;
	}
}