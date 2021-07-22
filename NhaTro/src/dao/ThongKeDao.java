/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DichVu;

/**
 *
 * @author Admin
 */
public class ThongKeDao {
    String soToaNha = "select count(IdToaNha) from TOA_NHA";
//    String soKhachThue = "select count(IdKhachThue) from KHACH_THUE";
    String soKhachThue = "select count(DISTINCT IdKhachThue) from PHONG_THUE";
    String soPhongTrong = "select count(IdPhong) from PHONG where TrangThai = 0";
    String soPhongDaThue = "select count(IdPhong) from PHONG where TrangThai = 1";
    String soPhong = "select count(IdPhong) from PHONG where TrangThai = ?";
    String selectbyToaNha = "select Phong.* ,TOA_NHA.TenToaNha, KHACH_THUE.HoVaTen\n" +
"from TOA_NHA inner join PHONG on PHONG.IdToaNha = TOA_NHA.IdToaNha\n" +
"	inner Join PHONG_THUE on Phong.IdPhong = PHONG_THUE.IdPhong\n" +
"	inner join KHACH_THUE on PHONG_THUE.IdKhachThue = KHACH_THUE.IdKhachThue\n" +
"	where TOA_NHA.IdToaNha = ? and KHACH_THUE.VaiTro = 1";
    public Integer demSoToaNha() {
        return selectBySQL(soToaNha).get(0);
    }
    public Integer demSoKhachThue() {
        return selectBySQL(soKhachThue).get(0);
    }
    public Integer demSoPhong(int key) {
        return selectBySQL(soPhong, key).get(0);
    }
    
    protected List<Integer> selectBySQL(String sql, Object... arg) {
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while(rs.next()) {
                list.add(rs.getInt(1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
