package controllers;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Adopcion;
import modelo.Animal;
import modelo.CadenciaVisitas;
import modelo.Cliente;
import modelo.EpreferenciaRecordatorio;
import modelo.Refugio;
import modelo.Seguimiento;
import modelo.Visitador;

public class AdopcionController {
	
	public static ArrayList<Adopcion> adopciones = new ArrayList<Adopcion>();
	
	public ArrayList<Adopcion> getAdopciones() {
		return adopciones;
	}

	public void setAdopciones(Adopcion adopcion) {
		this.adopciones.add(adopcion);
	}
	
	public void crearAdopcion(Cliente cliente, Animal animal, Visitador visitador,EpreferenciaRecordatorio preferenciaRecordatorio, CadenciaVisitas cadenciaVisitas) {
		if (cliente.puedeAdoptar() && animal.esAdoptable()) {		
			Seguimiento seguimiento = new Seguimiento(visitador);
			cliente.setPreferenciaRecordatorio(preferenciaRecordatorio);
			seguimiento.setCadenciaVisitas(cadenciaVisitas);
			cliente.setAnimalesAdoptados(cliente.getAnimalesAdoptados() + 1);
			Adopcion adopcion = new Adopcion(cliente, animal);
			animal.serAdoptado(animal);
			seguimiento.setAdopcion(adopcion);
			adopciones.add(adopcion);
			AnimalController.animales.remove(animal);
			SeguimientoController.seguimientoAdopciones.add(seguimiento);
			System.out.println(seguimiento);
		}
		else if(!cliente.puedeAdoptar()) {
			System.out.println("El cliente " + cliente.getNombre() + "ya posee mas de 2 mascotas");
		}
		else if(!animal.esAdoptable()) {
			System.out.println("El animal " + animal + "no se puede adoptar");
		}
	
	}
}
