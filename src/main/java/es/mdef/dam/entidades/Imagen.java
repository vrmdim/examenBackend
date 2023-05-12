package es.mdef.dam.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("imagen")
public class Imagen extends Recurso{
	

	
	private Resolucion resolucion;

	public Resolucion getResolucion() {
		return resolucion;
	}

	public void setResolucion(Resolucion resolucion) {
		this.resolucion = resolucion;
	}
	
	

}
