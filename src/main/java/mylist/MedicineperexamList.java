package mylist;

import java.util.ArrayList;

import model.Medicineperexam;

public class MedicineperexamList {
	private ArrayList<Medicineperexam> lstMedicineperexam;

	public MedicineperexamList() {
		lstMedicineperexam = new ArrayList<>();
	}

	public int add(Medicineperexam Medicineperexam) {
		try {
			lstMedicineperexam.add(Medicineperexam);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public ArrayList<Medicineperexam> getLstMedicineperexam() {
		return this.lstMedicineperexam;
	}
}
