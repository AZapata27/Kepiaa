package co.gov.banrep.kepiaa.menu.service.impl;

import java.net.URL;

import co.gov.banrep.kepiaa.menu.service.ClientDemeMenu;
import co.gov.banrep.kepiaa.menu.webservice.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ClientDemeMenuImpl implements ClientDemeMenu {


	private AdministradorMenuWS getAdministradorMenuWS(String endpoint) throws NullPointerException{

		final String INSTANCIA_WS_S3 = "Se instancia el WS del S3 con el siguiente endPoint = ";

		log.info("Inicio - getAdministradorMenuWS()");

		AdministradorMenuWS administradorMenuWS = null;

		try{
			administradorMenuWS = new AdministradorMenuWSPortBindingQSService(new URL(endpoint))
					.getAdministradorMenuWSPortBindingQSPort();

			log.info(INSTANCIA_WS_S3 + endpoint);
		}catch(Exception e){
			log.warn(e.getMessage(), e);
		}

		final String END_POINT_DEFAULT = " endpoint valor por defecto http://osb-pruebas.banrep.gov.co:8011/ServiciosS3/DemeMenu?WSDL";
		try{

			if(administradorMenuWS == null){
				log.error("No se pudo intanciar el WS del S3 despues de los 3 intentos configurados");
				administradorMenuWS = new AdministradorMenuWSPortBindingQSService()
						.getAdministradorMenuWSPortBindingQSPort();
				log.info(INSTANCIA_WS_S3 + END_POINT_DEFAULT);
			}
			
		}catch(Exception e){
			log.warn(e.getMessage(), e);
		}

		if(administradorMenuWS == null){
			throw new NullPointerException("Problema instanciando el servicio de dememenu con los siguientes valores "
					+ "\n 1 - intento " + INSTANCIA_WS_S3 + endpoint
					+ "\n 2 - intento " + INSTANCIA_WS_S3 + END_POINT_DEFAULT);
		}

		return administradorMenuWS;
	}

	@Override
	public RespuestaConsultarMenuPerfil consultarMenuPerfil(String aplicacion, String usuario, String endpoint)
			throws NullPointerException, AdministradorMenuException_Exception {

		log.info("inicio de consumo del cliente");

		if(aplicacion == null)
			throw new NullPointerException("Nombre de la aplicación a la cual pertenece el usuario es obligatorio");
		if(usuario == null)
			throw new NullPointerException("Usuario de la aplicación es obligatorio");

		AdministradorMenuWS administradorMenuWS = getAdministradorMenuWS(endpoint);

		PeticionConsultarMenuPerfil peticionConsultarMenuPerfil = new PeticionConsultarMenuPerfil();
		MenuRequest menuRequest = new MenuRequest();
		menuRequest.setAplicacion(aplicacion);
		menuRequest.setUsuario(usuario);
		peticionConsultarMenuPerfil.setRequest(menuRequest);

		ConsultarMenuPerfil consultarMenuPerfil = new ConsultarMenuPerfil();
		consultarMenuPerfil.setData(peticionConsultarMenuPerfil);

		RespuestaConsultarMenuPerfil respuestaConsultarMenuPerfil = administradorMenuWS.consultarMenuPerfil(consultarMenuPerfil.getData());
		log.info("getMenu=" + respuestaConsultarMenuPerfil.getDescripcion());
		return respuestaConsultarMenuPerfil;
	}


}
