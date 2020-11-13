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
public class Main {

    public static void main(String[] args) {
//        int cantidadPersonas = 60;
//        int cantidadJubilados = 10;
//        int umbralTemperatura = 30;
//        int capacidad=50;
//        int capacidadConTemperaturaAlta=35;
        
//utilicé estos valores para facilitar el testeo
        int cantidadPersonas = 10;
        int cantidadJubilados = 3;
        int umbralTemperatura = 30;
        int capacidad=3;
        int capacidadConTemperaturaAlta=1;

        GestorSala sala = new GestorSala(umbralTemperatura, capacidad, capacidadConTemperaturaAlta);
        Medidor medidor = new Medidor(sala);
        Thread[] t = new Thread[cantidadPersonas];
        Thread tMedidor = new Thread(medidor);
        tMedidor.start();
        for (int i = 0; i < cantidadPersonas; i++) {
            t[i] = new Thread(new Persona(sala), "persona " + i);
            t[i].start();
        }
        Thread[] tJubilados = new Thread[cantidadJubilados];
        for (int i = 0; i < cantidadJubilados; i++) {
            tJubilados[i] = new Thread(new Jubilado(sala), "jubilado " + i);
            tJubilados[i].start();
        }
    }

}
