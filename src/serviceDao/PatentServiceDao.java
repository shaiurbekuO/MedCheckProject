package serviceDao;

import moleds.Patient;

import java.util.List;
import java.util.Map;

public interface PatentServiceDao {
    String addPatientsToHospital(Long id,List<Patient> patients);
    Patient getPatientById(Long id);
    Map<Integer, Patient> getPatientByAge();
    List<Patient> sortPatientsByAge(String ascOrDesc);
}
