package EjercicioGrupalRWL;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Socio implements Runnable{

    int idSocio;
    CompaniaFilmica miCompania;
    boolean idioma;

    public Socio(int id, CompaniaFilmica CF, boolean idiomaOriginal) {
        idSocio = id;
        miCompania = CF;
        idioma = idiomaOriginal;
    }

    public void run() {
        Random r = new Random();
        while (true) {
            try {
                miCompania.mirarCapitulo((r.nextInt(miCompania.getCapDisponibles(idioma)+1)+1), idioma, idSocio);
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}