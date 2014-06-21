/**
 * Created by nicolas on 23/03/14.
 */
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
        }
    }


    public Piste[] getPistes()
    {
        return this.pistes;
    }

    public int getMeilleurePiste() {
        int nextPiste=this.pistes[0].getTempsAttente();

        for(int nbPiste=0;nbPiste<this.pistes.length;nbPiste++)
        {
           if(this.pistes[nbPiste].estLibre())
           {
               return nbPiste;
           }else
           {
               if(this.pistes[nbPiste].getTempsAttente()<nextPiste)
               {
                   nextPiste = this.pistes[nbPiste].getTempsAttente();
               }
           }
        }
        return nextPiste;
    }
}
