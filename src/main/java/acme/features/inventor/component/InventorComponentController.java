package acme.features.inventor.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorComponentController extends AbstractController<Inventor, Item> {
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorComponentShowService		showService;

	@Autowired
	protected InventorComponentListMineService	listAllService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-components", "list", this.listAllService);
		super.addCommand("show", this.showService);
	}
}
