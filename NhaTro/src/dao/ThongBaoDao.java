/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.XJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ThongBao;

/**
 *
 * @author Admin
 */
public class ThongBaoDao extends NhaTroDao<ThongBao, Integer>{
    String selectallsql = "select * from THONG_BAO";
    String updatesql = "update THONG_BAO set TrangThai = ? where id = ?";
    @Override
    public void insert(ThongBao entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ThongBao entity) {
        XJDBC.update(updatesql,entity.isTrangthai(), entity.getId());
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ThongBao> selectAll() {
        return selectBySQL(selectallsql);
    }

    @Override
    public ThongBao selectByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<ThongBao> selectBySQL(String sql, Object... arg) {
        List<ThongBao> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(new ThongBao(rs.getInt("Id"), rs.getString("NoiDung"), rs.getBoolean("TrangThai")));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
