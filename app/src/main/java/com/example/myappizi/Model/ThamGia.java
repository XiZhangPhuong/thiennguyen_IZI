package com.example.myappizi.Model;

public class ThamGia {
    private String Matv,Mahd,Ngaygiodk;
    private double diemTruongDoan;
    private double diemtc1,diemtc2,diemtv3;
    private String nhanXeyKhac;

    public ThamGia() {
    }

    public ThamGia(String matv, String mahd, String ngaygiodk, double diemTruongDoan, double diemtc1, double diemtc2, double diemtv3, String nhanXeyKhac) {
        Matv = matv;
        Mahd = mahd;
        Ngaygiodk = ngaygiodk;
        this.diemTruongDoan = diemTruongDoan;
        this.diemtc1 = diemtc1;
        this.diemtc2 = diemtc2;
        this.diemtv3 = diemtv3;
        this.nhanXeyKhac = nhanXeyKhac;
    }

    public String getMatv() {
        return Matv;
    }

    public void setMatv(String matv) {
        Matv = matv;
    }

    public String getMahd() {
        return Mahd;
    }

    public void setMahd(String mahd) {
        Mahd = mahd;
    }

    public String getNgaygiodk() {
        return Ngaygiodk;
    }

    public void setNgaygiodk(String ngaygiodk) {
        Ngaygiodk = ngaygiodk;
    }

    public double getDiemTruongDoan() {
        return diemTruongDoan;
    }

    public void setDiemTruongDoan(double diemTruongDoan) {
        this.diemTruongDoan = diemTruongDoan;
    }

    public double getDiemtc1() {
        return diemtc1;
    }

    public void setDiemtc1(double diemtc1) {
        this.diemtc1 = diemtc1;
    }

    public double getDiemtc2() {
        return diemtc2;
    }

    public void setDiemtc2(double diemtc2) {
        this.diemtc2 = diemtc2;
    }

    public double getDiemtv3() {
        return diemtv3;
    }

    public void setDiemtv3(double diemtv3) {
        this.diemtv3 = diemtv3;
    }

    public String getNhanXeyKhac() {
        return nhanXeyKhac;
    }

    public void setNhanXeyKhac(String nhanXeyKhac) {
        this.nhanXeyKhac = nhanXeyKhac;
    }
}
