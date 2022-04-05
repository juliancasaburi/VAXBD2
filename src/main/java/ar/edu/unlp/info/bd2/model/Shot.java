package ar.edu.unlp.info.bd2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Shot")
public class Shot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Vaccine vaccine;

    @ManyToOne
    private Centre centre;

    @ManyToOne
    private Nurse nurse;

    @OneToOne
    private ShotCertificate shotCertificate;

    public Shot() {
    }

    public Shot(Date date, Patient patient, Vaccine vaccine, Centre centre, Nurse nurse) {
        this.date = date;
        this.patient = patient;
        this.vaccine = vaccine;
        this.centre = centre;
        this.nurse = nurse;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public ShotCertificate getShotCertificate() {
        return shotCertificate;
    }

    public void setShotCertificate(ShotCertificate shotCertificate) {
        this.shotCertificate = shotCertificate;
    }
}