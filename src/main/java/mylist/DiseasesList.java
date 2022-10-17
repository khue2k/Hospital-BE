package mylist;

import java.util.ArrayList;

import model.Diseases;

public class DiseasesList {
	private ArrayList<Diseases> lstDiseases;
	
	public DiseasesList() {
		lstDiseases = new ArrayList<>();
	}
	
	public int add(Diseases Diseases) {
		try {
			lstDiseases.add(Diseases);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public ArrayList<Diseases> getLstDiseases(){
		return this.lstDiseases;
	}
}
