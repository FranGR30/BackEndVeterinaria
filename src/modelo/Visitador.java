package modelo;

import java.util.*;

public class Visitador extends Usuario {
	
    private EtipoUsuario tipoUsuario;

    public Visitador(String nombre,String apellido, String nombreUsuario, String password) {
    	super(nombre, apellido, nombreUsuario, password);
    	this.tipoUsuario = EtipoUsuario.VISITADOR;
    }

	@Override
	public String toString() {
		return "Visitador " + nombre + "[tipoUsuario=" + tipoUsuario + "]";
	}

	public EtipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(EtipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
    
}