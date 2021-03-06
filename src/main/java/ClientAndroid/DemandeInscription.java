package ClientAndroid;

import envoiScores.threadEnvoiScoresPrxHelper;
import receptionJoueurs.threadReceptionJoueursPrxHelper;

public class DemandeInscription extends Ice.Application{
	
	private int status;
	@Override
	public int run(String[] args) {
		Ice.Communicator ic = null;
		try {
			ic = Ice.Util.initialize(args);
			Ice.ObjectPrx base = ic.stringToProxy("receptionJoueur :tcp -h 192.168.1.10 -p 10020");
			receptionJoueurs.threadReceptionJoueursPrx receptionJoueur = threadReceptionJoueursPrxHelper.checkedCast(base);
			if (receptionJoueur == null)
				throw new Error("Invalid proxy");
			
			String[] equipe = new String[]{"Johan"};
			
			System.out.println(receptionJoueur.inscriptionJoueur(equipe));
			
			Ice.ObjectPrx base1 = ic.stringToProxy("envoiScores :tcp -h 192.168.1.10 -p 10020");
			envoiScores.threadEnvoiScoresPrx envoiScores = threadEnvoiScoresPrxHelper.checkedCast(base1);
			if (envoiScores == null)
				throw new Error("Invalid proxy");
			
			while(true){
				System.out.println(envoiScores.getScores(0));
			}
		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (ic != null) {
			// Clean up
			//
			try {
				ic.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemandeInscription app = new DemandeInscription();
		app.run(args);
		System.exit(0);
	}
}