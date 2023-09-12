package modelo;

import java.util.*;

public class Adopcion {
	
    private Cliente cliente;
    private Animal animal;

    public Adopcion(Cliente cliente, Animal animal) {
    	this.cliente = cliente;
    	this.animal = animal;
    }
    
    public Adopcion nuevaAdopcion() {
		return null;
    	
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
    

}