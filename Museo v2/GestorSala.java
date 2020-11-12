/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joa
 */
public class GestorSala {

    private final int umbralTemp;
    private final int capacidadPersonas;
    private int temperatura;
    private int personasAdentro;
    private int jubiladosEsperando;

    public GestorSala(int t, int c) {
        umbralTemp = t;
        capacidadPersonas = c;
        personasAdentro = 0;
        temperatura = 20;
    }

    public synchronized void entrarSala() {
        while (jubiladosEsperando > 0 || esperar()) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(GestorSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        sumarPersonas();
    }

    public synchronized void entrarSalaJubilado() {
        while (esperar()) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(GestorSala.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jubiladosEsperando--;
        sumarPersonas();
    }

    public synchronized void sumarPersonas() {
        personasAdentro++;
        System.out.println(Thread.currentThread().getName() + " ingresa. Ahora hay " + personasAdentro);
        this.notifyAll();
    }

    public synchronized boolean esperar() {
        return (temperatura > umbralTemp || personasAdentro == capacidadPersonas);
    }

    public synchronized void salirSala() {
        personasAdentro--;
        this.notifyAll();
    }

    public synchronized void notificarTemperatura(int t) {
        temperatura = t;
        System.out.println("----- Temperatura actual: " + temperatura + "°C");
        this.notifyAll();
    }
}
