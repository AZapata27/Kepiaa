package co.gov.banrep.kepiaa.menu.mapper;

import java.util.ArrayList;
import java.util.List;

import co.gov.banrep.kepiaa.menu.dto.AutoCompleteDTO;
import co.gov.banrep.kepiaa.menu.dto.MenuDTO;
import co.gov.banrep.kepiaa.menu.webservice.MenuElement;

public class MenuMapper {

	private MenuMapper(){}

	public static List<MenuDTO> menuElementToMenuDTO(MenuElement menu) {

		return getMenuChildren(menu.getMenu());
	}

	private static List<MenuDTO> getMenuChildren(List<MenuElement> menu) {
		
		List<MenuDTO> menuDTOs = null;
		MenuDTO menuDTO;
		if(menu != null && !menu.isEmpty()){
			menuDTOs = new ArrayList<>();
			for(MenuElement element : menu){
				menuDTO = new MenuDTO();
				menuDTO.setLabel(element.getTexto());
				menuDTO.setRouterLink(element.getLink());
				menuDTO.setItems(getMenuChildren(element.getMenu()));
				menuDTOs.add(menuDTO);
			}
		}

		return menuDTOs;
	}

	private static AutoCompleteDTO getAutoCompleteChildren(
			List<MenuElement> menu, 
			List<AutoCompleteDTO> autoCompleteDTOs,
			String indexName) {
		
		AutoCompleteDTO autoCompleteDTO = null;
		if(menu != null){
			
			for(MenuElement element : menu){
				
				autoCompleteDTO = getAutoCompleteChildren(
						element.getMenu(), 
						autoCompleteDTOs, 
						indexName.concat(" - ").concat(element.getTexto()));
						
				if(autoCompleteDTO == null){
					autoCompleteDTO = new AutoCompleteDTO();
				}
				if(element.getMenu().isEmpty()){
					autoCompleteDTO.setLabel(indexName.concat(" - ").concat(element.getTexto()));
					autoCompleteDTO.setRouterLink(element.getLink());
					autoCompleteDTOs.add(autoCompleteDTO);
				}
			}
		}
		return autoCompleteDTO;
	}

	public static List<AutoCompleteDTO> menuElementToAutoCompletDTO(MenuElement menu) {
		List<AutoCompleteDTO> autoCompleteDTOs = null;

		if(menu != null){
			autoCompleteDTOs = new ArrayList<>();
			for(MenuElement element : menu.getMenu()){
				getAutoCompleteChildren(element.getMenu(), autoCompleteDTOs, element.getTexto());
			}
		}

		return autoCompleteDTOs;
	}
}
