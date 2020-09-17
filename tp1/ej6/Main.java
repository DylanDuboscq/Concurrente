/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ej6;

/**
 *
 * @author joa
 */
public class Main {

    public static void main(String[] args) {
        //faltaba un trycach en el main
        double[] v = new double[15];
        try {
            acceso_por_indice(v, 16);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    public static double acceso_por_indice(double[] v, int j) throws RuntimeException {
        double i = 0;
        try {
            if ((0 <= j) && (j <= v.length)) {
                return v[j];
            } else {
                throw new RuntimeException("El indice " + j + " no existe en el vector");
            }
        } catch (RuntimeException exc) {
            throw exc;
        } finally {
            System.out.println("cartel de finally\n");
        }
    }
}
