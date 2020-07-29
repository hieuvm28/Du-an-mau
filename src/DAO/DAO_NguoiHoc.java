/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import GUI.PalNguoiHoc;
import Model.NguoiHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbcHelper.DateHelper;
import jdbcHelper.JdbcHelper;

/**
 *
 * @author Admin
 */


public class DAO_NguoiHoc {
    public void insert(NguoiHoc model){
        String sql = "insert into NguoiHoc values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaNguoiHoc(),
                model.getHoTen(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getDt(),
                model.getEmail(),
                model.getGhiChu(),
                model.getMaNhanVien(),
                model.getNgayDK()
                );
    }
    
    public void update(NguoiHoc model){
        String sql = "update NguoiHoc set HoTen =?, NgaySinh = ?, GioiTinh = ?, SoDienThoai = ?, Email = ?, GhiChu = ?, MaNhanVien = ? where MaNguoiHoc = ?";
        JdbcHelper.executeUpdate(sql, model.getHoTen(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getDt(),
                model.getEmail(),
                model.getGhiChu(),
                model.getMaNhanVien(),
                model.getMaNguoiHoc());
    }
    
    public void delete(String id){
        String sql = "Delete from NguoiHoc where MaNguoiHoc = ? ";
        JdbcHelper.executeUpdate(sql, id);
    }
    
    public ArrayList<NguoiHoc> selectByKeyword(String keyword){
        String sql = "select * from NguoiHoc where HoTen like ?";
        return select(sql, "%" + keyword + "%");
    }
    
    public ArrayList<NguoiHoc> selectByKeywordEmail(String keyword){
        String sql = "select * from NguoiHoc where Email like ?";
        return select(sql, "%" + keyword + "%");
    }
    
    
    public ArrayList<NguoiHoc> selectNyCourse(Integer makh){
        String sql = "select * from NguoiHoc where MaNguoiHoc not in (Select MaNguoiHoc from HocVien where MaKhoaHoc = ?)";
        return select(sql, makh);
    }
    
    public NguoiHoc findById(String manh){
        String sql = "select * from NguoiHoc where MaNguoiHoc = ?";
        ArrayList<NguoiHoc> list = select(sql, manh);
        return list.get(0);
    }
    
    public ArrayList<NguoiHoc> select(){
        String sql = "select * from NguoiHoc";
        return select(sql);
    }
    
    public ArrayList<NguoiHoc> select(String sql, Object...args){
        ArrayList<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {                    
                    NguoiHoc nh = readFromResultSet(rs);
                    list.add(nh);
                }
            } finally{
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public NguoiHoc readFromResultSet(ResultSet rs) throws SQLException{
        NguoiHoc model = new NguoiHoc();
        model.setMaNguoiHoc(rs.getString(1));
        model.setHoTen(rs.getString(2));
        model.setNgaySinh(DateHelper.toString(rs.getDate(3)));
        model.setGioiTinh(rs.getBoolean(4));
        model.setDt(rs.getString(5));
        model.setEmail(rs.getString(6));
        model.setGhiChu(rs.getString(7));
        model.setMaNhanVien(rs.getString(8));
        model.setNgayDK(DateHelper.toString(rs.getDate(9)));
        return  model;
    }
}
