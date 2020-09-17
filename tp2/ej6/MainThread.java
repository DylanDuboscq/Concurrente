/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.ej6;

/**
 *
 * @author joa
 */
public class MainThread {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente1", new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente2", new int[]{1, 3, 5, 1, 1});

        CajeraThread t1=new CajeraThread("Cajera1");
        CajeraThread t2=new CajeraThread("Cajera2");
        
        t1.asignarCliente(cliente1);
        t2.asignarCliente(cliente2);
        
        t1.start();
        t2.start();
    }
}
