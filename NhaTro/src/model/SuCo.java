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
public class SuCo {

    private int idsuco;
    private String mota;
    private String nha;
    private String phong;
    private String nguoibao;
    private String ngaybao;
    private String ghichu;
    private boolean trangthai = false;

    public SuCo() {
    }

    public SuCo(int idsuco, String mota, String nha, String phong, String nguoibao, String ngaybao, String ghichu, boolean trangthai) {
        this.idsuco = idsuco;
        this.mota = mota;
        this.nha = nha;
        this.phong = phong;
        this.nguoibao = nguoibao;
        this.ngaybao = ngaybao;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
    }

    public int getIdsuco() {
        return idsuco;
    }

    public void setIdsuco(int idsuco) {
        this.idsuco = idsuco;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNha() {
        return nha;
    }

    public void setNha(String nha) {
        this.nha = nha;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getNguoibao() {
        return nguoibao;
    }

    public void setNguoibao(String nguoibao) {
        this.nguoibao = nguoibao;
    }

    public String getNgaybao() {
        return ngaybao;
    }

    public void setNgaybao(String ngaybao) {
        this.ngaybao = ngaybao;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "SuCo{" + "idsuco=" + idsuco + ", mota=" + mota + ", nha=" + nha + ", phong=" + phong + ", nguoibao=" + nguoibao + ", ngaybao=" + ngaybao + ", ghichu=" + ghichu + ", trangthai=" + trangthai + '}';
    }

}
