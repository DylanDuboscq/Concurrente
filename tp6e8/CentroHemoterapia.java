package tp6e8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CentroHemoterapia {

    private final Lock lock = new ReentrantLock();
    private final Condition noHayCamillas = lock.newCondition();
    private final Condition noHaySillas = lock.newCondition();
    private final Condition noHayRevistas = lock.newCondition();
    private final Condition esperoClientes = lock.newCondition();
    private final Condition esperoDonar = lock.newCondition();
    private int camillas, camillasOcupadas;
    private int sillas, sillasOcupadas;
    private int revistas, revistasOcupadas;
    private int turnos, turnoActual;

    public CentroHemoterapia(int camill, int sill, int revis) {
        camillas = camill;
        sillas = sill;
        revistas = revis;
        camillasOcupadas = 0;
        sillasOcupadas = 0;
        revistasOcupadas = 0;
        turnos = 0;
        turnoActual = 0;
    }

    public void donarSangre(boolean prefieroSentarme, String nombre) {
        lock.lock();
        int miTurno = turnos++;
        boolean meSente = false;
        boolean agarreRevista = false;
        System.out.println(nombre + " entró al centro");
        while (camillasOcupadas == camillas) {
            try {
                if ((prefieroSentarme)) {
                    while (sillas == sillasOcupadas) {
                        noHaySillas.await();
                    }
                    System.out.println(nombre + " se sentó");
                    sillasOcupadas++;
                    System.out.println("sillas ocupadas "+sillasOcupadas);
                }
                while (revistas == revistasOcupadas) {
                    noHayRevistas.await();
                }
                System.out.println(nombre + " consiguió revista");
                revistasOcupadas++;
                System.out.println("revistas en mano "+revistasOcupadas);
                agarreRevista = true;
                noHayCamillas.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(CentroHemoterapia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (meSente) {
            sillasOcupadas--;
            noHaySillas.signal();
        }
        if (agarreRevista) {
            revistasOcupadas--;
            noHayRevistas.signal();
        }
        System.out.println(nombre + " consiguió camilla");
        camillasOcupadas++;
        System.out.println("camillas ocupadas "+camillasOcupadas);
        esperoClientes.signal();
        while (miTurno == turnoActual) {
            try {
                esperoDonar.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(CentroHemoterapia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(nombre + " fue atendido");
        lock.unlock();
    }

    public void terminarDonacion() {
        lock.lock();
        camillasOcupadas--;
        turnoActual++;
        noHayCamillas.signalAll();
        esperoDonar.signalAll();
        lock.unlock();
    }

    public void atenderCliente() {
        lock.lock();
        while (camillasOcupadas == 0) {
            try {
                esperoClientes.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(CentroHemoterapia.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        lock.unlock();
    }
}