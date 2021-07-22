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
public class ToaNha {

    private int idtoanha;
    private String diachi;
    private String tentoanha;
    private String mota;
    private String ghichu;

    public ToaNha() {
    }

    public ToaNha(int idtoanha, String tentoanha, String diachi, String mota, String ghichu) {
        this.idtoanha = idtoanha;
        this.diachi = diachi;
        this.tentoanha = tentoanha;
        this.mota = mota;
        this.ghichu = ghichu;
    }

    public int getIdtoanha() {
        return idtoanha;
    }

    public void setIdtoanha(int idtoanha) {
        this.idtoanha = idtoanha;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTentoanha() {
        return tentoanha;
    }

    public void setTentoanha(String tentoanha) {
        this.tentoanha = tentoanha;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return this.tentoanha;
    }

}
