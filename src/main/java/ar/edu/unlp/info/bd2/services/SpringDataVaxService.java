package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
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

    @Transactional
    @Override
    public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
        SupportStaff supportStaff = new SupportStaff(dni, fullName, area);
        try {
            supportStaffRepository.save(supportStaff);
            return supportStaff;
        } catch (DataIntegrityViolationException e) {
            throw new VaxException("Constraint Violation");
        }
    }

    @Transactional
    @Override
    public VaccinationSchedule createVaccinationSchedule() throws VaxException {
        VaccinationSchedule vaccinationSchedule = new VaccinationSchedule();
        try {
            vaccinationScheduleRepository.save(vaccinationSchedule);
            return vaccinationSchedule;
        } catch (DataIntegrityViolationException e) {
            throw new VaxException("Constraint Violation");
        }
    }

    @Override
    public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
        try {
            return this.vaccinationScheduleRepository.findVaccinationScheduleById(id);
        } catch (NoResultException e) {
            throw new VaxException(e.getMessage());
        }
    }

    @Override
    public Optional<Centre> getCentreByName(String name) {
        return this.centreRepository.findCentreByName(name);
    }

    @Transactional
    @Override
    public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
        return null;
    }

    @Transactional
    @Override
    public Centre updateCentre(Centre centre) throws VaxException {
        try {
            centreRepository.save(centre);
            return centre;
        } catch (Exception e) {
            throw new VaxException(e.getMessage());
        }
    }

    @Override
    public Optional<SupportStaff> getSupportStaffByDni(String dni) {
        return this.supportStaffRepository.findSupportStaffByDni(dni);
    }

    /* TP2 Methods */

    @Override
    public List<Patient> getAllPatients() {
        return this.patientRepository.findAll();
    }

    @Override
    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        return this.nurseRepository.findByExperienceGreaterThan(years);
    }

    @Override
    public List<Centre> getCentresTopNStaff(int n) {
        Pageable pageable = PageRequest.of(0, n);
        return this.centreRepository.getCentresTopNStaff(pageable);
    }

    @Override
    public Centre getTopShotCentre() {
        Pageable pageable = PageRequest.of(0, 1);
        List<Centre> topCentres = this.centreRepository.getTopShotCentre(pageable);
        return topCentres.get(0);
    }

    @Override
    public List<Nurse> getNurseNotShot() {
        return this.nurseRepository.getNurseNotShot();
    }

    @Override
    public String getLessEmployeesSupportStaffArea() {
        Pageable pageable = PageRequest.of(0, 1);
        List<String> areas = this.supportStaffRepository.getLessEmployeesSupportStaffArea(pageable);
        return areas.get(0);
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

    @Transactional
    @Override
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule vaccinationSchedule) throws VaxException {
        return null;
    }
}
