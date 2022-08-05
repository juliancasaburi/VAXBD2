package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.SupportStaff;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
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


    /**
     * Obtiene el area de suportStaff con menor cantidad de empleados.
     *
     * @param pageable
     * @return el area de suportStaff con menor cantidad de empleados.
     */
    @Query("select sf.area from SupportStaff sf group by sf.area order by count(sf.area) asc")
    List<String> getLessEmployeesSupportStaffArea(Pageable pageable);

}
