package tp4.ej9;

public class mainTaxis {

    public static void main(String[] args) {
        
        Taxi elTaxi = new Taxi();
        Pasajero elPasajero = new Pasajero("Jorge el pasajero", elTaxi);
        Taxista elTaxista = new Taxista("Jose el taxista", elTaxi);
        
        Thread pasajero = new Thread(elPasajero);
        Thread taxista = new Thread(elTaxista);
        
        pasajero.start();
        taxista.start();
    } 
}