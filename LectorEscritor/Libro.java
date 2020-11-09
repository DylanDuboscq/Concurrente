package LectorEscritor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Libro {
    
    private int escritores;
    private int lectores;
    
    public Libro(){
        escritores = 0;
        lectores = 0;
    }
    
    public synchronized void leer(){
        while(escritores > 0){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        lectores++;
    }
    
    public synchronized void terminarLeer(String nombre){
        lectores--;
        System.out.println(nombre+" terminó de leer.");
        this.notifyAll();
    }
    
    public synchronized void escribir(){
        escritores++;
        while(lectores > 0){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public synchronized void terminarEscribir(String nombre){
        escritores--;
        System.out.println(nombre+" terminó de escribir.");
        this.notifyAll();
    }
}