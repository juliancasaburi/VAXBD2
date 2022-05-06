package ar.edu.unlp.info.bd2.repositories;

import javax.persistence.Query;

import ar.edu.unlp.info.bd2.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class VaxRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Object o) {
        try {
            this.sessionFactory.getCurrentSession().saveOrUpdate(o);
        }
        catch (Exception e) {
            this.sessionFactory.getCurrentSession().clear();
            throw e;
        }
    }

    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    /* TP1 Methods */

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

    /* TP2 Methods */

    public List<Patient> findAllPatients() {
        Query query = getSession().createQuery("from Patient");
        List<Patient> patients = query.getResultList();
        return patients;
    }

    public List<Nurse> findNurseWithMoreThanNYearsExperience() {
        Query query = getSession().createQuery("from Nurse where experience > 9");
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
        Query query = getSession().createQuery("select s.centre from Shot s group by s.centre order by count(*) desc");
        query.setMaxResults(1);
        return (Centre) query.getSingleResult();
    }

    public List<Nurse> getNurseNotShot() {
        Query query = getSession().createQuery("from Nurse n where n.id NOT IN (select s.nurse.id from Shot s)");
        List<Nurse> nurses = query.getResultList();
        return nurses;
    }
}
