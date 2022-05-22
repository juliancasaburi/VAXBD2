package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "Centre")
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            // default table name
            joinColumns = @JoinColumn(name = "centre_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Staff> staffs = new HashSet<>();

    public Centre() {
    }

    public Centre(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public void addStaff(Staff staff) {
        staffs.add(staff);
        staff.addCentre(this);
    }
}