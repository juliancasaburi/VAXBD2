package ar.edu.unlp.info.bd2.repositories;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import ar.edu.unlp.info.bd2.model.Staff;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public class VaxRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Object o) throws VaxException {
        try {
            getSession().saveOrUpdate(o);
        } catch (ConstraintViolationException e) {
            throw new VaxException("Constraint Violation");
        } catch (Exception e) {
            getSession().clear();
            throw new VaxException(e.getMessage());
        }
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /* TP1 Methods */

    public Optional<Patient> findPatientByEmail(String email) {
        return (Optional<Patient>)getSession().createQuery("from Patient where email = :email").setParameter("email", email).uniqueResultOptional();
    }

    public Optional<Vaccine> findVaccineByName(String name) {
        return (Optional<Vaccine>)getSession().createQuery("from Vaccine where name = :name").setParameter("name", name).uniqueResultOptional();
    }

    public Optional<Centre> findCentreByName(String name) {
        return (Optional<Centre>)getSession().createQuery("from Centre where name = :name").setParameter("name", name).uniqueResultOptional();
    }
    public Optional<SupportStaff> findSupportStaffByDni(String dni) {
        return (Optional<SupportStaff>)getSession().createQuery("from SupportStaff where dni = :dni").setParameter("dni", dni).uniqueResultOptional();
    }



    public VaccinationSchedule findVaccinationScheduleById(Long id) throws VaxException {
        try {
            return (VaccinationSchedule) getSession().createQuery("from VaccinationSchedule where id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new VaxException(e.getMessage());
        } catch (Exception e) {
            getSession().clear();
            throw e;
        }
    }

    /* TP2 Methods */

    public List<Patient> findAllPatients() {
        Query query = getSession().createQuery("from Patient");
        List<Patient> patients = query.getResultList();
        return patients;
    }

    public List<Nurse> findNurseWithMoreThanNYearsExperience(int years) {
        Query query = getSession().createQuery("from Nurse where experience > :years");
        query.setParameter("years", years);
        List<Nurse> nurses = query.getResultList();
        return nurses;
    }

    public List<Centre> getCentresTopNStaff(int maxCentreQuantity) {
        Query query = getSession().createQuery("from Centre c order by size(c.staffs) desc");
        query.setMaxResults(maxCentreQuantity);
        List<Centre> centres = query.getResultList();
        return centres;
    }

    public Centre getTopShotCentre() {
        Query query = getSession().createQuery("select s.centre from Shot s group by s.centre order by count(s.centre) desc");
        query.setMaxResults(1);
        return (Centre) query.getSingleResult();
    }

    public List<Nurse> getNurseNotShot() {
        Query query = getSession().createQuery("from Nurse n where n.id not in (select s.nurse.id from Shot s)");
        List<Nurse> nurses = query.getResultList();
        return nurses;
    }

    public List<Staff> getStaffWithName(String name) {
        Query query = getSession().createQuery("from Staff where fullName like :name");
        query.setParameter("name", "%" + name + "%");
        List<Staff> staffs = query.getResultList();
        return staffs;
    }

    public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
        Query query = getSession().createQuery("from ShotCertificate sc where sc.date between :startDate and :endDate");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<ShotCertificate> shotCertificates = query.getResultList();
        return shotCertificates;
    }

    public List<Vaccine> getVaccineNotShot() {
        Query query = getSession().createQuery("from Vaccine v where v.id not in (select s.vaccine.id from Shot s)");
        List<Vaccine> vaccine = query.getResultList();
        return vaccine;
    }

    public String getLessEmployeesSupportStaffArea() {
        Query query = getSession().createQuery("select sf.area from SupportStaff sf group by sf.area order by count(sf.area) asc");
        query.setMaxResults(1);
        return (String) query.getSingleResult();
    }
}
