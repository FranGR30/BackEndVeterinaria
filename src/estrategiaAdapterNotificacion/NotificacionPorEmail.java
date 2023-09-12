package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;
import modelo.Visita;

/**
 * 
 */
public class NotificacionPorEmail implements EstrategiaDeNotificacion {

    private AdapterNotificadorEmail adapter;

    public NotificacionPorEmail(AdapterNotificadorEmail adapter) {
    	super();
    	this.adapter = adapter;
    }

    public void enviar(Notificacion notificacion, Visita visita) {
    	this.adapter.enviarEmail(notificacion, visita);
    }

	public void setAdapter(AdapterNotificadorEmail adapter) {
		this.adapter = adapter;
	}
}