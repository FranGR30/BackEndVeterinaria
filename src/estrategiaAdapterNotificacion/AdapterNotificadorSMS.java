package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;
import modelo.Visita;

public interface AdapterNotificadorSMS {
    public void enviarSMS(Notificacion notificacion, Visita visita);

}