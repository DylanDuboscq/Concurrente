/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.ej9;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author joa
 */
public class Taxista implements Runnable{
   private Taxi taxi;
    
   public Taxista(Taxi t){
       taxi=t;
   }
   
   
    public void run(){
        while(true){
        taxi.conducir();
        }
    }
}
