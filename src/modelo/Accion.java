package modelo;

import java.util.*;

public class Accion {

    private String nombreAccion;
    private String descripcion;

    public Accion(String nombreAccion, String desc) {
    	this.nombreAccion = nombreAccion;
    	this.descripcion = desc;
    }

	public Accion() {
	}

	public String getNombreAccion() {
		return nombreAccion;
	}

	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Accion: " + nombreAccion + ", descripcion: " + descripcion;
	}

}