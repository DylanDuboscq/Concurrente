/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joa
 */
public class Persona implements Runnable{
    
    GestorSala sala;
    
    public Persona(GestorSala s){
        sala=s;
    }
    
    public void mirar(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void solicitarEntrada(){
        sala.entrarSala();
    }
    
    public void run(){
        solicitarEntrada();
        mirar();
        System.out.println(Thread.currentThread().getName()+": Me retiro");
        sala.salirSala();
    }
}
