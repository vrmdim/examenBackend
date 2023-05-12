package es.mdef.dam.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.mdef.dam.entidades.UsuarioImpl;

public interface UsuarioRepositorio extends JpaRepository<UsuarioImpl, Long>{

	List<UsuarioImpl> findUsuarioImplByNombreUsuario(String nombreUsuario);
}
