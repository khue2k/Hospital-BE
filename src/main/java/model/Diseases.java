package model;

public class Diseases {
    private int iddiseases;
    private String name;
    private String description;
    private String type;

    public Diseases() {
    }

    public Diseases(int iddiseases, String name, String description, String type) {
        this.iddiseases = iddiseases;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public int getIddiseases() {
        return iddiseases;
    }

    public void setIddiseases(int iddiseases) {
        this.iddiseases = iddiseases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
     
}
