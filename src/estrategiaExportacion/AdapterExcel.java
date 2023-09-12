package estrategiaExportacion;

import java.util.*;

import modelo.FichaTecnica;

public class AdapterExcel implements AdapterExportarExcel {

    public AdapterExcel() {
    	super();
    }

    public void exportarExcel(FichaTecnica fichaTecnica) {
    	System.out.println("Exportando excel de la ficha tecnica, con los datos: "+fichaTecnica.toString());
    }

}