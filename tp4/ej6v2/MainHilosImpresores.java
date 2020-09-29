package tp4.e6;

public class mainHilosImpresores {

    public static void main(String[] args) {
        
        GestorImpresion gestor = new GestorImpresion(5);
        
        HiloImpresor h1 = new HiloImpresor(gestor,'A');
        HiloImpresor h2 = new HiloImpresor(gestor,'B');
        HiloImpresor h3 = new HiloImpresor(gestor,'C');
        HiloImpresor h4 = new HiloImpresor(gestor,'D');
        HiloImpresor h5 = new HiloImpresor(gestor,'E');
        
        Thread hiloA = new Thread(h1);
        Thread hiloB = new Thread(h2);
        Thread hiloC = new Thread(h3);
        Thread hiloD = new Thread(h4);
        Thread hiloE = new Thread(h5);
        
        hiloA.start();
        hiloB.start();
        hiloC.start();
        hiloD.start();
        hiloE.start();
    }
}