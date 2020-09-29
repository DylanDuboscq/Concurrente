package tp4.ej6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Turno {

    private Semaphore sems[];

    public Turno(int cantidadLetras) {
        sems = new Semaphore[cantidadLetras];

        sems[0] = new Semaphore(1);
        for (int i = 1; i < cantidadLetras; i++) {
            sems[i] = new Semaphore(0);
        }
    }

    public void verificarTurno(int i) {
        try {
            sems[i].acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Letra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void completarTurno(int i) {
        sems[(i + 1) % sems.length].release();
    }
}