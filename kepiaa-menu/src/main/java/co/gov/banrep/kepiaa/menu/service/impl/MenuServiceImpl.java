package co.gov.banrep.kepiaa.menu.service.impl;

import java.util.ArrayList;
import java.util.List;

import co.gov.banrep.kepiaa.commons.enums.ProfileEnum;
import co.gov.banrep.kepiaa.menu.dto.AutoCompleteDTO;
import co.gov.banrep.kepiaa.menu.dto.MenuDTO;
import co.gov.banrep.kepiaa.menu.service.ClientDemeMenu;
import co.gov.banrep.kepiaa.menu.webservice.AdministradorMenuException_Exception;
import co.gov.banrep.kepiaa.menu.webservice.RespuestaConsultarMenuPerfil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.gov.banrep.kepiaa.menu.mapper.MenuMapper;
import co.gov.banrep.kepiaa.menu.service.MenuService;
import co.gov.banrep.kepiaa.commons.service.UsuarioService;

@Service
public class MenuServiceImpl implements MenuService {

	@Value("${nombre.s3.app}")
	private String aplicacion;

	@Value("${dememenu.endpoint}")
	private String demeMenuEndpoint;

	@Value("${spring.profiles.active}")
	private String profile;

	private final UsuarioService usuarioService;
	private final ClientDemeMenu clientDemeMenu;

	public MenuServiceImpl(UsuarioService usuarioService, ClientDemeMenu clientDemeMenu) {
		this.usuarioService = usuarioService;
		this.clientDemeMenu = clientDemeMenu;
	}


	public List<MenuDTO> getMenu() throws AdministradorMenuException_Exception {


		if(ProfileEnum.LOCAL.equals(profile)){
			return getMockMenuLocal();
		}

		String usuario = usuarioService.getUsuarioActivoEnSesion();

		RespuestaConsultarMenuPerfil response = clientDemeMenu.consultarMenuPerfil(aplicacion, usuario, demeMenuEndpoint);

		return MenuMapper.menuElementToMenuDTO(response.getMenu());
	}




	public List<AutoCompleteDTO> getListAutoComplete() throws AdministradorMenuException_Exception {

		String usuario = usuarioService.getUsuarioActivoEnSesion();

		RespuestaConsultarMenuPerfil  response = clientDemeMenu.consultarMenuPerfil(aplicacion, usuario, demeMenuEndpoint);

		return  MenuMapper.menuElementToAutoCompletDTO(response.getMenu());

	}





	private List<MenuDTO> getMockMenuLocal(){

		List<MenuDTO> menuDTOList = new ArrayList<>();

		MenuDTO menu1 = construirMenu("Inicio","/kepiaa-frontend/index.html",null);
		menuDTOList.add(menu1);

		List<MenuDTO> menuDTOSListprocesos = new ArrayList<>();
		MenuDTO menuProcesos1 = construirMenu("Ejecución Procesos","/kepiaa-frontend/index.html#/kepiaa-frontend/ejecucion-procesos",null);
		MenuDTO menuProcesos2 = construirMenu("Resultado Procesos","/kepiaa-frontend/index.html#/kepiaa-frontend/resultados-procesos",null);
		menuDTOSListprocesos.add(menuProcesos1);
		menuDTOSListprocesos.add(menuProcesos2);

		MenuDTO menuProcesos = construirMenu("Procesos",null,menuDTOSListprocesos);

		menuDTOList.add(menuProcesos);



		return menuDTOList;
	}

	private MenuDTO construirMenu(String label,String link,List<MenuDTO> menuDTOList){

		MenuDTO menuDTO= new MenuDTO();
		menuDTO.setLabel(label);
		menuDTO.setRouterLink(link);
		menuDTO.setItems(menuDTOList);

		return menuDTO;
	}
	

}