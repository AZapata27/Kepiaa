package co.gov.banrep.kepiaa.menu.service;

import co.gov.banrep.kepiaa.menu.webservice.AdministradorMenuException_Exception;
import co.gov.banrep.kepiaa.menu.webservice.RespuestaConsultarMenuPerfil;

public interface ClientDemeMenu {

    RespuestaConsultarMenuPerfil consultarMenuPerfil(String aplicacion, String usuario, String endpoint)
            throws NullPointerException, AdministradorMenuException_Exception;
}
