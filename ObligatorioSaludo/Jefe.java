package ObligatorioSaludo;

public class Jefe implements Runnable{
    
    private Saludo saludo;

    public Jefe(Saludo s) {
        saludo = s;
    }
    
    public void run() {
            saludo.saludoJefe();
        }
}