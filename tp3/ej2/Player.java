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

    private Hp hp;

    public Player(Hp v) {
        hp = v;
    }

    public int getVida() {
        return hp.getHp();
    }

    /*sin el synchronized, hay veces en las que el curandero primero intenta curarnos, y luego nos golpea el orco, dejandonos en 7 
    de vida, sin embargo,gracias al synchronized, la vida permanece en 10
     */
    public synchronized void setVida(int valor) {
        if (hp.getHp() + valor < 1) {
            hp.setHp(0);
            System.out.println("Te han matado");
        } else {
            if (hp.getHp() + valor > hp.getVidaMaxima()) {
                System.out.println("Estás full vida");
            } else {
                hp.setHp(hp.getHp() + valor);
                System.out.println(Thread.currentThread().getName() + " hace " + valor + " de vida, ahora tu vida es: " + hp.getHp());
            }
        }

    }
}
