package Museo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona implements Runnable {

    private Boolean jubilado;
    private Museo miMuseo;

    public Persona(Museo m, boolean jub) {
        miMuseo = m;
        jubilado = jub;
    }

    public void run() {
        while (true) {
            try {
                miMuseo.entrarMuseo(jubilado);
                Thread.sleep(3000);
                miMuseo.salir();
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}