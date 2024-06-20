package serviceDao.Impl;

import db.Datebas;
import moleds.Department;
import moleds.Doctor;
import moleds.Hospital;
import serviceDao.DoctorServiceDao;
import serviceDao.GenericServiceDao;

import javax.print.PrintException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoctorServiceDaoImpl implements DoctorServiceDao, GenericServiceDao<Doctor> {
    private Datebas datebas;
    private Long id = 1L;

    public DoctorServiceDaoImpl(Datebas datebas) {
        this.datebas = datebas;
    }

    @Override
    public Doctor findDoctorById(Long id) { // Аты боюнча бөлүмдү табыңыз
        for (Doctor doctor : datebas.getDoctors()){
            try {
                if (doctor.getId().equals(id)){
                    return doctor;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {

        for (Hospital hospital: datebas.getHospitals()){
            for (Department department: hospital.getDepartments()){
                if (department.getId().equals(departmentId)) {
                    if (department.getDoctors() == null){ department.setDoctors(new ArrayList<>());}
                        for (Doctor doctor : hospital.getDoctors()) {
                            if (doctorsId.contains(doctor.getId())) {
                                department.getDoctors().add(doctor);
                                return "Success";
                            }
                        }

                }
            }
        }
        return "";
    }

   /* @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital : datebas.getHospitals()){
            for (Department department : hospital.getDepartments()){
                try {
                    if (departmentId.equals(department.getId())){
                        if (department.getDoctors() == null) {
                            department.setDoctors(new ArrayList<>());
                        }
                        for (Doctor doctor: hospital.getDoctors()){
                            try {
                                if (doctorsId.contains(doctor.getId())){
                                    department.getDoctors().add(doctor);
                                    return "Successful!";
                                }
                            }catch (Exception e){
                                System.out.println("Doctor not fount! "+e.getMessage());
                            }
                        }
                    }
                }catch (Exception e){
                    System.out.println("Departments not fount "+e.getMessage());
                }
            }
        }
        return "";
    }*/


    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for(Hospital hospital : datebas.getHospitals()){
            try {
                if (hospital.getId().equals(id)){
                    return hospital.getDoctors();
                }
            }catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) { //Бөлүм ID боюнча бардык дарыгерлерди алыңыз
        for (Hospital hospital : datebas.getHospitals()){
            for (Department department : hospital.getDepartments()){
               try {
                   if (department.getId().equals(id)){
                       return department.getDoctors();
                   }
               }catch (Exception e){
                   System.out.println("Department with ID not found."+e.getMessage());
               }
            }
        }
//        System.out.println("Department with ID " + id + " not found.");
        return Collections.emptyList(); // Бош тизмени кайтаруу
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        doctor.setId(id++);
        for (Hospital hospital : datebas.getHospitals()) {
            try {
                if (hospital.getId().equals(hospitalId)) {
                    if (hospital.getDoctors() == null) {
                        hospital.setDoctors(new ArrayList<>());
                    }
                    hospital.getDoctors().add(doctor);
                    return "Doctor successfully added to hospital with ID " + hospitalId;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return "Failed to add doctor due to an error: " + e.getMessage();
            }
        }
        return "Hospital with ID " + hospitalId + " not found.";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital hospital : datebas.getHospitals()){
            for (Doctor doctor : hospital.getDoctors()){
                try {
                    if(doctor.getId().equals(id)){
                        datebas.getDepartments().remove(doctor);
                        System.out.println(doctor);
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println(id+"not found");
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        for (Hospital hospital : datebas.getHospitals()){
            for (Doctor doctorr : hospital.getDoctors()){
                try {
                    if (doctorr.getId().equals(id)) {
                        doctorr.setFirstName(doctor.getFirstName());
                        doctorr.setLastName(doctor.getLastName());
                        doctorr.setGender(doctor.getGender());
                        doctorr.setExperienceYear(doctor.getExperienceYear());
                    }
                }catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }
        }
        return "Error Doctor";
    }
}
