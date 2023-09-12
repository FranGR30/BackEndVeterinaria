package testMain;

import modelo.Adopcion;
import modelo.Alarma;
import modelo.Notificacion;
import modelo.Refugio;
import modelo.Seguimiento;
import modelo.TratamientoMedico;
import modelo.Usuario;
import modelo.Visita;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Utilidades {

	public static int nroMatricula = 1;
	public static int idAnimal = 1;

	public static int contadorNumeroMatricula() {
		int aux = nroMatricula;
		nroMatricula++;
		return aux;
	}

	public static int contadorIdAnimal() {
		int aux = idAnimal;
		idAnimal++;
		return aux;
	}

	public static void esperar(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static LocalDateTime solicitarUnaFecha() {
		Scanner scanner = new Scanner(System.in);
		// Solicitar al usuario que ingrese una fecha
		System.out.print("Ingrese una fecha (formato: dd/MM/yyyy HH:mm:ss): ");
		String fechaIngresada = scanner.nextLine();
		// Definir el formato de la fecha
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime fecha = LocalDateTime.parse(fechaIngresada, formatter);
		return fecha;

	}

	public static Timer claseTimer(Alarma alarma, int periodo) {
		Timer timer = new Timer();
		long tiempoInicial = 0;
		long periodo2 = periodo * 60 * 1000;
		TratamientoMedico tratamiento = (TratamientoMedico) alarma.getTipo();
		long duracionTotal = calcularDiferenciaFechas(tratamiento.getFechaInicio(), tratamiento.getFechaFin()) * 60
				* 1000;
		TimerTask task = new TimerTask() {
			long tiempoInicio = System.currentTimeMillis();

			@Override
			public void run() {
				System.out.println("NOTIFICACION PUSH: " + alarma);
				long tiempoActual = System.currentTimeMillis();
				long duracionTranscurrida = tiempoActual - tiempoInicio;
				if (duracionTranscurrida >= duracionTotal) {
					cancel();
				}
			}
		};
		timer.scheduleAtFixedRate(task, tiempoInicial, periodo2);
		return timer;
	}

	public static long calcularDiferenciaFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return ChronoUnit.MINUTES.between(fechaInicio, fechaFin);
	}

	public static boolean estaEnRangoHorario(LocalDateTime fecha, DayOfWeek diaSemana, LocalTime inicioRango,
			LocalTime finRango) {
		// Verificar si el día de la semana coincide
		if (fecha.getDayOfWeek() != diaSemana) {
			return false;
		}

		// Verificar si la hora está dentro del rango
		LocalTime hora = fecha.toLocalTime();
		return !hora.isBefore(inicioRango) && !hora.isAfter(finRango);
	}

	public static Timer claseTimerSeguimientosVisitaSMS(Notificacion notificacion, Visita visita, int diasAntes) {
		Timer timer = new Timer();
		long aux = calcularDiferenciaFechas(LocalDateTime.now(), visita.getFecha());
		long tiempoInicial = 0;
		long duracionTotal = calcularDiferenciaFechas(LocalDateTime.now(), visita.getFecha()) * 60 * 24 * 1000;
		long periodo2 = duracionTotal - diasAntes * 60 * 24 * 1000;
		TimerTask task = new TimerTask() {
			long tiempoInicio = System.currentTimeMillis();

			@Override
			public void run() {
				System.out.println("Enviando SMS a " + notificacion.getCliente().getNombre() + " "
						+ notificacion.getCliente().getApellido() + " por SMS: " + " " + notificacion.getMensaje()
						+ " ");
				long tiempoActual = System.currentTimeMillis();
				long duracionTranscurrida = tiempoActual - tiempoInicio;
				if (duracionTranscurrida >= duracionTotal) {
					cancel();
				}
			}
		};
		timer.scheduleAtFixedRate(task, tiempoInicial, periodo2);
		return timer;
	}

	public static Timer claseTimerSeguimientosVisitaEmail(Notificacion notificacion, Visita visita, int diasAntes) {
		Timer timer = new Timer();
		long aux = calcularDiferenciaFechas(LocalDateTime.now(), visita.getFecha());
		long tiempoInicial = 0;
		long duracionTotal = calcularDiferenciaFechas(LocalDateTime.now(), visita.getFecha()) * 60 * 24 * 1000;
		long periodo2 = duracionTotal - diasAntes * 60 * 24 * 1000;
		TimerTask task = new TimerTask() {
			long tiempoInicio = System.currentTimeMillis();

			@Override
			public void run() {
				System.out.println("Enviando email a " + notificacion.getCliente().getNombre() + " "
						+ notificacion.getCliente().getApellido() + " por Email: " + " " + notificacion.getMensaje()
						+ " ");
				long tiempoActual = System.currentTimeMillis();
				long duracionTranscurrida = tiempoActual - tiempoInicio;
				if (duracionTranscurrida >= duracionTotal) {
					cancel();
				}
			}
		};
		timer.scheduleAtFixedRate(task, tiempoInicial, periodo2);
		return timer;
	}

	public static Timer claseTimerSeguimientosVisitaWhatsapp(Notificacion notificacion, Visita visita, int diasAntes) {
		Timer timer = new Timer();
		long aux = calcularDiferenciaFechas(LocalDateTime.now(), visita.getFecha());
		long tiempoInicial = 0;
		long duracionTotal = calcularDiferenciaFechas(LocalDateTime.now(), visita.getFecha()) * 60 * 24 * 1000;
		long periodo2 = duracionTotal - diasAntes * 60 * 24 * 1000;
		TimerTask task = new TimerTask() {
			long tiempoInicio = System.currentTimeMillis();

			@Override
			public void run() {
				System.out.println("Enviando WhatsaApp a " + notificacion.getCliente().getNombre() + " "
						+ notificacion.getCliente().getApellido() + " por WhatsApp: " + " " + notificacion.getMensaje()
						+ " ");
				long tiempoActual = System.currentTimeMillis();
				long duracionTranscurrida = tiempoActual - tiempoInicio;
				if (duracionTranscurrida >= duracionTotal) {
					cancel();
				}
			}
		};
		timer.scheduleAtFixedRate(task, tiempoInicial, periodo2);
		return timer;
	}
}
