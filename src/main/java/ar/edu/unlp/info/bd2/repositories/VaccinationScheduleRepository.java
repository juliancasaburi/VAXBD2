package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationScheduleRepository extends CrudRepository<VaccinationSchedule, Long> {

    /**
     * Recupera el VaccinationSchedule con id id.
     *
     * @param id
     * @return el VaccinationSchedule con id id.
     */
    VaccinationSchedule findVaccinationScheduleById(Long id);
}