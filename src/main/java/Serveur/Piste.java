package Serveur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 23/03/14.
 */
public class Piste extends Thread{

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    private boolean libre;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    private int numero;

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    private List<Joueur> joueurs;

    public Piste()
    {
        this.libre = true;
        this.joueurs = new ArrayList<Joueur>();

    }

    public void NouvellePartie() throws Exception{
        if(this.libre)
        {
            this.libre = false;
            this.JouerPartie();
        }
        else
            throw new Exception("La piste est déjà occupée.");
    }

    public void JouerPartie()
    {
        for(int i =0; i < 10; i++)
        {
            for(Joueur unJoueur : this.joueurs)
            {
                unJoueur.jouerSonTour();
            }
        }
        for(Joueur unJoueur : this.joueurs)
        {
            System.out.println("score "+unJoueur.getPseudo()+" : "+unJoueur.score());
        }

        this.libre = true;
        this.joueurs = null;
    }

    public int nombreDeJoueurs()
    {
        return this.joueurs.size();
    }

    public void ajoutDesJoueurs(List<Joueur> listeJoueur) throws Exception {
       if (listeJoueur.size()>= Bowling.nombreDeJoueursParPartie)
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

    public int getTempsAttente()
    {
        return this.calculTempsAttente();
    }

    private int calculTempsAttente()
    {
        int total = 0;
        for(int i  = 0; i < this.joueurs.size(); i++)
        {
            for(int j = 0; j < 20 - this.joueurs.get(i).getLanceCourant(); j++)
            {
                total += 10;
            }
        }
        return total;
    }
}