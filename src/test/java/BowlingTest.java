import org.junit.Before;
import org.junit.Test;

import Serveur.Bowling;
import Serveur.Equipe;
import Serveur.Joueur;

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

        Equipe equipe = new Equipe();
        List<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs.add(new Joueur());
        joueurs.add(new Joueur());
        equipe.setJoueurs(joueurs);
        try {
            this.bowling.getPistes()[0].ajoutEquipe(equipe);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            bowling.getPistes()[1].NouvellePartie();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.bowling.getPistes()[1].ajoutEquipe(equipe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1, this.bowling.getMeilleurePiste().getNumero());
    }




}
