package com.dangtrananhtu.qlsv;

public class SinhVien {
    String id,mssv,tensv,que,gioitinh,khoa,khoaSv,nganh,email,sdt,ghichu;

    public SinhVien() {
    }

    public SinhVien(String id, String mssv, String tensv, String que, String gioitinh, String khoa, String khoaSv, String nganh, String email, String sdt, String ghichu) {
        this.id = id;
        this.mssv = mssv;
        this.tensv = tensv;
        this.que = que;
        this.gioitinh = gioitinh;
        this.khoa = khoa;
        this.khoaSv = khoaSv;
        this.nganh = nganh;
        this.email = email;
        this.sdt = sdt;
        this.ghichu = ghichu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getKhoaSv() {
        return khoaSv;
    }

    public void setKhoaSv(String khoaSv) {
        this.khoaSv = khoaSv;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

}
