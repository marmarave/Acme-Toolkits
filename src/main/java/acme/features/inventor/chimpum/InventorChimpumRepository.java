package acme.features.inventor.chimpum;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.entities.ItemType;
import acme.entities.MoneyExchangeCache;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorChimpumRepository extends AbstractRepository{
	
	@Query("select c from Chimpum c where c.id = :id")
	Chimpum findOneById(int id);
	
	@Query("select i.chimpum from Item i where i.inventor.id = :id")
	Collection<Chimpum> findChimpumByInventorId(int id);
	
	@Query("select i.inventor from Item i where i.inventor.id = :inventorId")
	Inventor findInventorById(int inventorId);
	
	@Query("select i from Item i where i.chimpum.code = :code")
	Item findItemByChimpumCode(String code);
	
	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);

	@Query("select i from Item i where i.chimpum.id = :id")
	Item findOneItemByChimpumId(int id);
	
	
}
