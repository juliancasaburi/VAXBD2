package ar.edu.unlp.info.bd2.services;
import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import ar.edu.unlp.info.bd2.repositories.VaxException;

import java.util.Date;
import java.util.Optional;

import ar.edu.unlp.info.bd2.repositories.VaxRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class VaxServiceImpl implements VaxService{

	@Autowired
	private VaxRepository repository;

	public VaxServiceImpl(VaxRepository repository) {
		this.repository = repository;
	}

	@Transactional
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

	public Optional<Patient> getPatientByEmail(String email){
		return Optional.ofNullable(this.repository.findPatientByEmail(email));
	}

	public Optional<Vaccine> getVaccineByName(String name){
		return Optional.ofNullable(this.repository.findVaccineByName(name));
	}

	@Transactional
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

	/**
	 * @return el esquema nueva vacío
	 * @throws VaxException
	 * */
	public VaccinationSchedule createVaccinationSchedule() throws VaxException{
		return null;
	}

	/**
	 * @param id el id del esquema
	 * @return el esquema de vacunación
	 * */
	public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException{
		return null;
	}

	public Optional<Centre> getCentreByName(String name) throws VaxException{
		return Optional.ofNullable(this.repository.findCentreByName(name));
	}

	/**
	 * @param staff el staff a actualizar
	 * @return el staff
	 * @throws VaxException
	 */
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException{
		return null;
	}

	/**
	 * @param centre el centre a actualizar
	 * @return el centre
	 * @throws VaxException
	 */
	public Centre updateCentre(Centre centre){
		return null;
	}

	/**
	 * @param dni el dni del SupportStaff a buscar
	 * @return el SupportStaff
	 * */
	public Optional<SupportStaff> getSupportStaffByDni(String dni){
		return null;
	}
}
