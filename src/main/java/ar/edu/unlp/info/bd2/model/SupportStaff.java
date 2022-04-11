package ar.edu.unlp.info.bd2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SupportStaff")
public class SupportStaff extends Staff {
    @Column(nullable=false)
    private String area;

    public SupportStaff() {
    }

    public SupportStaff(String dni, String fullName, String area) {
        super(dni, fullName);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
