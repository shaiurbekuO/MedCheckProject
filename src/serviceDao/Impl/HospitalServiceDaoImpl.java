package serviceDao.Impl;
import db.Datebas;
import moleds.Hospital;
import moleds.Patient;
import serviceDao.HospitalServiceDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalServiceDaoImpl implements HospitalServiceDao {
    private  Datebas datebasDao;
    private Long id = 1L;

    public HospitalServiceDaoImpl(Datebas datebasDao) {
        this.datebasDao = datebasDao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        hospital.setId(id++);
        try {
            for(Hospital hos:datebasDao.getHospitals()){
                if (hos.getHospitalName(hospital).equals(hospital.getHospitalName(hospital))){
                    throw new RuntimeException("Myndai atta hospital bar");
                }
            }
            datebasDao.getHospitals().add(hospital);
        }catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
        } return "";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital hospital : datebasDao.getHospitals()) {
            try {
                if (hospital.getId().equals(id)) {
                    return hospital;
                }
            } catch (Exception e) {
                System.out.println("ID кайтадан киргизиңиз " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return datebasDao.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) { //Бардык бейтаптарды ооруканадан алуу
        for (Hospital hospital : datebasDao.getHospitals()){
            for (Patient patient : hospital.getPatients()){
                try {
                    if (patient.getId().equals(id)){
                        System.out.println(patient);
                    }
                }catch (Exception e){
                    System.out.println(" "+e.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        for (Hospital hospital : datebasDao.getHospitals()) {
            try {
                if (hospital.getId().equals(id)) {
                    datebasDao.getHospitals().remove(hospital);
//                    datebasDao.getHospitals().remove(hospital);
                    return "Оорукананы ийгиликтүү жок кылынды";
                }
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }
        return "Оорукананы өчүрүүдө ката кетти";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        List<Hospital> hospitals = datebasDao.getHospitals();
        Map<String, Hospital> hospitalByAddress = new HashMap<>();
        for (Hospital hospital : hospitals) {
            if (hospital.getAddress().equals(address)) {
                try {
                    hospitalByAddress.put(hospital.getHospitalName(hospital), hospital);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return hospitalByAddress;
    }
}
