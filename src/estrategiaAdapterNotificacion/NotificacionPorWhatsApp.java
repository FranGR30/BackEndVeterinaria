package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;
import modelo.Visita;

 
public class NotificacionPorWhatsApp implements EstrategiaDeNotificacion {
    private AdapterNotificadorWhatsApp adapter;
    public NotificacionPorWhatsApp(AdapterNotificadorWhatsApp adapter) {
        super();
        this.adapter = adapter;
    }

    public void enviar(Notificacion notificacion, Visita visita) {
    	this.adapter.enviarWhatsApp(notificacion, visita);
    }

	public void setAdapter(AdapterNotificadorWhatsApp adapter) {
		this.adapter = adapter;
	}

}