/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

/**
 *
 * @author joa
 */
public class Jubilado extends Persona{
    
    public Jubilado(GestorSala s){
        super(s);
    }
    
    public void solicitarEntrada(){
        sala.entrarSalaJubilado();
    }
}
