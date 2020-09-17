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
public class Auto extends Vehiculo implements Runnable {

    private int kmActual;
    private int kmAutonomia;
    private Surtidor surtidor;

    public Auto(Surtidor s,int kmAut) {
        kmActual = 0;
        kmAutonomia=kmAut;
        surtidor=s;
    }

    public void run() {
        while(true){
        for(int i=kmAutonomia;i>20;i--){
        System.out.println("Al "+Thread.currentThread().getName()+" le quedan "+i+"km antes de entrar en reserva");
        }
        System.out.println(Thread.currentThread().getName()+" entró en reserva, toca surtidor");
        surtidor.cargarNafta(this);
        }
    }

}
