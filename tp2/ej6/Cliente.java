/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.ej6;

/**
 *
 * @author joa
 */
public class Cliente {

    private String nombre;
    private int[] carroCompra;

    public Cliente(String nom,int[] carro) {
        nombre = nom;   
        carroCompra=carro;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int[] getCarroCompra(){
        return carroCompra;
    }
}
