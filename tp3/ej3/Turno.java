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
public class Turno {

    private int turno;

    public Turno() {
        turno = 1;
    }

    public synchronized void setTurno(int t) {
        if (t > 3) {
            turno = 1;
        } else {
            turno = t;
        }
    }

    public synchronized int getTurno() {
        return turno;
    }

}
