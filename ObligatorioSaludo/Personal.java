package ObligatorioSaludo;

public class Personal implements Runnable{

    private String nombre;
    private Saludo saludo;

    Personal(Saludo s, String n) {
        nombre = n;
        saludo = s;
    }

    public void run() {
        saludo.saludoEmpleado(nombre);
        }
}