package acme.features.inventor.component;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorComponentRepository extends AbstractRepository {
	
	@Query("select i from Item i where i.type='COMPONENT' AND i.id = :id")
    Item findOneComponentById(int id);

    @Query("select i from Item i where i.type='COMPONENT' AND i.inventor.id = :inventorId")
    Collection<Item> findManyComponentsByInventorId(int inventorId);


}
