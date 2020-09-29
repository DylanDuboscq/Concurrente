package tp4.ej6;

public class Letra implements Runnable {

    private int cantRepeticiones;
    private char letra;
    private Turno turno;
    private int numeroTurno;

    public Letra(int i, char l, Turno t) {
        cantRepeticiones = i + 1;
        letra = l;
        turno = t;
        numeroTurno = i;
    }

    public void imprimir() {
        for (int i = 1; i <= cantRepeticiones; i++) {
            System.out.print(letra);
        }
    }

    public void run() {
        while (true) {
            turno.verificarTurno(numeroTurno);
            imprimir();
            turno.completarTurno(numeroTurno);
        }
    }

}
