package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shot")
public class Shot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Vaccine vaccine;

    @ManyToOne
    private Centre centre;

    @ManyToOne
    private Nurse nurse;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "shot_certificate_serial_number", nullable = false)
    private ShotCertificate shotCertificate;

    public Shot() {
    }

    public Shot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) {
        this.patient = patient;
        this.vaccine = vaccine;
        this.date = date;
        this.centre = centre;
        this.nurse = nurse;
        patient.addShot(this);
        setShotCertificate(new ShotCertificate(date));
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