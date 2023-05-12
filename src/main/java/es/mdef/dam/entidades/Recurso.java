package es.mdef.dam.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="RECURSOS")
public class Recurso {
	
	public static enum Resolucion {
		CuatroK,
		DosK,
		UnK,
		HD,
		SD
	}
	
	public static enum TipoRecursos {
		audio,
		imagen,
		video
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@NotBlank(message="El nombre del fichero no puede estar vacio")
	private String fichero;
	private int tamano;
	private Resolucion resolucion;
	private int duracion;
	private TipoRecursos tipo;
	
	// RELACION MANY TO ONE CON USUARIO
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarioId", nullable = false)
	private UsuarioImpl usuario;
	
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
	public TipoRecursos getTipo() {
		return tipo;
	}
	public void setTipo(TipoRecursos tipo) {
		this.tipo = tipo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UsuarioImpl getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioImpl usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
