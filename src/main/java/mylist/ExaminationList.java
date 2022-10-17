package mylist;

import java.util.ArrayList;

import model.Examination;

public class ExaminationList {
	private ArrayList<Examination> lstExamination;

	public ExaminationList() {
		lstExamination = new ArrayList<>();
	}

	public int add(Examination Examination) {
		try {
			lstExamination.add(Examination);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public ArrayList<Examination> getLstExamination() {
		return this.lstExamination;
	}
}
