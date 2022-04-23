
package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ItemQuantity;
import acme.entities.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowMineService implements AbstractShowService<Inventor, Toolkit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolkitRepository repository;

	// AbstractShowService<Inventor, Toolkit> interface ---------------------------


	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;

		final boolean result;
		int id;
		int inventorId;
		Toolkit toolkit;
		Principal principal;
		Collection<Toolkit> ownedToolkits;

		id = request.getModel().getInteger("id");
		toolkit = this.repository.findOneToolkitById(id);
		principal = request.getPrincipal();
		inventorId=principal.getActiveRoleId();
		ownedToolkits = this.repository.findManyToolkitsByInventorId(inventorId);
		result = ownedToolkits.contains(toolkit);
		return result;
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);
		final Money totalPrice = this.calculateTotalPrice(result);
		result.setTotalPrice(totalPrice);
		this.repository.save(result);

		return result;
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "totalPrice", "moreInfo");
	}
	
	private Money calculateTotalPrice(final Toolkit t) {
		final Money money = new Money();
		money.setCurrency("EUR"); //Default Currency
		Double sum=0.;
		final Collection<ItemQuantity> quantities = this.repository.findItemQuantitiesOfToolkit(t.getId());
		for(final ItemQuantity quantity: quantities) {
			sum+=quantity.getItem().getRetailPrice().getAmount()*quantity.getQuantity();
		}
		money.setAmount(sum);
		return money;
	}
}
