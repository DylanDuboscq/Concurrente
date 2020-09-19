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
public class Curandero implements Runnable {

    private int curacion;
    private Player pj;

    public Curandero(int valor, Player p) {
        curacion = valor;
        pj = p;
    }

    public void run() {
        pj.setVida(curacion);
    }
}
