package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitCreateService implements AbstractCreateService<Inventor, Toolkit>{
	
	@Autowired
	InventorToolkitRepository repository;
	
/*	@Autowired
	ItemQ
*/
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		request.getModel();
		return true;
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "code", "title", "description", "assemblyNotes", "moreInfo", "totalPrice"); //No he incluido draftMode
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "title","description", "assemblyNotes", "moreInfo", "totalPrice");
		model.setAttribute("readonly", false);
	}

	@Override
	public Toolkit instantiate(final Request<Toolkit> request) {
		
		assert request != null;
		
		Toolkit toolkit;
		toolkit = new Toolkit();
		
		toolkit.setCode("");
		toolkit.setTitle("");
		toolkit.setDescription("");
		toolkit.setAssemblyNotes("");
		toolkit.setMoreInfo("");
		//final Item item;
		//item = this.repository.findItemById(request.getModel().getAttribute("item")); //Aqui entiendo que se coge el item que se selecciona en la vista
		
		//ItemQuantity itemQuantity;
		//itemQuantity = new ItemQuantity();
		
	//	itemQuantity.setItem(item);
		//itemQuantity.setToolkit(toolkit);
		//this.repository.save(itemQuantity);
		
		return toolkit;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;

		entity.setDraftMode(false);
		this.repository.save(entity);
	}

}
