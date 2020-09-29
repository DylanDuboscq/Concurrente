package tp4.e7;

import java.util.concurrent.Semaphore;

public class CentroImpresion {

    private Semaphore impresorasA;
    private Semaphore impresorasB;

    public CentroImpresion(int nroImpresorasA, int nroImpresorasB) {
        impresorasA = new Semaphore(nroImpresorasA);
        impresorasB = new Semaphore(nroImpresorasB);
    }

    public void imprimir(char tipoImpresora, String nombreCliente) throws InterruptedException {
        if (tipoImpresora == 'c') {
            if (impresorasA.tryAcquire()) {
                System.out.println(nombreCliente + " imprimió un trabajo A.");
                impresorasA.release();
            } else {
                impresorasB.acquire();
                System.out.println(nombreCliente + " imprimió un trabajo B.");
                impresorasB.release();
            }
        } else {
            if (tipoImpresora == 'a') {
                impresorasA.acquire();
                System.out.println(nombreCliente + " imprimió un trabajo A.");
                impresorasA.release();
            } else {
                impresorasB.acquire();
                System.out.println(nombreCliente + " imprimió un trabajo B.");
            }
        }
    }
}