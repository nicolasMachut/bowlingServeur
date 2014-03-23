/**
 * Created by edouard on 14/03/14.
 */
public class Joueur {

    private int[] lances = new int[21];
    private int lanceCourant = 0;
    private String pseudo;

    public Joueur()
    {

    }

    public Joueur(String pseudo)
    {
        this.pseudo = pseudo;
    }

    public void lance(int nombreDeQuille)
    {
        this.lances[lanceCourant++] = nombreDeQuille;
    }

    public int score()
    {
        int score = 0;
        int indexDeFrame = 0;
        for(int frame = 0; frame < 10; frame++)
        {
            if(this.estUnStrike(indexDeFrame))
            {
                score += 10 + this.bonusDeStrike(indexDeFrame);
                indexDeFrame++;
            }
            else
            {
                if(this.estUnSpare(indexDeFrame))
                {
                    score += 10  + bonusDeSpare(indexDeFrame);
                    indexDeFrame += 2;
                }
                else
                {
                    score += this.nombreDequilleTombeDansLaFrame(indexDeFrame);
                    indexDeFrame += 2;
                }
            }


        }
        return score;
    }

    private boolean estUnSpare(int indexDeFrame)
    {
        if(lances[indexDeFrame] + lances[indexDeFrame+1] == 10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean estUnStrike(int indexDeFrame)
    {
        if(lances[indexDeFrame] == 10)
            return true;
        else
            return false;
    }

    private int nombreDequilleTombeDansLaFrame(int indexDeFrame)
    {
        return this.lances[indexDeFrame] + this.lances[indexDeFrame+1];
    }

    private int bonusDeStrike(int indexDeFrame)
    {
        return this.lances[indexDeFrame+1] + this.lances[indexDeFrame+2];
    }

    private int bonusDeSpare(int indexDeFrame)
    {
        return this.lances[indexDeFrame+2];
    }

}
