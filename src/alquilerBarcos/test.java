package alquilerBarcos;

import java.sql.Date;

import alquilerBarcos.tipoDeBarco.Veleros;

public class test {
    public static void main(String[] args) {
        Date date = new Date(2002, 07, 15);
        SistemaBarcos sistema = new SistemaBarcos();
        Cliente cliente1 = sistema.newCliente("Joaquin", "Medel", 44121868);
        System.out.println(cliente1.getNombre());
        Veleros barco = sistema.newVelero(1234, 12, date, 2);
        Alquiler alquiler = sistema.newAlquiler(cliente1, 1234, 1);
        System.out.println("0");
    }
}
