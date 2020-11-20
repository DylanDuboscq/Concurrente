package tp6e8;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Medico implements Runnable{
    
    private CentroHemoterapia centro;
    private Random r = new Random();
    
    public Medico(CentroHemoterapia cent){
        centro = cent;
    }
    
    public void run(){
        while(true){
            centro.atenderCliente();
            try {
                Thread.sleep(r.nextInt(7)*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
            }
            centro.terminarDonacion();
        }
    }
}