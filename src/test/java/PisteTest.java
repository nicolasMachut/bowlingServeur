
import Serveur.Piste;

import org.junit.Before;
import org.junit.Test;

import Serveur.Bowling;
import Serveur.Equipe;
import Serveur.Joueur;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by nicolas on 23/03/14.
 */
public class PisteTest {

	private Piste piste;
	private Bowling bowling;
	private static int numero = 0;

	@Before
	public void setup()
	{
		this.piste = new Piste();
		this.bowling = new Bowling();

	}

	@Test
	public void ajoutTropDeJoueurs()
	{
		Equipe equipe = new Equipe();
		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(new Joueur());
		joueurs.add(new Joueur());
		equipe.setJoueurs(joueurs);
		for(int i = 0; i < 10; i++)
		{

			joueurs.add(new Joueur());
			joueurs.add(new Joueur());

		}
		equipe.setJoueurs(joueurs);
		try {
			this.piste.ajoutEquipe(equipe);
			fail("Erreur, une exception était attendue");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testPisteLibreALaCreation()
	{

		boolean libre = this.piste.estLibre();
		assertTrue(libre);
	}
	@Test
	public void testPisteOccupeApresCreation()
	{
		try {
			this.piste.NouvellePartie();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean libre = this.piste.estLibre();
		assertFalse(libre);
	}
	@Test
	public void testPisteLibrePartieTerminee()
	{
		try {
			this.piste.NouvellePartie();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.piste.CloturerPartie();
		boolean libre = this.piste.estLibre();
		assertTrue(libre);
	}

	@Test
	public void testCreerPartieSurPisteOccupe()
	{

		try
		{
			bowling.getPistes()[1].NouvellePartie();
			bowling.getPistes()[1].NouvellePartie();
			fail("Erreur, une exception était attendue");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
	@Test
	public void testTempsAttente()
	{
		try {
			this.piste.NouvellePartie();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Equipe equipe = new Equipe();
		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(new Joueur());
		joueurs.add(new Joueur());
		equipe.setJoueurs(joueurs);
		try {
			this.piste.ajoutEquipe(equipe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(400, this.piste.getTempsAttente());
	}
}