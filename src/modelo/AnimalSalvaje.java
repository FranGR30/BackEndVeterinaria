package modelo;

public class AnimalSalvaje extends Animal {
	
	public AnimalSalvaje() {
		super();
	}
    public AnimalSalvaje(String especie, double altura, double peso, double edadAproximada) {
        super(especie, altura, peso, edadAproximada);
        this.tipoAnimal = EtipoAnimal.SALVAJE;
    }

    public boolean esAdoptable() {
        return false;
    }

    public void recuperar(Animal animal) {
        this.estado.recuperar(this);
    }

    public void serAdoptado(Animal animal) {
        this.estado.serAdoptado(this);
    }
}