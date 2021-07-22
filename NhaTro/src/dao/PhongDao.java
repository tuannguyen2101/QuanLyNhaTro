/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.Auth;
import helper.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Phong;
import view.PhongWindows;
import view.TrangChuWindows;

/**
 *
 * @author Admin
 */
public class PhongDao extends NhaTroDao<Phong, Integer> {

    String selectallsql = "select Phong.*, TOA_NHA.TenToaNha from PHONG inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha";
    String selectbynamesql = "select Phong.*, TOA_NHA.TenToaNha from PHONG inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha where Phong like ?";
    String selectbyidsql = "select Phong.*, TOA_NHA.TenToaNha from PHONG inner join TOA_NHA on PHONG.IDToaNha = TOA_NHA.IdToaNha where IDPhong = ?";
    String insertsql = "insert into PHONG values (?,?,?,?,?,?,?)";
    String updatesql = "update PHONG set Phong = ?, Tang = ?, DienTich = ?, Gia = ?, Mota = ?, TrangThai = ?, IdToaNha = ? where IdPhong = ?";
    String xoathanhvien = "delete from PHONG_THUE where IdKhachThue = ? and IdPhong = ?";
    String deletesql = "delete from PHONG where IdPhong = ?";
    String themthanhviensql = "insert into PHONG_THUE values (?,?,?,?)";

    String selectphongbykhachthue = "select PHONG.*, TOA_NHA.TenToaNha from PHONG inner join TOA_NHA on TOA_NHA.IdToaNha = PHONG.IdToaNha\n"
            + "where PHONG.IdPhong in (select IdPhong from PHONG_THUE where IdKhachThue = ? and Phong like ?)";

    String selectbyToaNha_PhongTrong = "select Phong.*,TOA_NHA.TenToaNha, TOA_NHA.IdToaNha from PHONG inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha where TOA_NHA.IdToaNha = ? and TrangThai = 0";

    String selectbyToaNha = "select * from PHONG_THUE inner join KHACH_THUE\n"
            + "on PHONG_THUE.IdKhachThue = KHACH_THUE.IdKhachThue\n"
            + "inner join PHONG on PHONG.IdPhong = PHONG_THUE.IdPhong\n"
            + "inner join TOA_NHA on TOA_NHA.IdToaNha = PHONG.IdToaNha\n"
            + "where PHONG_THUE.VaiTro = 1 and TOA_NHA.IdToaNha = ?";

    @Override
    public void insert(Phong entity) {
        XJDBC.update(insertsql, entity.getPhong(), entity.getTang(), entity.getDientich(), entity.getGia(), entity.getMota(), entity.isTrangthai(), entity.getIdtoanha());
    }

    @Override
    public void update(Phong entity) {
        XJDBC.update(updatesql, entity.getPhong(), entity.getTang(), entity.getDientich(), entity.getGia(), entity.getMota(), entity.isTrangthai(), entity.getIdtoanha(), entity.getIdphong());
    }

    @Override
    public void delete(Integer key) {
        XJDBC.update(deletesql, key);
    }

    @Override
    public List<Phong> selectAll() {
        return selectBySQL(selectallsql);
    }

    public List<Phong> selectAllPhongTrongTheoToaNha(int key) {
        return selectBySQL(selectbyToaNha_PhongTrong, key);
    }

    public List<Phong> selectbyname(String name) {
        return selectBySQL(selectbynamesql, "%" + name + "%");
    }

    public List<Phong> selectbyKhchThue(int key, String name) {
        return selectBySQL(selectphongbykhachthue, key, "%" + name + "%");
    }

    public List<Phong> selectbyfilter(Integer key) {
        String selectbyfilter = PhongWindows.sql;
        return selectBySQL(selectbyfilter, key);
    }

    @Override
    public Phong selectByID(Integer key) {
        List<Phong> list = selectBySQL(selectbyidsql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<Object[]> selectByToaNha(int key) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(selectbyToaNha, key);
            while (rs.next()) {
                Object[] o = new Object[]{rs.getInt("IdPhong"), rs.getString("Phong"),
                    rs.getInt("Tang"), rs.getDouble("DienTich"), rs.getDouble("Gia"),
                    rs.getString("MoTa"), rs.getBoolean("TrangThai") == true ? "Đã thuê" : "Chưa thuê", rs.getString("HovaTen")};
                list.add(o);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void themThanhVien(int key1, int key2, boolean key3) {
        XJDBC.update(themthanhviensql, new Date(), key1, key2, key3);
    }

    public void xoaThanhVien(int key1, int key2) {
        XJDBC.update(xoathanhvien, key1, key2);
    }

    @Override
    protected List<Phong> selectBySQL(String sql, Object... arg) {
        List<Phong> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(new Phong(rs.getInt("IdPhong"), rs.getString("Phong"),
                        rs.getInt("Tang"), rs.getDouble("DienTich"), rs.getDouble("Gia"),
                        rs.getString("MoTa"), rs.getBoolean("TrangThai"), rs.getInt("IdToaNha"), rs.getString("TenToaNha")));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Phong> selectbyfilterTrangChu() {
        String selectbyfilter = TrangChuWindows.sql;
        return selectBySQL(selectbyfilter);
    }

    public List<Phong> selectByHoaDon(int thang, int nam) {
        return selectBySQL("select Phong.*, TOA_NHA.TenToaNha from PHONG inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha where IdPhong not in (select IdPhong from HOA_DON where Thang = ? and Nam = ?) and TrangThai = 1", thang, nam);
    }

}
