package tp6e8;

public class Donante implements Runnable{
    
    private CentroHemoterapia centro;
    private String nombre;
    private boolean prefieroSentarme;
    
    public Donante(CentroHemoterapia cent,String n, boolean quieroSentarme){
        centro = cent;
        nombre = n;
        prefieroSentarme = quieroSentarme;
    }
    
    public void run(){
        centro.donarSangre(prefieroSentarme,nombre);
        System.out.println(nombre+" donó sangre.");
    }
}