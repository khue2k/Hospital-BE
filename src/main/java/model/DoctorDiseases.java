package model;

public class DoctorDiseases {
    private int iddoctordiseases;
    private int iddoctor;
    private int iddiseases;
    private String type;

    public DoctorDiseases() {
    }

    public DoctorDiseases(int iddoctordiseases, int iddoctor, int iddiseases, String type) {
        this.iddoctordiseases = iddoctordiseases;
        this.iddoctor = iddoctor;
        this.iddiseases = iddiseases;
        this.type = type;
    }

    public int getIddoctordiseases() {
        return iddoctordiseases;
    }

    public void setIddoctordiseases(int iddoctordiseases) {
        this.iddoctordiseases = iddoctordiseases;
    }

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public int getIddiseases() {
        return iddiseases;
    }

    public void setIddiseases(int iddiseases) {
        this.iddiseases = iddiseases;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
