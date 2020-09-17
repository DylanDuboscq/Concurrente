/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp0.ej2;


/**
 *
 * @author J0A
 */
public class AMotor extends Barco{
    
    private final int cv;
    
    public AMotor(String matr,int esl, int an, int potencia){
        super(matr, esl, an);  
        cv=potencia;
    }
    
        public int getModulo(){
        return (super.getModulo()+cv);
    }
}