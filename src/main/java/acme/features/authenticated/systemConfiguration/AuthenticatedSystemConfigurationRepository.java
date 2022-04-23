package acme.features.authenticated.systemConfiguration;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedSystemConfigurationRepository extends AbstractRepository{

	@Query("select sc from SystemConfiguration sc where sc.id = :id")
	SystemConfiguration findOneSystemConfigurationCurrencyInfoById(int id);
	
	@Query("select sc from SystemConfiguration sc")
	Collection<SystemConfiguration> findManySystemConfiguration();
}
