
package acme.features.inventor.patronage;

import javax.annotation.PostConstruct;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import acme.entities.PatronageReport;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorPatronageReportController extends AbstractController<Inventor, PatronageReport> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPatronageReportListMineService	patronageReportListMineService;

	@Autowired
	protected InventorPatronageReportShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list", "list", this.patronageReportListMineService);
		super.addCommand("show", this.showService);
	}

}
