
package dao;

import helper.XJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DichVuPhong;

/**
 *
 * @author Admin
 */
public class DichVuPhongDao extends NhaTroDao<DichVuPhong, Integer> {
    String selectbyphongsql = "select DICH_VU_PHONG.*,TenDichVu, Gia from DICH_VU_PHONG inner join DICH_VU on DICH_VU_PHONG.IdDichVu = DICH_VU.IdDichVu where IdPhong = ?";
    String updatesql = "update DICH_VU_PHONG set SoLuong = ? where Id = ?";
    String insertsql = "insert into DICH_VU_PHONG values (?,?,?)";
    String deleteAllDichVuPhong = "";
    @Override
    public void insert(DichVuPhong entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DichVuPhong entity) {
        XJDBC.update(updatesql, entity.getSoLuong());
    }

    
    
    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DichVuPhong> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DichVuPhong selectByID(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    protected List<DichVuPhong> selectBySQL(String sql, Object... arg) {
        List<DichVuPhong> list = new ArrayList<>();
        try {
            ResultSet rs = helper.XJDBC.query(sql, arg);
            while (rs.next()) {
                DichVuPhong dichvuphong = new DichVuPhong(
                        rs.getInt("Id"), rs.getInt("IdDichVu"), rs.getInt("IdPhong"), rs.getInt("SoLuong"), rs.getString("TenDichVu"), rs.getDouble("Gia")
                );
                list.add(dichvuphong);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
    
    public List<DichVuPhong> selectByIDPhong(Integer key) {
        return selectBySQL(selectbyphongsql, key);
    }
    
    public void updateDichVuPhong(int Soluong, int id) {
        XJDBC.update(updatesql, Soluong, id);
    }
    public void insertDichVuPhong(int iddv, int soluong, int idPhong) {
        XJDBC.update(insertsql, iddv, soluong, idPhong);
    }
}
