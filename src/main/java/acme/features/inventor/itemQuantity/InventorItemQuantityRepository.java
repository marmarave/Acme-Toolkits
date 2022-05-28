package acme.features.inventor.itemQuantity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.ItemQuantity;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorItemQuantityRepository extends AbstractRepository{

	@Query("select i from ItemQuantity i where i.toolkit.id = :toolkitId")
	Collection<ItemQuantity> findManyItemQuantitiesByToolkitId(int toolkitId);
	
	@Query("select i from ItemQuantity i where i.id = :quantityId")
	ItemQuantity findItemQuantityById(int quantityId);

	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
}
