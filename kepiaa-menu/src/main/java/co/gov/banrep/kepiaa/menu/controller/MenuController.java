package co.gov.banrep.kepiaa.menu.controller;

import co.gov.banrep.kepiaa.menu.dto.AutoCompleteDTO;
import co.gov.banrep.kepiaa.menu.dto.MenuDTO;
import co.gov.banrep.kepiaa.menu.webservice.AdministradorMenuException_Exception;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import co.gov.banrep.kepiaa.menu.service.MenuService;

import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {


	private final MenuService menuService;

	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MenuDTO> getMenu() throws MalformedURLException, AdministradorMenuException_Exception {

		return menuService.getMenu();
	}
	
	@GetMapping(value="/busqueda-autocompletada", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AutoCompleteDTO> getListAutoComplete() throws MalformedURLException, AdministradorMenuException_Exception {

		return menuService.getListAutoComplete();
	}

	
}
