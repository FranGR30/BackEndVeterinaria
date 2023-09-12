package modelo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * 
 */
public class CadenciaVisitas {

    public CadenciaVisitas(DayOfWeek dia, LocalTime rangoHorarioInicio, LocalTime rangoHorarioFin) {
    	this.dia = dia;
    	this.rangoHorarioFin = rangoHorarioFin;
    	this.rangoHorarioInicio = rangoHorarioInicio;
    }

    private DayOfWeek dia;
    private LocalTime rangoHorarioInicio;
    private LocalTime rangoHorarioFin;


    public boolean dentroDeRango(LocalTime hora) {
        return !hora.isBefore(rangoHorarioInicio) && !hora.isAfter(rangoHorarioFin);
    }


	@Override
	public String toString() {
		return "CadenciaVisitas [dia=" + dia + ", rangoHorarioInicio=" + rangoHorarioInicio + ", rangoHorarioFin="
				+ rangoHorarioFin + "]";
	}


	public DayOfWeek getDia() {
		return dia;
	}


	public void setDia(DayOfWeek dia) {
		this.dia = dia;
	}


	public LocalTime getRangoHorarioInicio() {
		return rangoHorarioInicio;
	}


	public void setRangoHorarioInicio(LocalTime rangoHorarioInicio) {
		this.rangoHorarioInicio = rangoHorarioInicio;
	}


	public LocalTime getRangoHorarioFin() {
		return rangoHorarioFin;
	}


	public void setRangoHorarioFin(LocalTime rangoHorarioFin) {
		this.rangoHorarioFin = rangoHorarioFin;
	}

}