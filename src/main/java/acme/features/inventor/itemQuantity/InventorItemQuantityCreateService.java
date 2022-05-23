package acme.features.inventor.itemQuantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ItemQuantity;
import acme.entities.ItemType;
import acme.entities.Toolkit;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorItemQuantityCreateService implements AbstractCreateService<Inventor, ItemQuantity> {

	@Autowired
	InventorToolkitRepository repository;
	
	@Override
	public boolean authorise(final Request<ItemQuantity> request) {
		assert request != null;

		boolean checkPublished = true;
		int masterId;
		Toolkit toolkit;

		masterId = request.getModel().getInteger("masterId");
		toolkit = this.repository.findOneToolkitById(masterId);
		checkPublished = (toolkit != null && toolkit.isDraftMode()) && request.isPrincipal(toolkit.getInventor());
		
		return checkPublished;
	}

	@Override
	public void bind(final Request<ItemQuantity> request, final ItemQuantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		entity.setItem(this.repository.findItemById(Integer.valueOf(request.getModel().getAttribute("itemId").toString())));
		request.bind(entity, errors, "quantity", "itemId");
		
	}

	@Override
	public void unbind(final Request<ItemQuantity> request, final ItemQuantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final Toolkit t = this.repository.findOneToolkitById(Integer.valueOf(request.getModel().getAttribute("masterId").toString()));
		model.setAttribute("draftMode", t.isDraftMode());
		model.setAttribute("type",  request.getModel().getAttribute("type").toString());
		model.setAttribute("masterId", request.getModel().getAttribute("masterId"));
		model.setAttribute("tools", this.repository.findAllItemsByType(ItemType.TOOL));
		model.setAttribute("components", this.repository.findAllItemsByType(ItemType.COMPONENT));
		model.setAttribute("items", this.repository.findAllItems());
		request.unbind(entity, model, "quantity");
		
	}

	@Override
	public ItemQuantity instantiate(final Request<ItemQuantity> request) {
		assert request != null;
		
		final ItemQuantity iq = new ItemQuantity();
		final int toolkitId = request.getModel().getInteger("masterId");
		iq.setToolkit(this.repository.findOneToolkitById(toolkitId));
		iq.setQuantity(1);
		
		return iq;
	}

	@Override
	public void validate(final Request<ItemQuantity> request, final ItemQuantity entity, final Errors errors) {
		assert request != null;
		assert errors != null;
		assert entity != null;
		
		if(!errors.hasErrors("quantity")) {
			errors.state(request, entity.getQuantity() > 0, "quantity", "inventor.item-quantity.form.error.negative-number");
		}
					
		if(!errors.hasErrors("quantity")) {
			if(entity.getItem().getType().equals(ItemType.TOOL)) {
				errors.state(request, entity.getQuantity() == 1, "quantity", "inventor.item-quantity.form.error.incorrect-tool-quantity");
			}
		}	
		
	}

	@Override
	public void create(final Request<ItemQuantity> request, final ItemQuantity entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}

}
