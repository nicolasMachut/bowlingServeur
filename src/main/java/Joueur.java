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
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        this.lances[lanceCourant] = nombreDeQuille;

        System.out.println(this.pseudo +" Lance n° "+this.lanceCourant+" : A fait tombé "+nombreDeQuille+" quilles");

            lanceCourant++;
    }

    public int score()
    {
        int score = 0;

        for(int frame = 0; frame <= 10; frame++) {
            if (frame != 10) {
                if (this.estUnStrikePourScore(frame)) {
                    score += 10 + this.bonusDeStrike(frame);
                } else {
                    if (this.estUnSparePourScore(frame)) {
                        score += 10 + bonusDeSpare(frame);

                    } else {
                        score += this.nombreDequilleTombeDansLaFrame(frame);
                    }
                }
            }
            else
            {
                score += this.nombreDequilleTombeDansLaFrame(frame);
            }
        }
        return score;
    }

    private boolean estUnSparePourScore(int indexDeFrame)
    {
        if(lances[indexDeFrame*2] + lances[indexDeFrame*2+1] == 10)
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
        if(lances[indexDeFrame*2] == 10)
            return true;
        else
            return false;
    }

    private int nombreDequilleTombeDansLaFrame(int indexDeFrame)
    {
        int bonus = 0;
        if (indexDeFrame==10)
        {
            bonus = this.lances[indexDeFrame*2];
        }else
        bonus = this.lances[indexDeFrame*2] + this.lances[indexDeFrame*2+1];

        System.out.println("bonus nombreQuilleFrame "+indexDeFrame+" score : "+bonus);
        return bonus;
    }

    private int bonusDeStrike(int indexDeFrame)
    {
        int indexDeFrameSuivante = indexDeFrame+1;
        int bonus = 0;
        if(indexDeFrame!=10)
            if(indexDeFrame==9) {
                bonus = this.lances[indexDeFrameSuivante * 2];
                System.out.println("bonus pour le strike index 18 " +bonus);
            }
                else{
                bonus = this.lances[indexDeFrameSuivante*2] + this.lances[indexDeFrameSuivante*2+1];
            }

        return bonus;
    }

    private int bonusDeSpare(int indexDeFrame)
    {
        int indexDeFrameSuivante = indexDeFrame +1;

        return this.lances[indexDeFrameSuivante*2];
    }

    public int getLanceCourant()
    {
        return this.lanceCourant;
    }

    public void jouerSonTour() {


        int RandomQuillePremierLancé = this.randomQuilles(0);
        int random2 = 0;
        this.lance(RandomQuillePremierLancé);

        FrameClassique(RandomQuillePremierLancé);
        if (this.lanceCourant==20 && this.estUnSparePourScore(9))
         {
           this.lance(this.randomQuilles(0));
          }


    }

    private void FrameClassique(int randomQuillePremierLancé) {
        int randomQuilleSecondLancé;
        if(this.estUnStrike(randomQuillePremierLancé))
        {
            if(this.lanceCourant==19)
            {

                this.lance(this.randomQuilles(0));
            }else {
                this.lances[this.lanceCourant] = 0;
                this.lanceCourant++;
            }
        }
        else
        {
            randomQuilleSecondLancé = this.randomQuilles(randomQuillePremierLancé);
            this.lance(randomQuilleSecondLancé);
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
