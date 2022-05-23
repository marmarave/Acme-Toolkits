package acme.features.inventor.itemQuantity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.ItemQuantity;
import acme.entities.ItemType;
import acme.entities.Toolkit;
import acme.features.inventor.toolkit.InventorToolkitRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorItemQuantityDeleteService implements AbstractDeleteService<Inventor, ItemQuantity>{

	@Autowired
	InventorItemQuantityRepository iqRepository;
	
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
		
	}

	@Override
	public void unbind(final Request<ItemQuantity> request, final ItemQuantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "quantity", "item.type", "item.name", "item.technology", "item.description", "item.retailPrice", "item.moreInfo");
		model.setAttribute("draftMode", entity.getToolkit().isDraftMode());
		model.setAttribute("itemId", entity.getItem().getId());
		
		final Collection<ItemQuantity> quantities = this.repository.findItemQuantitiesOfToolkit(Integer.valueOf(request.getModel().getAttribute("masterId").toString()));
		final List<Item> toolkitTools = quantities.stream().filter(x->x.getItem().getType().equals(ItemType.TOOL)).map(x->x.getItem()).collect(Collectors.toList());
		final List<Item> toolkitComponents = quantities.stream().filter(x->x.getItem().getType().equals(ItemType.COMPONENT)).map(x->x.getItem()).collect(Collectors.toList());
		model.setAttribute("toolkitComponents", toolkitComponents);
		model.setAttribute("toolkitTools", toolkitTools);
	}

	@Override
	public ItemQuantity findOne(final Request<ItemQuantity> request) {
		assert request != null;
		
		final int masterId = Integer.parseInt(request.getModel().getAttribute("masterId").toString());
		//Esto pilla el masterId del toolkit
		final Collection<ItemQuantity> quantities = this.iqRepository.findManyItemQuantitiesByToolkitId(masterId);
		
		return quantities.stream().findFirst().get();
	}

	@Override
	public void validate(final Request<ItemQuantity> request, final ItemQuantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<ItemQuantity> request, final ItemQuantity entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.delete(entity);
	}

}
