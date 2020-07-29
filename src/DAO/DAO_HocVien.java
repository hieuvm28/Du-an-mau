/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.HocVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbcHelper.JdbcHelper;

/**
 *
 * @author Admin
 */
public class DAO_HocVien {
    public void insert(HocVien model){
        String sql = "insert into HocVien values(?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaKhoaHoc(),
                model.getMaNguoiHoc(),
                model.getDiem());
    }
    
    public void update(HocVien model){
        String sql = "UPDATE HocVien SET MaKhoaHoc=?, MaNguoiHoc=?, DiemTrungBinh=? WHERE MaHocVien=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaKhoaHoc(),
                model.getMaNguoiHoc(),
                model.getDiem(),
                model.getMaHocVien());
    }
    
    public void delete(int maHV){
        String sql = "delete from HocVien where MaHocVien = ?";
        JdbcHelper.executeUpdate(sql, maHV);
    }
    
    public ArrayList<HocVien> select(){
        String sql = "Select * from HocVien";
        return select(sql);
    }
    
    public HocVien finById(int mahv){
        String sql = "Select * from HocVien where MaHocVien = ?";
        ArrayList<HocVien> list = select(sql, mahv);
        return list.get(0);
    }
    
    public ArrayList<HocVien> select(String sql, Object...args){
        ArrayList<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {                    
                    HocVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    private HocVien readFromResultSet(ResultSet rs) throws SQLException{
        HocVien model = new HocVien();
        model.setMaHocVien(rs.getInt(1));
        model.setMaKhoaHoc(rs.getInt(2));
        model.setMaNguoiHoc(rs.getString(3));
        model.setDiem(rs.getDouble(4));
        return model;
    }

    
}
