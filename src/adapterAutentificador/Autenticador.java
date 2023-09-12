package adapterAutentificador;

import java.util.*;

import controllers.UsuarioController;
import modelo.EtipoUsuario;
import modelo.Refugio;
import modelo.Usuario;
import testMain.Utilidades;

public class Autenticador implements IAdapterAutenticador {

    public Autenticador() {
	}

	public void autenticar(String usuario, String password, EtipoUsuario tipoUsuario) {

		boolean iniciadoAux = false;
		int contadorAux = 0;
		System.out.println("Iniciando sesion...");
		Utilidades.esperar(1);

		for (Usuario u : UsuarioController.usuarios) {
			contadorAux++;

			if (iniciadoAux == false) {

				if (u.isAutenticado() == false) {
					if (u.getNombreUsuario() == usuario && u.getPassword() == password) {
						if (u.isAutenticado() == false) {
							System.out.println("El usuario: " + usuario + " (" + tipoUsuario + ")"
									+ " ha iniciado sesion correctamente.");
							System.out.println();
							u.setAutenticado(true);
							UsuarioController.userConectado = u;
							iniciadoAux = true;
						}

						else if (u.isAutenticado() == true) {
							System.out.println("El usuario ya esta conectado.");
						}
					}

					else if (UsuarioController.usuarios.size() == contadorAux && u.isAutenticado() == false) {
						System.out.println("El usuario o la contrasenia es incorrecta.");
					}
				}

				else if (u.isAutenticado() == true) {
					System.out.println("No es posible iniciar sesion, ya hay una sesion activa.");
					System.out.println();
					iniciadoAux = true;
				}
			}
		}
	}
}
