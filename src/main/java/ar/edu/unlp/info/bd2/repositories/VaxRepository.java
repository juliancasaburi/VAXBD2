package ar.edu.unlp.info.bd2.repositories;

import javax.persistence.Query;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Vaccine;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class VaxRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Object o) {
        try {
            getSession().saveOrUpdate(o);
        } catch (Exception e) {
            getSession().clear();
            throw e;
        }
    }

    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public Patient findPatientByEmail(String email) {
        try {
            Query query = getSession().createQuery("from Patient where email = :email");
            query.setParameter("email", email);
            List<Patient> patients = query.getResultList();
            return !patients.isEmpty() ? patients.get(query.getFirstResult()) : null;
        }
        catch (Exception e){
            getSession().clear();
            throw e;
        }
    }

    public Vaccine findVaccineByName(String name) {
        try{
            Query query = getSession().createQuery("from Vaccine where name = :name");
            query.setParameter("name", name);
            List<Vaccine> vaccines = query.getResultList();
            return !vaccines.isEmpty() ? vaccines.get(query.getFirstResult()) : null;
        }
        catch (Exception e){
            getSession().clear();
            throw e;
        }
    }

    public Centre findCentreByName(String name) {
        try {
            Query query = getSession().createQuery("from Centre where name = :name");
            query.setParameter("name", name);
            List<Centre> centres = query.getResultList();
            return !centres.isEmpty() ? centres.get(query.getFirstResult()) : null;
        }
        catch (Exception e){
            getSession().clear();
            throw e;
        }
    }

    public SupportStaff findSupportStaffByDni(String dni){
        try {
            Query query = getSession().createQuery("from SupportStaff where dni = :dni");
            query.setParameter("dni", dni);
            List<SupportStaff> supportStaffList = query.getResultList();
            return !supportStaffList.isEmpty() ? supportStaffList.get(query.getFirstResult()) : null;
        }
        catch (Exception e){
            getSession().clear();
            throw e;
        }
    }

    public VaccinationSchedule findVaccinationScheduleById(Long id){
        try {
            Query query = getSession().createQuery("from VaccinationSchedule where id = :id");
            query.setParameter("id", id);
            List<VaccinationSchedule> vaccinationSchedule = query.getResultList();
            return !vaccinationSchedule.isEmpty() ? vaccinationSchedule.get(query.getFirstResult()) : null;
        }
        catch (Exception e){
            getSession().clear();
            throw e;
        }
    }
}
