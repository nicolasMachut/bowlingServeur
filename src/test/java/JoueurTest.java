import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by nicolas on 14/03/14.
 */
public class JoueurTest {
    @Test
    public void PeutFaireLancerMediocre()
    {
        Joueur joueur = new Joueur();

        assertEquals(0, joueur.Lance());

    }

    @Test
    public void PeutFaireUnLancerMoyen()



}
