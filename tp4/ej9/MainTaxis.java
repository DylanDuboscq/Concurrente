package tp4.ej9;

public class mainTaxis {

    public static void main(String[] args) {
        
        Thread hilos[] = new Thread[10];
        Taxi elTaxi = new Taxi();
        
        hilos[0] = new Thread(new Taxista("taxista", elTaxi));
        for (int i = 1; i < 10; i++) {
            hilos[i] = new Thread(new Pasajero("pasajero "+i, elTaxi));
        }
        for (int i = 0; i < 10; i++) {
            hilos[i].start();
        }
    }
    } 
}