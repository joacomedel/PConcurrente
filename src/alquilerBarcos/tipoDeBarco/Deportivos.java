package alquilerBarcos.tipoDeBarco;

import java.util.Date;

public class Deportivos extends BarcoAMotor {
    public Deportivos (int matricula,int metrosEslora,Date fechaFabricacion,int CV){
        incializarBarco(matricula, metrosEslora, fechaFabricacion);
        incializarBarcoAMotor(CV);

    }
}
