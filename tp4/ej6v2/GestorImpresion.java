package tp4.e6;

import java.util.Hashtable;
import java.util.concurrent.Semaphore;

public class GestorImpresion {

    private Semaphore[] semaforos;
   private Hashtable abecedario = new Hashtable();

    private void inicializarTabla() {
        abecedario.put('A', 0);
        abecedario.put('B', 1);
        abecedario.put('C', 2);
        abecedario.put('D', 3);
        abecedario.put('E', 4);
        abecedario.put('F', 5);
        abecedario.put('G', 6);
        abecedario.put('H', 7);
        abecedario.put('I', 8);
        abecedario.put('J', 9);
        abecedario.put('K', 10);
        abecedario.put('L', 11);
        abecedario.put('M', 12);
        abecedario.put('N', 13);
        abecedario.put('O', 14);
        abecedario.put('P', 15);
        abecedario.put('Q', 16);
        abecedario.put('R', 17);
        abecedario.put('S', 18);
        abecedario.put('T', 19);
        abecedario.put('U', 20);
        abecedario.put('V', 21);
        abecedario.put('W', 22);
        abecedario.put('X', 23);
        abecedario.put('Y', 24);
        abecedario.put('Z', 25);
    }

    public int cuantoImprimo(char letra) {
        return (((int) abecedario.get(letra)) + 1);
    }

    public GestorImpresion(int cantHilos) {
        this.inicializarTabla();
        semaforos = new Semaphore[cantHilos];
        for (int i = 0; i < cantHilos; i++) {
            semaforos[i] = new Semaphore(0);
        }
        semaforos[0].release();
    }

    public void imprimir(char letra, int nroVeces) throws InterruptedException {
        int indice = (int) abecedario.get(letra);
        semaforos[indice].acquire();
        for (int i = 0; i < nroVeces; i++) {
            System.out.print(letra);
        }
        if (indice == semaforos.length - 1) {
            System.out.println("");
            semaforos[0].release();
        } else {
            semaforos[indice + 1].release();
        }
        ;
    }
}