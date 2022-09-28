package TrabajoPractico4.ej6;

public class Empleado extends Thread{
    Sala sala;
    String nombre;
    public Empleado (String nombre , Sala sala){
        this.sala = sala;
        this.nombre = nombre;
    }
    @Override
    public void run() {
        try {
            sala.entraEmpleado();
            System.out.println(nombre + " esta comiendo");
            Thread.sleep(10);
            System.out.println(nombre + " termina de comer");  
            sala.saleEmpleado();
        } catch (Exception e) {}
       
    }
    
}
