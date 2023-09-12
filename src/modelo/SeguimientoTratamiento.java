package modelo;

import java.time.LocalDateTime;
import java.util.*;

public class SeguimientoTratamiento {

    private LocalDateTime fecha;
    private TratamientoMedico tratamiento;
    private Veterinario veterinario;
    private String comentario;

    public SeguimientoTratamiento() {
    	this.fecha = LocalDateTime.now();
    }

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public TratamientoMedico getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(TratamientoMedico tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
    
}