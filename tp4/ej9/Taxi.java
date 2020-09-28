/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.ej9;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joa
 */
public class Taxi {

    private Semaphore semTaxista;
    private Semaphore semPasajero;

    public Taxi(Semaphore t, Semaphore p) {
        semTaxista = t;
        semPasajero = p;
    }

    public void encontrarTaxi() {
        try {
            semPasajero.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Estoy buscando un taxi");
        esperar();
        System.out.println("Encontré uno!");
        semTaxista.release();
    }

    public void conducir() {
        try {
            semTaxista.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Buen día pasajero, comencemos el viaje");
        esperar();
        System.out.println("Llegamos! ahora me duermo un rato");
        semPasajero.release();
    }

    public void esperar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
