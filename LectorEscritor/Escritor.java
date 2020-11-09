package LectorEscritor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Escritor implements Runnable{
    
    private Libro miLibro;
    private String nombre;
    
    public Escritor(Libro l,String n){
        miLibro = l;
        nombre = n;
    }
    
    public void run(){
        while(true){
            miLibro.escribir();
            System.out.println(nombre+" está escribiendo.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
            miLibro.terminarEscribir(nombre);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}