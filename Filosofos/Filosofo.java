package Filosofos;

public class Filosofo implements Runnable {

    private Mesa laMesa;
    private int id;
    private String nombre;

    public Filosofo(Mesa m, String n, int i) {
        laMesa = m;
        id = i;
        nombre = n;
    }

    public void run() {
        while (true) {
            laMesa.comer(id);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
            System.out.println(nombre + " terminó de comer.");
            laMesa.pensar(id);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
        }
    }
}