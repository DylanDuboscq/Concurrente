/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.ej9;
import java.util.concurrent.Semaphore;
/**
 *
 * @author joa
 */
public class Main {
    
        public static void main(String args[]){
            Semaphore semPasajero=new Semaphore(1);
            Semaphore semTaxista=new Semaphore(0);
            Taxi t=new Taxi(semTaxista,semPasajero);
            Taxista taxista=new Taxista(t);
            Pasajero pasajero=new Pasajero(t);
            Thread t1=new Thread(taxista);
            Thread t2=new Thread(pasajero);
            
            t1.start();
            t2.start();
        }
        
}
