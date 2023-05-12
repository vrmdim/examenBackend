package es.mdef.dam.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import es.mdef.dam.entidades.Recurso;

public interface RecursoRepositorio  extends JpaRepository<Recurso, Long>{
	
	List<Recurso> findRecursoByFichero(String fichero);
}
