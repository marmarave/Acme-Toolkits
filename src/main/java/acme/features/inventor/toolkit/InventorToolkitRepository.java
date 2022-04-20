package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import acme.entities.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorToolkitRepository extends AbstractRepository {
	
	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findOneToolkitById(int id);

	@Query("select distinct i.itemQuantity.toolkit from Item i  where i.inventor.id = :inventorId")
	Collection<Toolkit> findManyToolkitsByInventorId(int inventorId);
}
