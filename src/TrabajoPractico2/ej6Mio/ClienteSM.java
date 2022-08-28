package TrabajoPractico2.ej6Mio;

public class ClienteSM {
    private ProductoSM productoSM[];
    private String nombre;
    private int productosComprados;

    public ClienteSM (String nombre) {
        this.nombre = nombre;
        productosComprados = 0;
        productoSM = new ProductoSM[50];
    }
    public void agregarProducto(ProductoSM elProducto) {
        productoSM[productosComprados] = elProducto;
        productosComprados++;
    }
    public int getProductosComprados() {
        return productosComprados;
    }
    public ProductoSM getProductoSM(int id){
        return productoSM[id];
    }
    public String getNombre() {
        return nombre;
    }


}
