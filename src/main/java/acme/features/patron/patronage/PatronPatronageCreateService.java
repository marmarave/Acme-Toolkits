package acme.features.patron.patronage;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.entities.PatronageStatus;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class PatronPatronageCreateService implements AbstractCreateService<Patron, Patronage>{

	// Internal state ---------------------------------------------------------

		@Autowired
		protected PatronPatronageRepository repository;

		// AbstractCreateService<Patron, Patronage> interface -------------------------
			
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors,"status" ,"code", "legalStuff", "budget", "creationMoment", "startDate","endDate","moreInfo");
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status" ,"code", "legalStuff", "budget", "creationMoment", "startDate","endDate","moreInfo");
		
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		
		assert request != null;

		final Patronage result = new Patronage();
		Date moment;
		Date startDate;
		Date endDate;
		int principalId;
		final Money budget;

		principalId = request.getPrincipal().getActiveRoleId();
		final Patron patron = this.repository.findOnePatronById(principalId);

		moment = new Date(System.currentTimeMillis() - 1);
		
		final Calendar cal = Calendar.getInstance();
		cal.setTime(moment);
		cal.add(Calendar.MONTH, 1);
		startDate = cal.getTime();
		
		cal.add(Calendar.MONTH, 1);
		endDate = cal.getTime();
		
		budget = new Money();
		budget.setAmount(1.0);
		budget.setCurrency("EUR");
		
		
		//ARREGLAR LA RELACION DE INVENTOR!!!!!
		
		final Inventor inventor = new Inventor();

		result.setPatron(patron);
		result.setInventor(inventor);
		result.setCreationMoment(moment);
		result.setStatus(PatronageStatus.PROPOSED);
		result.setCode("");
		result.setLegalStuff("");
		result.setBudget(budget);
		result.setStartDate(startDate);
		result.setEndDate(endDate);
		result.setMoreInfo("");

		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {		
		assert request != null;
		assert entity != null;
		assert errors != null;

		/*if (!errors.hasErrors("startDate")) {
			final Long duration = Duration.between(entity.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), entity.getCreationMoment().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).getSeconds();
			errors.state(request, duration > 26280000L, "startDate", "patron.patronage.form.error.too-close");
		}

		if (!errors.hasErrors("endDate")) {
			final Long duration = Duration.between(entity.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), entity.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).getSeconds();
			errors.state(request, duration > 26280000L, "endDate", "patron.patronage.form.error.insufficient-duration");
		}

		if (!errors.hasErrors("budget")) {
			errors.state(request, entity.getBudget().getAmount() >= 1, "budget", "patron.patronage.form.error.minimum-budget");
		}*/
		
	}

	@Override
	public void create(final Request<Patronage> request, final Patronage entity) {
		
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);

		this.repository.save(entity);
		
	}

}
