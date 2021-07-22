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
public class DichVu {
    private int id;
    private String tendichvu;
    private double gia;
    private String donvi;
    private String mota;
    private boolean trangthai;
    private String tentoanha;

    public DichVu() {
    }
    
    public DichVu(int id, String tendichvu, double gia, String donvi, String mota, boolean trangthai, String tentoanha) {
        this.id = id;
        this.tendichvu = tendichvu;
        this.gia = gia;
        this.donvi = donvi;
        this.mota = mota;
        this.trangthai = trangthai;
        this.tentoanha = tentoanha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTendichvu() {
        return tendichvu;
    }

    public void setTendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
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

    public String getTentoanha() {
        return tentoanha;
    }

    public void setTentoanha(String tentoanha) {
        this.tentoanha = tentoanha;
    }

    @Override
    public String toString() { 
        return tendichvu+ " - " +gia +" - " +donvi;
    }
}
