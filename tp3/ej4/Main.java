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
public class Main {

    public static void main(String[] args) {
        Surtidor s=new Surtidor();
        Thread[] t = new Thread[5];
        for (int i = 0; i < 5; i++) {
            t[i] = new Thread(new Auto(s,(i+1)*50), "auto" + i);
        }
        for (int i = 0; i < 5; i++) {
            t[i].start();
        }
    }
}
