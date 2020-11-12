package Museo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Museo {

    private int capacidad;
    private int umbral;
    private int genteAdentro;
    private int temperatura;
    private int capTempAlta;
    private int jubiladoEsperando;

    public Museo(int cap, int umb, int capT) {
        capacidad = cap;
        umbral = umb;
        genteAdentro = 0;
        temperatura = 20;
        jubiladoEsperando = 0;
        capTempAlta = capT;
    }

    public synchronized void actualizarTemperatura(int nuevaTemperatura) {
        temperatura = nuevaTemperatura;
        System.out.println("Temperatura: "+temperatura);
        this.notifyAll();
    }

    public synchronized void entrarMuseo(boolean jubilado) {
        while (jubiladoEsperando > 0 && !jubilado) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Museo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jubilado) {
            jubiladoEsperando++;
        }
        while ((genteAdentro == capacidad) || ((genteAdentro >= capTempAlta) && (temperatura >= umbral))) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Museo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jubilado) {
            jubiladoEsperando--;
            System.out.println("Entró jubilado.");
            genteAdentro++;
            this.notifyAll();
        } else {
            System.out.println("Entró persona");
            genteAdentro++;
            this.notifyAll();
        }
    }

    public synchronized void salir() {
        System.out.println("Salió persona.");
        genteAdentro--;
        this.notifyAll();
    }
}