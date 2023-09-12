package estadoCondicionMedica;

import modelo.Animal;

public class Saludable implements EstadoCondicionMedica {

    public void recuperar(Animal animal) {
        System.out.println("El animal esta sano.");
        }

    public void serAdoptado(Animal animal) {
        if(animal.esAdoptable()) {
            animal.cambiarEstado(new Adoptado());
        }
        else{
            System.out.println("El animal no puede ser adoptado, es un animal salvaje.");
        }
    }
}