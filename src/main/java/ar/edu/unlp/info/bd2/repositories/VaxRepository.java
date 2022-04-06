package ar.edu.unlp.info.bd2.repositories;

import javax.persistence.Query;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Vaccine;
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
}
