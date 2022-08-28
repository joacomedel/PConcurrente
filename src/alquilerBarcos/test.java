package alquilerBarcos;

import java.sql.Date;
import java.util.Scanner;

import alquilerBarcos.tipoDeBarco.Veleros;

public class test {
    public static void main(String[] args) {
        Date date = new Date(2002, 07, 15);
        SistemaBarcos sistema = new SistemaBarcos();
        Cliente cliente1 = sistema.newCliente("Joaquin", "Medel", 44121868);
        Veleros velero = sistema.newVelero(1234, 12, date, 2);
        Alquiler alquiler = sistema.newAlquiler(cliente1, velero, 1);
        System.out.println("0");
        
    }
    /*public void IngresaNumero() throws Exception {
        Scanner sc = new Scanner(System.in);
        int i =0; 
        System.out.println("Ingrese 1 o 2");
        try {
            i = sc.nextInt();
        } catch (Exception e) {
        }
        switch (i) {
            case 1:
                //hace cosas
                break;
            case 2:
                //hace cosas
                break;
        
            default:
            Exception exp = new Exception("Ingrese uno de los valores pedidos");
            throw exp;
        }

    }*/
}
