/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ToaNha;

/**
 *
 * @author Admin
 */
public class ToaNhaDao extends NhaTroDao<ToaNha, Integer> {

    String selectbyid = "SELECT * FROM TOA_NHA WHERE idtoanha = ?";
    String selectall = "SELECT * FROM TOA_NHA";
    String insert = "INSERT INTO TOA_NHA VALUES (?, ?, ?, ?)";
    String update = "UPDATE TOA_NHA SET TenToaNha = ?, DIACHI = ?, MOTA = ?, GHICHU = ? WHERE IDTOANHA = ?";
    String delete = "DELETE FROM TOA_NHA WHERE IDTOANHA = ?";

    @Override
    public void insert(ToaNha entity) {
        helper.XJDBC.update(insert,  entity.getDiachi(), entity.getMota(), entity.getGhichu(), entity.getTentoanha());
    }

    @Override
    public void update(ToaNha entity) {
        helper.XJDBC.update(update, entity.getTentoanha(), entity.getDiachi(), entity.getMota(), entity.getGhichu(), entity.getIdtoanha());
    }

    @Override
    public void delete(Integer key) {
        helper.XJDBC.update(delete, key);
    }

    @Override
    public List<ToaNha> selectAll() {
        return selectBySQL(selectall);
    }

    @Override
    public ToaNha selectByID(Integer key) {
        List<ToaNha> list = selectBySQL(selectbyid, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<ToaNha> selectBySQL(String sql, Object... arg) {
        List<ToaNha> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(new ToaNha(rs.getInt("IdToaNha"), rs.getString("TenToaNha"), rs.getString("DiaChi"), rs.getString("Mota"), rs.getString("GhiChu")));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    

}
