/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joa
 */
public class Medidor implements Runnable{
    
    private GestorSala sala;
    
    public Medidor(GestorSala s){
        sala=s;
    }
    
    public void espera(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Medidor.class.getName()).log(Level.SEVERE, null, ex);
            }                   
    }
    
    public int calcularTemperatura(){
        int t;
        Random r=new Random();
        t=20+r.nextInt(20);
        return t;
    }
    
    public void run(){
        while(true){
        sala.notificarTemperatura(calcularTemperatura());
        espera();
        }
    }
    
}
