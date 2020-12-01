package EjercicioGrupalRWL;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CompaniaFilmica {

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    private final Condition faltaEpisodio = rwLock.writeLock().newCondition();
    private final Condition noHayParaTraducir = rwLock.writeLock().newCondition();

    private int capEspañol;
    private int capIngles;
    private int capTraducir;

    public CompaniaFilmica(){
        capEspañol = 0;
        capIngles = 0;
        capTraducir = 0;
    }
    
    public void subirCapituloEspañol() {
        writeLock.lock();
        try {
            capEspañol++;
            capTraducir++;
            System.out.println("Subido capitulo " + capEspañol + " en español");
            noHayParaTraducir.signal();
            faltaEpisodio.signalAll();
        } finally {
            writeLock.unlock();
        }
    }

    public void traducirCapitulo() throws InterruptedException {
        writeLock.lock();
        while (capTraducir <= 0) {
            noHayParaTraducir.await();
        }
        capTraducir--;
        writeLock.unlock();
    }

    public void subirCapituloIngles() {
        writeLock.lock();
        try {
            capIngles++;
            System.out.println("Subido capitulo " + capIngles + " en ingles");
            faltaEpisodio.signalAll();
        } finally {
            writeLock.unlock();
        }
    }

    public int getCapDisponibles(boolean idiomaOriginal) {
        int disponibles;
        readLock.lock();
        try {
            if (idiomaOriginal) {
                disponibles = capEspañol;
            } else {
                disponibles = capIngles;
            }
        } finally {
            readLock.unlock();
        }
        return disponibles;
    }

    public void mirarCapitulo(int capQueVeo, boolean idiomaOriginal, int idSocio) throws InterruptedException {
        if (idiomaOriginal) {
            readLock.lock();
            if (capEspañol < capQueVeo) {
                readLock.unlock();
                try {
                    writeLock.lock();
                    while (capEspañol < capQueVeo) {
                        faltaEpisodio.await();
                    }
                } finally {
                    writeLock.unlock();
                    readLock.lock();
                }
            }
        } else {
            readLock.lock();
            if (capEspañol < capQueVeo || capQueVeo == 0) {
                readLock.unlock();
                try {
                    writeLock.lock();
                    while (capIngles < capQueVeo || capQueVeo == 0) {
                        faltaEpisodio.await();
                    }
                } finally {
                    writeLock.unlock();
                    readLock.lock();
                }
            }
        }
            readLock.unlock();
            System.out.println(idSocio + " miró episodio " + capQueVeo);
    }
}