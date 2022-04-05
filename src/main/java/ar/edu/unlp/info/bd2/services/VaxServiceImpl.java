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
		Patient patient = new Patient(email, fullname, password, dayOfBirth);
		try {
			repository.save(patient);
		}
		catch(ConstraintViolationException e) {
			throw new VaxException("Constraint Violation");
		}
		return patient;
	}

	/**
	 *
	 * @param name nombre de la vacuna
	 * @return la vacuna creada
	 * @throws VaxException
	 */
	public Vaccine createVaccine(String name) throws VaxException{
		return null;
	}

	/**
	 *
	 * @param patient paciente vacunado
	 * @param vaccine vacuna aplicada
	 * @param date fecha de aplicación
	 * @param centre el centro de vacunación donde se aplicó
	 * @param nurse enfermero/a que aplico la vacuna
	 * @return el usuario creado
	 * @throws VaxException
	 */
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException{
		return null;
	}


	/**
	 *
	 * @param email email del usuario
	 * @return
	 */
	public Optional<Patient> getPatientByEmail(String email){
		return null;
	}


	/**
	 *
	 * @param name nombre de la vacuna
	 * @return
	 */
	public Optional<Vaccine> getVaccineByName(String name){
		return null;
	}

	/**
	 *
	 * @param name nombre del centro de vacunación
	 * @return el centro de vacunación nuevo
	 * @throws VaxException
	 */
	public Centre createCentre(String name) throws VaxException{
		return null;
	}

	/**
	 * @param dni el dni
	 * @param fullName nombre del/la enfermero/a
	 * @param experience experiencia en años
	 * @return el enfermero creado
	 * @throws VaxException
	 */
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException{
		return null;
	}

	/**
	* @param dni el dni
	* @param fullName nombre completo
	* @param area el area o areas de trabajo
	* @return el personal de apoyo creado
	* @throws VaxException
	* */
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException{
		return null;
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

	/**
	 * @param name el nombre del centro a buscar
	 * @return el centro
	 * */
	public Optional<Centre> getCentreByName(String name) throws VaxException{
		return null;
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
