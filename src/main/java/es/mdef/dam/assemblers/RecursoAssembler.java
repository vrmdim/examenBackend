package es.mdef.dam.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.dam.controllers.RecursoController;
import es.mdef.dam.controllers.UsuarioController;
import es.mdef.dam.entidades.Recurso;
import es.mdef.dam.models.RecursoModel;

@Component
public class RecursoAssembler implements RepresentationModelAssembler<Recurso, RecursoModel>{

	@Override
	public RecursoModel toModel(Recurso entity) {
		RecursoModel model = new RecursoModel();
		model.setFichero(entity.getFichero());
		model.setTamano(entity.getTamano());
		model.setDuracion(entity.getDuracion());
		model.setResolucion(entity.getResolucion());
		model.setTipo(entity.getTipo());
		model.setUsuario(entity.getUsuario());
		
		
		model.add(
				linkTo(methodOn(RecursoController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withRel("usuario")
				);
		return model;
	}
	
	public Recurso toEntity(RecursoModel model) {
		Recurso recurso = new Recurso();
		
		recurso.setFichero(model.getFichero());
		recurso.setTamano(model.getTamano());
		recurso.setDuracion(model.getDuracion());
		recurso.setResolucion(model.getResolucion());
		recurso.setTipo(model.getTipo());
		recurso.setUsuario(model.getUsuario());

		
		return recurso;
		
	}
	
	public CollectionModel<RecursoModel> toCollection(List<Recurso> lista) {
		CollectionModel<RecursoModel> collection = CollectionModel.of(
				lista.stream().map(this::toModel).collect(Collectors.toList())
				);
		collection.add(
				linkTo(methodOn(RecursoController.class).all()).withRel("recursos")
				);
		return collection;
	}

}
