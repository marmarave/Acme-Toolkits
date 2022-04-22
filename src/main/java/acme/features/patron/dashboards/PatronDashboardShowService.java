
package acme.features.patron.dashboards;

import org.springframework.beans.factory.annotation.Autowired;

import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

public class PatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard>{

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronDashboardRepository repository;

	// AbstractShowService<Administrator, Dashboard> interface ----------------


	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		assert request != null;

		final PatronDashboard result;
//		final Double averageNumberOfApplicationsPerEmployer;
//		final Double averageNumberOfApplicationsPerWorker;
//		final Double averageNumberOfJobsPerEmployer;
//		final Double ratioOfPendingApplications;
//		final Double ratioOfAcceptedApplications;
//		final Double ratioOfRejectedApplications;
//
//		averageNumberOfApplicationsPerEmployer = this.repository.averageNumberOfApplicationsPerEmployer();
//		averageNumberOfApplicationsPerWorker = this.repository.averageNumberOfApplicationsPerWorker();
//		averageNumberOfJobsPerEmployer = this.repository.averageNumberOfJobsPerEmployer();
//		ratioOfPendingApplications = this.repository.ratioOfPendingApplications();
//		ratioOfAcceptedApplications = this.repository.ratioOfAcceptedApplications();
//		ratioOfRejectedApplications = this.repository.ratioOfRejectedApplications();

		result = new PatronDashboard();
//		result.setAvegageNumberOfApplicationsPerEmployer(averageNumberOfApplicationsPerEmployer);
//		result.setAverageNumberOfApplicationsPerWorker(averageNumberOfApplicationsPerWorker);
//		result.setAverageNumberOfJobsPerEmployer(averageNumberOfJobsPerEmployer);
//		result.setRatioOfPendingApplications(ratioOfPendingApplications);
//		result.setRatioOfAcceptedApplications(ratioOfAcceptedApplications);
//		result.setRatioOfRejectedApplications(ratioOfRejectedApplications);

		return result;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, //
			"averageNumberOfJobsPerEmployer", "averageNumberOfApplicationsPerWorker", // 
			"avegageNumberOfApplicationsPerEmployer", "ratioOfPendingApplications", //
			"ratioOfRejectedApplications", "ratioOfAcceptedApplications");
	}
}
