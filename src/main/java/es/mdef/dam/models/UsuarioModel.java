package es.mdef.dam.models;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.dam.support.Usuario.Role;

@Relation(itemRelation="usuarioImpl")
public class UsuarioModel extends RepresentationModel<UsuarioModel>{

	private String nombreUsuario;
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
	
	

	
	
}
