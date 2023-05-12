package es.mdef.dam.REST;

public class RegisterNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RegisterNotFoundException(Long id, String tipo) {
		super("No se ha encontrado el " + tipo + " " + id);
	}
}
