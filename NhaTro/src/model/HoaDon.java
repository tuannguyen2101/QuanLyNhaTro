/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private int idHoaDon;
    private int idPhong;
    private String tenToaNha;
    private String tenPong;
    private int thang;
    private int nam;
    private boolean trangThai;

    public HoaDon() {
    }

    public HoaDon(int idHoaDon, int idPhong, int thang, int nam, boolean trangThai) {
        this.idHoaDon = idHoaDon;
        this.idPhong = idPhong;
//        this.tongTien = tongTien;
        this.thang = thang;
        this.nam = nam;
        this.trangThai = trangThai;
    }

    public HoaDon(int idHoaDon, int idPhong, String tenToaNha, String tenPong, int thang, int nam, boolean trangThai) {
        this.idHoaDon = idHoaDon;
        this.idPhong = idPhong;
        this.tenToaNha = tenToaNha;
        this.tenPong = tenPong;
//        this.tongTien = tongTien;
        this.thang = thang;
        this.nam = nam;
        this.trangThai = trangThai;
    }

    
    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

//    public double getTongTien() {
//        return tongTien;
//    }
//
//    public void setTongTien(double tongTien) {
//        this.tongTien = tongTien;
//    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenToaNha() {
        return tenToaNha;
    }

    public void setTenToaNha(String tenToaNha) {
        this.tenToaNha = tenToaNha;
    }

    public String getTenPong() {
        return tenPong;
    }

    public void setTenPong(String tenPong) {
        this.tenPong = tenPong;
    }
    
    
}
