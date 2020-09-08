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
public class Velero extends Barco {

    private final int mastiles;

    public Velero(String matr, int esl, int an, int masti) {
        super(matr, esl, an);
        mastiles = masti;
    }
    
    public int getModulo(){
        return (super.getModulo()+mastiles);
    }
}
