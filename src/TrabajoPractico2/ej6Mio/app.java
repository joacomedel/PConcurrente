package TrabajoPractico2.ej6Mio;


public class app {
    private static ProductoSM stock[];
    public static void main(String[] args) {
        cargarStock();
        int temp[] = {0,1,2,3,4};
        ClienteSM cliente1 = cargarCliente("Jose",temp);
        int temp2[] = {5,6,7,8,9};
        ClienteSM cliente2 = cargarCliente("Juan",temp2);
        System.out.println(Cobrar(cliente1));
        System.out.println(Cobrar(cliente2));
        for (int i = 0; i < 50; i++) {
            System.out.print(i+",");
        }
    }
    public static void cargarStock() {
        stock = new ProductoSM[10];
        stock[0]= new ProductoSM(10,"Caramelo De Miel");
        stock[1]= new ProductoSM(7,"Caramelo De Frutilla");
        stock[2]= new ProductoSM(5,"Caramelo De Banana");
        stock[3]= new ProductoSM(8,"Caramelo De Anana");
        stock[4]= new ProductoSM(10,"Caramelo De Pera");
        stock[5]= new ProductoSM(15,"Caramelo De Manzana");
        stock[6]= new ProductoSM(30,"Chupetin con Chicle");
        stock[7]= new ProductoSM(20,"Chupetin normal");
        stock[8]= new ProductoSM(10,"Chicle De Frutilla");
        stock[9]= new ProductoSM(10,"Chicle De Menta");
        
    }
    public static ClienteSM cargarCliente(String nombre , int id[]) {
        ClienteSM clienteRetorna = new ClienteSM(nombre);
        int longitud = id.length;
        for (int i = 0; i < longitud; i++) {
            clienteRetorna.agregarProducto(stock[id[i]]);
        }
        return clienteRetorna;
    }
    public static int Cobrar(ClienteSM clienteSM) {
        Cobro cobro = new Cobro(clienteSM);
        Thread hilo = new Thread(cobro, "Hilo De " + clienteSM.getNombre());
        hilo.start();
        int retorna = cobro.getPrecioCobro();
        return retorna;
    }
}
