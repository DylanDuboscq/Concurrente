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
public class Yate extends Barco{
    
    private final int cv;
    private final int camarotes;
    
    public Yate(String matr,int esl, int an, int potencia, int cantCamarotes){
        super(matr,esl, an);
        cv=potencia;
        camarotes=cantCamarotes;
    }
    
        public int getModulo(){
        return (super.getModulo()+cv+camarotes);
    }
}
