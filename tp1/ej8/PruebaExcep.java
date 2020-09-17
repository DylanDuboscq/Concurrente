/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ej8;
import tp1.TecladoIn;
import java.util.Random;
/**
 *
 * @author joa
 */
public class PruebaExcep {
    
     public static void main(String[] args) {
         //menorDeEdad();
         //ruleta();
         ingresarNumeros();
     }
     
     public static void menorDeEdad(){
         int edad;
         System.out.println("Ingrese la edad");

         edad=TecladoIn.readInt();
         try{
         if(edad<18)
             throw new Exception();        
         }catch(Exception e){
             System.err.println("La persona es menor de edad");                    
         }
     }
     
     public static void ruleta(){
         int numero,ganador;
         Random aleatorio=new Random();
         System.out.println("Ingrese un numero de la ruleta (entre 1 y 4)");
         numero=TecladoIn.readInt();
         ganador=aleatorio.nextInt(4)+1;
         try{
             if(numero!=ganador)
                 throw new Exception();
         }catch(Exception e){
             System.err.println("El número elegido no fue el ganador");
         }  
     }
     
     public static void ingresarNumeros(){
         int[] arreglo= new int[5];
         for(int i=0;i<arreglo.length;i++){
             arreglo[i]=i;
         }
         try{
         for(int i=0;i<8;i++){
             arreglo[i]=i;
             System.out.println(i);
         }
         }catch(ArrayIndexOutOfBoundsException e){
             System.err.println(e);
         }
     }
}
