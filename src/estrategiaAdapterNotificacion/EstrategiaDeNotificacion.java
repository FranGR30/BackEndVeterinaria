package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;
import modelo.Visita;

/**
 * 
 */
public interface EstrategiaDeNotificacion {

    public void enviar(Notificacion notificacion, Visita visita);

}