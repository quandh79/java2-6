package library.entities;

public class Rent {
    public Integer id;
    public String sach;
    public String student;
    public String ngayMuon;
    public String ngayTra;

    public Rent() {
    }

    public Rent(Integer id, String sach, String student, String ngayMuon, String ngayTra) {
        this.id = id;
        this.sach = sach;
        this.student = student;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSach() {
        return sach;
    }

    public void setSach(String sach) {
        this.sach = sach;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
}
