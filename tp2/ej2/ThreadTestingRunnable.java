/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.ej2;

/**
 *
 * @author joa
 */
public class ThreadTestingRunnable {

    public static void main(String[] args) throws InterruptedException {
        MiEjecucionRunnable objeto = new MiEjecucionRunnable();
        Thread miHilo=new Thread(objeto);
        
//objeto.run(); Si no creo el Thread miHilo y ejecuto este run, veremos que solo tenemos un hilo

        miHilo.start();
        System.out.println("En el main      "+Thread.currentThread());
    }
}
