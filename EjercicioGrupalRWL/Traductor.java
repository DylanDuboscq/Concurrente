package EjercicioGrupalRWL;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Traductor implements Runnable{
    
    CompaniaFilmica miCompania;

    public Traductor(CompaniaFilmica CF) {
        miCompania = CF;
    }

    public void run() {
        Random r = new Random();
        while (true) {
            try {
                miCompania.traducirCapitulo(); // Espera que el filmador dé capitulos para traducir
                System.out.println("Nuevo capitulo siendo traducido al inglés.");
                Thread.sleep((r.nextInt(5) + 1) * 1000); // Le toma un tiempo arbitrario traducir el capitulo (tiempo mayor al que toma grabarlo)
                miCompania.subirCapituloIngles(); // Sube el capitulo
            } catch (InterruptedException ex) {
                Logger.getLogger(Traductor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}