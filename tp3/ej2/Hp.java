/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej2;

/**
 *
 * @author joa
 */
public class Hp {
    
    private int vida;
    private int vidaMaxima;
    
    public Hp(int v){
        vida=v;
        vidaMaxima=v;
    }
    
    public void setHp(int valor){
        vida=valor;
    }
    
    public int getHp(){
        return vida;
    }
    
    public int getVidaMaxima(){
        return vidaMaxima;
    }
}
