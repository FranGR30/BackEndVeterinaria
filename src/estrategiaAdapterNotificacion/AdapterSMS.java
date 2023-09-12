package estrategiaAdapterNotificacion;

import java.util.*;

import controllers.UsuarioController;
import modelo.Notificacion;
import modelo.Refugio;
import modelo.Veterinario;
import modelo.Visita;
import modelo.Visitador;
import testMain.Utilidades;

/**
 * 
 */
public class AdapterSMS implements AdapterNotificadorSMS {

    public AdapterSMS() {
    }

    public void enviarSMS(Notificacion notificacion, Visita visita) {
		if(UsuarioController.userConectado.getClass().equals(Visitador.class)) {
			Utilidades.claseTimerSeguimientosVisitaSMS(notificacion, visita, notificacion.getDiasPreferencia());
		}
    }

}