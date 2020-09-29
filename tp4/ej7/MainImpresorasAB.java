package tp4.e7;

public class mainImpresoresAB {

    public static void main(String[] args) {
        
        Thread[] hilos = new Thread[10];
        CentroImpresion centro = new CentroImpresion(3,3);
        for (int i = 0; i < 10; i++) {
            hilos[i] = new Thread(new Cliente("Cliente "+i, centro)); 
        }
        for (int i = 0; i < 10; i++) {
            hilos[i].start();
        }
    }
    
}