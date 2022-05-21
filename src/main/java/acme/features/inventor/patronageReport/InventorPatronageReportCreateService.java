/*
 * InventorPatronageReportCreateService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.inventor.patronageReport;

import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import acme.entities.Patronage;
import acme.entities.PatronageReport;
import acme.entities.PatronageStatus;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport> {

	// Internal state ---------------------------------------------------------

		@Autowired
		protected InventorPatronageReportRepository repository;

		// AbstractCreateService<Inventor, PatronageReport> interface --------------
		
		@Override
		public boolean authorise(final Request<PatronageReport> request) {
			assert request != null;
			assert request != null;

			boolean result;
			int patronageId;
			Patronage patronage;

			patronageId = request.getModel().getInteger("masterId");
			patronage = this.repository.findOnePatronageById(patronageId);
			result = (patronage != null && request.isPrincipal(patronage.getInventor()) && patronage.getStatus().equals(PatronageStatus.ACCEPTED));

			return result;
			
		}
		
		@Override
		public PatronageReport instantiate(final Request<PatronageReport> request) {
			assert request != null;

			final PatronageReport result;
			Date creationMoment;
			final Patronage patronage;
			final int masterId;
			
			masterId = request.getModel().getInteger("masterId");
			
			patronage =this.repository.findOnePatronageById(masterId);

			creationMoment = new Date(System.currentTimeMillis() - 1);

			final Collection<PatronageReport> patronages = this.repository.findAllPatronageReportsByPatronageId(masterId);

			final Integer sNumber = patronages.size() + 1;
			
			result = new PatronageReport();
			result.setCreationMoment(creationMoment);
			result.setSerialNumber(sNumber);
			result.setPatronage(patronage);
			

			return result;
		}

		@Override
		public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			request.bind(entity, errors, "memorandum", "moreInfo");
			
		}
		
		@Override
		public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;
			
			boolean confirmation;
			
			confirmation = request.getModel().getBoolean("confirmation");
			errors.state(request, confirmation, "confirmation", "inventor.patronage-report.form.label.confirmation");
			
		}

		@Override
		public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "memorandum", "moreInfo");
			model.setAttribute("confirmation", false);
			model.setAttribute("readonly", false);
			model.setAttribute("masterId", entity.getPatronage().getId());
			
		}

		

		

		@Override
		public void create(final Request<PatronageReport> request, final PatronageReport entity) {
			
			assert request != null;
			assert entity != null;

			this.repository.save(entity);
			
		}

	}
