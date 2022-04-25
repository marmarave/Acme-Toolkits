package acme.features.administrator.systemConfiguration;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSystemConfigurationRepository extends AbstractRepository{
	
	@Query("select sc from SystemConfiguration sc where sc.id = :id")
	SystemConfiguration findOneSystemConfigurationById(int id);

	@Query("select sc from SystemConfiguration sc")
	Collection<SystemConfiguration> findManySystemConfigurationByAvailability();
}
