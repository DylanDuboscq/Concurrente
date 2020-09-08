/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ej2;

import tp1.ej2.Barco;
import tp1.ej2.Cliente;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

/**
 *
 * @author J0A
 */
public class Alquiler {

    private Cliente cliente;
    private Date fechaInicial;
    private Date fechaFinal;
    private int amarre;
    private Barco barco;
    private int valorFijo;

    public Alquiler(Cliente c, String fi, String ff, int posAmarre, Barco b) throws Exception {
        //para la fecha, se ingresa como String y se pasa a Date
        cliente = c;
        fechaInicial = new SimpleDateFormat("dd/MM/yyyy").parse(fi);
        fechaFinal = new SimpleDateFormat("dd/MM/yyyy").parse(ff);
        amarre = posAmarre;
        barco = b;
        valorFijo = 200;
    }

    public void actualizarValor(int i) {
        valorFijo = i;
    }

    public int calcularAlquiler() {
        //creo una Date 
        Date diferenciaDias = new Date(fechaFinal.getTime() - fechaInicial.getTime());
        int dias = DateToDays(diferenciaDias);
        return (10 * this.barco.getEslora() + valorFijo + this.barco.getModulo()+dias);
    }

    public int DateToDays(Date fecha) {
        //milisec*sec*min*hours=1000*60*60*24=86400000
        long dias = fecha.getTime();
        dias = dias / 86400000;
        return (int) dias;
    }
}