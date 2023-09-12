package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import estadoCondicionMedica.Enfermo;
import estadoCondicionMedica.EstadoCondicionMedica;
import modelo.Animal;
import modelo.AnimalDomestico;
import modelo.AnimalSalvaje;
import modelo.EtipoAnimal;
import modelo.FichaTecnica;
import modelo.Refugio;

public class AnimalController {
	public static ArrayList<Animal> animales = new ArrayList<Animal>();

	public void listarAnimales() {
		for (Animal animal : animales) {
			System.out.println(animal);
		}
	}

	public Animal buscarAnimal(int idAnimal) {
		for (Animal animal : animales) {
			if (animal.getIdAnimal() == idAnimal) {
				return animal;
			}
		}
		return null;
	}

	public ArrayList<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(Animal animal) {
		this.animales.add(animal);
	}

	public void registrarAnimal(String especie, double altura, double peso, double edadAproximada,
			EtipoAnimal tipoAnimal) {
		if (tipoAnimal.equals(EtipoAnimal.DOMESTICO)) {
			Animal nuevoAnimal = new AnimalDomestico(especie, altura, peso, edadAproximada);
			agregarAnimal(nuevoAnimal);
		} else {
			Animal nuevoAnimal = new AnimalSalvaje(especie, altura, peso, edadAproximada);
			agregarAnimal(nuevoAnimal);
		}
	}

	private void agregarAnimal(Animal nuevoAnimal) {
		FichaTecnica fichaTecnicaNuevoAnimal = new FichaTecnica(nuevoAnimal);
		nuevoAnimal.setFichaTecnica(fichaTecnicaNuevoAnimal);
		this.animales.add(nuevoAnimal);
	}
	public void cambiarEstadoAnimal(Animal animal, EstadoCondicionMedica estado) {
		animal.cambiarEstado(estado);
	}
	public void recuperar(Animal animal) {
		animal.recuperar(animal);
	}
}
