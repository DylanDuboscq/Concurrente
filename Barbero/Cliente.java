package barbero;

public class Cliente implements Runnable {

    private Barberia laBarberia;
    private String nombre;

    public Cliente(Barberia barbe, String n) {
        laBarberia = barbe;
        nombre = n;
    }

    public void run() {
        while (true) {
            if (laBarberia.entrar()) {
                System.out.println(nombre+" consiguio silla");
                laBarberia.solicitarTurno(nombre);
                laBarberia.salir();
                System.out.println(nombre+" fue atendido");
            }else{
                System.out.println(nombre+" no consiguio silla");
            }
            System.out.println(nombre + " se fue");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
            }
        }
    }
}