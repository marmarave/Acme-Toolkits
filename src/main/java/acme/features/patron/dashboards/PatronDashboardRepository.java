package acme.features.patron.dashboards;

import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronDashboardRepository extends AbstractRepository{
	
	/*@Query("select count(p) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED ")
	Double  numberOfProposedPatronages();
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED ")
	Double  numberOfAcceptedPatronages();
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED ")
	Double  numberOfDeniedPatronages();
	
	
	// AVERAGE
	
	@Query("select avg(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED ")
	Double averageBudgetProposedPatronages();
	
	@Query("select avg(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED ")
	Double averageBudgetAcceptedPatronages();
	
	@Query("select avg(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED ")
	Double averageBudgetDeniedPatronages();
	*/
	
	// DEVIATION
	
//	@Query("select stdev(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED ")
//	Double deviationBudgetProposedPatronages();
//	
//	@Query("select stdev(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED ")
//	Double deviationBudgetAcceptedPatronages();
//	
//	@Query("select stdev(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED ")
//	Double deviationBudgetDeniedPatronages();
	
	
	
	//MINIMUN
	/*
	@Query("select min(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED ")
	Double minBudgetProposedPatronages();
	
	@Query("select min(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED ")
	Double minBudgetAcceptedPatronages();
	
	@Query("select min(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED ")
	Double minBudgetDeniedPatronages();
	
	//MAXIMUM
	
	@Query("select max(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED ")
	Double maxBudgetProposedPatronages();
	
	@Query("select max(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED ")
	Double maxBudgetAcceptedPatronages();
	
	@Query("select max(p.budget) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED ")
	Double maxBudgetDeniedPatronages();
*/
}
