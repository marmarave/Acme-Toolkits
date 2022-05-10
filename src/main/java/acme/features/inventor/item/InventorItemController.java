
package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemListMineService	listMineService;

	@Autowired
	protected InventorItemShowMineService	showMineService;
	
	@Autowired
	protected InventorComponentUpdateService updateService;

	@Autowired
	protected InventorItemCreateService createService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list","list", this.listMineService);
		super.addCommand("show","show", this.showMineService);
		super.addCommand("create",this.createService);
		super.addCommand("update",this.updateService);
	}

}
