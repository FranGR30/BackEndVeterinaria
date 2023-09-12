package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;
import modelo.Visita;

/**
 * 
 */
public class NotificacionPorSMS implements EstrategiaDeNotificacion {

    private AdapterNotificadorSMS adapter;
    
    public NotificacionPorSMS(AdapterNotificadorSMS adapter) {
        super();
        this.adapter = adapter;
    }
    public void enviar(Notificacion notificacion, Visita visita) {
    	this.adapter.enviarSMS(notificacion, visita);
    }
	public void setAdapter(AdapterNotificadorSMS adapter) {
		this.adapter = adapter;
	}
    

}