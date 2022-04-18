
package acme.features.inventor.tool;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorToolRepository extends AbstractRepository {

	@Query("select i from Item i where i.type='TOOL' AND i.id = :id")
	Item findOneToolById(int id);

	@Query("select i from Item i where i.type='TOOL' AND i.inventor.id = :inventorId")
	Collection<Item> findManyToolsByInventorId(int inventorId);

}
