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
import model.TaiKhoan;

/**
 *
 * @author Admin
 */
public class TaiKhoanDao extends NhaTroDao<TaiKhoan, Integer> {
    String selectall = "select * from Tai_Khoan";
    String selectbyid = "select * from Tai_Khoan where IdKhachThue = ?";
    String insert = "insert into Tai_Khoan values (?, ?, ?, ?)";
    String update = "update Tai_Khoan set MatKhau = ? where TaiKhoan = ?";
    String delete = "delete from Tai_Khoan where IdKhachThue = ?";
    String selectTaiKhoan = "select * from TAI_KHOAN left join KHACH_THUE on TAI_KHOAN.IdKhachThue = KHACH_THUE.IdKhachThue where TaiKhoan = ? and MatKhau = ?";

    @Override
    public void insert(TaiKhoan entity) {
        XJDBC.update(insert, entity.getTaikhoan(), entity.getMatkhau(), entity.getIdkhachthue(), entity.isRoles());
    }

    @Override
    public void update(TaiKhoan entity) {
        XJDBC.update(update, entity.getMatkhau(), entity.getTaikhoan());
    }

    @Override
    public void delete(Integer key) {
        XJDBC.update(delete, key);
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return selectBySQL(selectall);
    }

    @Override
    public TaiKhoan selectByID(Integer key) {
        List<TaiKhoan> tk = selectBySQL(selectbyid, key);
        return tk.size() > 0 ? tk.get(0) : null;
    }

    public TaiKhoan selectByTaiKhoan(String taikhoan, String matKhau) {
        List<TaiKhoan> list = selectBySQL(selectTaiKhoan, taikhoan, matKhau);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    protected List<TaiKhoan> selectBySQL(String sql, Object... arg) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(new TaiKhoan(rs.getString("HoVaTen"), rs.getString("TaiKhoan"), rs.getString("MatKhau"), rs.getInt("IdKhachThue"), rs.getBoolean("Roles")));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
