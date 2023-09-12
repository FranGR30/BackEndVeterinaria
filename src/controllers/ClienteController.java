package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Adopcion;
import modelo.Cliente;

public class ClienteController {
	
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public void crearCliente(String nombre, String apellido, String estadoCivil, String email, String telefono, String ocupacion, boolean otrasMascotas, String motivoAdopcion,
	    	String tipoAnimalInteresado, int animalesAdoptados) {
		Cliente cliente = new Cliente(nombre,apellido,estadoCivil,email,telefono,ocupacion,otrasMascotas,motivoAdopcion,tipoAnimalInteresado,animalesAdoptados);
		clientes.add(cliente);
	}

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
}
