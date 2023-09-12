package modelo;

import java.util.*;

/**
 * 
 */
public class EncuestaVisitador {

    private ERespuestaEncuesta estadoGeneralAnimal;
    private ERespuestaEncuesta limpiezaLugar;
    private ERespuestaEncuesta ambiente;
    
    public EncuestaVisitador() {
    }
    
	public EncuestaVisitador(ERespuestaEncuesta estadoGeneralAnimal, ERespuestaEncuesta limpiezaLugar,
			ERespuestaEncuesta ambiente) {
		this.estadoGeneralAnimal = estadoGeneralAnimal;
		this.limpiezaLugar = limpiezaLugar;
		this.ambiente = ambiente;
	}



	public ERespuestaEncuesta getEstadoGeneralAnimal() {
		return estadoGeneralAnimal;
	}
	public void setEstadoGeneralAnimal(ERespuestaEncuesta estadoGeneralAnimal) {
		this.estadoGeneralAnimal = estadoGeneralAnimal;
	}
	public ERespuestaEncuesta getLimpiezaLugar() {
		return limpiezaLugar;
	}
	public void setLimpiezaLugar(ERespuestaEncuesta limpiezaLugar) {
		this.limpiezaLugar = limpiezaLugar;
	}
	public ERespuestaEncuesta getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(ERespuestaEncuesta ambiente) {
		this.ambiente = ambiente;
	}
    
}