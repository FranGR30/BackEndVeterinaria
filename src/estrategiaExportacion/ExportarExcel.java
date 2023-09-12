package estrategiaExportacion;

import java.util.*;

import modelo.FichaTecnica;

/**
 * 
 */
public class ExportarExcel implements IExportar {
	private AdapterExportarExcel adapter;
	
    public ExportarExcel(AdapterExportarExcel adapter) {
    	super();
    	this.adapter = adapter;
    }

    public void exportar(FichaTecnica fichaTecnica) {
    	this.adapter.exportarExcel(fichaTecnica);

    }

}