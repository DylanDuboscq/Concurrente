/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ej2;


/**
 *
 * @author J0A
 */
public class Main {

    public static void main(String[] args) throws Exception { //throws por lo de la clase Date
        Cliente cliente1 = new Cliente("Juan");
        Velero barcoVelero = new Velero("USB 123", 2, 2, 1);
        Alquiler alq = new Alquiler(cliente1, "01/04/2022", "03/04/2022", 1, barcoVelero);
        System.out.println(alq.calcularAlquiler());
    }

}
