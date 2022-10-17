package mylist;

import java.util.ArrayList;

import model.Doctor;

public class DoctorList {
	private ArrayList<Doctor> lstDoctor;
	
	public DoctorList() {
		lstDoctor = new ArrayList<>();
	}
	
	public int add(Doctor doctor) {
		try {
			lstDoctor.add(doctor);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public ArrayList<Doctor> getLstDoctor(){
		return this.lstDoctor;
	}
}	
