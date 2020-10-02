package tp4.ej9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Taxista implements Runnable {

    private String nombre;
    private Taxi taxi;

    public Taxista(String miNombre, Taxi miTaxi) {
        nombre = miNombre;
        taxi = miTaxi;
    }

    public void run() {
        try {
            while (true) {
                taxi.esperarCliente(nombre);
                System.out.println(nombre + " con cliente a bordo y manejando.");
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println("un viaje terminado");
                taxi.terminarViaje();
                Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}