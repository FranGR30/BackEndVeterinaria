package modelo;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class Notificacion {
	
    private String mensaje;
    private LocalDateTime fecha;
    private Cliente cliente;
    private int diasPreferencia;

    public Notificacion(String mensaje,Cliente cliente,int diasPreferencia) {
    	this.mensaje = mensaje;
    	this.cliente = cliente;
    	this.diasPreferencia= diasPreferencia;
    	this.fecha = LocalDateTime.now();
    }
    
    public Notificacion() {
    	this.fecha = LocalDateTime.now();
    }
    
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getDiasPreferencia() {
		return diasPreferencia;
	}

	public void setDiasPreferencia(int diasPreferencia) {
		this.diasPreferencia = diasPreferencia;
	}

	@Override
	public String toString() {
		return "Notificacion [mensaje=" + mensaje + ", fecha=" + fecha + ", cliente=" + cliente + ", diasPreferencia="
				+ diasPreferencia + "]";
	}
	

}