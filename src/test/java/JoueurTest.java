
import org.junit.Before;
import org.junit.Test;

import Serveur.Joueur;
import static org.junit.Assert.*;

/**
 * Created by nicolas on 14/03/14.
 */
public class JoueurTest {

    private Joueur joueur;

    @Before
    public void setup()
    {
        joueur = new Joueur("NICOLAS");
    }

    @Test
    public void partieMediocre()
    {
        effectueLesLances(20, 0);
        assertEquals(0, this.joueur.score());
    }

    @Test
    public void partieMoinsMediocre()
    {
        effectueLesLances(20, 1);
        assertEquals(20, this.joueur.score());
    }


    private void effectueLesLances(int nombreDeLances, int nombreDeQuilles)
    {
        for(int i = 0; i < nombreDeLances; i++)
        {
            this.joueur.lance(nombreDeQuilles);
        }
    }

    @Test
    public void testUnSpare()
    {
        this.lanceUnSpare();
        this.joueur.lance(4);
        this.effectueLesLances(17, 0);
        assertEquals(18, this.joueur.score());
    }


    private void lanceUnSpare()
    {
        this.joueur.lance(5);
        this.joueur.lance(5);
    }

    private void lanceUnStrike()
    {
        this.joueur.lance(10);
    }

    @Test
    public void testUnStrike()
    {

        this.joueur.lance(10);
        this.joueur.lance(0);
        this.joueur.lance(5);
        this.effectueLesLances(17,0);
        assertEquals(20, this.joueur.score());
    }

    @Test
    public void testPartieParfaite()
    {
        this.effectueLesLances(10, 10);
        assertEquals(300, this.joueur.score());
    }

    @Test
    public void testDixiemeFrameSpare()
    {
        this.effectueLesLances(18, 0);
        this.joueur.lance(5);
        this.joueur.lance(5);
        this.joueur.lance(5);
        assertEquals(20, this.joueur.score());
    }

    @Test
    public void testDixiemeFrameStrike()
    {
        this.effectueLesLances(18,0);
        this.joueur.lance(10);
        this.joueur.lance(8);
        assertEquals(26,this.joueur.score());
    }

    @Test
    public void testPasPlusDeVingtLance()
    {
        this.effectueLesLances(20, 2);
        this.joueur.lance(2);
        assertEquals(this.joueur.score(),40);
    }

    @Test
    public void testVingtUneEmeLanceAvecSpare()
    {
        this.effectueLesLances(18, 2);
        this.lanceUnSpare();
        this.joueur.lance(1);
        assertEquals(48, this.joueur.score());
    }

    @Test
    public void testJoueurJoueSonTourAuPremierTour()
    {
        this.joueur.jouerSonTour();
        assertEquals(this.joueur.getLanceCourant(), 2);
    }

    @Test
    public void testJoueurJoueSonToutEtEffectueUnStrike()
    {
        this.joueur.jouerSonTour();
        assertEquals(2, this.joueur.getLanceCourant());
    }

    @Test
    public void testEstunSparePourScoreVrai()
    {
        this.effectueLesLances(2,5);
        assertTrue(this.joueur.estUnSparePourScore(0));
    }
    @Test
    public void testEstUnSparePourScoreFaux()
    {
        this.effectueLesLances(2,4);
        assertFalse(this.joueur.estUnSparePourScore(0));
    }

    @Test
    public void testEstUnStrikePourScoreVrai()
    {
        this.lanceUnStrike();
        assertTrue(this.joueur.estUnStrikePourScore(0));
    }
    @Test
    public void testEstUnStrikePourScoreFaux()
    {
        this.lanceUnStrike();
        assertTrue(this.joueur.estUnStrikePourScore(0));
    }

    @Test
    public void testRandomQuilles()
    {
        assertEquals(0, this.joueur.randomQuilles(10));
    }

    @Test
    public void testEstUnStrike()
    {
        assertTrue(this.joueur.estUnStrike(10));
    }
    @Test
    public void testEstUnStrikeFaux()
    {
        assertFalse(this.joueur.estUnStrike(9));
    }
    @Test
    public void testFrameClassique()
    {

    }


}
