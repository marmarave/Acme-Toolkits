package acme.features.patron.dashboards;



import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronDashboardRepository extends AbstractRepository{
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED ")
	Double  numberOfProposedPatronages();
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED ")
	Double  numberOfAcceptedPatronages();
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED ")
	Double  numberOfDeniedPatronages();
	
	
	// AVERAGE
	
	@Query("select avg(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED GROUP BY p.status")
	Double averageBudgetProposedPatronages();
	
	@Query("select avg(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED GROUP BY p.status")
	Double averageBudgetAcceptedPatronages();
	
	@Query("select avg(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED GROUP BY p.status")
	Double averageBudgetDeniedPatronages();
	
	
	@Query("select stddev(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED ")
	Double deviationBudgetProposedPatronages();

	@Query("select stddev(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED ")
	Double deviationBudgetAcceptedPatronages();
	
	@Query("select stddev(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED ")
	Double deviationBudgetDeniedPatronages();
	
	
	
	@Query("select min(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED ")
	Double minBudgetProposedPatronages();
	
	@Query("select min(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED ")
	Double minBudgetAcceptedPatronages();
	
	@Query("select min(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED ")
	Double minBudgetDeniedPatronages();
	

	
	@Query("select max(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED ")
	Double maxBudgetProposedPatronages();
	
	@Query("select max(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED ")
	Double maxBudgetAcceptedPatronages();
	
	@Query("select max(p.budget.amount) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED ")
	Double maxBudgetDeniedPatronages();
	
}
