package alquilerBarcos;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Alquiler {
    private Date fechaInicio;
    private Date fechaFinal;
    private int posicionAmarre;
    private double valor;
    private Barco barcoAlquilado;
    private Cliente cliente;

    public Alquiler (int posicionAmarre ,Barco barcoAlquilado,Cliente cliente) {
        this.posicionAmarre = posicionAmarre;
        this.barcoAlquilado = barcoAlquilado;
        this.cliente= cliente;
        barcoAlquilado.setAlquilado(true);
        fechaInicio = Calendar.getInstance().getTime();//Obtengo la fecha actual
    }
    public double devolver(Date fechaFinal){
        double valor;
        this.fechaFinal = fechaFinal;
        int modulo = barcoAlquilado.obtenerModulo();
        int diasDeOcupacion = (int)Math.abs(fechaInicio.getTime()- fechaFinal.getTime());
        valor = modulo * diasDeOcupacion;
        this.valor = valor;
        barcoAlquilado.setAlquilado(false);
        return valor;
    }

    
}
