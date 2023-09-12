package modelo;

import java.util.*;
import adapterAutentificador.IAdapterAutenticador;

public abstract class Usuario implements IAdapterAutenticador {
	protected String nombre;
	protected String apellido;
	protected String nombreUsuario;
	protected String password;
	protected IAdapterAutenticador adapter;
	protected EtipoUsuario tipoUsuario;
	protected boolean isAutenticado = false;

	public Usuario(String nombre, String apellido, String nombreUsuario, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	public void autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {
		this.adapter.autenticar(usuario, password, tipoUsuario);
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EtipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(EtipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public void setAdapter(IAdapterAutenticador adapter) {
		this.adapter = adapter;
	}

	public boolean isAutenticado() {
		return isAutenticado;
	}

	public void setAutenticado(boolean isAutenticado) {
		this.isAutenticado = isAutenticado;
	}

	public void cerrarSesion() {
		this.isAutenticado = false;
	}

}