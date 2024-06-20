import Service.Impl.DepartmentServiceImpl;
import Service.Impl.DoctorServiceImpl;
import Service.Impl.HospitalSerivceImpl;
import Service.Impl.PatentServiceImpl;
import db.Datebas;
import enums.Gender;
import moleds.Department;
import moleds.Doctor;
import moleds.Hospital;
import moleds.Patient;
import serviceDao.Impl.DepartmentServiceDaoImpl;
import serviceDao.Impl.DoctorServiceDaoImpl;
import serviceDao.Impl.HospitalServiceDaoImpl;
import serviceDao.Impl.PatientServiceDaoImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Datebas datebas = new Datebas();
        HospitalServiceDaoImpl hospitalServiceDao = new HospitalServiceDaoImpl(datebas);
        DepartmentServiceDaoImpl departmentServiceDao = new DepartmentServiceDaoImpl(datebas);
        DoctorServiceDaoImpl doctorServiceDao = new DoctorServiceDaoImpl(datebas);
        PatientServiceDaoImpl patientServiceDao = new PatientServiceDaoImpl(datebas);

        HospitalSerivceImpl hospitalService = new HospitalSerivceImpl(hospitalServiceDao, datebas);
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl(departmentServiceDao, datebas);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorServiceDao, datebas);
        PatentServiceImpl patentService = new PatentServiceImpl(patientServiceDao, datebas);

        ArrayList<Department> departments = new ArrayList<>(List.of(
                new Department("1. Кан бөлүмү"),
                new Department("2. Лор бөлүмү"),
                new Department("3. терапевт бөлүмү")
        ));
        // Департаменттерге IDлерди кошуу
        departments.get(0).setId(1L);
        departments.get(1).setId(2L);
        departments.get(2).setId(3L);

        Hospital hospital = new Hospital();
        hospital.setDepartments(departments);

        Doctor doctor1 = new Doctor(1L, "Test", "Test", Gender.MALE, 2);
        Doctor doctor2 = new Doctor(2L, "Test2", "Test", Gender.MALE, 3);
        Doctor doctor3 = new Doctor(3L, "Test3", "Test", Gender.MALE, 5);
        List<Long> doctorsId = new ArrayList<>(List.of(doctor1.getId(), doctor2.getId(), doctor3.getId()));

        hospital.setDoctors(new ArrayList<>(List.of(doctor1, doctor2, doctor3)));
        datebas.setHospitals(new ArrayList<>(List.of(hospital)));

        String result = doctorService.assignDoctorToDepartment(1L, doctorsId);
        System.out.println(result); // "Success"

        ArrayList<Patient> patients = new ArrayList<>(List.of(
                new Patient("Omurbek", "Shayrbek uulu", 22, Gender.MALE),
                new Patient("Mirbek", "Rustamov", 25, Gender.MALE),
                new Patient("Sezim", "Nurbekova", 22, Gender.FEMALE)
        ));
        Hospital hospital1 = new Hospital(1L,"Hospital","bishkek");
        hospitalService.addHospital(hospital1);
        doctorService.add(1L, doctor1);
        doctorService.add(1L, doctor2);
        doctorService.add(1L, doctor3);
        departmentService.add(1L, departments.get(0));
        departmentService.add(1L, departments.get(1));
        departmentService.add(1L, departments.get(2));
        patentService.add(1L, patients.get(0));
        patentService.add(1L, patients.get(1));
        patentService.add(1L, patients.get(2));
//        System.out.println(hospitalService.findHospitalById(1L));
//        System.out.println(hospitalService.deleteHospitalById(1L));
//        System.out.println(hospitalService.getAllHospitalByAddress("bishkek"));
//        System.out.println(hospitalService.getAllPatientFromHospital(2L));
//        System.out.println(departmentService.getAllDepartmentByHospital(1L));
//        System.out.println(doctorService.getAllDoctorsByDepartmentId(1L));
//        doctorService.removeById(1L);
//        doctorService.updateById(2L, new Doctor("fds","dsfs",Gender.MALE, 12));
//        System.out.println(doctorService.getAllDoctorsByHospitalId(1L));
//        System.out.println(doctorService.getAllDoctorsByDepartmentId(1L));
//        departmentService.removeById(1L);
//        System.out.println(departmentService.getAllDepartmentByHospital(1L));
//        System.out.println(departmentService.updateById(1L, new Department("4 Bolum")));
//        departmentService.findDepartmentByName()
//        doctorService.assignDoctorToDepartment(1L, 2L);
//        System.out.println(doctorService.findDoctorById(1L));



        System.out.println(hospitalService.getAllHospital());

//

    }
}