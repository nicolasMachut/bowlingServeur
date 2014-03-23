import static org.junit.Assert.*;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by nicolas on 14/03/14.
 */


public class PartieTest{

    private Partie partie;


    @Before
    public void setup()
    {
        partie = new Partie();
    }

    @Test
    public void partieVide()
    {
        assertEquals(0, this.partie.nombreDeJoueursDansLaPartie());
    }

    @Test
    public void partieADeuxJoueurs()
    {
        this.ajoutDesJoueurs(2);
        assertEquals(2, this.partie.nombreDeJoueursDansLaPartie());
    }

    @Test
    public void partiePleine()
    {
        this.ajoutDesJoueurs(11);
        assertEquals(10, this.partie.nombreDeJoueursDansLaPartie());
    }


    private void ajoutDesJoueurs(int nombreDeJoueurs)
    {
        for(int i = 0; i < nombreDeJoueurs; i++)
        {
            this.partie.ajoutDesJoueurs();
        }
    }

}
