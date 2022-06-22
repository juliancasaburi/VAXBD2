package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Nurse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NurseRepository extends CrudRepository<Nurse, Long> {

    /**
     * Recupera los Nurses con experiencia mayor a years
     *
     * @param years
     * @return los Nurses con experiencia mayor a years
     */
    List<Nurse> findByExperienceGreaterThan(int years);

    /**
     * Recupera el Centre con name name.
     *
     * @param name
     * @return el Centre con name name.
     */
    @Query("from Nurse n where n.id not in (select s.nurse.id from Shot s)")
    List<Nurse> getNurseNotShot();
}