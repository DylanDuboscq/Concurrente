package tp4.ej8;

import java.util.concurrent.Semaphore;

public class Carrera {
    
    private Semaphore testigo = new Semaphore(1);   
    
    public void correr(String nombreCorredor) throws InterruptedException{
        testigo.acquire();
        System.out.println(System.currentTimeMillis()+" "+nombreCorredor+" empezó su carrera");
        Thread.sleep((long) (9000 + Math.random()*2000));
        System.out.println(System.currentTimeMillis()+" "+nombreCorredor+" terminó su carrera");
        testigo.release();
    }
}