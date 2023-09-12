package modelo;

import java.util.ArrayList;

public class Refugio {
	
	private ArrayList<Notificacion> notificacionesVisitador = new ArrayList<Notificacion>();

	private static Refugio instance;

	private Refugio() {
	};

	public static Refugio getInstance() {
		if (instance == null) {
			instance = new Refugio();
		}
		return instance;
	}

	
}
