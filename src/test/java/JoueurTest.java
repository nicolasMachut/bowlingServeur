import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by nicolas on 14/03/14.
 */
public class JoueurTest {

    private Joueur joueur;

    @Before
    public void setup()
    {
        joueur = new Joueur();
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
        this.lanceUnStrike();
        this.joueur.lance(2);
        this.joueur.lance(3);
        this.effectueLesLances(16, 0);
        assertEquals(20, this.joueur.score());
    }

    @Test
    public void testPartieParfaite()
    {
        this.effectueLesLances(12, 10);
        assertEquals(300, this.joueur.score());
    }

}
