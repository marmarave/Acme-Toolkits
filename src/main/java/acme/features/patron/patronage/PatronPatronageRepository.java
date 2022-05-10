package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Patronage;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface PatronPatronageRepository extends AbstractRepository{
	
	@Query("select p from Patronage p WHERE p.id = :id")
    Patronage findOnePatronageById(int id);

    @Query("select p from Patronage p WHERE p.patron.id = :patronId")
    Collection<Patronage> findManyPatronagesByPatronId(int patronId);
    
    @Query("select p from Patron p where p.id = :id")
    Patron findOnePatronById(int id);
    
}
