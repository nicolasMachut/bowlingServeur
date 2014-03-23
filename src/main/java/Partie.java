import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 14/03/14.
 */
public class Partie
{
    private List<Joueur> joueurs = new ArrayList<Joueur>();

    public int nombreDeJoueursDansLaPartie()
    {
        return this.joueurs.size();
    }

    public void ajoutDesJoueurs()
    {
        if(this.nombreDeJoueursDansLaPartie() < Bowling.nombreDeJoueursParPartie)
        {
            this.joueurs.add(new Joueur());
        }
    }


}
