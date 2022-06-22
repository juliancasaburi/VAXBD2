package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.Centre;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    /**
     * Recupera los n Centre con mayor cantidad de Staff
     *
     * @param n la cantidad de Centre
     * @return los i Centre con mayor cantidad de Staff
     */
    @Query("from Centre c order by size(c.staffs) desc")
    List<Centre> getCentresTopNStaff(Pageable pageable);


    /**
     * Recupera el Centre con mayor cantidad de Shots
     *
     * @return el Centre con mayor cantidad de Shots
     */
    @Query("select s.centre from Shot s group by s.centre order by count(s.centre) desc")
    List<Centre> getTopShotCentre(Pageable pageable);

}