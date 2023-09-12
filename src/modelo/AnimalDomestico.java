package modelo;

import java.util.*;

import estadoCondicionMedica.Saludable;

public class AnimalDomestico extends Animal {

	public AnimalDomestico() {
		super();
	}
    
    public AnimalDomestico(String especie, double altura, double peso, double edadAproximada) {
        super(especie, altura, peso, edadAproximada);
        this.tipoAnimal = EtipoAnimal.DOMESTICO;
    }
    
    public boolean esAdoptable() {
    	if(this.estado.getClass().equals(Saludable.class)) {
    		return true;
    	}
        return false;
    }

    public void recuperar(Animal animal) {
        this.estado.recuperar(this);
    }

    public void serAdoptado(Animal animal) {
        this.estado.serAdoptado(this);
    }
}