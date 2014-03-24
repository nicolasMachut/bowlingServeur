import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 23/03/14.
 */
public class Piste {

    private boolean libre;

    private List<Joueur> joueurs;

    public Piste()
    {
        this.libre = true;
        this.joueurs = new ArrayList<Joueur>();

    }

    public void NouvellePartie() {
        this.libre = false;
    }

    public int nombreDeJoueurs()
    {
        return this.joueurs.size();
    }

    public void ajoutDesJoueurs(List<Joueur> listeJoueur) throws Exception {
       if (listeJoueur.size()>=6)
       {
           throw new Exception("Trop de joueurs sur cette piste, 6 au maximum.");
       }

       this.joueurs=listeJoueur;

    }



    public boolean estLibre() {
        return this.libre;
    }

    public void CloturerPartie() {
        this.libre = true;
    }
}