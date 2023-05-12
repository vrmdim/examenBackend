package es.mdef.dam.models;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.dam.support.Usuario.Role;

@Relation(itemRelation="usuarioImpl")
public class UsuarioPostModel extends RepresentationModel<UsuarioPostModel>{

	private String nombreUsuario;
	private String contrasenia;
	private Role role;
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	

	
	
}
