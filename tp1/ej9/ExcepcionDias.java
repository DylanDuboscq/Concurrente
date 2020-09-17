/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ej9;

/**
 *
 * @author joa
 */
public class ExcepcionDias extends Exception{
    /*pensé en hacer una excepción para cuando se ingresa una fecha incial despues de la final o viceversa, estaria mal
    hacer un if para mostrar carteles distintos? o es más correcto hacer una excepción nueva?
*/
    public ExcepcionDias(){
    }
    
    public String toString(){
        return "El alquiler supera el máximo de días";
    }
}
