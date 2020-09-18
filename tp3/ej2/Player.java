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
public class Player {

    private int vida;
    private int vidaMaxima;

    public Player(int v) {
        vida = v;
    }

    public int getVida() {
        return vida;
    }

    //sin el synchronized, la vida máxima no es un valor consistente
    public synchronized void setVida(int valor) {
        if (vida + valor < 1) {
            vida = 0;
            System.out.println("Te han matado");
        } else {
            vida = vida + valor;
            System.out.println(Thread.currentThread().getName() + " hace " + valor + " de vida, ahora tu vida es: " + vida);
        }

    }
}
