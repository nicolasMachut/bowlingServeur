import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by nicolas on 14/03/14.
 */


public class PartieTest {

    @Test
    public void PeutFaireUnePartieMediocre()
    {
        Partie partie = new Partie();
        int scorePartie = Partie.GetScore();

        assertEquals(0,scorePartie);

    }
}
