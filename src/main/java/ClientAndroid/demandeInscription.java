package ClientAndroid;

import receptionJoueurs.JoueurSlice;

public class demandeInscription {
	public static void main(String[] args) {
		int status = 0;
		Ice.Communicator ic = null;
		try {
			ic = Ice.Util.initialize(args);
			Ice.ObjectPrx base = ic
					.stringToProxy("receptionJoueur:default -p 10020");
			receptionJoueurs.threadReceptionJoueursPrx receptionJoueur = receptionJoueurs.threadReceptionJoueursPrxHelper.checkedCast(base);
			if (receptionJoueur == null)
				throw new Error("Invalid proxy");

			JoueurSlice[] maListe = null;
			
			System.out.println(receptionJoueur.inscriptionJoueur(maListe));
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
		System.exit(status);
	}
}