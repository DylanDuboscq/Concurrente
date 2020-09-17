/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej3;

/**
 *
 * @author joa
 */
public class Main {

    public static void main(String args[])throws InterruptedException {
        Turno t=new Turno();
        Letra a = new Letra(1,"A",t);
        Letra b = new Letra(2,"BB",t);
        Letra c = new Letra(3,"CCC",t);
        
        Thread t1=new Thread(a, "A");
        Thread t2=new Thread(b, "BB");
        Thread t3=new Thread(c, "CCC");
        
        t1.start();
        t2.start();
        t3.start();

        
    }
}
