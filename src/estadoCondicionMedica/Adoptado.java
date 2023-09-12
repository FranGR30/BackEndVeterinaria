package estadoCondicionMedica;

import modelo.Animal;

public class Adoptado implements EstadoCondicionMedica {

    public void recuperar(Animal animal) {
        System.out.println("El animal no se puede recuperar porque ya ha sido adoptado.");
    }

    public void serAdoptado(Animal animal) {
        System.out.println("El animal ya ha sido adoptado.");
    }
}