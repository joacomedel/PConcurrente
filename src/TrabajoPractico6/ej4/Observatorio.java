package TrabajoPractico6.ej4;



public class Observatorio {
    int personasMax;
    int cantPersonas;
    int cantMantenimiento;
    int cantInvestigadores;
    int cantSilla;
    int esperaInvestigadores; //Prioridad para investigadores
    public Observatorio(){
    }
    public synchronized void entrarVisitante(boolean silla){
        while (estaLLeno() || esperaInvestigadores != 0 || cantMantenimiento != 0 || cantInvestigadores != 0)
        try {this.wait();}catch(InterruptedException e){}
        if (silla) {
            personasMax = 30;
            cantSilla++;
        }
        cantPersonas++;
    }
    public synchronized void salirVisitante(boolean silla){
        if (silla){
            cantSilla--;
            if (cantSilla == 0)personasMax = 50;
        }
        cantPersonas--;
        this.notifyAll();
    }
    public synchronized void entrarInvetigador(){
        esperaInvestigadores++;
        while(estaLLeno() || cantPersonas != cantInvestigadores )//Si hay la misma cantidad de investigadores que de Personas , es q solo hay investigadores
            try {this.wait(); } catch (InterruptedException e){}
        esperaInvestigadores--;
        cantPersonas++;
        cantInvestigadores++;
    }
    public synchronized void salirInvetigador(){
        cantPersonas--;
        cantInvestigadores--;
        notifyAll();
    }
    public synchronized void entrarMantenimento(){
        while (estaLLeno() || cantPersonas != cantMantenimiento) {
            try {this.wait();} catch (InterruptedException e){
            }
        }
        cantPersonas++;
        cantMantenimiento++;
    }
    public synchronized void salirMantenimiento(){
        cantMantenimiento--;
        cantPersonas--;
        notifyAll();
    }
    private synchronized boolean estaLLeno(){
        return cantPersonas >= personasMax;
    }
}
