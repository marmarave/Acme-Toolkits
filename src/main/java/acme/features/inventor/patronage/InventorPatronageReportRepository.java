package acme.features.inventor.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.Patronage;
import acme.entities.PatronageReport;
import acme.framework.repositories.AbstractRepository;

public interface InventorPatronageReportRepository extends AbstractRepository {
	
	@Query("select pr from PatronageReport pr where pr.id = :id")
	PatronageReport findOneById(int id);
	
	@Query("select pr from PatronageReport pr where pr.patronage.inventor.id = :inventorId")
	Collection<PatronageReport> findManyPatronagesReportByInventorId(int inventorId);

}
