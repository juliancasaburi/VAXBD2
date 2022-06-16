package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Centre;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentreRepository extends CrudRepository<Centre, Long> {

    /**
     * Recupera el Centre con name name.
     *
     * @param name
     * @return el Centre con name name.
     */
    Optional<Centre> findCentreByName(String name);
}