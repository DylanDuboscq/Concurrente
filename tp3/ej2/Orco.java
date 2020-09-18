/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej2;

/**
 *
 * @author joa
 */
public class Orco implements Runnable {

    private int danio;
    private Player pj;

    public Orco(int valor, Player p) {
        danio = valor;
        pj = p;
    }

    public void run() {
        pj.setVida(-danio);
    }
}
