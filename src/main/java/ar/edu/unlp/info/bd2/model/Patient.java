package ar.edu.unlp.info.bd2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dayOfBirth;

    @OneToMany(mappedBy = "patient")
    private Set<Shot> shots = new HashSet<>();

    public Patient() {
    }

    public Patient(String email, String password, String fullname, Date dayOfBirth) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.dayOfBirth = dayOfBirth;
    }

    public Long getId() {
        return id;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addShot(Shot shot){
        shots.add(shot);
    }

    public Set<Shot> getShots() {
        return shots;
    }
}