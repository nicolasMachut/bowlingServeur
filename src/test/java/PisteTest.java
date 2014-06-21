
import Serveur.Piste;
import org.junit.Before;
import org.junit.Test;

import Serveur.Bowling;
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

    @Before
    public void setup()
    {
        this.piste = new Piste();
        this.bowling = new Bowling();

    }

    @Test
    public void ajoutTropDeJoueurs()
    {
        List<Joueur> uneListeJoueur= new ArrayList<Joueur>();
        for(int i = 0; i < 10; i++)
        {
            Joueur unJoueur = new Joueur();
            uneListeJoueur.add(unJoueur);
        }

        try {
            this.piste.ajoutDesJoueurs(uneListeJoueur);
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
        List<Joueur> equipe = new ArrayList<Joueur>();
        equipe.add(new Joueur());
        equipe.add(new Joueur());
        try {
            this.piste.ajoutDesJoueurs(equipe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(30*60, this.piste.getTempsAttente());
    }


    @Test
    public void testTempsEcoule()
    {
        try {
            this.piste.NouvellePartie();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Joueur> equipe = new ArrayList<Joueur>();
        equipe.add(new Joueur());
        equipe.add(new Joueur());

        try {
            this.piste.ajoutDesJoueurs(equipe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        equipe.get(1).lance(6);
        assertEquals(30 * 60 - 5, piste.getTempsAttente());
    }


}