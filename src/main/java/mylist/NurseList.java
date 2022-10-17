package mylist;

import java.util.ArrayList;

import model.Nurse;

public class NurseList {
	private ArrayList<Nurse> lstNurse;

	public NurseList() {
		lstNurse = new ArrayList<>();
	}

	public int add(Nurse nurse) {
		try {
			lstNurse.add(nurse);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public ArrayList<Nurse> getLstNurse() {
		return this.lstNurse;
	}
}
