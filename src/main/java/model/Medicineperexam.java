package model;

public class Medicineperexam {
    private int idmedicineperexam;
    private int idmedicine;
    private int idexamination;

    public Medicineperexam() {
    }

    public Medicineperexam(int idmedicineperexam, int idmedicine, int idexamination) {
        this.idmedicineperexam = idmedicineperexam;
        this.idmedicine = idmedicine;
        this.idexamination = idexamination;
    }

    public int getIdmedicineperexam() {
        return idmedicineperexam;
    }

    public void setIdmedicineperexam(int idmedicineperexam) {
        this.idmedicineperexam = idmedicineperexam;
    }

    public int getIdmedicine() {
        return idmedicine;
    }

    public void setIdmedicine(int idmedicine) {
        this.idmedicine = idmedicine;
    }

    public int getIdexamination() {
        return idexamination;
    }

    public void setIdexamination(int idexamination) {
        this.idexamination = idexamination;
    }
}
