package model;

public class Medicine {
	private int idmedicine;
	private String name;
	private int cost;
	private String type;

	public Medicine() {
    }

	public Medicine(int idmedicine, String name, int cost, String type) {
        this.idmedicine = idmedicine;
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

	public int getIdmedicine() {
		return idmedicine;
	}

	public void setIdmedicine(int idmedicine) {
		this.idmedicine = idmedicine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
