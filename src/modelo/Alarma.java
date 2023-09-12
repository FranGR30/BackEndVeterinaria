package modelo;

import java.util.*;

public class Alarma {

    private TipoAlarma tipo;
    
    public Alarma(TipoAlarma tipoAlarma) {
    	this.tipo = tipoAlarma;
    }
	public Alarma() {
	}

	@Override
	public String toString() {
		return "Alarma: " + tipo;
	}
	
	public void enviarNotificacionPush() {
		this.tipo.enviarNotificacionPush(this);
	}

	public TipoAlarma getTipo() {
		return tipo;
	}

	public void setTipo(TipoAlarma tipo) {
		this.tipo = tipo;
	}

}