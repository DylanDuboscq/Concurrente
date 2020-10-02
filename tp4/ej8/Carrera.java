package tp4.ej8;

import java.util.concurrent.Semaphore;

public class Carrera {

    Semaphore[] postas;

    public Carrera(int nroAtletas) {
        postas = new Semaphore[nroAtletas];
        for (int i = 0; i < nroAtletas; i++) {
            postas[i] = new Semaphore(0);
        }
        postas[0].release();
    }

    public void empezarCorrer(String nombreCorredor, int nroPosta) throws InterruptedException {
        postas[nroPosta].acquire();
    }

    public void pasarPosta(int nroPosta) {
        postas[nroPosta + 1].release();
    }
}