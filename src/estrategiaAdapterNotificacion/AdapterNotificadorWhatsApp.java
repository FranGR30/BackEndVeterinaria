package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;
import modelo.Visita;


public interface AdapterNotificadorWhatsApp {

    public void enviarWhatsApp(Notificacion notificacion, Visita visita);

}