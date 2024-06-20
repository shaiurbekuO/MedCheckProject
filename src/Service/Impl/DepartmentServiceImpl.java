package Service.Impl;

import Service.DepartmentService;
import Service.GenericService;
import db.Datebas;
import moleds.Department;
import serviceDao.DepartmentServiceDao;
import serviceDao.Impl.DepartmentServiceDaoImpl;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService, GenericService<Department>{
    private DepartmentServiceDaoImpl departmentServiceDao;
    private Datebas datebas;
    private Long id = 1L;

    public DepartmentServiceImpl(DepartmentServiceDao department, Datebas datebas) {
        this.departmentServiceDao = new DepartmentServiceDaoImpl(datebas);
        this.datebas = datebas;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return departmentServiceDao.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return  departmentServiceDao.findDepartmentByName(name);

    }

    @Override
    public String add(Long hospitalId, Department department) {
        department.setId(id++);
        return departmentServiceDao.add(hospitalId,department);
    }

    @Override
    public void removeById(Long id) {
        departmentServiceDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Department department) {
      return   departmentServiceDao.updateById(id, department);

    }

}
