/**
 * Created by nicolas on 23/03/14.
 */
package Serveur;
public class Bowling
{
    public static final int nombreDeJoueursParPartie = 6;

    private Piste[] pistes = new Piste[15];


    public Bowling()
    {
        this.initialisationDesPistes();
    }

    private void initialisationDesPistes()
    {
        for(int i = 0; i < this.pistes.length; i++)
        {
            this.pistes[i] = new Piste();
            this.pistes[i].setNumero(i);
        }
    }


    public Piste[] getPistes()
    {
        return this.pistes;
    }

    public Piste getMeilleurePiste() {
        Piste nextPiste = this.pistes[0];

        for(int nbPiste=0;nbPiste<this.pistes.length;nbPiste++)
        {
           if(this.pistes[nbPiste].estLibre())
           {
               return this.pistes[nbPiste];
           }else
           {
               if(this.pistes[nbPiste].getTempsAttente()<nextPiste.getTempsAttente())
               {
                   nextPiste = this.pistes[nbPiste];
               }
           }

        }
        return nextPiste;
    }
}
