package tp4.ej8;
package tp4.ej8;

public class mainCarrera {

    public static void main(String[] args) {
        
        Thread[] hilosAtletas = new Thread[4];
        
        Carrera carrerón = new Carrera(4);
       
        for (int i = 0; i < 4; i++) {
            hilosAtletas[i] = new Thread(new Atleta("corredor "+i, carrerón,i));
        }
        for (int i = 0; i < 4; i++) {
            hilosAtletas[i].start();
        }
    } 
}