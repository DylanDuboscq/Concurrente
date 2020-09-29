package tp4.ej9;

import java.util.concurrent.Semaphore;

public class Taxi {
    
    private Semaphore pasajero;
    private Semaphore cabina;
    
    public Taxi(){
        pasajero = new Semaphore(0);
        cabina = new Semaphore(0);
    }
    
    public void esperarCliente(String nombreTaxista) throws InterruptedException{
        pasajero.acquire();
        System.out.println(nombreTaxista + " con cliente a bordo y manejando.");
        Thread.sleep((long) (Math.random()*1000));
        cabina.release();
    }
    
    public void buscarTaxi(String nombrePasajero)throws InterruptedException{
        pasajero.release();
        cabina.acquire();
        System.out.println(nombrePasajero + " terminó su viaje en taxi.");
    }
}