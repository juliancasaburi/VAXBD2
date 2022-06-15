package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    /**
     * Recupera el Patient con email email.
     *
     * @param email
     * @return el TestModel cuyo title contiene title.
     */
    Optional<Patient> findPatientByEmail(String email);
}