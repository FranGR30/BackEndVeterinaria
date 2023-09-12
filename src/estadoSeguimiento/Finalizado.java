package estadoSeguimiento;

import java.time.LocalDateTime;
import java.util.*;

import modelo.Seguimiento;

public class Finalizado implements EstadoSeguimiento {

    public Finalizado() {
    }


    public void realizarSeguimiento(Seguimiento segumiento, LocalDateTime fechaVisita, int preferenciaDias) {
    	System.out.println("El seguimiento se encuentra finalizado");
    }

}