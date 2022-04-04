package co.gov.banrep.kepiaa.commons.service;

public interface UsuarioService {

	/**
	 * Metodo que extrae el usuario activo de la sesion
	 * @return String Usuario activo
	 * @throws NullPointerException excepción arrojada cuando no se localiza el usuario activo
	 */
	String getUsuarioActivoEnSesion() throws NullPointerException;

}
