package mylist;

import java.util.ArrayList;

import model.Patient;

public class PatientList {
	private ArrayList<Patient> lstPatient;

	public PatientList() {
		lstPatient = new ArrayList<>();
	}

	public int add(Patient Patient) {
		try {
			lstPatient.add(Patient);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public ArrayList<Patient> getLstPatient() {
		return this.lstPatient;
	}
}
