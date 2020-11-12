package Museo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Temperatura implements Runnable {

    private Museo miMuseo;
    private Random r;

    public Temperatura(Museo m){
        miMuseo = m;
        r = new Random();
    }
    
    public void run() {
        while (true) {
            miMuseo.actualizarTemperatura(r.nextInt(50) + 1);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}