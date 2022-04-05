package ar.edu.unlp.info.bd2.repositories;

import javax.persistence.Query;
import ar.edu.unlp.info.bd2.model.Patient;
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
}
