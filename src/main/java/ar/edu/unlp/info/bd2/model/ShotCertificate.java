package ar.edu.unlp.info.bd2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "shot_certificate")
public class ShotCertificate {

    @PrePersist
    public void initializeUUID() {
        if (serialNumber == null) {
            serialNumber = UUID.randomUUID();
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", updatable = false, nullable = false)
    private UUID serialNumber;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    public ShotCertificate() {
    }

    public ShotCertificate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public UUID getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(UUID serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}