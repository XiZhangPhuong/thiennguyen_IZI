package com.example.myappizi.Model;

public class HoatDong {
    private String MaHD;
    private String TenHD;
    private String motaHD;
    private String ngayGioBatDau;
    private String ngayGioKetThuc;
    private int sl_ToiThieu;
    private int sl_ToiDa;
    private String thoiHanDK;
    private String TrangThai;
    private String maTV;
    private String lyDOHuyHD;

    public HoatDong(String maHD, String tenHD, String motaHD, String ngayGioBatDau, String ngayGioKetThuc, int sl_ToiThieu, int sl_ToiDa, String thoiHanDK, String trangThai, String maTV, String lyDOHuyHD) {
        MaHD = maHD;
        TenHD = tenHD;
        this.motaHD = motaHD;
        this.ngayGioBatDau = ngayGioBatDau;
        this.ngayGioKetThuc = ngayGioKetThuc;
        this.sl_ToiThieu = sl_ToiThieu;
        this.sl_ToiDa = sl_ToiDa;
        this.thoiHanDK = thoiHanDK;
        TrangThai = trangThai;
        this.maTV = maTV;
        this.lyDOHuyHD = lyDOHuyHD;
    }

    public HoatDong() {
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public String getTenHD() {
        return TenHD;
    }

    public void setTenHD(String tenHD) {
        TenHD = tenHD;
    }

    public String getMotaHD() {
        return motaHD;
    }

    public void setMotaHD(String motaHD) {
        this.motaHD = motaHD;
    }

    public String getNgayGioBatDau() {
        return ngayGioBatDau;
    }

    public void setNgayGioBatDau(String ngayGioBatDau) {
        this.ngayGioBatDau = ngayGioBatDau;
    }

    public String getNgayGioKetThuc() {
        return ngayGioKetThuc;
    }

    public void setNgayGioKetThuc(String ngayGioKetThuc) {
        this.ngayGioKetThuc = ngayGioKetThuc;
    }

    public int getSl_ToiThieu() {
        return sl_ToiThieu;
    }

    public void setSl_ToiThieu(int sl_ToiThieu) {
        this.sl_ToiThieu = sl_ToiThieu;
    }

    public int getSl_ToiDa() {
        return sl_ToiDa;
    }

    public void setSl_ToiDa(int sl_ToiDa) {
        this.sl_ToiDa = sl_ToiDa;
    }

    public String getThoiHanDK() {
        return thoiHanDK;
    }

    public void setThoiHanDK(String thoiHanDK) {
        this.thoiHanDK = thoiHanDK;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public String getMaTV() {
        return maTV;
    }

    public void setMaTV(String maTV) {
        this.maTV = maTV;
    }

    public String getLyDOHuyHD() {
        return lyDOHuyHD;
    }

    public void setLyDOHuyHD(String lyDOHuyHD) {
        this.lyDOHuyHD = lyDOHuyHD;
    }
}
