package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {

    /**
     * Recupera los Staff cuyo name contenga el string pasado por parametro name
     *
     * @param name
     * @return los Staff cuyo name contenga el string pasado por parametro name
     */
    List<Staff> getStaffByFullNameContaining(String name);
}