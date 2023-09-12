package modelo;

import java.util.*;

public interface TipoAlarma {

    public Alarma crearAlarma(TipoAlarma tipo);
    public void enviarNotificacionPush(Alarma alarma);

}