package estadoSeguimiento;

import java.time.LocalDateTime;
import java.util.*;

import modelo.Seguimiento;

public interface EstadoSeguimiento {

    public void realizarSeguimiento(Seguimiento segumiento, LocalDateTime fechaVisita, int preferenciaDias);


}