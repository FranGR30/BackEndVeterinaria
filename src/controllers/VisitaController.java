package controllers;

import java.util.Scanner;

import modelo.ERespuestaEncuesta;
import modelo.EncuestaVisitador;
import modelo.Seguimiento;
import modelo.Visita;

public class VisitaController {

	public void completarEncuesta(Visita visita, ERespuestaEncuesta estadoGeneralAnimal, ERespuestaEncuesta limpiezaLugar,
			ERespuestaEncuesta ambiente) {
    	EncuestaVisitador encuesta = new EncuestaVisitador(estadoGeneralAnimal, limpiezaLugar, ambiente);
    	visita.setEncuesta(encuesta);
	}
	
	public void finalizarVisita(Visita visita, Seguimiento seguimiento) {
    	visita.setEstaFinalizada(true);
	}
}

