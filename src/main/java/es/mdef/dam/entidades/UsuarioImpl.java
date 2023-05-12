package es.mdef.dam.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="USUARIOS")
public class UsuarioImpl extends es.mdef.dam.support.Usuario{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	// Me traigo nombreUsuario y contraseña para aplicarles validación
	@NotBlank(message="El nombre de usuario no puede estar vacio")
	private String nombreUsuario;
	@NotBlank(message="La contraseña no puede estar vacia")
	private String contrasenia;
	
	// Relacion OneToMany Usuario-Recursos
	@OneToMany(mappedBy = "usuarioImpl")
	private List<Recurso> recursos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	
	

}
