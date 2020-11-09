package ObligatorioSaludo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Saludo {
    
    private boolean jefeSaludo;
    private int nroEmpleados;
    private int llegaron;
    
    public Saludo(int nroEmp){
        jefeSaludo = false;
        nroEmpleados = nroEmp;
        llegaron = 0;
    }
    
    public synchronized void saludoJefe(){
        while(llegaron < nroEmpleados){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Saludo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Jefe: Buenos días.");
        jefeSaludo = true;
        this.notifyAll();
    }
    
    public synchronized void saludoEmpleado(String nombre){
        System.out.println(nombre+": Buenos días jefe!");
        llegaron++;
        this.notifyAll();
        while(!jefeSaludo){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Saludo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}