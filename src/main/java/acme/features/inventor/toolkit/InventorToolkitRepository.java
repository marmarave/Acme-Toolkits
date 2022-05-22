package acme.features.inventor.toolkit;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.ItemQuantity;
import acme.entities.MoneyExchangeCache;
import acme.entities.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorToolkitRepository extends AbstractRepository {
	
	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findOneToolkitById(int id);

	@Query("select distinct iq.toolkit from ItemQuantity iq, Item i where iq.item.id=i.id and i.inventor.id = :inventorId")
	Collection<Toolkit> findManyToolkitsByInventorId(int inventorId);
	
	@Query("select iq from ItemQuantity iq where iq.toolkit.id = :masterId")
    Collection<ItemQuantity> findItemQuantitiesOfToolkit(int masterId);
	
	@Query("select c from MoneyExchangeCache c where c.source = :sourceCurrency and c.target=:targetCurrency")
	Optional<MoneyExchangeCache> findCacheBySourceAndTarget(String sourceCurrency, String targetCurrency);
}
