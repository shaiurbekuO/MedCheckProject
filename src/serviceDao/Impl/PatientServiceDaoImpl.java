package serviceDao.Impl;

import db.Datebas;
import moleds.Department;
import moleds.Doctor;
import moleds.Hospital;
import moleds.Patient;
import serviceDao.GenericServiceDao;
import serviceDao.PatentServiceDao;

import java.util.*;

public class PatientServiceDaoImpl implements PatentServiceDao, GenericServiceDao<Patient> {
    private Datebas datebas;
    private Long id = 1L;

    public PatientServiceDaoImpl(Datebas datebas) {
        this.datebas = datebas;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        patient.setId(id++);
        for (Hospital hospital : datebas.getHospitals()) {
            try {
                if (hospital.getId().equals(hospitalId)) {
                    if (hospital.getDoctors() == null) {
                        hospital.setPatients(new ArrayList<>());
                    }
                    hospital.getPatients().add(patient);
                    return "Patient successfully added to hospital with ID "+hospitalId;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return "Failed to add doctor due to an error: " + e.getMessage();
            }
        }
        return "Hospital with ID " + patient + " not found.";

    }

    @Override
    public void removeById(Long id) {
        for (Patient patient : datebas.getPatients()){
            try {
                if(patient.getId().equals(id)){
                    datebas.getDepartments().remove(patient);
                    System.out.println(patient);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(id+"not found");
    }

    @Override
    public String updateById(Long id, Patient patient) {
        for (Hospital hospital : datebas.getHospitals()){
            for (Patient patient1 : hospital.getPatients()){
                try {
                    if (patient1.getId().equals(id)){
                        patient1.setFirstName(patient.getFirstName());
                        patient1.setLastName(patient.getLastName());
                        patient1.setAge(patient.getAge());
                        patient1.setGender(patient.getGender());
                    }
                }catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }
        }
        return "Error Patient ";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) { // Бейтаптарды ооруканага кошуу
        for (Hospital hospital : datebas.getHospitals()){
            if (hospital.getId().equals(id)){
                hospital.getPatients().addAll(patients);
                return "Patients added to hospital successfully.";
            }
        }
        return "Error added";
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Patient patient : datebas.getPatients()){
            try {
                if (patient.getId().equals(id)){
                    return patient;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        Map<Integer, Patient> patientsByAge = new HashMap<>();
        for (Patient patient : datebas.getPatients()) {
            patientsByAge.put(patient.getAge(), patient);
        }
        return patientsByAge;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
            List<Patient> patients = new ArrayList<>(datebas.getPatients());
            try {
                if ("asc".equalsIgnoreCase(ascOrDesc)){
                    patients.sort(Comparator.comparing(Patient::getAge));
                } else if ("desc".equalsIgnoreCase(ascOrDesc)) {
                    patients.sort(Comparator.comparing(Patient::getAge).reversed());
                }else {
                    System.out.println("Invalid sort order: " + ascOrDesc);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        return patients;
    }
}
