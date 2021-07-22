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
public class LienHe {

    private String tenchunha;
    private int tuoi;
    private String sodienthoai;
    private String email;

    public LienHe() {
    }

    public LienHe(String tenchunha, int tuoi, String sodienthoai, String email) {
        this.tenchunha = tenchunha;
        this.tuoi = tuoi;
        this.sodienthoai = sodienthoai;
        this.email = email;
    }

    public String getTenchunha() {
        return tenchunha;
    }

    public void setTenchunha(String tenchunha) {
        this.tenchunha = tenchunha;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LienHe{" + "tenchunha=" + tenchunha + ", tuoi=" + tuoi + ", sodienthoai=" + sodienthoai + ", email=" + email + '}';
    }

}
