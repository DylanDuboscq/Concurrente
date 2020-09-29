package tp4.e7;

public class Cliente implements Runnable {

    private CentroImpresion impresoras;
    private String nombre;

    public Cliente(String miNombre, CentroImpresion miCentro) {
        nombre = miNombre;
        impresoras = miCentro;
    }

    public void run() {
        try {
            while (true) {
                impresoras.imprimir('a', nombre);
                impresoras.imprimir('b', nombre);
            }
        } catch (InterruptedException ex) {
        }
    }
}