package modelo;

import java.util.*;

import estrategiaExportacion.IExportar;

/**
 * 
 */
public class FichaTecnica {
	
    private Animal animal;
    private ArrayList<TratamientoMedico> tratamiento;
    private ArrayList<Control> controles;

    public FichaTecnica(Animal animal) {
    	this.animal = animal;
    	this.tratamiento = new ArrayList();
    	this.controles = new ArrayList();
    }
    
    public void agregarTratamiento(TratamientoMedico tratamientoMedico) {
    	this.tratamiento.add(tratamientoMedico);
    }
    
    public void agregarControl(Control control) {
    	this.controles.add(control);
    }

	@Override
	public String toString() {
		return "FichaTecnica [animal=" + animal + "]";
	}

}