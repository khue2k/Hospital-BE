package model;

public class Examination {
	private int idexamination;
	private int iddoctordiseases;
	private int idnurse;
	private int idpatient;
	private String dayin;
	private String dayout;
	private String type;

	public Examination() {
    }

	public Examination(int idexamination, int iddoctordiseases, int idnurse, int idpatient, String dayin, String dayout, String type) {
        this.idexamination = idexamination;
        this.iddoctordiseases = iddoctordiseases;
        this.idnurse = idnurse;
        this.idpatient = idpatient;
        this.dayin = dayin;
        this.dayout = dayout;
        this.type = type;
    }

	public int getIdexamination() {
		return idexamination;
	}

	public void setIdexamination(int idexamination) {
		this.idexamination = idexamination;
	}

	public int getIddoctordiseases() {
		return iddoctordiseases;
	}

	public void setIddoctordiseases(int iddoctordiseases) {
		this.iddoctordiseases = iddoctordiseases;
	}

	public int getIdnurse() {
		return idnurse;
	}

	public void setIdnurse(int idnurse) {
		this.idnurse = idnurse;
	}

	public int getIdpatient() {
		return idpatient;
	}

	public void setIdpatient(int idpatient) {
		this.idpatient = idpatient;
	}

	public String getDayin() {
		return dayin;
	}

	public void setDayin(String dayin) {
		this.dayin = dayin;
	}

	public String getDayout() {
		return dayout;
	}

	public void setDayout(String dayout) {
		this.dayout = dayout;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
