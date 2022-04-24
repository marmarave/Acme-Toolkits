
package acme.features.patron.dashboards;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard>{

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronDashboardRepository repository;


	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		assert request != null;

		final PatronDashboard result;

		final int numberOfAcceptedPatronages = this.repository.numberOfAcceptedPatronages().intValue();
		final int numberOfDeniedPatronages = this.repository.numberOfDeniedPatronages().intValue();
		final int numberOfProposedPatronages = this.repository.numberOfProposedPatronages().intValue();
		final Double minPriceOfAcceptedPatronages = this.repository.minBudgetAcceptedPatronages();
		final Double maxPriceOfAcceptedPatronages = this.repository.maxBudgetAcceptedPatronages();
		final Double averagePriceOfAcceptedPatronages = this.repository.averageBudgetAcceptedPatronages();
		final Double deviationPriceOfAcceptedPatronages = this.repository.deviationBudgetAcceptedPatronages();
		final Double minPriceOfDeniedPatronages = this.repository.minBudgetDeniedPatronages();
		final Double maxPriceOfDeniedPatronages = this.repository.maxBudgetDeniedPatronages();
		final Double averagePriceOfDeniedPatronages = this.repository.averageBudgetDeniedPatronages();
		final Double deviationPriceOfDeniedPatronages = this.repository.deviationBudgetDeniedPatronages();
		final Double minPriceOfProposedPatronages = this.repository.minBudgetProposedPatronages();
		final Double maxPriceOfProposedPatronages = this.repository.maxBudgetProposedPatronages();
		final Double averagePriceOfProposedPatronages = this.repository.averageBudgetProposedPatronages();
		final Double deviationPriceOfProposedPatronages = this.repository.deviationBudgetProposedPatronages();
		
		final Map<String, Integer> numberOfPatronages = new HashMap<>();
		numberOfPatronages.put("accepted", numberOfAcceptedPatronages);
		numberOfPatronages.put("denied", numberOfDeniedPatronages);
		numberOfPatronages.put("proposed", numberOfProposedPatronages);
		
		final Map<String, Double> patronageStats = new HashMap<>();
		patronageStats.put("maxAccepted", maxPriceOfAcceptedPatronages);
		patronageStats.put("minAccepted", minPriceOfAcceptedPatronages);
		patronageStats.put("averageAccepted", averagePriceOfAcceptedPatronages);
		patronageStats.put("deviationAccepted", deviationPriceOfAcceptedPatronages);
		patronageStats.put("maxDenied", maxPriceOfDeniedPatronages);
		patronageStats.put("minDenied", minPriceOfDeniedPatronages);
		patronageStats.put("averageDenied", averagePriceOfDeniedPatronages);
		patronageStats.put("deviationDenied", deviationPriceOfDeniedPatronages);
		patronageStats.put("maxProposed", maxPriceOfProposedPatronages);
		patronageStats.put("minProposed", minPriceOfProposedPatronages);
		patronageStats.put("averageProposed", averagePriceOfProposedPatronages);
		patronageStats.put("deviationProposed", deviationPriceOfProposedPatronages);

		result = new PatronDashboard();
		result.setNumberOfPatronages(numberOfPatronages);
		result.setPatronagesStats(patronageStats);

		return result;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		
		model.setAttribute("numberOfAcceptedPatronages", entity.getNumberOfPatronages().get("accepted"));
		model.setAttribute("numberOfDeniedPatronages", entity.getNumberOfPatronages().get("denied"));
		model.setAttribute("numberOfProposedPatronages", entity.getNumberOfPatronages().get("proposed"));
		model.setAttribute("maxAcceptedPatronages", entity.getPatronagesStats().get("maxAccepted"));
		model.setAttribute("minAcceptedPatronages", entity.getPatronagesStats().get("minAccepted"));
		model.setAttribute("averageAcceptedPatronages", entity.getPatronagesStats().get("averageAccepted"));
		model.setAttribute("deviationAcceptedPatronages", entity.getPatronagesStats().get("deviationAccepted"));
		model.setAttribute("maxDeniedPatronages", entity.getPatronagesStats().get("maxDenied"));
		model.setAttribute("minDeniedPatronages", entity.getPatronagesStats().get("minDenied"));
		model.setAttribute("averageDeniedPatronages", entity.getPatronagesStats().get("averageDenied"));
		model.setAttribute("deviationDeniedPatronages", entity.getPatronagesStats().get("deviationDenied"));
		model.setAttribute("maxProposedPatronages", entity.getPatronagesStats().get("maxProposed"));
		model.setAttribute("minProposedPatronages", entity.getPatronagesStats().get("minProposed"));
		model.setAttribute("averageProposedPatronages", entity.getPatronagesStats().get("averageProposed"));
		model.setAttribute("deviationProposedPatronages", entity.getPatronagesStats().get("deviationProposed"));	
	}
}
