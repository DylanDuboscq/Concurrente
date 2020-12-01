package EjercicioGrupalRWL;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Filmador implements Runnable {

    CompaniaFilmica miCompania;

    public Filmador(CompaniaFilmica CF) {
        miCompania = CF;
    }

    public void run() {
        Random r = new Random();
        while (true) {
            try {
                System.out.println("Nuevo capítulo siendo filmado");
                Thread.sleep((r.nextInt(3) + 1) * 1000); // Tarda un nro arbitrario de tiempo en crear un capitulo
                miCompania.subirCapituloEspañol(); // Y lo sube
            } catch (InterruptedException ex) {
                Logger.getLogger(Filmador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}