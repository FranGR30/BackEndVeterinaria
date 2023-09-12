package modelo;

import java.time.LocalDateTime;
import java.util.*;

import controllers.UsuarioController;

public class Control implements TipoAlarma{

    private ArrayList<Accion> accionesARealizar;
    private LocalDateTime fecha;
    private Veterinario veterinario;
    private boolean estaFinalizado;
    private String comentario;
    
    public Control() {
    	this.fecha = LocalDateTime.now();
    	this.accionesARealizar = new ArrayList();
    	this.estaFinalizado = false;
    }
    
	@Override
	public Alarma crearAlarma(TipoAlarma tipo) {
		Alarma alarma = new Alarma(this);
		return alarma;
	}
	
	public void marcarFinalizado() {
    	this.estaFinalizado = true;
    }

	public void agregarAccion (Accion accion) {
		this.accionesARealizar.add(accion);
	}

	@Override
	public String toString() {
		return "Control, Acciones a realizar: " + accionesARealizar + ", fecha: " + fecha;
	}

	@Override
	public void enviarNotificacionPush(Alarma alarma) {
		if(UsuarioController.userConectado.getClass().equals(Veterinario.class)) {
			System.out.println("NOTIFICACION PUSH: " +this.toString());
		}
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setAccionesARealizar(ArrayList<Accion> accionesARealizar) {
		this.accionesARealizar = accionesARealizar;
	}
	
	

}