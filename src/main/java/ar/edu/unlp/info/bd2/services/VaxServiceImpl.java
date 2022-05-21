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

	@Transactional
	@Override
	public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
		Patient patient = new Patient(email, password, fullname, dayOfBirth);
		repository.save(patient);
		return patient;
	}

	@Transactional
	@Override
	public Vaccine createVaccine(String name) throws VaxException{
		Vaccine vaccine = new Vaccine(name);
		repository.save(vaccine);
		return vaccine;
	}

	@Transactional
	@Override
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException{
		Shot shot = new Shot(patient, vaccine, date, centre, nurse);
		repository.save(shot);
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
		repository.save(centre);
		return centre;
	}

	@Transactional
	@Override
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException{
		Nurse nurse = new Nurse(dni, fullName, experience);
		repository.save(nurse);
		return nurse;
	}

	@Transactional
	@Override
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException{
		SupportStaff supportStaff = new SupportStaff(dni, fullName, area);
		repository.save(supportStaff);
		return supportStaff;
	}

	@Transactional
	@Override
	public VaccinationSchedule createVaccinationSchedule() throws VaxException{
		VaccinationSchedule vaccinationSchedule = new VaccinationSchedule();
		repository.save(vaccinationSchedule);
		return vaccinationSchedule;
	}

	@Override
	public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException{
		return this.repository.findVaccinationScheduleById(id);
	}

	@Override
	public Optional<Centre> getCentreByName(String name){
		return Optional.ofNullable(this.repository.findCentreByName(name));
	}

	@Transactional
	@Override
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException{
		repository.save(staff);
		return staff;
	}

	@Transactional
	@Override
	public Centre updateCentre(Centre centre) throws VaxException {
		repository.save(centre);
		return centre;
	}

	@Override
	public Optional<SupportStaff> getSupportStaffByDni(String dni){
		return Optional.ofNullable(this.repository.findSupportStaffByDni(dni));
	}
}
