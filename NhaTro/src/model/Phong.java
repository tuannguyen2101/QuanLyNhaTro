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
public class Phong {

    private int idphong;
    private String phong;
    private int tang;
    private double dientich;
    private double gia;
    private String mota;
    private boolean trangthai;
    private int idtoanha;
    private String tentoanha;

    public Phong() {
    }

    public Phong(int idphong, String phong, int tang, double dientich, double gia, String mota, boolean trangthai, int idtoanha, String tentoanha) {
        this.idphong = idphong;
        this.phong = phong;
        this.tang = tang;
        this.dientich = dientich;
        this.gia = gia;
        this.mota = mota;
        this.trangthai = trangthai;
        this.idtoanha = idtoanha;
        this.tentoanha = tentoanha;
    }

    public int getIdphong() {
        return idphong;
    }

    public void setIdphong(int idphong) {
        this.idphong = idphong;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public double getDientich() {
        return dientich;
    }

    public void setDientich(double dientich) {
        this.dientich = dientich;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public int getIdtoanha() {
        return idtoanha;
    }

    public void setIdtoanha(int idtoanha) {
        this.idtoanha = idtoanha;
    }

    public String getTentoanha() {
        return tentoanha;
    }

    public void setTentoanha(String tentoanha) {
        this.tentoanha = tentoanha;
    }

    @Override
    public String toString() {
        return "Phòng: " + phong + " - Nhà: " + tentoanha;
    }
    

}
