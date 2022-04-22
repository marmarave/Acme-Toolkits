package acme.features.authenticated.systemConfiguration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.SystemConfiguration;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Authenticated;

public class AuthenticatedSystemConfigurationController extends AbstractController<Authenticated,SystemConfiguration>{

	/*@Autowired
	protected AdministratorSystemConfigurationListService	listService; */

	@Autowired
	protected AuthenticatedSystemConfigurationShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		//super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
	}

}
