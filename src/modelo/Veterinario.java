package modelo;

import java.util.*;
import testMain.Utilidades;

public class Veterinario extends Usuario {

	private int nroMatricula;
    private EtipoUsuario tipoUsuario;

    public Veterinario(String nombre,String apellido, String nombreUsuario, String password) {
    	super(nombre, apellido, nombreUsuario, password);
    	this.nroMatricula = Utilidades.contadorNumeroMatricula();
    	this.tipoUsuario = EtipoUsuario.VETERINARIO;
    }
    
	public int getNroMatricula() {
		return nroMatricula;
	}

	public EtipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	@Override
	public String toString() {
		return "Nombre: "+nombre+" Apellido: "+apellido+" nombreUsuario: "+nombreUsuario+" password: "+password+" Nro matricula: "+nroMatricula;
	}
	
}