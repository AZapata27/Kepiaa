package co.gov.banrep.kepiaa.menu.dto;

import java.util.List;

public class MenuDTO {
	
	private String label;
	private String routerLink;
	
	private List<MenuDTO> items;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getRouterLink() {
		return routerLink;
	}
	public void setRouterLink(String link) {
		this.routerLink = link;
	}
	public List<MenuDTO> getItems() {
		return items;
	}
	public void setItems(List<MenuDTO> children) {
		this.items = children;
	}
}
