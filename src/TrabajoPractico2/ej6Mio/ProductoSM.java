package TrabajoPractico2.ej6Mio;

public class ProductoSM {
    private int precio;
    private String nombre;
    public ProductoSM (int precio , String nombre){
        this.precio = precio;
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
}
