package tp4.ej8;

public class Atleta implements Runnable {

    private Carrera pistaCarrera;
    private String nombre;
    private int posta;

    public Atleta(String miNombre, Carrera miPista, int miPosta) {
        nombre = miNombre;
        pistaCarrera = miPista;
        posta = miPosta;
    }

    public void run() {
        try {
            pistaCarrera.empezarCorrer(nombre, posta);
            System.out.println(System.currentTimeMillis() + " " + nombre + " empezó su carrera");
            Thread.sleep((long) (9000 + Math.random() * 2000));
            System.out.println(System.currentTimeMillis() + " " + nombre + " terminó su carrera");
            pistaCarrera.pasarPosta(posta);
        } catch (InterruptedException ex) {
        }
    }
}