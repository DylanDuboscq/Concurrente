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
        System.out.println(Thread.currentThread().getName()+ " dice: Encontré uno!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }        
        semTaxista.release();
    }

    public void comenzarRecorrido() {
        try {
            semTaxista.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llegadaADestino(){
                semPasajero.release();
    }



}
