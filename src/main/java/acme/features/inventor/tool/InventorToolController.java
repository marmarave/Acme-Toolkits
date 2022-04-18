
package acme.features.inventor.tool;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorToolController extends AbstractController<Inventor, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolListMineService	listMineService;

	@Autowired
	protected InventorToolShowMineService	showMineService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-tool","list", this.listMineService);
		super.addCommand("show","show", this.showMineService);
	}

}
