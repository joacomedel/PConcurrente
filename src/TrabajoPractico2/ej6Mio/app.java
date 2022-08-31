package TrabajoPractico2.ej6Mio;


public class app {
    private static ProductoSM stock[];
    public static void main(String[] args) {
        cargarStock();
        int temp[] = {0,1,2,3,4};
        ClienteSM cliente1 = cargarCliente("Jose",temp);
        int temp2[] = {5,6,7,8,9};
        ClienteSM cliente2 = cargarCliente("Juan",temp2);
        Cobro cobro1 = new Cobro(cliente1);
        Cobro cobro2 = new Cobro(cliente2);
        Thread t1 = new Thread(cobro1);
        Thread t2 = new Thread(cobro2);
        t1.start();
        t2.start();
        try {
            t1.join();
            System.out.println(cobro1.getPrecioCobro());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            t2.join();
            System.out.println(cobro2.getPrecioCobro());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
}
