package acme.features.administrator.systemConfiguration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.SystemConfiguration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorSystemConfigurationListService implements AbstractListService<Administrator,SystemConfiguration>{
	
	@Autowired
	protected AdministratorSystemConfigurationRepository repository;

	@Override
	public boolean authorise(final Request<SystemConfiguration> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<SystemConfiguration> findMany(final Request<SystemConfiguration> request) {
		assert request != null;

		Collection<SystemConfiguration> result;

		result = this.repository.findManySystemConfigurationByAvailability();

		return result;
	}

	@Override
	public void unbind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model,"systemCurrency","acceptedCurrencies", "strongSpam", "strongThreshold","weakSpam","weakThreshold");
	}
}
