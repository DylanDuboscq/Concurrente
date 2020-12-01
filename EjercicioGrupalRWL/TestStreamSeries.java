package EjercicioGrupalRWL;

public class TestStreamSeries {

    public static void main(String[] args) {

        CompaniaFilmica filmicos = new CompaniaFilmica();

        Thread[] hilos = new Thread[10];

        hilos[0] = new Thread(new Filmador(filmicos));

        for (int i = 1; i < 3; i++) {
            hilos[i] = new Thread(new Traductor(filmicos)); // Creamos 2 traductores
        }

        for (int i = 3; i < 7; i++) {
            hilos[i] = new Thread(new Socio(i, filmicos, true)); // Creamos socios que consumen la serie en español
        }

        for (int i = 7; i < 10; i++) {
            hilos[i] = new Thread(new Socio(i, filmicos, false)); // Y socios que la consumen en ingles
        }

        for (int i = 0; i < 10; i++) {
            hilos[i].start();   // Inicializamos los hilos
        }
    }
}