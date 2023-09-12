package modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import estadoCondicionMedica.Saludable;
import estadoSeguimiento.Finalizado;
import testMain.Utilidades;

/**
 * 
 */
public class Visita {

    private LocalDateTime fecha;
    private EncuestaVisitador encuesta;
    private boolean estaFinalizada = false;
    
    public Visita() {
    }

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public EncuestaVisitador getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(EncuestaVisitador encuesta) {
		this.encuesta = encuesta;
	}

	@Override
	public String toString() {
		return "Visita [fecha=" + fecha + ", encuesta=" + encuesta + ", estaFinalizada=" + estaFinalizada + "]";
	}

	public boolean isEstaFinalizada() {
		return estaFinalizada;
	}

	public void setEstaFinalizada(boolean estaFinalizada) {
		this.estaFinalizada = estaFinalizada;
	}
	

}