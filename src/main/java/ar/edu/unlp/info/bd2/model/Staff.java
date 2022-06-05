package ar.edu.unlp.info.bd2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.HashSet;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "staff")
public abstract class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String dni;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "staffs")
    private Set<Centre> centres = new HashSet<>();

    public Staff() {
    }

    public Staff(String fullName, String dni) {
        this.fullName = fullName;
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Set<Centre> getCentres() {
        return centres;
    }

    public void setCentres(Set<Centre> centres) {
        this.centres = centres;
    }

    public void addCentre(Centre centre){
        this.centres.add(centre);
    }
}