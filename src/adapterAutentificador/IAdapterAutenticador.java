package adapterAutentificador;

import java.util.*;
import modelo.EtipoUsuario;

public interface IAdapterAutenticador {

    public void autenticar(String usuario, String password, EtipoUsuario tipoUsuario);

}