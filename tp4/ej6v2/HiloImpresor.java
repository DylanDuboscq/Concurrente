package tp4.e6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloImpresor implements Runnable{
    
    private GestorImpresion gestor;
    private char letra;
    private int cuantoImprimo;
    
    public HiloImpresor(GestorImpresion g, char miLetra){
        gestor = g;
        cuantoImprimo = gestor.cuantoImprimo(miLetra);
        letra = miLetra;
    }
    
    public void run(){
        while(true){
            try {
                gestor.imprimir(letra, cuantoImprimo);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloImpresor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}