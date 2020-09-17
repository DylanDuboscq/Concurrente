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
public class Main {
    
    public static void main(String args[])throws InterruptedException{
        Hp hpDePlayer=new Hp(10);
        Player player=new Player(hpDePlayer);
        Orco orco=new Orco(3,player);
        Curandero supp=new Curandero(3,player);
        
        
        Thread t1=new Thread(orco, "orco");
        Thread t2=new Thread(supp, "supp");
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Vida del jugador: "+player.getVida());
    }
}
