package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VaccineRepository extends CrudRepository<Vaccine, Long> {

    /**
     * Recupera la Vaccine con name name
     *
     * @param name
     * @return la Vaccine con name name
     */
    Optional<Vaccine> findVaccineByName(String name);
}