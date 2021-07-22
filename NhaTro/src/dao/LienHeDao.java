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
import model.LienHe;

/**
 *
 * @author Admin
 */
public class LienHeDao extends NhaTroDao<LienHe, Integer> {

    String select = "select * from Lien_He";
    String update = "update Lien_He set TenChuNha = ?, Tuoi = ?, SoDienThoai = ?, Email = ?";

    @Override
    public void insert(LienHe entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(LienHe entity) {
        XJDBC.update(update, entity.getTenchunha(), entity.getTuoi(), entity.getSodienthoai(), entity.getEmail());
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LienHe selectByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<LienHe> selectBySQL(String sql, Object... arg) {
        List<LienHe> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(new LienHe(rs.getString("TenChuNha"), rs.getInt("Tuoi"), rs.getString("SoDienThoai"), rs.getString("Email")));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<LienHe> selectAll() {
        return selectBySQL(select);
    }

}
