package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.ItemType;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorItemCreateService implements AbstractCreateService<Inventor,Item> {
	
	@Autowired
	protected InventorItemRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		request.getModel();
		return true;
	}
	
	@Override
	public Item instantiate(final Request<Item> request) {
		assert request != null;
		Item item;
		Inventor inventor;
		inventor = this.repository.findInventorById(request.getPrincipal().getActiveRoleId());
		item = new Item();
		item.setInventor(inventor);
		return item;
	}
	
	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		ItemType type;
		type = ItemType.COMPONENT;
		entity.setType(type);
		request.bind(entity, errors, "name", "type", "code","technology","description","retailPrice","moreInfo","published");
		
	}
	
	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}
	
	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "type", "code","technology","description","retailPrice","moreInfo","published");
		model.setAttribute("readonly", false);
	}
	
	@Override
	public void create(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}
}
