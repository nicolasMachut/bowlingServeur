package Serveur;

/**
 * Created by edouard on 14/03/14.
 */
public class Joueur {

    private int[] lances = new int[21];
    private int lanceCourant = 0;
    private String pseudo;
    private boolean partiejoueurTerminee = false;

    public Joueur()
    {

    }

    public Joueur(String pseudo)
    {
        this.pseudo = pseudo;
        for(int unIndex : this.lances)
            unIndex=0;
    }

    public void lance(int nombreDeQuille)
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.lances[lanceCourant] = nombreDeQuille;

        System.out.println(this.pseudo +" Lance n∞ "+this.lanceCourant+" : A fait tomb√© "+nombreDeQuille+" quilles");

        lanceCourant++;
    }

    public int score()
    {
        int score = 0;
        int scoreParFrame;
        for(int frame = 0; frame < 9; frame++)
        {
            scoreParFrame = 0;
            if (this.estUnStrikePourScore(frame))
            {
                score += 10 + this.bonusDeStrike(frame);
                scoreParFrame += 10 + this.bonusDeStrike(frame);
            }
            else
            {
                if (this.estUnSparePourScore(frame))
                {
                    score += 10 + this.bonusDeSpare(frame);
                    scoreParFrame+= 10 + this.bonusDeSpare(frame);
                }
                else
                {
                    score += this.nombreDequilleTombeDansLaFrame(frame);
                    scoreParFrame += this.nombreDequilleTombeDansLaFrame(frame);
                }
            }
            System.out.println("debug: score frame"+frame+" "+ scoreParFrame);
        }
        System.out.println("debug :score avant dernier frame" +score);
        if(this.estUnSparePourScore(9) || this.estUnStrikePourScore(9))
        {
            if(this.estUnSparePourScore(9))
            {
                score += 10 +this.bonusDeSpare(9);
                score += this.lances[20];
            }
            if(this.estUnStrikePourScore(9))
            {
                System.out.println("debug: strike au dernier frame");
                score += 10 + this.lances[19] + this.lances[20];
                score += this.lances[19];
                score += this.lances[20];
            }
        }
        else
        {
            System.out.println("debug: dernier frame normal");
            score += this.lances[18];
            score += this.lances[19];
        }
        System.out.println("debug: score apres dernier frame"+score);

        return score;
    }

    public boolean estUnSparePourScore(int indexDeFrame)
    {
        if(lances[indexDeFrame*2] + lances[indexDeFrame*2+1] == 10)
        {
            System.out.println("debug :la frame "+indexDeFrame+" est un spare avec le lance "+indexDeFrame*2+" et "+(indexDeFrame*2+1));
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean estUnStrikePourScore(int indexDeFrame)
    {
        if(lances[indexDeFrame*2] == 10)
        {
            System.out.println("debug: la frame "+indexDeFrame+" est un strike avec le lance "+indexDeFrame*2+" et "+(indexDeFrame*2+1));
            return true;
        }
        else
        {
            return false;
        }
    }

    public int nombreDequilleTombeDansLaFrame(int indexDeFrame)
    {
        int bonus = 0;
        if (indexDeFrame==10)
        {
            bonus = this.lances[indexDeFrame*2];
        }
        else
            bonus = this.lances[indexDeFrame*2] + this.lances[indexDeFrame*2+1];

        return bonus;
    }

    public int bonusDeStrike(int indexDeFrame)
    {
        int indexDeFrameSuivante = indexDeFrame+1;
        int bonus = 0;
        if(indexDeFrame==9)
        {
            bonus = this.lances[indexDeFrameSuivante * 2];
        }
        else
        {
            bonus = this.lances[indexDeFrameSuivante*2] + this.lances[indexDeFrameSuivante*2+1];
        }
        return bonus;
    }

    public int bonusDeSpare(int indexDeFrame)
    {
        int indexDeFrameSuivante = indexDeFrame +1;

        return this.lances[indexDeFrameSuivante*2];
    }

    public int getLanceCourant()
    {
        return this.lanceCourant;
    }

    public void jouerSonTour() {


        int RandomQuillePremierLancer = this.randomQuilles(0);
        int random2 = 0;
        this.lance(RandomQuillePremierLancer);

        FrameClassique(RandomQuillePremierLancer);
        if (this.lanceCourant==20 && this.estUnSparePourScore(9))
        {
            this.lance(this.randomQuilles(0));
        }


    }

    public void FrameClassique(int randomQuillePremierLancer) {
        int randomQuilleSecondLancer;
        if(this.estUnStrike(randomQuillePremierLancer))
        {
            if(this.lanceCourant==19)
            {
                this.lance(this.randomQuilles(0));
            }
            else
            {
                this.lances[this.lanceCourant] = 0;
            }
        }
        else
        {
            randomQuilleSecondLancer = this.randomQuilles(randomQuillePremierLancer);
            this.lance(randomQuilleSecondLancer);
        }
    }

    public String getPseudo()
    {
        return this.pseudo;
    }

    public boolean estUnStrike(int nbQuilles)
    {
        boolean res = false;
        if(nbQuilles == 10)
            res = true;
        return res;
    }

    public int randomQuilles(int quillesTombees)
    {
        int higher = 11 - quillesTombees;
        int random = (int)(Math.random() * (higher));
        return random;
    }
}
