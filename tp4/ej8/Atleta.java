package tp4.ej8;

public class Atleta implements Runnable{
    
    private Carrera pistaCarrera;
    private String nombre;
    
    public Atleta(String miNombre, Carrera miPista){
        nombre = miNombre;
        pistaCarrera = miPista;
    }
    
    public void run(){
        try {
            pistaCarrera.correr(nombre);
        } catch (InterruptedException ex) {}
    }
}