package acme.features.inventor.itemQuantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.ItemQuantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorItemQuantityShowService implements AbstractShowService<Inventor,ItemQuantity>{

	@Autowired
	InventorItemQuantityRepository repository;
	
	
	@Override
	public boolean authorise(final Request<ItemQuantity> request) {
		assert request != null;
		boolean result;
		int id;
		Item item;

		id = request.getModel().getInteger("id");
		item = this.repository.findOneItemById(id);
		result = item.isPublished();

		return true;
	}

	@Override
	public ItemQuantity findOne(final Request<ItemQuantity> request) {
		assert request != null;

		ItemQuantity result;
		int masterId;

		masterId = request.getModel().getInteger("masterId");
		result = this.repository.findItemQuantityById(masterId);

		return result;
	}

	@Override
	public void unbind(final Request<ItemQuantity> request, final ItemQuantity entity, final Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 

		request.unbind(entity, model,"quantity", "item.name", "item.type","item.code","item.description", "item.technology", "item.retailPrice"); 
		
	}

}
