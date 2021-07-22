/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author shiro
 */
public class Info {

    private int idkhachthue;
    private String tendangnhap;
    private String hovaten;
    private String tentoanha;
    private String phong;

    public Info() {
    }

    public Info(int idkhachthue, String tendangnhap, String hovaten, String tentoanha, String phong) {
        this.idkhachthue = idkhachthue;
        this.tendangnhap = tendangnhap;
        this.hovaten = hovaten;
        this.tentoanha = tentoanha;
        this.phong = phong;
    }

    public int getIdkhachthue() {
        return idkhachthue;
    }

    public void setIdkhachthue(int idkhachthue) {
        this.idkhachthue = idkhachthue;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getTentoanha() {
        return tentoanha;
    }

    public void setTentoanha(String tentoanha) {
        this.tentoanha = tentoanha;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    @Override
    public String toString() {
        return "Info{" + "idkhachthue=" + idkhachthue + ", tendangnhap=" + tendangnhap + ", hovaten=" + hovaten + ", tentoanha=" + tentoanha + ", phong=" + phong + '}';
    }

}
