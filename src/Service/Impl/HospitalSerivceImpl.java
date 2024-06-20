package Service.Impl;

import Service.HospitalService;
import db.Datebas;
import moleds.Hospital;
import moleds.Patient;
import serviceDao.Impl.HospitalServiceDaoImpl;

import java.util.List;
import java.util.Map;

public class HospitalSerivceImpl implements HospitalService {
    private HospitalServiceDaoImpl haspitalDao;
    private Datebas datebas;
    private Long id = 1L;

    public HospitalSerivceImpl(HospitalServiceDaoImpl haspitalDao, Datebas datebas) {
        this.haspitalDao = new HospitalServiceDaoImpl(datebas);
        this.datebas = datebas;
    }

    @Override
    public String addHospital(Hospital hospital) {
        hospital.setId(id++);
      return haspitalDao.addHospital(hospital);

    }

    @Override
    public Hospital findHospitalById(Long id) {
        return haspitalDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
      return haspitalDao.getAllHospital();

    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {

        return haspitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {

        return haspitalDao.deleteHospitalById(id);
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return haspitalDao.getAllHospitalByAddress(address);
    }
}
