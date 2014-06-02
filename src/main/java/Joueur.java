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
    }

    public void lance(int nombreDeQuille)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.lances[lanceCourant++] = nombreDeQuille;
        System.out.println(this.pseudo +" Lance : A fait tombé "+nombreDeQuille+" quilles");
    }

    public int score()
    {
        int score = 0;
        int indexDeFrame = 0;
        for(int frame = 0; frame < 10; frame++)
        {
            if(this.estUnStrikePourScore(indexDeFrame))
            {
                score += 10 + this.bonusDeStrike(indexDeFrame);
                indexDeFrame++;
            }
            else
            {
                if(this.estUnSparePourScore(indexDeFrame))
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

    private boolean estUnSparePourScore(int indexDeFrame)
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

    private boolean estUnStrikePourScore(int indexDeFrame)
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

    public int getLanceCourant()
    {
        return this.lanceCourant;
    }

    public void jouerSonTour() {


        int random = this.randomQuilles(0);
        int random2 = 0;
        this.lance(random);
        if(this.lanceCourant < 20)
        {
            FrameClassique(random);
        }
        else
        {
            FrameTerminale(random);
        }
    }

    private void FrameTerminale(int random) {
        if(!this.estUnStrike(random))
        {
            this.lance(random);
            if(this.estUnSparePourScore(10))
            {
                random = this.randomQuilles(random);
                this.lance(random);
                this.partiejoueurTerminee = true;
            }
            else
            {
                this.partiejoueurTerminee = true;
            }
        }
        else
        {
            int random2 = this.randomQuilles(random);
            this.lance(random2);
            int random3 = this.randomQuilles(0);
            this.lance(random3);
            this.partiejoueurTerminee = true;

        }
    }

    private void FrameClassique(int random) {
        int random2;
        if(this.estUnStrike(random))
        {
            this.lances[this.lanceCourant] = 0;
            this.lanceCourant++;
        }
        else
        {
            random2 = this.randomQuilles(random);
            this.lance(random2);
        }
    }

    public String getPseudo()
    {
        return this.pseudo;
    }

    public boolean estUnStrike(int nbQuilles)
    {
        boolean res = false;
        if (nbQuilles==10 && this.lanceCourant%2==0)
            res= true;
        return res;
    }

    public int randomQuilles(int quillesTombees)
    {
        int higher = 11 - quillesTombees;
        int random = (int)(Math.random() * (higher));
        return random;
    }
}
