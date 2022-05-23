package acme.features.inventor.itemQuantity;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.ItemQuantity;
import acme.entities.ItemType;
import acme.entities.Toolkit;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.helpers.CollectionHelper;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;


@Service
public class InventorItemQuantityComponentsListService implements AbstractListService<Inventor, ItemQuantity>{

	@Autowired
	protected InventorToolkitRepository repository;
	
	@Autowired
	protected InventorItemQuantityRepository iqrepo;
	
	
	@Override
	public boolean authorise(final Request<ItemQuantity> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<ItemQuantity> findMany(final Request<ItemQuantity> request) {
		int toolkitId;
		toolkitId = request.getModel().getInteger("masterId");
		
		final Collection<ItemQuantity> itemQuantities = this.iqrepo.findManyItemQuantitiesByToolkitId(toolkitId); //Aqui tengo ya las lineas de la tabla quantities agrupadas por cada toolkit
		final Collection<ItemQuantity> result = itemQuantities.stream().filter(x->x.getItem().getType().equals(ItemType.COMPONENT)).collect(Collectors.toCollection(HashSet::new));
		return result;

	}

	@Override
	public void unbind(final Request<ItemQuantity> request, final Collection<ItemQuantity> entities, final Model model) {
		assert request != null;
		assert !CollectionHelper.someNull(entities);
		assert model != null;

		int masterId;
		Toolkit toolkit;
		boolean checkPublished = true;
		String type;

		masterId = request.getModel().getInteger("masterId");
		toolkit = this.repository.findOneToolkitById(masterId);
		checkPublished = (toolkit.isDraftMode() && request.isPrincipal(toolkit.getInventor()));
		type = request.getModel().getAttribute("type").toString();
		model.setAttribute("draftMode", toolkit.isDraftMode());
		model.setAttribute("type", type);
		model.setAttribute("masterId", masterId);
		model.setAttribute("showCreate", checkPublished);
	}

	@Override
	public void unbind(final Request<ItemQuantity> request, final ItemQuantity entity, final Model model) {
		assert request != null; 
		assert entity != null; 
		assert model != null; 

		request.unbind(entity, model,"quantity", "item.name", "item.type","item.code", "item.technology", "item.retailPrice","toolkit.draftMode"); 
		
	}

}