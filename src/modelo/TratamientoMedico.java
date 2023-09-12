package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import controllers.UsuarioController;
import testMain.Utilidades;

public class TratamientoMedico implements TipoAlarma {

	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private ArrayList<Accion> acciones;
	private String descripcion;
	private String nombre;
	private int periodicidad;
	private boolean estaFinalizado;
	private Veterinario veterinario;
	private ArrayList<SeguimientoTratamiento> seguimientosTratamiento;
	private Timer timer;

	public TratamientoMedico(LocalDateTime fechaInicio, LocalDateTime fechaFin, String desc, String nombre, int periodicidad) {
		this.fechaFin = fechaFin;
		this.descripcion = desc;
		this.nombre = nombre;
		this.periodicidad = periodicidad;
		this.estaFinalizado = false;
		this.acciones = new ArrayList();
		this.seguimientosTratamiento = new ArrayList();
		this.fechaInicio = fechaInicio;
	}

	public TratamientoMedico() {
		this.acciones = new ArrayList();
	}

	public void marcarFinalizado() {
		this.estaFinalizado = true;
		this.timer.cancel();
	}

	public void agregarAccion(Accion accion) {
		this.acciones.add(accion);
	}

	@Override
	public Alarma crearAlarma(TipoAlarma tipo) {
		Alarma alarma = new Alarma(this);
		return alarma;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Accion> getAcciones() {
		return acciones;
	}

	public void setAcciones(ArrayList<Accion> acciones) {
		this.acciones = acciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}

	public boolean isEstaFinalizado() {
		return estaFinalizado;
	}

	public void setEstaFinalizado(boolean estaFinalizado) {
		this.estaFinalizado = estaFinalizado;
	}

	@Override
	public String toString() {
		return "TratamientoMedico, " + nombre + " fecha inicio: " + fechaInicio + ", fecha fin: " + fechaFin
				+ ", acciones: " + acciones + ", descripcion=" + descripcion + ", periodicidad=" + periodicidad
				+ ", estaFinalizado=" + estaFinalizado + "]";
	}

	@Override
	public void enviarNotificacionPush(Alarma alarma) {
		if (UsuarioController.userConectado.getClass().equals(Veterinario.class)) {
			this.timer = Utilidades.claseTimer(alarma, periodicidad);
		}

	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public void setSeguimientosTratamiento(SeguimientoTratamiento seguimientosTratamiento) {
		this.seguimientosTratamiento.add(seguimientosTratamiento);
	}

}