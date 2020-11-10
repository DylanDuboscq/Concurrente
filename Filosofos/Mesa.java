package Filosofos;

import java.util.concurrent.Semaphore;

public class Mesa {

    private Semaphore[] tenedores;

    public Mesa() {
        tenedores = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            tenedores[i] = new Semaphore(1);
        }
    }

    public synchronized void comer(int filosofo) {
        boolean conseguiCubiertos = false;
        while (!conseguiCubiertos) {
            if (tenedores[filosofo].tryAcquire()) {
                if (tenedores[(filosofo + 1) % tenedores.length].tryAcquire()) {
                    conseguiCubiertos = true;
                    System.out.println("Filosofo " + filosofo + " consiguió cubiertos.");
                } else {
                    tenedores[filosofo].release();
                    this.notifyAll();
                    try {
                        this.wait();
                    } catch (InterruptedException ex) {
                    }
                }
            } else {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    public synchronized void pensar(int filosofo) {
        tenedores[filosofo].release();
        tenedores[(filosofo + 1) % tenedores.length].release();
        this.notifyAll();
    }
}