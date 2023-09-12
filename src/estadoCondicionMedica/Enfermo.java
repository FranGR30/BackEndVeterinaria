package estadoCondicionMedica;

import modelo.Animal;

public class Enfermo implements EstadoCondicionMedica {

    public void recuperar(Animal animal) {
        System.out.println("El animal se ha recuperado.");
        animal.cambiarEstado(new Saludable());
    }

    public void serAdoptado(Animal animal) {
        System.out.println("El animal no puede ser adoptado, debe estar saludable.");
    }
}