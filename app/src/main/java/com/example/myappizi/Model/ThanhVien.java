package com.example.myappizi.Model;

public class ThanhVien {
    private String MaTV;
    private String hoTen;
    private String GioiTinh;
    private String email;
    private String soDienThoai;

    public ThanhVien() {
    }

    public ThanhVien(String maTV, String hoTen, String gioiTinh, String email, String soDienThoai) {
        MaTV = maTV;
        this.hoTen = hoTen;
        GioiTinh = gioiTinh;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    public String getMaTV() {
        return MaTV;
    }

    public void setMaTV(String maTV) {
        MaTV = maTV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
