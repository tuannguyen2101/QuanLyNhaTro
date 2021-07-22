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
import model.HoaDonChiTiet;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietDao extends NhaTroDao<HoaDonChiTiet, Integer> {

    String selectbyidHoaDon = "SELECT * FROM HOA_DON_CHI_TIET WHERE IdHoaDon = ?";
    String insertsql = "insert into HOA_DON_CHI_TIET values (?,?,?,?,?,?)";
    String deletesql = "delete from HOA_DON_CHI_TIET where IdHoaDon = ?";
    String updatesql = "update HOA_DON_CHI_TIET set SoCu = ?, SoMoi = ?, SuDung = ? where IdHoaDon = ?";
    @Override
    public void insert(HoaDonChiTiet entity) {
        XJDBC.update(insertsql, entity.getIdHoaDon(), entity.getKhoanThu(), entity.getSoCu(), entity.getSoMoi(), entity.getSuDung(),entity.getGia());
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        XJDBC.update(updatesql, entity.getSoCu(), entity.getSoMoi(), entity.getSuDung(),entity.getIdHoaDon());
    }

    @Override
    public void delete(Integer key) {
        XJDBC.update(deletesql, key);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HoaDonChiTiet selectByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<HoaDonChiTiet> selectByIDHoaDon(int key) {
        return selectBySQL(selectbyidHoaDon, key);
    }

    @Override
    protected List<HoaDonChiTiet> selectBySQL(String sql, Object... arg) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(
                        new HoaDonChiTiet(rs.getInt("IdHoaDonChiTiet"), rs.getInt("IdHoaDon"), rs.getString("KhoanThu"), rs.getInt("SoCu"), rs.getInt("SoMoi"),rs.getInt("SuDung"), rs.getDouble("Gia"))
                );
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double getTienPhongbyHoaDon(int key) {
        double tienPhong = 0;
        try {
            ResultSet rs = helper.XJDBC.query("select * from HOA_DON_CHI_TIET\n"
                    + "where KhoanThu like N'Tiền Phòng' and IdHoaDon = ?", key);
            while (rs.next()) {
                tienPhong = rs.getDouble("ThanhTien");
            }
            rs.getStatement().getConnection().close();
            return tienPhong;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
