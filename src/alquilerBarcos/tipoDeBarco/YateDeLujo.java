package alquilerBarcos.tipoDeBarco;

import java.util.Date;

public class YateDeLujo extends BarcoAMotor {
    private int camarotes;
    public YateDeLujo (int matricula,int metrosEslora,Date fechaFabricacion,int CV, int camarotes){
        incializarBarco(matricula, metrosEslora, fechaFabricacion);
        incializarBarcoAMotor(CV);
        this.camarotes = camarotes;

    }
    public int obtenerModulo (){
        int modulo = super.obtenerModulo()+camarotes;
        return modulo;
    } 
}
