
package acme.features.inventor.item;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.CalculateMoneyExchange;
import acme.entities.Item;
import acme.entities.MoneyExchangeCache;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorItemCreateService implements AbstractCreateService<Inventor, Item> {

	@Autowired
	protected InventorItemRepository					repository;

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

		request.bind(entity, errors, "name", "type", "code", "technology", "description", "retailPrice", "convertedPrice", "moreInfo", "published");

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

		request.unbind(entity, model, "name", "type", "code", "technology", "description", "retailPrice", "convertedPrice", "moreInfo", "published");
	}

	@Override
	public void create(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;
		final Money converted;
		Money source;
		String targetCurrency;
		final MoneyExchange exchange;
		final Date date;
		final Calendar today = Calendar.getInstance();

		source = entity.getRetailPrice();
		targetCurrency = "EUR";

		
		if (!(entity.getRetailPrice().getCurrency().equals(targetCurrency))) {
			exchange = this.getConversion(source, targetCurrency);
			converted = exchange.getTarget();
			date = exchange.getDate();
		} else {
			converted = source;
			date = today.getTime();
		}
		entity.setConvertedPrice(converted);
		entity.setExchangeDate(date);
		this.repository.save(entity);
	}
	
	public MoneyExchange getConversion(final Money source, final String targetCurrency) {
		MoneyExchangeCache cache;
		MoneyExchange exchange;
		final Calendar date;
		
		date=Calendar.getInstance();
		
		final Optional<MoneyExchangeCache> opt = this.repository.findCacheBySourceAndTarget(source.getCurrency(), targetCurrency);
		if(opt.isPresent()) {
			cache = opt.get();
			if (Boolean.TRUE.equals(CalculateMoneyExchange.checkCache(cache)))
				exchange = CalculateMoneyExchange.calculateMoneyExchangeFromCache(source, targetCurrency, cache);
			else {
				exchange = CalculateMoneyExchange.computeMoneyExchange(source, targetCurrency);
				
				date.setTime(exchange.getDate());
				cache.setDate(date);
				cache.setRate(exchange.getRate());
				
				this.repository.save(cache);
			}
			return exchange;
		}else {
			exchange = CalculateMoneyExchange.computeMoneyExchange(source, targetCurrency);
			
			date.setTime(exchange.getDate());
			cache = new MoneyExchangeCache();
			cache.setDate(date);
			cache.setRate(exchange.getRate());
			cache.setSource(source.getCurrency());
			cache.setTarget(targetCurrency);
			
			this.repository.save(cache);
			
			return exchange;
		}
	}
}
