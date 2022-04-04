package co.gov.banrep.kepiaa.menu.service;

import co.gov.banrep.kepiaa.menu.dto.AutoCompleteDTO;
import co.gov.banrep.kepiaa.menu.dto.MenuDTO;
import co.gov.banrep.kepiaa.menu.webservice.AdministradorMenuException_Exception;

import java.net.MalformedURLException;
import java.util.List;

public interface MenuService {

	List<MenuDTO> getMenu() throws MalformedURLException, AdministradorMenuException_Exception;

	List<AutoCompleteDTO> getListAutoComplete() throws MalformedURLException, AdministradorMenuException_Exception;
	
}
