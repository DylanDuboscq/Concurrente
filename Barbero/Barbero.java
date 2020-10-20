package barbero;

public class Barbero implements Runnable {

    private Barberia miBarberia;

    public Barbero(Barberia barbe) {
        miBarberia = barbe;
    }

    public void cortarPelo() {
        System.out.println("estoy cortando pelo");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        System.out.println("termine de cortar");
    }

    public void run() {
        while (true) {
            miBarberia.esperarCliente();
            this.cortarPelo();
            miBarberia.terminarAtencion();
        }
    }
}   