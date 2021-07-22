/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhachThue {
    private int idKhachThue;
    private String  hoTen;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String queQuan;
    private String dienThoai;
    private String email;
    private String cMND;
    private String ghiChu;
    public KhachThue() {
    }

    public KhachThue(int idKhachThue, String hoTen, Date ngaySinh, boolean gioiTinh, String queQuan, String dienThoai, String email, String cMND, String ghiChu) {
        this.idKhachThue = idKhachThue;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.dienThoai = dienThoai;
        this.email = email;
        this.cMND = cMND;
        this.ghiChu = ghiChu;
    }

    

//    public boolean isVaiTro() {
//        return vaiTro;
//    }
//
//    public void setVaiTro(boolean vaiTro) {
//        this.vaiTro = vaiTro;
//    }

    

    public int getIdKhachThue() {
        return idKhachThue;
    }

    public void setIdKhachThue(int idKhachThue) {
        this.idKhachThue = idKhachThue;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getcMND() {
        return cMND;
    }

    public void setcMND(String cMND) {
        this.cMND = cMND;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
    
    
}
