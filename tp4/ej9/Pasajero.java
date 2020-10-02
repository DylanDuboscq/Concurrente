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
public class Pasajero implements Runnable {

    private Taxi taxi;

    public Pasajero(Taxi t) {
        taxi = t;
    }

    private void buscarTaxi() {
        System.out.println(Thread.currentThread().getName()+" dice: Estoy buscando un taxi");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        buscarTaxi();
        taxi.encontrarTaxi();
    }
}
