import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by nicolas on 23/03/14.
 */
public class BowlingTest {

    private Bowling bowling;

    @Before
    public void setup()
    {
        bowling = new Bowling();
    }

    @Test
    public void TestAssignationPiste()
    {
        try {
            bowling.getPistes()[0].NouvellePartie();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Joueur> equipe = new ArrayList<Joueur>();
        equipe.add(new Joueur());
        equipe.add(new Joueur());

        try {
            this.bowling.getPistes()[0].ajoutDesJoueurs(equipe);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bowling.getPistes()[1].NouvellePartie();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.bowling.getPistes()[1].ajoutDesJoueurs(equipe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(2, this.bowling.getMeilleurePiste());
    }


}
