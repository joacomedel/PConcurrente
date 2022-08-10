package alquilerBarcos.tipoDeBarco;

import alquilerBarcos.Barco;

public abstract class BarcoAMotor extends Barco {
    protected int CV;
    protected void incializarBarcoAMotor(int CV) {
        this.CV = CV;
    }
}
