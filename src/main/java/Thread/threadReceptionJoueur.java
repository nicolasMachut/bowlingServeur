package Thread;

import Serveur.Bowling;


public class threadReceptionJoueur extends Thread {

    private FileAttente fileAttente;
    private Bowling bowling;
    
    public threadReceptionJoueur(FileAttente fileAttente,Bowling bowling){
        super();
        this.fileAttente = fileAttente;
        this.bowling = bowling;
    }

	public void run() {
		this.setName("enfoiredethread");
	    int status = 0;
        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize();

            Ice.ObjectAdapter adapter =
                ic.createObjectAdapterWithEndpoints("receptionJoueurAdapter", "default -h 192.168.1.10 -p 10020");
            Ice.Object object = new threadReceptionJoueursI(this.fileAttente);
            Ice.Object object1 = new threadEnvoiScores(this.bowling);
            adapter.add(object, ic.stringToIdentity("receptionJoueur"));
            adapter.add(object1, ic.stringToIdentity("envoiScores"));
            adapter.activate();
            ic.waitForShutdown();
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
