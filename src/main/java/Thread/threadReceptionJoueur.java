package Thread;


public class threadReceptionJoueur extends Thread {

    private FileAttente fileAttente;

    public threadReceptionJoueur(FileAttente fileAttente){
        super();
        this.fileAttente = fileAttente;
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
            adapter.add(object, ic.stringToIdentity("receptionJoueur"));
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
