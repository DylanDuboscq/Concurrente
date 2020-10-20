package barbero;

public class Main {

    public static void main(String[] args) {
        
        Barberia barberia = new Barberia(4);
        Thread[] hilos = new Thread[10];
        hilos[0] = new Thread(new Barbero(barberia));
        for (int i = 1; i < 10; i++) {
            hilos[i] = new Thread(new Cliente(barberia, "cliente"+i));
        }
        for (int i = 0; i < 10; i++) {
            hilos[i].start();
        }
    }
}