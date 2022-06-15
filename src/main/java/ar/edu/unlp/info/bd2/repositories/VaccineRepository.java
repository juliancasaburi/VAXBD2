package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends CrudRepository<Vaccine, Long> {
}