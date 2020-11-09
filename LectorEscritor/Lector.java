package LectorEscritor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lector implements Runnable{
    
    private Libro miLibro;
    private String nombre;
    
    public Lector(Libro l,String n){
        miLibro = l;
        nombre = n;
    }
    
    public void run(){
        while(true){
            miLibro.leer();
            System.out.println(nombre+" está leyendo");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
            miLibro.terminarLeer(nombre);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}