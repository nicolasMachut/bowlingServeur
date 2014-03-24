import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
            Assert.fail("Erreur, une exception était attendue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testPisteLibreALaCreation()
    {

        boolean libre = this.piste.estLibre();
        Assert.assertTrue(libre);
    }
    @Test
    public void testPisteOccupeApresCreation()
    {
        this.piste.NouvellePartie();
        boolean libre = this.piste.estLibre();
        Assert.assertFalse(libre);
    }
    @Test
    public void testPisteLibrePartieTerminee()
    {
        this.piste.NouvellePartie();
        this.piste.CloturerPartie();
        boolean libre = this.piste.estLibre();
        Assert.assertTrue(libre);
    }
}
