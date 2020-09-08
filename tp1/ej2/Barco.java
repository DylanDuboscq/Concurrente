/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ej2;

/**
 *
 * @author J0A
 */
public class Barco {
    
    private final String matricula;
    private final int eslora;
    private final int anio;
    
    
    public Barco(String matr, int esl, int an){
        super();
        matricula=matr;
        eslora=esl;
        anio=an;
    }
    
    public int getEslora(){
        return eslora;
    }
    
    public int getModulo(){
        return (eslora*10);
    }
    
}