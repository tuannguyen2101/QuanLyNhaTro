/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KhachThue;

/**
 *
 * @author Admin
 */
public class KhachThueDao extends NhaTroDao<KhachThue, Integer>{
    String selectallsql = "select * from KHACH_THUE";
    String selectbyname = "select * from KHACH_THUE where HoVaTen like ?";
    String selectthemthanhviensql = "select * from KHACH_THUE where IdKhachThue not in (Select IdKhachThue from PHONG_THUE where IdPhong = ?)";
    String selectthanhvien = "Select * from KHACH_THUE inner join PHONG_THUE on KHACH_THUE.IdKhachThue = PHONG_THUE.IdKhachThue where PHONG_THUE.IdPhong = ?";
    String selectDaiDien = "select KHACH_THUE.* from PHONG_THUE inner join KHACH_THUE \n"
            + "on KHACH_THUE.IdKhachThue = PHONG_THUE.IdKhachThue\n"
            + "inner join PHONG on PHONG.IdPhong = PHONG_THUE.IdPhong\n"
            + "where PHONG_THUE.VaiTro = 1 and PHONG.IdPhong = ?";
    String selectbyid = "select * from KHACH_THUE where IdKhachThue = ?";
    String updatesql = "update KHACH_THUE set HoVaTen = ? , NgaySinh = ?, GioiTinh = ?, QueQuan = ?, DienThoai = ?, Email = ?, CMND = ?, GhiChu = ? where IdKhachThue = ?";
    
    @Override
    public void insert(KhachThue entity) {
         String sql = "insert into KHACH_THUE (HoVaTen,NgaySinh,GioiTinh,QueQuan,DienThoai,Email,CMND,GhiChu) values (?,?,?,?,?,?,?,?)";
        XJDBC.update(sql,
                entity.getHoTen(),
                entity.getNgaySinh(),
                entity.isGioiTinh(),
                entity.getQueQuan(),
                entity.getDienThoai(),
                entity.getEmail(),
                entity.getcMND(),
                entity.getGhiChu());

    }
    
    @Override
    public void update(KhachThue entity) {
        XJDBC.update(updatesql, entity.getHoTen(), entity.getNgaySinh(), entity.isGioiTinh(), entity.getQueQuan(), entity.getDienThoai(), entity.getEmail(), entity.getcMND(), entity.getGhiChu(),entity.getIdKhachThue());
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from KHACH_THUE where IdKhachThue=?";
        XJDBC.update(sql, id);
    }

    @Override
    public List<KhachThue> selectAll() {
        return selectBySQL(selectallsql);
    }

    @Override
    public KhachThue selectByID(Integer key) {
        List<KhachThue> list = selectBySQL(selectbyid,key);
        if(list.isEmpty()) {
            return null;
        }
        else{
            return list.get(0);
        }
    }
//    public KhachThue selectDaiDien(int key) {
//        List<KhachThue> list = selectBySQL(selectDaiDien, key);
//        if(list.isEmpty()) {
//            return null;
//        }
//        else return list.get(0);
//    }

    
    public List<KhachThue> selectByName(String name) {
        return selectBySQL(selectbyname, "%" + name +"%");
    }
    
    public String getNgayThueDaiDien (int key){
        String ngaythue = null;
        try {
            ResultSet rs = helper.XJDBC.query(selectDaiDien, key);
            while (rs.next()) {
                ngaythue = rs.getString("NgayThue");
            }
            rs.getStatement().getConnection().close();
            return ngaythue;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<KhachThue> selectThemThanhVien(int key) {
        return selectBySQL(selectthemthanhviensql, key);
    }
    public KhachThue selectDaiDien(int key) {
        List<KhachThue> list = selectBySQL(selectDaiDien, key);
        return list.get(0);
    }
    
    @Override
    protected List<KhachThue> selectBySQL(String sql, Object... arg) {
        List<KhachThue> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(new KhachThue(
                        rs.getInt("IdKhachThue"), rs.getString("HoVaTen"), rs.getDate("NgaySinh"), rs.getBoolean("GioiTinh"), rs.getString("QueQuan"),
                        rs.getString("DienThoai"), rs.getString("Email"), rs.getString("CMND"), rs.getString("GhiChu")
                ));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Object[]> getThanhVien(int key) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query("select KHACH_THUE.*, PHONG_THUE.NgayThue from KHACH_THUE inner join PHONG_THUE on KHACH_THUE.IdKhachThue = PHONG_THUE.IdKhachThue where PHONG_THUE.IdPhong = ?", key);
                while(rs.next()) {
                    Object[] model = new Object[] {
                        rs.getInt("IdKhachThue"), rs.getString("HoVaTen"), rs.getDate("NgaySinh"), rs.getBoolean("GioiTinh")==true ? "Nam":"Nữ", rs.getString("QueQuan"),
                        rs.getString("DienThoai"), rs.getString("Email"), rs.getString("CMND"), rs.getString("GhiChu"), rs.getDate("NgayThue")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
}
