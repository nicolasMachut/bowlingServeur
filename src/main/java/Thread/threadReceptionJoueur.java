package Thread;


public class threadReceptionJoueur extends Thread {

	public void run() {
		this.setName("enfoiredethread");
	    int status = 0;
        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize();

            Ice.ObjectAdapter adapter =
                ic.createObjectAdapterWithEndpoints("receptionJoueurAdapter", "default -p 10020");
            Ice.Object object = new threadReceptionJoueursI();
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
