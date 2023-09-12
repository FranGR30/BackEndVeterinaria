package estrategiaExportacion;

import java.util.*;

import modelo.FichaTecnica;

/**
 * 
 */
public class ExportarPDF implements IExportar{

	private AdapterExportarPDF adapter;
	
    public ExportarPDF(AdapterExportarPDF adapter) {
    	super();
    	this.adapter = adapter;
    }



    public void exportar(FichaTecnica fichaTecnica) {
    	this.adapter.exportarPDF(fichaTecnica);
    }

}