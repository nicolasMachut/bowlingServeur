package Thread;

import Serveur.Bowling;
import Serveur.Equipe;
import Serveur.Piste;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by edouard on 21/06/14.
 */
public class FileAttente  {

	private Bowling bowling;

	public FileAttente(Bowling bowling) {
		super();
		this.bowling = bowling;
	}

		public synchronized String ajoutJoueursFileAttente(Equipe equipe){
		String tempsAttente = null;
		Piste meilleurePiste;
		try {
			
			System.out.println("meilleure piste" + this.bowling.getMeilleurePiste().getNumero());
			meilleurePiste = this.bowling.getMeilleurePiste();
			tempsAttente = String.valueOf(meilleurePiste.ajoutEquipe(equipe) + "," + meilleurePiste.getNumero());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempsAttente;
	}

}
