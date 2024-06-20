package Service.Impl;

import Service.DoctorService;
import Service.GenericService;
import db.Datebas;
import moleds.Doctor;
import serviceDao.Impl.DoctorServiceDaoImpl;

import java.util.List;

public class DoctorServiceImpl implements DoctorService, GenericService<Doctor> {
    private DoctorServiceDaoImpl doctorServiceDao;
    private Datebas datebas;
    private Long id = 1L;

    public DoctorServiceImpl(DoctorServiceDaoImpl departmentServiceDao, Datebas datebas) {
        this.doctorServiceDao = new DoctorServiceDaoImpl(datebas);
        this.datebas = datebas;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorServiceDao.findDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return doctorServiceDao.assignDoctorToDepartment(departmentId, doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorServiceDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return getAllDoctorsByHospitalId(id);
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        doctor.setId(id++);
        return doctorServiceDao.add(hospitalId, doctor);
    }

    @Override
    public void removeById(Long id) {
        doctorServiceDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        return doctorServiceDao.updateById(id, doctor);
    }
}
