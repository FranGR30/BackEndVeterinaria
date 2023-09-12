package estrategiaAdapterNotificacion;

import java.util.*;

import modelo.Notificacion;
import modelo.Visita;

public interface AdapterNotificadorEmail {
    public void enviarEmail(Notificacion notificacion, Visita visita);

}