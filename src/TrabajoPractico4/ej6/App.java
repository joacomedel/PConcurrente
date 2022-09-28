package TrabajoPractico4.ej6;

public class App {
    public static void main(String[] args) {
        Empleado[] arregloEmpleados = new Empleado[10];
        String[] nombres = {"pepito","juan","ariel","lopez"};
        Sala sala = new Sala();
        for (int i = 0; i < arregloEmpleados.length; i++) {
            arregloEmpleados[i] = new Empleado(nombres[i%2] + " " + i , sala);
            arregloEmpleados[i].start();
        }
        Mozo mozo = new Mozo(sala);
        mozo.start();
    }
}
