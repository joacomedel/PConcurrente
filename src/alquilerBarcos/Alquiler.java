package alquilerBarcos;

import java.util.Calendar;
import java.util.Date;

public class Alquiler {
    private Date fechaInicio;
    private Date fechaFinal;
    private int posicionAmarre;
    private double valor;
    private Barco barcoAlquilado;

    public Alquiler (int posicionAmarre ,Barco barcoAlquilado) {
        this.posicionAmarre = posicionAmarre;
        this.barcoAlquilado = barcoAlquilado;
        fechaFinal = Calendar.getInstance().getTime();
    }

    
}
