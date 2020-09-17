/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej4;

/**
 *
 * @author joa
 */
public class Surtidor {

    private Auto autoCargando;

    public Surtidor() {
    }

    public synchronized void cargarNafta(Auto a) {
        System.out.println(Thread.currentThread().getName() + " está cargando");
        try {
            //sleep para simular la carga
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " completó la carga");
    }
}
