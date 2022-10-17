package mylist;

import java.util.ArrayList;

import model.DoctorDiseases;

public class DoctorDiseasesList {
	private ArrayList<DoctorDiseases> lstDoctorDiseases;
	
	public DoctorDiseasesList() {
		lstDoctorDiseases = new ArrayList<>();
	}
	
	public int add(DoctorDiseases DoctorDiseases) {
		try {
			lstDoctorDiseases.add(DoctorDiseases);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public ArrayList<DoctorDiseases> getLstDoctorDiseases(){
		return this.lstDoctorDiseases;
	}
}
