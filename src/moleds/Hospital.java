package moleds;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private Long id;
    private String hospitalName;
    private String address;
    private List<Department> departments = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public Hospital(String hospitalName, String hospitalAddress) {
    }

    public Hospital() {
    }

    public Hospital(Long id, String hospitalName, String address) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
    }

    public Hospital(Long id, String hospitalName, String address, List<Department> departments, List<Doctor> doctors, List<Patient> patients) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departments = departments;
        this.doctors = doctors;
        this.patients = patients;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName(Hospital hospital) {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nHospital " +
                "id: " + id +
                " hospitalName: " + hospitalName +
                " address: " + address +
                " departments: " + departments +
                " doctors: " + doctors +
                " patients: " + patients;
    }
}
