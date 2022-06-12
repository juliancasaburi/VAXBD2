package ar.edu.unlp.info.bd2.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Nurse")
public class Nurse extends Staff {
    @Column
    private Integer experience;

    public Nurse() {
    }

    public Nurse(String dni, String fullName, Integer experience) {
        super(fullName, dni);
        this.experience = experience;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }
}
