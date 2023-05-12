package es.mdef.dam.models;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.dam.entidades.Recurso.Resolucion;
import es.mdef.dam.entidades.Recurso.TipoRecursos;

@Relation(itemRelation="recurso")
public class RecursoModel extends RepresentationModel<RecursoModel>{

	private String fichero;
	private int tamano;
	private int duracion;
	private Resolucion resolucion;
	private TipoRecursos tipo;
	
	
	public String getFichero() {
		return fichero;
	}
	public void setFichero(String fichero) {
		this.fichero = fichero;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public Resolucion getResolucion() {
		return resolucion;
	}
	public void setResolucion(Resolucion resolucion) {
		this.resolucion = resolucion;
	}
	public TipoRecursos getTipo() {
		return tipo;
	}
	public void setTipo(TipoRecursos tipo) {
		this.tipo = tipo;
	}
	
	
}
