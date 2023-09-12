package modelo;

import estadoCondicionMedica.Enfermo;
import estadoCondicionMedica.EstadoCondicionMedica;
import testMain.Utilidades;

public abstract class Animal implements EstadoCondicionMedica{
	
	protected int idAnimal;
    protected String especie;
    protected EstadoCondicionMedica estado;
    protected double altura;
    protected double peso;
    protected double edadAproximada;
    protected FichaTecnica fichaTecnica;
    protected EtipoAnimal tipoAnimal;
    
    public Animal() {
    	this.idAnimal = Utilidades.contadorIdAnimal();
    	this.estado = new Enfermo();

    }

    public Animal(String especie, double altura, double peso, double edadAproximada) {
    	this.idAnimal = Utilidades.contadorIdAnimal();
        this.especie = especie;
        this.altura = altura;
        this.peso = peso;
        this.edadAproximada = edadAproximada;
        this.estado = new Enfermo();
    }

    public abstract boolean esAdoptable();

    public void recuperar(Animal animal){
    	this.estado.recuperar(this);
    }
    
    public void serAdoptado(Animal animal){}

    public String toString() {
        return  "idAnimal: "+idAnimal+ ", especie: "+ especie + " altura: " + altura + "cm, peso: " + peso + "kg, edad aproximada: " + edadAproximada + " anios " + "\n";
    }

    public String getEspecie() {
        return especie;
    }

    public EstadoCondicionMedica getEstado() {
        return estado;
    }

    public void cambiarEstado(EstadoCondicionMedica estado) {
        this.estado = estado;
    }

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getEdadAproximada() {
		return edadAproximada;
	}

	public void setEdadAproximada(double edadAproximada) {
		this.edadAproximada = edadAproximada;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public void setFichaTecnica(FichaTecnica fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}

	public FichaTecnica getFichaTecnica() {
		return fichaTecnica;
	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	
}