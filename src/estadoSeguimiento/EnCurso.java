package estadoSeguimiento;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import estrategiaAdapterNotificacion.AdapterEmail;
import estrategiaAdapterNotificacion.AdapterSMS;
import estrategiaAdapterNotificacion.AdapterWhatsApp;
import estrategiaAdapterNotificacion.EstrategiaDeNotificacion;
import estrategiaAdapterNotificacion.NotificacionPorEmail;
import estrategiaAdapterNotificacion.NotificacionPorSMS;
import estrategiaAdapterNotificacion.NotificacionPorWhatsApp;
import modelo.EpreferenciaRecordatorio;
import modelo.Notificacion;
import modelo.Seguimiento;
import modelo.Visita;
import testMain.Utilidades;

public class EnCurso implements EstadoSeguimiento {

    public EnCurso() {
    }

    public void realizarSeguimiento(Seguimiento seguimiento, LocalDateTime fechaVisita, int preferenciaDias) {
    	Visita visita = new Visita();
    	seguimiento.setVisitas(visita);
    	visita.setFecha(fechaVisita);
        Notificacion notificacion = new Notificacion();
        notificacion.setDiasPreferencia(preferenciaDias);
        notificacion.setMensaje("Visita programada para la fecha: "+visita.getFecha());
        notificacion.setCliente(seguimiento.getAdopcion().getCliente());
        
        if(seguimiento.getAdopcion().getCliente().getPreferenciaRecordatorio().equals(EpreferenciaRecordatorio.SMS)) {
        	EstrategiaDeNotificacion notificadorSMS = new NotificacionPorSMS(new AdapterSMS());
        	seguimiento.getNotificador().cambiarEstrategiaNotificacion(notificadorSMS);
        }
        else if(seguimiento.getAdopcion().getCliente().getPreferenciaRecordatorio().equals(EpreferenciaRecordatorio.WHATSAPP)) {
        	EstrategiaDeNotificacion notificadorWhatsApp  = new NotificacionPorWhatsApp(new AdapterWhatsApp());
        	seguimiento.getNotificador().cambiarEstrategiaNotificacion(notificadorWhatsApp);
        }
        else if(seguimiento.getAdopcion().getCliente().getPreferenciaRecordatorio().equals(EpreferenciaRecordatorio.EMAIL)) {
        	EstrategiaDeNotificacion notificadorEmail  = new NotificacionPorEmail(new AdapterEmail());
        	seguimiento.getNotificador().cambiarEstrategiaNotificacion(notificadorEmail);
        }
        seguimiento.getNotificador().enviar(notificacion, visita);
    }
}