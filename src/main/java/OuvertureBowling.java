/**
 * Created by nicolas on 24/03/14.
 */
public class OuvertureBowling {

    public static void main(String[] args) {
        Bowling bowling = new Bowling();



        bowling.getPistes()[1].NouvellePartie();

        for(int i = 0; i < bowling.getPistes().length; i++)
        {
            System.out.println("Piste n° "+ (i+1) +" : "+bowling.getPistes()[i].estLibre());
        }
    }
}
