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

	public String ajoutJoueursFileAttente(Equipe equipe){
		String tempsAttente = null;
		try {
			tempsAttente = String.valueOf(this.bowling.getMeilleurePiste().ajoutEquipe(equipe) + "," + this.bowling.getMeilleurePiste().getNumero());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ajouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuut");
		return tempsAttente;
	}

}
