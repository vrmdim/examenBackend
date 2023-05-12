package es.mdef.dam.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("video")
public class Video extends Recurso{

	private Resolucion resolucion;
	private int duracion;
	
	public Resolucion getResolucion() {
		return resolucion;
	}
	public void setResolucion(Resolucion resolucion) {
		this.resolucion = resolucion;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
	
}
