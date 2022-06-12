package ar.edu.unlp.info.bd2.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SupportStaff")
public class SupportStaff extends Staff {
    @Column
    private String area;

    public SupportStaff() {
    }

    public SupportStaff(String dni, String fullName, String area) {
        super(fullName, dni);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
