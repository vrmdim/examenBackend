package es.mdef.dam.REST;

public class RegisterNotFoundAdvice extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RegisterNotFoundAdvice(Long id, String tipo) {
		super("No se ha encontrado el " + tipo + " " + id);
	}
}
