package alquilerBarcos.tipoDeBarco;

import java.util.Date;

import alquilerBarcos.Barco;

public abstract class BarcoAMotor extends Barco {
    protected int CV;
    protected void incializarBarcoAMotor(int CV) {
        this.CV = CV;
    }
    public BarcoAMotor(int matricula,int metrosEslora,Date fechaFabricacion,int CV){
        super(matricula, metrosEslora, fechaFabricacion);
        this.CV = CV;
    }
    public int obtenerModulo (){
        int modulo = super.obtenerModulo()+CV;
        return modulo;
    } 
}
