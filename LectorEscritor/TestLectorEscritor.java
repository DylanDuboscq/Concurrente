package LectorEscritor;

public class TestLectorEscritor {
    
    public static void main(String[] args) {
        
        Libro librito = new Libro();
        
        Thread[] hilos = new Thread[10];
        
        for (int i = 0; i < 2; i++) {
            hilos[i] = new Thread(new Escritor(librito, "Escritor "+i));
        }
        for (int i = 2; i < 10; i++) {
            hilos[i] = new Thread(new Lector(librito, "Lector "+i));
        }
        for (int i = 0; i < 10; i++) {
            hilos[i].start();
        }
    }
}