package controllers;

import java.util.ArrayList;

import modelo.Usuario;

public class UsuarioController {
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public static Usuario userConectado;

	public Usuario getUserConectado() {
		return userConectado;
	}

	public void setUserConectado(Usuario userConectado) {
		this.userConectado = userConectado;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void autenticar(Usuario usuario) {
		usuario.autenticar(usuario.getNombreUsuario(), usuario.getPassword(), usuario.getTipoUsuario());
	}
	
	public void cerrarSesion(Usuario usuario) {
		usuario.cerrarSesion();
	}
}
