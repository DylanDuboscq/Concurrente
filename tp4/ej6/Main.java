/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.ej6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author joa
 */

public class Main {

    public static void main(String args[]) {
        Turno t = new Turno(3);

        Letra a = new Letra(0, 'A', t);
        Letra b = new Letra(1, 'B', t);
        Letra c = new Letra(2, 'C', t);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(c);

        t1.start();
        t2.start();
        t3.start();

    }
}
