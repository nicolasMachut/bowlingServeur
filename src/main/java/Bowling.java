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

}
