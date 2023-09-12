package controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import modelo.Seguimiento;
import modelo.Visita;

public class SeguimientoController {
	public static ArrayList<Seguimiento> seguimientoAdopciones = new ArrayList<Seguimiento>();
	public void listarSeguimientos() {
		int cont = 0;
		for (Seguimiento seguimiento : seguimientoAdopciones) {
			cont++;
			System.out.println(cont + "- " + seguimiento);
		}
	}

	public void listarVisitasDeSeguimiento(Seguimiento seguimiento) {
		int cont = 0;
		for (Visita visita : seguimiento.getVisitas()) {
			cont++;
			System.out.println(" " + cont + "- " + visita);
		}
	}

	public ArrayList<Seguimiento> getSeguimientoAdopciones() {
		return seguimientoAdopciones;
	}

	public void setSeguimientoAdopcion(Seguimiento seguimientoAdopciones) {
		this.seguimientoAdopciones.add(seguimientoAdopciones);
	}
	public void eliminarSeguimiento(Seguimiento seguimientoAdopciones) {
		this.seguimientoAdopciones.remove(seguimientoAdopciones);
	}
	
	public void realizarSeguimiento(Seguimiento seguimientoAdopciones, LocalDateTime fechaVisita, int preferenciaDias) {
		seguimientoAdopciones.realizarSeguimiento(seguimientoAdopciones, fechaVisita, preferenciaDias);
	}
}
