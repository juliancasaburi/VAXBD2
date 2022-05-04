package ar.edu.unlp.info.bd2.services;
import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import ar.edu.unlp.info.bd2.model.Staff;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import ar.edu.unlp.info.bd2.repositories.VaxException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import ar.edu.unlp.info.bd2.repositories.VaxRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VaxServiceImpl implements VaxService{

	@Autowired
	private VaxRepository repository;

	public VaxServiceImpl(VaxRepository repository) {
		this.repository = repository;
	}

	/* TP1 Methods */

	@Transactional
	@Override
	public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
		Patient patient = new Patient(email, password, fullname, dayOfBirth);
		try {
			repository.save(patient);
		}
		catch(ConstraintViolationException e) {
			throw new VaxException("Constraint Violation");
		}
		return patient;
	}

	@Transactional
	@Override
	public Vaccine createVaccine(String name) throws VaxException{
		Vaccine vaccine = new Vaccine(name);
		try {
			repository.save(vaccine);
		}
		catch(ConstraintViolationException e) {
			throw new VaxException("Constraint Violation");
		}
		return vaccine;
	}

	@Transactional
	@Override
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException{
		Shot shot = new Shot(patient, vaccine, date, centre, nurse);
		try {
			repository.save(shot);
		}
		catch(ConstraintViolationException e) {
			throw new VaxException("Constraint Violation");
		}
		return shot;
	}

	@Override
	public Optional<Patient> getPatientByEmail(String email){
		return Optional.ofNullable(this.repository.findPatientByEmail(email));
	}

	@Override
	public Optional<Vaccine> getVaccineByName(String name){
		return Optional.ofNullable(this.repository.findVaccineByName(name));
	}

	@Transactional
	@Override
	public Centre createCentre(String name) throws VaxException{
		Centre centre = new Centre(name);
		try {
			repository.save(centre);
		}
		catch(ConstraintViolationException e) {
			throw new VaxException("Constraint Violation");
		}
		return centre;
	}

	@Transactional
	@Override
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException{
		Nurse nurse = new Nurse(dni, fullName, experience);
		try {
			repository.save(nurse);
		}
		catch(ConstraintViolationException e) {
			throw new VaxException("Constraint Violation");
		}
		return nurse;
	}

	@Transactional
	@Override
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException{
		SupportStaff supportStaff = new SupportStaff(dni, fullName, area);
		try {
			repository.save(supportStaff);
		}
		catch(ConstraintViolationException e) {
			throw new VaxException("Constraint Violation");
		}
		return supportStaff;
	}

	@Transactional
	@Override
	public VaccinationSchedule createVaccinationSchedule() throws VaxException{
		VaccinationSchedule vaccinationSchedule = new VaccinationSchedule();
		try {
			repository.save(vaccinationSchedule);
		}
		catch (ConstraintViolationException e){
			throw new VaxException("Constraint Violation");
		}
		return vaccinationSchedule;
	}

	@Override
	public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException{
		return this.repository.findVaccinationScheduleById(id);
	}

	@Override
	public Optional<Centre> getCentreByName(String name) throws VaxException{
		return Optional.ofNullable(this.repository.findCentreByName(name));
	}

	@Transactional
	@Override
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException{
		return null;
	}

	@Transactional
	@Override
	public Centre updateCentre(Centre centre) {
		repository.save(centre);
		return centre;
	}

	@Override
	public Optional<SupportStaff> getSupportStaffByDni(String dni){
		return Optional.ofNullable(this.repository.findSupportStaffByDni(dni));
	}

	/* TP2 Methods */

	@Override
	public List<Patient> getAllPatients(){
		return this.repository.findAllPatients();
	}

	@Override
	public List<Nurse> getNurseWithMoreThanNYearsExperience(int years){
		return this.repository.findNurseWithMoreThanNYearsExperience();
	}

	@Override
	public List<Centre> getCentresTopNStaff(int n){
		return null;
	}

	@Override
	public Centre getTopShotCentre(){
		return null;
	}

	@Override
	public List<Nurse> getNurseNotShot(){
		return null;
	}

	@Override
	public String getLessEmployeesSupportStaffArea(){
		return null;
	}

	@Override
	public List<Staff> getStaffWithName(String name){
		return null;
	}

	@Override
	public List<Vaccine> getUnappliedVaccines(){
		return null;
	}

	@Override
	public List <ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate){
		return null;
	}

	@Transactional
	@Override
	public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule vaccinationSchedule) {
		repository.save(vaccinationSchedule);
		return vaccinationSchedule;
	}
}
