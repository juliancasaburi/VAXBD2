package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SpringDataVaxService implements VaxService {

    /* Repositories */
    @Autowired
    private CentreRepository centreRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private ShotCertificateRepository shotCertificateRepository;

    @Autowired
    private ShotRepository shotRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private SupportStaffRepository supportStaffRepository;

    @Autowired
    private VaccinationScheduleRepository vaccinationScheduleRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    /* TP1 Methods */

    @Transactional
    @Override
    public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
        Patient patient = new Patient(email, password, fullname, dayOfBirth);
        try {
            patientRepository.save(patient);
            return patient;
        } catch (DataIntegrityViolationException e) {
            throw new VaxException("Constraint Violation");
        }
    }

    @Transactional
    @Override
    public Vaccine createVaccine(String name) throws VaxException {
        Vaccine vaccine = new Vaccine(name);
        try {
            vaccineRepository.save(vaccine);
            return vaccine;
        } catch (DataIntegrityViolationException e) {
            throw new VaxException("Constraint Violation");
        }
    }

    @Transactional
    @Override
    public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
        Shot shot = new Shot(patient, vaccine, date, centre, nurse);
        try {
            shotRepository.save(shot);
            return shot;
        } catch (DataIntegrityViolationException e) {
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public Optional<Patient> getPatientByEmail(String email) {
        return this.patientRepository.findPatientByEmail(email);
    }

    @Override
    public Optional<Vaccine> getVaccineByName(String name) {
        return this.vaccineRepository.findVaccineByName(name);
    }

    @Transactional
    @Override
    public Centre createCentre(String name) throws VaxException {
        Centre centre = new Centre(name);
        try {
            centreRepository.save(centre);
            return centre;
        } catch (DataIntegrityViolationException e) {
            throw new VaxException("Constraint Violation");
        }
    }

    @Transactional
    @Override
    public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
        Nurse nurse = new Nurse(dni, fullName, experience);
        try {
            nurseRepository.save(nurse);
            return nurse;
        } catch (DataIntegrityViolationException e) {
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        return null;
    }

    @Override
    public VaccinationSchedule createVaccinationSchedule() throws VaxException {
        return null;
    }

    @Override
    public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
        return null;
    }

    @Override
    public Optional<Centre> getCentreByName(String name) {
        return this.centreRepository.findCentreByName(name);
    }

    @Override
    public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
        return null;
    }

    @Override
    public Centre updateCentre(Centre centre) throws VaxException {
        return null;
    }

    @Override
    public Optional<SupportStaff> getSupportStaffByDni(String dni) {
        return Optional.empty();
    }

    /* TP2 Methods */

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        return null;
    }

    @Override
    public List<Centre> getCentresTopNStaff(int n) {
        return null;
    }

    @Override
    public Centre getTopShotCentre() {
        return null;
    }

    @Override
    public List<Nurse> getNurseNotShot() {
        return null;
    }

    @Override
    public String getLessEmployeesSupportStaffArea() {
        return null;
    }

    @Override
    public List<Staff> getStaffWithName(String name) {
        return null;
    }

    @Override
    public List<Vaccine> getUnappliedVaccines() {
        return null;
    }

    @Override
    public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule vaccinationSchedule) throws VaxException {
        return null;
    }
}
