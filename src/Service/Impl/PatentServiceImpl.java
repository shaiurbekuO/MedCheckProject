package Service.Impl;

import Service.GenericService;
import Service.PatentService;
import db.Datebas;
import moleds.Hospital;
import moleds.Patient;
import serviceDao.Impl.PatientServiceDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PatentServiceImpl implements PatentService, GenericService<Patient> {
    private PatientServiceDaoImpl patientServiceDao;
    private Datebas datebas;
    private Long id = 1L;

    public PatentServiceImpl(PatientServiceDaoImpl patientServiceDao, Datebas datebas) {
        this.patientServiceDao = new PatientServiceDaoImpl(datebas);
        this.datebas = datebas;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        patient.setId(id++);
        return patientServiceDao.add(hospitalId, patient);
    }

    @Override
    public void removeById(Long id) {
        patientServiceDao.removeById(id);

    }

    @Override
    public String updateById(Long id, Patient patient) {
        return patientServiceDao.updateById(id, patient);
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientServiceDao.addPatientsToHospital(id, patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientServiceDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return patientServiceDao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientServiceDao.sortPatientsByAge(ascOrDesc);
    }
}
