/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.PingPong;

/**
 *
 * @author joa
 */


/*

a) Sin la sentencia sleep, el codigo se ejecuta de inmediato (intercalados)
c) Al agregar el bucle, salen algunos PING PONG antes pero mayormente sale bucle for, y luego los PING PONG
d) Cuando agregamos un sleep dentro del bucle, algunos bucle for salen entre los PING PONG, pero en generaleste termina siendo 
el ultimo en ejecutarse
f) Al agregar PUNG y PANG se intercalan los 4 hilos

*/
public class PingPong extends Thread{
    private String cadena;
    private int delay;
            
            
            
            
    public static void main(String args[])throws InterruptedException{
        PingPong t1=new PingPong("PING",10);
        PingPong t2=new PingPong("PONG",20);
        PingPong t3=new PingPong("PANG",5);
        PingPong t4=new PingPong("PUNG",30);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
//        for(int i=0;i<100;i++){
//            Thread.sleep(100);
//            System.out.println("Bucle for");
//        }
//        t1.join();  //el hilo actual (en este caso el main) espera a que el t1 termine su ejecución
//        System.out.println("                aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        
//
//        
//       Thread.sleep(1750);
//        System.out.println("\nsleep largo que seguramente salga al final");
    }
    
    public PingPong(String cartel,int cantMs){
        cadena=cartel;
        delay=cantMs;
    }
    public void run(){
        for(int i=1;i<delay;i++){
            System.out.print(cadena+" ");
            try{
                Thread.sleep(delay);
            }catch(InterruptedException e){   
            }
        }
    }
}
