
package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.ItemType;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);

	@Query("select i from Item i where i.type=:type AND i.inventor.id = :inventorId")
	Collection<Item> findManyItemsByTypeAndInventorId(ItemType type, int inventorId);
	
	@Query("select i.inventor from Item i where i.inventor.id = :inventorId")
	Inventor findInventorById(int inventorId);
	
	@Query("select i from Item i WHERE i.code = :code")
    Item findOneItemByCode(String code);
	
	@Query("select s.acceptedCurrencies from SystemConfiguration s")
	String findAvailableCurrencies();

}
