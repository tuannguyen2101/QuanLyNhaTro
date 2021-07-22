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
public class TaiKhoan {

    private String hovaten;
    private String taikhoan;
    private String matkhau;
    private int idkhachthue;
    private boolean roles;

    public TaiKhoan() {
    }

    public TaiKhoan(String hovaten, String taikhoan, String matkhau, int idkhachthue, boolean roles) {
        this.hovaten = hovaten;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.idkhachthue = idkhachthue;
        this.roles = roles;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getIdkhachthue() {
        return idkhachthue;
    }

    public void setIdkhachthue(int idkhachthue) {
        this.idkhachthue = idkhachthue;
    }

    public boolean isRoles() {
        return roles;
    }

    public void setRoles(boolean roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "hovaten=" + hovaten + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau + ", idkhachthue=" + idkhachthue + ", roles=" + roles + '}';
    }

}
