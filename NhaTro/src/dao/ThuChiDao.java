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
import model.KhoanThu;

/**
 *
 * @author Admin
 */
public class ThuChiDao {

    String thusql = "select SUM(HOA_DON_CHI_TIET.SuDung*HOA_DON_CHI_TIET.Gia) as TongTien\n"
            + "from HOA_DON_CHI_TIET  inner join HOA_DON on HOA_DON_CHi_TIET.IdHoaDon = HOA_DON.IdHoaDon\n"
            + "where HOA_DON.Thang = ? and Nam = ?";

    public KhoanThu selectbythangnam(int thang, int nam) {
        List<KhoanThu> list = selectBySQL(thusql, thang, nam);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    protected List<KhoanThu> selectBySQL(String sql, Object... arg) {
        List<KhoanThu> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(new KhoanThu(rs.getInt(1)));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
