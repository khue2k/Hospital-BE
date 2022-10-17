package model;

public class Nurse {
	private int idnurse;
	private String cmd;
	private String name;
	private String birthday;
	private String address;
	private String level;
	private String phone;
	private int seniority;
	private String type;

	public Nurse() {
	}

	public Nurse(int idnurse, String cmd, String name, String address, String birthday, String phone, String level,
			int seniority, String type) {
		this.idnurse = idnurse;
		this.cmd = cmd;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.level = level;
		this.phone = phone;
		this.seniority = seniority;
		this.type = type;
	}

	public int getIdnurse() {
		return idnurse;
	}

	public void setIdnurse(int idnurse) {
		this.idnurse = idnurse;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
