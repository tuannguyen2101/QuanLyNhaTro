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
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class HoaDonDao extends NhaTroDao<HoaDon, Integer> {

    String selectAllSql = "select HOA_DON.*, PHONG.Phong, TOA_NHA.TenToaNha \n"
            + "from HOA_DON inner join PHONG  on HOA_DON.IdPhong = PHONG.IdPhong\n"
            + "				inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha";
    String selectHoaDonSql = "select HOA_DON.*, PHONG.Phong, TOA_NHA.TenToaNha \n"
            + "from HOA_DON inner join PHONG  on HOA_DON.IdPhong = PHONG.IdPhong\n"
            + "				inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha where Thang = ? and Nam = ? and HOA_DON.TrangThai = ?";
    String selectyID = "select HOA_DON.*, PHONG.Phong, TOA_NHA.TenToaNha \n"
            + "from HOA_DON inner join PHONG  on HOA_DON.IdPhong = PHONG.IdPhong\n"
            + "				inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha where IdHoaDon = ?";
    String insertsql = "insert into HOA_DON values (?,?,?,?)";
    String deletesql = "delete from HOA_DON where IdHoaDon = ?";
    String updatesql = "update HOA_DON set TrangThai = ? where IdHoaDon = ?";
    String selectHoaDonByKhachThue = "select HOA_DON.*, PHONG.Phong, TOA_NHA.TenToaNha \n"
            + "from HOA_DON inner join PHONG  on HOA_DON.IdPhong = PHONG.IdPhong\n"
            + "				inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha where HOA_DON.IdPhong in (select IdPhong from PHONG_THUE where IdKhachThue = ?)";
    String selectHoaDonByIdPhong = "select HOA_DON.*, PHONG.Phong, TOA_NHA.TenToaNha \n"
            + "from HOA_DON inner join PHONG  on HOA_DON.IdPhong = PHONG.IdPhong\n"
            + "				inner join TOA_NHA on PHONG.IdToaNha = TOA_NHA.IdToaNha where HOA_DON.IdPhong = ?";
    @Override
    public void insert(HoaDon entity) {
        XJDBC.update(insertsql, entity.getThang(), entity.getNam(), entity.isTrangThai(), entity.getIdPhong());
    }

    @Override
    public void update(HoaDon entity) {
        XJDBC.update(updatesql, entity.isTrangThai(), entity.getIdHoaDon());
    }

    @Override
    public void delete(Integer key) {
        XJDBC.update(deletesql, key);
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySQL(selectAllSql);
    }

    public List<HoaDon> selectByCbo(int thang, int nam, boolean trangthai) {
        return selectBySQL(selectHoaDonSql, thang, nam, trangthai);
    }
    public List<HoaDon> selectByKhachThue(int idkhachthue) {
        return selectBySQL(selectHoaDonByKhachThue, idkhachthue);
    }
    public List<HoaDon> selectByPhong(int idPhong) {
        return selectBySQL(selectHoaDonByIdPhong, idPhong);
    }
    
    @Override
    public HoaDon selectByID(Integer key) {
        List<HoaDon> list = selectBySQL(selectyID, key);
        if(list.isEmpty()) {
            return null;
        }
        else return list.get(0);
    }

    @Override
    protected List<HoaDon> selectBySQL(String sql, Object... arg) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(
                        new HoaDon(rs.getInt("IdHoaDon"), rs.getInt("IdPhong"), rs.getString("TenToaNha"), rs.getString("Phong"), rs.getInt("Thang"), rs.getInt("Nam"), rs.getBoolean("TrangThai"))
                );
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
