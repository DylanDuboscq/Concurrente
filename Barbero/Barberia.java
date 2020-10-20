package barbero;

import java.util.concurrent.Semaphore;

public class Barberia {

    private Semaphore semBarbero;
    private Semaphore semCliente;
    private Semaphore semSillas;

    public Barberia(int numSillas) {
        semBarbero = new Semaphore(0);
        semCliente = new Semaphore(0,true);
        semSillas = new Semaphore(numSillas);
    }

    public boolean entrar() {
        return semSillas.tryAcquire();
    }

    public void solicitarTurno(String nombre) {
        semBarbero.release();
        try {
            System.out.println(nombre+" espera ser atendido");
            semCliente.acquire();
            System.out.println(nombre+" va a ser atendido");
        } catch (InterruptedException ex) {
        }
    }

    public void salir() {
        semSillas.release();
    }

    public void esperarCliente() {
        try {
            semBarbero.acquire();
        } catch (InterruptedException ex) {
        }
    }

    public void terminarAtencion() {
        semCliente.release();
    }
}
