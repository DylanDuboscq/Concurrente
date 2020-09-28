/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.ej9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joa
 */
public class Taxista implements Runnable {

    private Taxi taxi;

    public Taxista(Taxi t) {
        taxi = t;
    }

    private void conducir() {
        System.out.println("Buen día pasajero, comencemos el viaje");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
                System.out.println("Llegamos! ahora me duermo un rato");                
    }

    public void run() {
        while (true) {
            taxi.comenzarRecorrido();
            conducir();
            taxi.llegadaADestino();
        }
    }
}
