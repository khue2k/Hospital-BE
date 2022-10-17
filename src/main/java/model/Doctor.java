package model;

public class Doctor {
	private int iddoctor;
	private String cmd;
	private String name;
	private String birthday;
	private String address;
	private String level;
	private int seniority;
	private String type;

	public Doctor() {
	}

	public Doctor(int iddoctor, String name, String birthday, String cmd, String address, String level, int seniority,
			String type) {
		this.iddoctor = iddoctor;
		this.cmd = cmd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.level = level;
		this.seniority = seniority;
		this.type = type;
	}

	public int getIddoctor() {
		return iddoctor;
	}

	public void setIddoctor(int iddoctor) {
		this.iddoctor = iddoctor;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}