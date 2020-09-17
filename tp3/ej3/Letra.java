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
public class Letra implements Runnable {

    private int numeroDeTurno;
    private String s;
    private Turno turno;

    public Letra(int i, String cad, Turno t) {
        numeroDeTurno = i;
        s = cad;
        turno = t;
    }

    public synchronized void imprimir() {
        System.out.println(s);
        int temp = numeroDeTurno + 1;
        turno.setTurno(temp);
    }

    public void run() {
        //puse este while que vi de un compañero ya que de lo contrario no muestra toda la cadena como debería
        while (true) {
            if (numeroDeTurno == turno.getTurno()) {
                this.imprimir();
            }

        }
    }

}
