/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej1;

/**
 *
 * @author joa
 */
public class CuentaBanco {

    private int balance = 50;

    public CuentaBanco() {
    }

    public int getBalance() {
        return balance;
    }

    //si sólo sincronizo verificarCuenta, el método retiroBancario me queda "libre" y puede generar problemas
    public synchronized void retiroBancario(int retiro) {
        balance = balance - retiro;
    }
}
