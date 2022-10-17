package mylist;

import java.util.ArrayList;

import model.Medicine;

public class MedicineList {
	private ArrayList<Medicine> lstMedicine;

	public MedicineList() {
		lstMedicine = new ArrayList<>();
	}

	public int add(Medicine Medicine) {
		try {
			lstMedicine.add(Medicine);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public ArrayList<Medicine> getLstMedicine() {
		return this.lstMedicine;
	}
}
