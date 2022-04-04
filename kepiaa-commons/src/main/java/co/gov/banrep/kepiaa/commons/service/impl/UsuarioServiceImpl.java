package co.gov.banrep.kepiaa.commons.service.impl;

import javax.servlet.http.HttpSession;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import co.gov.banrep.kepiaa.commons.service.UsuarioService;

@Service
@Log4j2
public class UsuarioServiceImpl implements UsuarioService {

	@Value("${usuario.local}")
	private String usuarioLocal;

	@Value("${spring.profiles.active}")
	private String profile;

	private final ObjectFactory<HttpSession> sessionObjectFactory;

	public UsuarioServiceImpl(ObjectFactory<HttpSession> sessionObjectFactory) {
		this.sessionObjectFactory = sessionObjectFactory;
	}

	@Override
	public String getUsuarioActivoEnSesion() throws NullPointerException{

		String codigoUsuario;

		HttpSession httpSession = sessionObjectFactory.getObject();

		if(profile.equals("local")) {
			codigoUsuario = usuarioLocal;
			log.info("se extrajo el usuario del properties =" + codigoUsuario);
		}else {

			codigoUsuario = (String) httpSession.getAttribute("__USUARIO_SESION_S3__");

			log.info("__USUARIO_SESION_S3__" + "=" + codigoUsuario);
		}
	
		return codigoUsuario;
	}

}