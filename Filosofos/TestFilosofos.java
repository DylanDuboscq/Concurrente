package Filosofos;

public class TestFilosofos {

    public static void main(String[] args) {

        Mesa laMesa = new Mesa();
        Thread[] filosofos = new Thread[5];
        for (int i = 0; i < 5; i++) {
            filosofos[i] = new Thread(new Filosofo(laMesa, "filosofo " + i, i));
        }
        for (int i = 0; i < 5; i++) {
            filosofos[i].start();
        }
    }
}