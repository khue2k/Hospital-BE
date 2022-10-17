package model;

public class Patient {
	private int idpatient;
	private String cmd;
	private String name;
	private String birthday;
	private String address;
	private String phone;

	public Patient(int idpatient, String cmd, String name, String birthday, String address, String phone) {
        this.idpatient = idpatient;
        this.cmd = cmd;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
    }

	public Patient() {
    }

	public int getIdpatient() {
		return idpatient;
	}

	public void setIdpatient(int idpatient) {
		this.idpatient = idpatient;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
