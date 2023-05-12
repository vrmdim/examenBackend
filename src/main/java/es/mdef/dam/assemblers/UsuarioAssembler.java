package es.mdef.dam.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.dam.controllers.UsuarioController;
import es.mdef.dam.entidades.UsuarioImpl;
import es.mdef.dam.models.UsuarioModel;
import es.mdef.dam.models.UsuarioPostModel;

@Component
public class UsuarioAssembler implements RepresentationModelAssembler<UsuarioImpl, UsuarioModel>{

	@Override
	public UsuarioModel toModel(UsuarioImpl entity) {
		UsuarioModel model = new UsuarioModel();	
		model.setNombreUsuario(entity.getNombreUsuario());
		model.setRole(entity.getRole());
		
		model.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel(),
				// Link de recursos RELACION 1:N
				linkTo(methodOn(UsuarioController.class).recursos(entity.getId())).withRel("recursos")
				);
		return model;
	}
	
	
	public UsuarioImpl toEntity(UsuarioModel model) {
		UsuarioImpl usuario = new UsuarioImpl();
		
		usuario.setNombreUsuario(model.getNombreUsuario());
		usuario.setRole(model.getRole());
		
		return usuario;
		
	}
	
	// SOBRECARGA usuarioPostAssembler
	public UsuarioImpl toEntity(UsuarioPostModel model) {
		UsuarioImpl usuario = new UsuarioImpl();
		
		usuario.setNombreUsuario(model.getNombreUsuario());
		usuario.setContrasenia(model.getContrasenia());
		usuario.setRole(model.getRole());
		
		return usuario;
		
	}
	
	public CollectionModel<UsuarioModel> toCollection(List<UsuarioImpl> lista) {
		CollectionModel<UsuarioModel> collection = CollectionModel.of(
				lista.stream().map(this::toModel).collect(Collectors.toList())
				);
		collection.add(
				linkTo(methodOn(UsuarioController.class).all()).withRel("usuarios")
				);
		return collection;
	}


}
