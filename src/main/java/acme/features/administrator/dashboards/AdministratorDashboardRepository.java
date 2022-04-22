package acme.features.administrator.dashboards;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository{
	
	
	//Components
	
	@Query("select count(i) from Item i where i.type = 'COMPONENT'")
	Integer totalNumOfComponents();
	
	@Query("select avg(i.retailPrice.amount) from Item i where i.type = 'COMPONENT' GROUP BY i.type")
	Double averagePriceOfComponents();
	
	@Query("select max(i.retailPrice.amount) from Item i where i.type = 'COMPONENT'")
	Double maxPriceOfComponents();
	
	@Query("select min(i.retailPrice.amount) from Item i where i.type = 'COMPONENT'")
	Double minPriceOfComponents();
	
	@Query("select stddev(i.retailPrice.amount) from Item i where i.type = 'COMPONENT' GROUP BY i.type")
	Double deviationPriceOfComponents();
	
	
	//Tools
	
	@Query("select count(i) from Item i where i.type = 'TOOL'")
	Integer totalNumOfTools();
	
	@Query("select avg(i.retailPrice.amount) from Item i where i.type = 'TOOL' GROUP BY i.type")
	Double averagePriceOfTools();
	
	@Query("select max(i.retailPrice.amount) from Item i where i.type = 'TOOL'")
	Double maxPriceOfTools();
	
	@Query("select min(i.retailPrice.amount) from Item i where i.type = 'TOOL'")
	Double minPriceOfTools();
	
	@Query("select stddev(i.retailPrice.amount) from Item i where i.type = 'TOOL'")
	Double deviationPriceOfTools();
	
	
	//Patronages
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.PatronageStatus.PROPOSED ")
	Integer  numberOfProposedPatronages();
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.PatronageStatus.ACCEPTED ")
	Integer  numberOfAcceptedPatronages();
	
	@Query("select count(p) from Patronage p where p.status = acme.entities.PatronageStatus.DENIED ")
	Integer  numberOfDeniedPatronages();
	
	
	
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
