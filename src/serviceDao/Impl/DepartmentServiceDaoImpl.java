package serviceDao.Impl;

import db.Datebas;
import moleds.Department;
import moleds.Doctor;
import moleds.Hospital;
import serviceDao.DepartmentServiceDao;
import serviceDao.GenericServiceDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepartmentServiceDaoImpl implements DepartmentServiceDao, GenericServiceDao<Department>{
    private Datebas datebas;
    private Long id = 1L;

    public DepartmentServiceDaoImpl(Datebas datebas) {
        this.datebas = datebas;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) { // Оорукананын бардык бөлүмүн алуу
            for(Hospital hospital : datebas.getHospitals()){
                try {
                    if (hospital.getId() == id){
                        return hospital.getDepartments();
                    }
                }catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }

            }
        System.out.println("Hospital with ID " + id + " not found.");
        return Collections.emptyList(); // Бош тизмени кайтаруу
    }


    @Override
    public Department findDepartmentByName(String name) { // Аты боюнча бөлүмдү табыңыз
        for (Hospital hospital : datebas.getHospitals()){
            for (Department department : hospital.getDepartments()){
                try{
                    if (department.getDepartmentName().equals(name)){
                        return department;
                    }
                }catch (Exception e){
                System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }


    @Override
    public String add(Long hospitalId, Department department) {
        department.setId(id++);
        for (Hospital hospital : datebas.getHospitals() ){
            try {
                if(hospital.getId().equals(hospitalId)){
                    if (hospital.getDepartments() == null) {
                        hospital.setDepartments(new ArrayList<>());
                    }
                    hospital.getDepartments().add(department);
                    return "Department successfully added to hospital with ID " + hospitalId;


                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return "";
    }

    @Override
    public void removeById(Long id) { // Id боюнча алып салуу
        for (Hospital hospital : datebas.getHospitals()){
            for (Department department : hospital.getDepartments()){
                try {
                    if(department.getId().equals(id)){
                        datebas.getDepartments().remove(department);
                        System.out.println(department);
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
//        System.out.println(id + "not found");
    }

    @Override
    public String updateById(Long id, Department department) {
        for (Hospital hospital : datebas.getHospitals()){
            for (Department depart : hospital.getDepartments()){
                try {
                    if (depart.getId().equals(id)) {
                        depart.setDepartmentName(department.getDepartmentName());
                    }
                }catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }
        }
        return "";
    }
}
