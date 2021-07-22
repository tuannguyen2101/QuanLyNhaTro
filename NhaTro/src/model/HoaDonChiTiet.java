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
public class HoaDonChiTiet {
    private int idHDCT;
    private int idHoaDon;
    private String khoanThu;
    private int soCu;
    private int soMoi;
    private int SuDung;
    private double gia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int idHDCT, int idHoaDon, String khoanThu, int soCu, int soMoi, int SuDung, double gia) {
        this.idHDCT = idHDCT;
        this.idHoaDon = idHoaDon;
        this.khoanThu = khoanThu;
        this.soCu = soCu;
        this.soMoi = soMoi;
        this.SuDung = SuDung;
        this.gia = gia;
    }

    public int getIdHDCT() {
        return idHDCT;
    }

    public void setIdHDCT(int idHDCT) {
        this.idHDCT = idHDCT;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getKhoanThu() {
        return khoanThu;
    }

    public void setKhoanThu(String khoanThu) {
        this.khoanThu = khoanThu;
    }

    public int getSoCu() {
        return soCu;
    }

    public void setSoCu(int soCu) {
        this.soCu = soCu;
    }

    public int getSoMoi() {
        return soMoi;
    }

    public void setSoMoi(int soMoi) {
        this.soMoi = soMoi;
    }

    public int getSuDung() {
        return SuDung;
    }

    public void setSuDung(int SuDung) {
        this.SuDung = SuDung;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    
}
