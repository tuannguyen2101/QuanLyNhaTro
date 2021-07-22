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
import model.MoTa;

/**
 *
 * @author Admin
 */
public class MoTaDao {
    String selectStatussql = "Select * from MO_TA where IdPhong = ?";
    String updatemotasql = "update MO_TA set Loc1 = ?, Loc2 = ?, Loc3 = ?, Loc4 = ?, Loc5 = ?, Loc6 = ?, Loc7 = ?, Loc8 = ?, Loc9 = ? where IdPhong = ?";
    String insertmotasql = "insert into MO_TA values (?,?,?,?,?,?,?,?,?,?)";
    String deletesql = "delete from MO_TA where IdPhong = ?";
    public MoTa setStatus(int key) {
        return selectStatus(selectStatussql, key).get(0);
    }
    
    public void insertmota(MoTa entity){
        XJDBC.update(insertmotasql,entity.getIdphong(), entity.isLoc1(), entity.isLoc2(), entity.isLoc3(), entity.isLoc4(), entity.isLoc5(), entity.isLoc6(), entity.isLoc7(), entity.isLoc8(), entity.isLoc9());
    }
    
    public void updatemota(MoTa entity) {
        XJDBC.update(updatemotasql, entity.isLoc1(),entity.isLoc2(),entity.isLoc3(),entity.isLoc4(),entity.isLoc5(),entity.isLoc6(),entity.isLoc7(),entity.isLoc8(),entity.isLoc9(),entity.getIdphong());
    }
    
    public void deletemota(int key) {
        XJDBC.update(deletesql, key);
    }
    protected List<MoTa> selectStatus(String sql, Object... arg) {
        List<MoTa> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(new MoTa(rs.getInt("IdPhong"), rs.getBoolean("Loc1"), rs.getBoolean("Loc2"), rs.getBoolean("Loc3"), rs.getBoolean("Loc4"), rs.getBoolean("Loc5")
                , rs.getBoolean("Loc6"), rs.getBoolean("Loc7"), rs.getBoolean("Loc8"), rs.getBoolean("Loc9")));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
}
