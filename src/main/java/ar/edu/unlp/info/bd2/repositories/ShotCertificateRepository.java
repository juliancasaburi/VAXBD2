package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.ShotCertificate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShotCertificateRepository extends CrudRepository<ShotCertificate, Long> {

    List<ShotCertificate> getShotCertificateByDateBetween(Date startDate, Date endDate);
}