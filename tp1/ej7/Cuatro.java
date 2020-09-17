/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ej7;
import java.io.*;
/**
 *
 * @author joa
 */
public class Cuatro {
    
     public static void main(String[] args) {
         //el catch no esta atrapando la excepcion que está ocurriendo porque no es una IOException
    try {
            System.out.println(metodo());
        } catch (Exception e) {
            System.err.println("Exception en metodo()");
            e.printStackTrace();
        }
    }

    private static int metodo() {   
        int valor = 0;
        try {
            valor = valor + 1;
            valor = valor + Integer.parseInt("W");
            valor = valor + 1;
            System.out.println("Valor final del try: " + valor);
            throw new IOException();    
        } catch (IOException e) {
            valor = valor + Integer.parseInt("42");
            System.out.println("Valor final del catch: " + valor);
        } finally {
            valor = valor + 1;
            System.out.println("Valor al final del finally: " + valor);
        }
        valor = valor + 1;
        System.out.println("Valor antes del return: " + valor);
        return valor;
    }
}
