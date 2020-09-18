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
public class Main {
//lo que quiero es sincronizar el objeto compartido (que en este caso es la cuentaBanco) por lo que eso es lo que tengo que sincronizar
    public static void main(String[] args) {
        VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Luis.start();
        Manuel.start();
    }
}
