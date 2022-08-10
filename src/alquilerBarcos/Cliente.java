package alquilerBarcos;

public class Cliente {
    private String nombre;
    private String apellido;
    private int dni;
    private Alquiler alquilerCliente;
    
    public Cliente(String nombre , String apellido , int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    public void alquilar(Alquiler alquiler){
        alquilerCliente = alquiler;
    }
    public String getApellido() {
        return apellido;
    }
    public Alquiler getAlquilerCliente() {
        return alquilerCliente;
    }
    public int getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
}
