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
import model.SuCo;

/**
 *
 * @author Admin
 */
public class SuCoDao extends NhaTroDao<SuCo, Integer> {

    String selectSuCoFalse = "select * from Su_Co where TrangThai = 0";
    String selectSuCoTrue = "select * from Su_Co where TrangThai = 1";
    String insert = "insert into Su_Co values(?, ?, ?, ?, ?, ?, ?)";
    String update = "update Su_Co set TrangThai = 1 where id = ?";
    String delete = "delete from Su_Co where id = ? ";
    String selectbyid = "select * from So_Co where id = ?";

    String selectbyIdKhachThue = "select TOA_NHA.TenToaNha, Phong.Phong, KHACH_THUE.HoVaTen "
            + "from TOA_NHA inner join PHONG on TOA_NHA.IdToaNha = Phong.IdToaNha "
            + "inner join PHONG_THUE on Phong.IdPhong = PHONG_THUE.IdPhong "
            + "inner join KHACH_THUE on PHONG_THUE.IdKhachThue = KHACH_THUE.IdKhachThue "
            + "where KHACH_THUE.IdKhachThue = ?";

    @Override
    public void insert(SuCo entity) {
        XJDBC.update(insert,
                entity.getMota(),
                entity.getNha(),
                entity.getPhong(),
                entity.getNguoibao(),
                entity.getNgaybao(),
                entity.getGhichu(),
                entity.isTrangthai()
        );
    }

    @Override
    public void update(SuCo entity) {
        XJDBC.update(update, entity.getIdsuco());
    }

    public void updateSuCo(Integer key) {
        XJDBC.update(update, key);
    }

    @Override
    public void delete(Integer key) {
        XJDBC.update(delete, key);
    }

    @Override
    public List<SuCo> selectAll() {
        return null;
    }

    public List<SuCo> selectFalse() {
        return selectBySQL(selectSuCoFalse);
    }

    public List<SuCo> selectTrue() {
        return selectBySQL(selectSuCoTrue);
    }

    @Override
    public SuCo selectByID(Integer key) {
        List<SuCo> list = selectBySQL(selectbyid, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public SuCo selectByIdKhachThue(Integer key) {
        List<SuCo> list = selectBySQL(selectbyIdKhachThue, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<SuCo> selectBySQL(String sql, Object... arg) {
        List<SuCo> list = new ArrayList<>();
        try {
            ResultSet rs = XJDBC.query(sql, arg);
            while (rs.next()) {
                list.add(new SuCo(rs.getInt("id"),
                        rs.getString("mota"),
                        rs.getString("Nha"),
                        rs.getString("Phong"),
                        rs.getString("nguoibao"),
                        rs.getString("Ngaybao"),
                        rs.getString("Ghichu"),
                        rs.getBoolean("TrangThai")
                ));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
