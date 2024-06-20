package db;

import moleds.Department;
import moleds.Doctor;
import moleds.Hospital;
import moleds.Patient;

import java.util.ArrayList;


public class Datebas {
    private ArrayList<Department> departments = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Hospital> hospitals = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();

    public ArrayList<Hospital> getHospitals() {return hospitals;}

    public void setHospitals(ArrayList<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
}
