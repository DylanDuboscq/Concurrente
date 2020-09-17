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
class ThreadTesting {
//el comportamiento siempre es el mismo, se muestra el cartel "en main" y luego el cartel "en pila" 
    public static void main(String[] args) throws InterruptedException {
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        
        //miHilo.join();                      //agregando este join, forzamos a que los carteles salgan en el orden contrario
        System.out.println("En el main");
    }
}
