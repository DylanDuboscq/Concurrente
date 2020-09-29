package tp4.ej9;

public class Pasajero implements Runnable{
    
    private String nombre;
    private Taxi taxi;

    public Pasajero(String miNombre, Taxi miTaxi) {
        nombre = miNombre;
        taxi = miTaxi;
    }

    public void run() {
        try {
            while (true) {
                taxi.buscarTaxi(nombre);
            }
        } catch (InterruptedException ex) {};
    }
}