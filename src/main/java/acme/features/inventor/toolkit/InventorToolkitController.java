package acme.features.inventor.toolkit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Toolkit;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorToolkitController  extends AbstractController<Inventor, Toolkit>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorToolkitListMineService	listMineService;

	@Autowired
	protected InventorToolkitShowMineService	showMineService;
	
	// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list", this.listMineService);
			super.addCommand("show", this.showMineService);
		}
	
}
