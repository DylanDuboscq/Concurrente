package tp4.ej8;

public class mainCarrera {

    public static void main(String[] args) {
        
        Thread[] hilosAtletas = new Thread[4];
        
       Carrera carrerón = new Carrera();
       
        for (int i = 0; i < 4; i++) {
            hilosAtletas[i] = new Thread(new Atleta("corredor "+i, carrerón));
        }
        for (int i = 0; i < 4; i++) {
            hilosAtletas[i].start();
        }
    } 
}