/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.ej6;

/**
 *
 * @author joa
 */
public class esperarXSegundos {
    
        public static void esperarXSegundos(int esperaDeItem) {
        try {
            Thread.sleep(esperaDeItem*1500);
        } catch (InterruptedException e) {
        }
    }
        
}
