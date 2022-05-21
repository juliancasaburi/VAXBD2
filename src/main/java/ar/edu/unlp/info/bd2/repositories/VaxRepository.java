package ar.edu.unlp.info.bd2.repositories;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Vaccine;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class VaxRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Object o) throws VaxException {
        try {
            getSession().saveOrUpdate(o);
        }
        catch (ConstraintViolationException e) {
            throw new VaxException("Constraint Violation");
        }
        catch (Exception e) {
            getSession().clear();
            throw new VaxException(e.getMessage());
        }
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public Patient findPatientByEmail(String email) {
        Query query = getSession().createQuery("from Patient where email = :email");
        query.setParameter("email", email);
        List<Patient> patients = query.getResultList();
        return !patients.isEmpty() ? patients.get(query.getFirstResult()) : null;
    }

    public Vaccine findVaccineByName(String name) {
        Query query = getSession().createQuery("from Vaccine where name = :name");
        query.setParameter("name", name);
        List<Vaccine> vaccines = query.getResultList();
        return !vaccines.isEmpty() ? vaccines.get(query.getFirstResult()) : null;
    }

    public Centre findCentreByName(String name) {
        Query query = getSession().createQuery("from Centre where name = :name");
        query.setParameter("name", name);
        List<Centre> centres = query.getResultList();
        return !centres.isEmpty() ? centres.get(query.getFirstResult()) : null;
    }

    public SupportStaff findSupportStaffByDni(String dni) {
        Query query = getSession().createQuery("from SupportStaff where dni = :dni");
        query.setParameter("dni", dni);
        List<SupportStaff> supportStaffList = query.getResultList();
        return !supportStaffList.isEmpty() ? supportStaffList.get(query.getFirstResult()) : null;
    }

    public VaccinationSchedule findVaccinationScheduleById(Long id) throws VaxException {
        try {
            return (VaccinationSchedule) getSession().createQuery("from VaccinationSchedule where id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new VaxException(e.getMessage());
        }
        catch (Exception e) {
            getSession().clear();
            throw e;
        }
    }
}
