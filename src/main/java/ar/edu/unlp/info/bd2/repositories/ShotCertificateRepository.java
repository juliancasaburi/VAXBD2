package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.ShotCertificate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShotCertificateRepository extends CrudRepository<ShotCertificate, Long> {

    /**
     * Recupera los ShotCertificate con date entre startDate y endDate
     *
     * @param startDate
     * @param endDate
     * @return los ShotCertificate con date entre startDate y endDate
     */
    List<ShotCertificate> getShotCertificateByDateBetween(Date startDate, Date endDate);
}