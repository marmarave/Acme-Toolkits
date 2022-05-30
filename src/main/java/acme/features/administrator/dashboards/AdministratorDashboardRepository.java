package acme.features.administrator.dashboards;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository{
	
	
	//Components
	
	@Query("select count(i) from Item i where i.type = 'COMPONENT'")
	Integer totalNumOfComponents();
	
	@Query("select avg(i.retailPrice.amount),technology,i.retailPrice.currency  from Item i where i.type = 'COMPONENT' GROUP BY i.retailPrice.currency, technology")
	List<Object[]> averagePriceOfComponents();
	
	@Query("select max(i.retailPrice.amount),technology,i.retailPrice.currency from Item i where i.type = 'COMPONENT' GROUP BY i.retailPrice.currency, technology")
	List<Object[]> maxPriceOfComponents();
	
	@Query("select min(i.retailPrice.amount),technology,i.retailPrice.currency from Item i where i.type = 'COMPONENT' GROUP BY i.retailPrice.currency, technology")
	List<Object[]> minPriceOfComponents();
	
	@Query("select stddev(i.retailPrice.amount),technology,i.retailPrice.currency from Item i where i.type = 'COMPONENT' GROUP BY i.retailPrice.currency, technology")
	List<Object[]> deviationPriceOfComponents();
	
	
	//Tools
	
	@Query("select count(i) from Item i where i.type = 'TOOL'")
	Integer totalNumOfTools();
	
	@Query("select avg(i.retailPrice.amount),i.retailPrice.currency from Item i where i.type = 'TOOL' GROUP BY i.retailPrice.currency")
	List<Object[]> averagePriceOfTools();
	
	@Query("select max(i.retailPrice.amount),i.retailPrice.currency from Item i where i.type = 'TOOL' GROUP BY i.retailPrice.currency")
	List<Object[]> maxPriceOfTools();
	
	@Query("select min(i.retailPrice.amount),i.retailPrice.currency from Item i where i.type = 'TOOL' GROUP BY i.retailPrice.currency")
	List<Object[]> minPriceOfTools();
	
	@Query("select stddev(i.retailPrice.amount),i.retailPrice.currency from Item i where i.type = 'TOOL' GROUP BY i.retailPrice.currency")
	List<Object[]> deviationPriceOfTools();
	
	
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
	
	//Chimpum
	@Query("select count(c) from Chimpum c where c.item is not null ")
	Integer  numberOfChimpumWhithItem();
	
	@Query("select avg(c.budget.amount),c.budget.currency from Chimpum c  GROUP BY c.budget.currency")
	List<Object[]> averageChimpum();
	
	@Query("select stddev(c.budget.amount),c.budget.currency from Chimpum c  GROUP BY c.budget.currency")
	List<Object[]> deviationChimpum();
	
	@Query("select min(c.budget.amount),c.budget.currency from Chimpum c  GROUP BY c.budget.currency")
	List<Object[]> minChimpum();
	
	@Query("select max(c.budget.amount),c.budget.currency from Chimpum c  GROUP BY c.budget.currency")
	List<Object[]> maxChimpum();
	
}
