package es.mdef.dam.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.mdef.dam.DamApplication;
import es.mdef.dam.assemblers.RecursoAssembler;
import es.mdef.dam.assemblers.UsuarioAssembler;
import es.mdef.dam.entidades.Recurso;
import es.mdef.dam.entidades.UsuarioImpl;
import es.mdef.dam.models.RecursoModel;
import es.mdef.dam.models.UsuarioModel;
import es.mdef.dam.models.UsuarioPostModel;
import es.mdef.dam.repositorios.UsuarioRepositorio;
import jakarta.validation.Valid;
import es.mdef.dam.REST.RegisterNotFoundException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final UsuarioRepositorio repositorio;
	private final UsuarioAssembler assembler;
	private final Logger log;
	
	// RELACION 1:N con RECURSOS
	private final RecursoAssembler recursoAssembler;
	
	UsuarioController (UsuarioRepositorio repositorio,
					UsuarioAssembler assembler,
					RecursoAssembler recursoAssembler
			) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.recursoAssembler = recursoAssembler;
		log = DamApplication.log;
		
	}
	
	
	@GetMapping
	public CollectionModel<UsuarioModel> all() {
		return assembler.toCollection(repositorio.findAll());
	}
	
	@GetMapping("{id}")
	public UsuarioModel one(@PathVariable Long id) {
		UsuarioImpl usuario = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		log.info("Recuperado " + usuario);
		
		return assembler.toModel(usuario);
	}
	
	
	// recursos del usuario
	@GetMapping("{id}/recursos")
	public CollectionModel<RecursoModel> recursos(@PathVariable long id) {
		
		List<Recurso> recursos = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"))
				.getRecursos();
		
		return CollectionModel.of(
				recursos.stream().map(recurso -> recursoAssembler.toModel(recurso)).collect(Collectors.toList()),
				linkTo(methodOn(UsuarioController.class).one(id)).slash("recursos").withSelfRel()
				);
		
	}
	
	@PostMapping
	public UsuarioModel add(@Valid @RequestBody UsuarioPostModel model) {
		UsuarioImpl usuario = repositorio.save(assembler.toEntity(model));
		log.info("Añadido " + usuario);
		return assembler.toModel(usuario);
	}
	
	@PutMapping("{id}")
	public UsuarioModel edit(@PathVariable Long id,@Valid @RequestBody UsuarioModel model){
		UsuarioImpl usuario = repositorio.findById(id).map(usr -> {
			usr.setNombreUsuario(model.getNombreUsuario());
			usr.setRole(model.getRole());
			
			return repositorio.save(usr);
		})
		.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		log.info("Actualizado " + usuario);
		return assembler.toModel(usuario);
	}
	
	@PostMapping("{id}/contrasenia")
	public UsuarioModel edit(@Valid @PathVariable Long id, @RequestBody UsuarioPostModel model) {
		UsuarioImpl usuario = repositorio.findById(id).map(usr -> {
			usr.setContrasenia(model.getContrasenia());
			return repositorio.save(usr);
		})
		.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
		log.info("Actualizada contraseña de " + usuario);
		return assembler.toModel(usuario);	

	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrado usuario " + id);
		repositorio.deleteById(id);
	}
}






















