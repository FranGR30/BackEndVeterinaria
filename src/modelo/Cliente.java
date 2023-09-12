package modelo;

import java.util.*;

/**
 * 
 */
public class Cliente {
	private String nombre;
	private String apellido;
	private String estadoCivil;
	private String email;
	private String telefono;
	private String ocupacion;
	private boolean otrasMascotas;
	private String motivoAdopcion;
	private String tipoAnimalInteresado;
	private EpreferenciaRecordatorio preferenciaRecordatorio;
	private int animalesAdoptados;

	public Cliente(String nombre, String apellido, String estadoCivil, String email, String telefono, String ocupacion,
			boolean otrasMascotas, String motivoAdopcion, String tipoAnimalInteresado, int animalesAdoptados) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.estadoCivil = estadoCivil;
		this.email = email;
		this.telefono = telefono;
		this.ocupacion = ocupacion;
		this.otrasMascotas = otrasMascotas;
		this.motivoAdopcion = motivoAdopcion;
		this.tipoAnimalInteresado = tipoAnimalInteresado;
		this.animalesAdoptados = animalesAdoptados;
	}

	public boolean puedeAdoptar() {
		if (animalesAdoptados >= 2) {
			return false;
		}
		return true;

	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public EpreferenciaRecordatorio getPreferenciaRecordatorio() {
		return preferenciaRecordatorio;
	}

	public void setPreferenciaRecordatorio(EpreferenciaRecordatorio preferenciaRecordatorio) {
		this.preferenciaRecordatorio = preferenciaRecordatorio;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public boolean isOtrasMascotas() {
		return otrasMascotas;
	}

	public void setOtrasMascotas(boolean otrasMascotas) {
		this.otrasMascotas = otrasMascotas;
	}

	public String getMotivoAdopcion() {
		return motivoAdopcion;
	}

	public void setMotivoAdopcion(String motivoAdopcion) {
		this.motivoAdopcion = motivoAdopcion;
	}

	public String getTipoAnimalInteresado() {
		return tipoAnimalInteresado;
	}

	public void setTipoAnimalInteresado(String tipoAnimalInteresado) {
		this.tipoAnimalInteresado = tipoAnimalInteresado;
	}

	public int getAnimalesAdoptados() {
		return animalesAdoptados;
	}

	public void setAnimalesAdoptados(int animalesAdoptados) {
		this.animalesAdoptados = animalesAdoptados;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + " Apellido: " + apellido;
	}

}