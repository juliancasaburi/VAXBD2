package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.config.SpringDataConfiguration;
import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@Rollback(true)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {SpringDataConfiguration.class},
        loader = AnnotationConfigContextLoader.class)
public class VaxServiceCustomTestCase {

    @Autowired
    VaxService service;

    @Test
    public void testCascadeCentre() throws VaxException{
        Centre nuevo = this.service.createCentre("Calle 2");
        Nurse fabian = this.service.createNurse("43142333", "Fabian Ayala", 4);
        nuevo.addStaff(fabian);
        assertNotNull(nuevo.getId());
        Optional<Centre> calle2Saved = this.service.getCentreByName("Calle 2");
        if (!calle2Saved.isPresent()){throw new VaxException("No existe el centro con ese nombre");};
        Centre calle2 = calle2Saved.get();
        assertEquals("Calle 2", calle2.getName());
        assertTrue(calle2.getStaffs().contains(fabian));
        assertTrue(fabian.getCentres().contains(calle2));

        // Centre Persist cascade
        SupportStaff newStaff = new SupportStaff("12345", "cascade", "unArea");
        calle2.addStaff(newStaff);
        this.service.updateCentre(calle2);

        Optional<SupportStaff> newStaffSaved = this.service.getSupportStaffByDni("12345");
        if (!newStaffSaved.isPresent()){throw new VaxException("No existe el SupportStaff con ese id");};
        assertTrue(calle2.getStaffs().contains(newStaffSaved.get()));

        // Centre Update cascade
        Set<Staff> staffs = calle2.getStaffs();
        Optional<Staff> cascadeStaff = staffs.stream().filter(n -> n.getFullName().equals("cascade")).
                findFirst();
        cascadeStaff.get().setFullName("otro nombre");
        this.service.updateCentre(calle2);
        Optional<SupportStaff> cascadeSaved = this.service.getSupportStaffByDni("12345");
        if (!cascadeSaved.isPresent()){throw new VaxException("No existe el SupportStaff con ese id");};
        assertEquals(cascadeSaved.get().getFullName(), "otro nombre");
    }

}
