package TrabajoPractico3.ej4;

public class Hamster extends Thread {
    private Actividad actividadAr[];
    private String nombre;
    private String color;
    final private String colorNegro = "\u001B[30m";
    

    public Hamster (String nombre , Actividad actividadAr[], String color){
        this.nombre = nombre;
        this.actividadAr = actividadAr;
        this.color = color;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.hacerAct(actividadAr[i%3]);
            } catch (InterruptedException e) {
            }
        }
    }
    public void hacerAct(Actividad act) throws InterruptedException{
        boolean actPermitida;
        String nombreConColor = color + this.nombre;
        actPermitida = act.usar();
        if (actPermitida) {
            System.out.println(nombreConColor + colorNegro +" esta haciendo " + act.getNombre());
            Thread.sleep(40);
            act.dejarDeUsar();
            System.out.println(nombreConColor + colorNegro +" deja de hacer " + act.getNombre());
        }else{
            String colorTemp = "\u001B[30m";
            System.out.println(nombreConColor + colorTemp +" no puede hacer " + act.getNombre());
        }
    }
    
}
