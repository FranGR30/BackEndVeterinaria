package controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import estadoCondicionMedica.Enfermo;
import estadoCondicionMedica.EstadoCondicionMedica;
import estadoCondicionMedica.Saludable;
import modelo.Accion;
import modelo.Alarma;
import modelo.Animal;
import modelo.Control;
import modelo.Refugio;
import modelo.Seguimiento;
import modelo.SeguimientoTratamiento;
import modelo.TratamientoMedico;
import modelo.Veterinario;
import testMain.Utilidades;

public class AlarmaController {
	public static ArrayList<Alarma> alarmas = new ArrayList<Alarma>();

	public void listarAlarmas() {
		int cont = 0;
		for (Alarma alarma : alarmas) {
			cont++;
			System.out.println(cont + "- " + alarma);
		}
	}

	public ArrayList<Alarma> getAlarmas() {
		return alarmas;
	}

	public void setAlarma(Alarma alarma) {
		this.alarmas.add(alarma);
	}

	public void eliminarAlarma(Alarma alarma) {
		this.alarmas.remove(alarma);
	}

	public void crearAlarmaControl(Animal animal, ArrayList<Accion> acciones) {
		Control control = new Control();
		Alarma alarma = control.crearAlarma(control);
		animal.getFichaTecnica().agregarControl(control);
		alarmas.add(alarma);
		control.setAccionesARealizar(acciones);
		alarma.enviarNotificacionPush();
		System.out.println("Se ha creado una nueva alarma de control");
	}

	public void crearAlarmaTratamientoMedico(Animal animal, LocalDateTime fechaInicio, LocalDateTime fechaFin, String desc, String nombre, int periodicidad, ArrayList<Accion> acciones) {
		TratamientoMedico tratamiento = new TratamientoMedico(fechaInicio,fechaFin,desc,nombre,periodicidad);
		Alarma alarma = tratamiento.crearAlarma(tratamiento);
		animal.getFichaTecnica().agregarTratamiento(tratamiento);
		alarmas.add(alarma);
		tratamiento.setAcciones(acciones);
		alarma.enviarNotificacionPush();
		System.out.println("Se ha creado una nueva alarma de tratamiento medico");
	}

	public void atenderControl(Veterinario veterinario, Alarma alarma, Animal animal, String comentario) {
		((Control) alarma.getTipo()).setVeterinario(veterinario);
		((Control) alarma.getTipo()).marcarFinalizado();
		((Control) alarma.getTipo()).setComentario(comentario);
		alarmas.remove(alarma);
	}

	public void atenderTratamientoMedico(Veterinario veterinario, Alarma alarma, Animal animal,String comentario,boolean finalizarTratamiento) {
		SeguimientoTratamiento seguimientoTratamiento = new SeguimientoTratamiento();
		((TratamientoMedico) alarma.getTipo()).setVeterinario(veterinario);
		if(finalizarTratamiento) {			
			((TratamientoMedico) alarma.getTipo()).marcarFinalizado();
			alarmas.remove(alarma);
		}
		seguimientoTratamiento.setVeterinario(veterinario);
		seguimientoTratamiento.setFecha(LocalDateTime.now());
		seguimientoTratamiento.setComentario(comentario);
		seguimientoTratamiento.setTratamiento((TratamientoMedico) alarma.getTipo());
		((TratamientoMedico) alarma.getTipo()).setSeguimientosTratamiento(seguimientoTratamiento);
	}
}