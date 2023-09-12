package estrategiaExportacion;

import java.util.*;

import modelo.FichaTecnica;

/**
 * 
 */
public class AdapterPDF implements AdapterExportarPDF {

    public AdapterPDF() {
    	super();
    }

    public void exportarPDF(FichaTecnica fichaTecnica) {
    	System.out.println("Exportando pdf de la ficha tecnica, con los datos: "+fichaTecnica.toString());
    }


}