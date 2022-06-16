package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.SupportStaff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupportStaffRepository extends CrudRepository<SupportStaff, Long> {

    /**
     * Recupera el SupportStaff con dni dni.
     *
     * @param dni
     * @return el SupportStaff con dni dni.
     */
    Optional<SupportStaff> findSupportStaffByDni(String dni);
}