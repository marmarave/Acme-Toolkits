package acme.features.inventor.chimpum;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.features.inventor.item.InventorItemShowMineService;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;
import acme.roles.Inventor;


@Controller
public class InventorChimpumController extends AbstractController<Inventor, Chimpum> {
	
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected InventorChimpumListMineService	listService;
		
		@Autowired
		protected InventorChimpumShowMineService	showService;
		
		@Autowired
		protected InventorChimpumCreateService	createService;
		
		// Constructors -----------------------------------------------------------


		@PostConstruct
		protected void initialise() {
			super.addCommand("list", this.listService);
			super.addCommand("show", this.showService);
			super.addCommand("create", this.createService);
		}

	}

