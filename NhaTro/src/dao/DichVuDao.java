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
import model.DichVu;
import view.DichVuWindows;

/**
 *
 * @author Admin
 */
public class DichVuDao extends NhaTroDao<DichVu, Integer>{
    String selectallsql = "select TOA_NHA.TenToaNha, DICH_VU.*  from DICH_VU inner join TOA_NHA on DICH_VU.IdToaNha = TOA_NHA.IdToaNha";
    String updatesql = "update DICH_VU set TenDichVu = ?, Gia = ?, DonVi = ?, MoTa = ?, TrangThai = ? where IdDichVu = ?";
    String insertsql = "insert into DICH_VU values(?,?,?,?,?,?)";
    String deletesql = "delete from DICH_VU where IdDichVu = ?";
    String selectbyidsql = "select TOA_NHA.TenToaNha, DICH_VU.*  from DICH_VU inner join TOA_NHA on DICH_VU.IdToaNha = TOA_NHA.IdToaNha where IdDichVu = ?";
    String selectbynamesql = "select * from DICH_VU where TenDichVu like ?";
    String selectbyphong = "select TOA_NHA.DiaChi, DICH_VU.*  from DICH_VU inner join TOA_NHA on DICH_VU.IdToaNha = TOA_NHA.IdToaNha where IdDichVu not in (select IdPhong from Dich_Vu_Phong where IdPhong = ?)";
    String selectbytoanha_phong = "select TOA_NHA.TenToaNha, DICH_VU.* from DICH_VU inner join TOA_NHA on DICH_VU.IdToaNha = TOA_NHA.IdToaNha where TOA_NHA.IdToaNha = (select TOA_NHA.IdToaNha from TOA_NHA inner join PHONG on TOA_NHA.IdToaNha = PHONG.IdToaNha where IdPhong = ? and IdDichVu not in (select IdDichVu from Dich_Vu_Phong where IdPhong = ?))";
    @Override
    public void insert(DichVu entity) {
        XJDBC.update(insertsql,entity.getTendichvu(),entity.getGia(),entity.getDonvi(),entity.getMota(),true, DichVuWindows.idToaNha);
    }

    @Override
    public void update(DichVu entity) {
        XJDBC.update(updatesql, entity.getTendichvu(),entity.getGia(),entity.getDonvi(),entity.getMota(),true, entity.getId());
    }

    @Override
    public void delete(Integer key) {
        XJDBC.update(deletesql, key);
    }

    @Override
    public List<DichVu> selectAll() {
        return selectBySQL(selectallsql);
    }
    @Override
    public DichVu selectByID(Integer key) {
        List<DichVu> list = selectBySQL(selectbyidsql, key);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
        
    public DichVu selectByName(String name) {
        List<DichVu> list = selectBySQL(selectbyidsql, "%" + name + "%");
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<DichVu> selectByPhong(int key) {
        List<DichVu> list = selectBySQL(selectbyphong, key);
        return list;
    }
    
    public List<DichVu> selectByToaNha_Phong(int key) {
        return selectBySQL(selectbytoanha_phong, key,key);
    }
    
    @Override
    protected List<DichVu> selectBySQL(String sql, Object... arg) {
        List<DichVu> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while(rs.next()) {
                DichVu dichvu = new DichVu(rs.getInt("IdDichVu"), rs.getString("TenDichVu"), rs.getDouble("Gia"), rs.getString("DonVi"), rs.getString("MoTa"), 
                        rs.getBoolean("TrangThai"), rs.getString("TenToaNha"));
                list.add(dichvu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
