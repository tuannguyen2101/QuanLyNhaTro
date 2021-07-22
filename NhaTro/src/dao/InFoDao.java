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
import model.Info;

/**
 *
 * @author shiro
 */
public class InFoDao extends NhaTroDao<Info, Integer> {

    String selectById = "select KHACH_THUE.IdKhachThue, TAI_KHOAN.TaiKhoan, KHACH_THUE.HoVaTen, TOA_NHA.TenToaNha, Phong.Phong\n"
            + "from TOA_NHA	inner join PHONG on TOA_NHA.IdToaNha = Phong.IdToaNha \n"
            + "inner join PHONG_THUE on Phong.IdPhong = PHONG_THUE.IdPhong \n"
            + "inner join KHACH_THUE on PHONG_THUE.IdKhachThue = KHACH_THUE.IdKhachThue\n"
            + " inner join TAI_KHOAN on KHACH_THUE.IdKhachThue = TAI_KHOAN.IdKhachThue\n"
            + "where KHACH_THUE.IdKhachThue = ?";

    @Override
    public void insert(Info entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Info entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Info> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Info selectByID(Integer key) {
        List<Info> list = selectBySQL(selectById, key);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Info> selectBySQL(String sql, Object... arg) {
        List<Info> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(new Info(rs.getInt("IdKhachThue"), rs.getString("TaiKhoan"), rs.getString("HoVaTen"), rs.getString("TenToaNha"), rs.getString("Phong")));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
