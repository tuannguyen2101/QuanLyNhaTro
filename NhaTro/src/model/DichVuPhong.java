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
public class DichVuPhong {
    private int id;
    private int idDichVu;
    private int idPhong;
    private int soLuong;
    private String  tenDichVu;
    private double gia;
    
    public DichVuPhong() {
    }

    public DichVuPhong(int id, int idDichVu, int idPhong, int soLuong, String tenDichVu, double gia) {
        this.id = id;
        this.idDichVu = idDichVu;
        this.idPhong = idPhong;
        this.soLuong = soLuong;
        this.tenDichVu = tenDichVu;
        this.gia = gia;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(int idDichVu) {
        this.idDichVu = idDichVu;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    
}
