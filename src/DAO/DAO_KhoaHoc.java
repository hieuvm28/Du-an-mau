/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.KhoaHoc;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import jdbcHelper.DateHelper;
import jdbcHelper.JdbcHelper;

/**
 *
 * @author Admin
 */
public class DAO_KhoaHoc {

    public void insert(KhoaHoc model) {
        
        System.out.println("getMaChuyenDe: " +model.getMaChuyenDe());
        System.out.println("Ngay khai giang: " +model.getNgayKhaiGiang());
        System.out.println("MaNhanVien: " +model.getMaNhanVien());
        System.out.println("GhiChu: " +model.getGhiChu());
        System.out.println("NgayTao: " +model.getNgayTao());
                
        String sql = "INSERT INTO KhoaHoc (MaChuyenDe, NgayTao, NgayKhaiGiang, MaNhanVien, GhiChu) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, 
                model.getMaChuyenDe(),
                model.getNgayTao(),
                model.getNgayKhaiGiang(),
                model.getMaNhanVien(),
                model.getGhiChu());   
    }

    public void update(KhoaHoc kh) {
        String sql = "update KhoaHoc set MaChuyenDe = ?, NgayTao = ?, NgayKhaiGiang = ?, MaNhanVien = ?, GhiChu = ? where MaKhoaHoc = ?";
        jdbcHelper.JdbcHelper.executeUpdate(sql, kh.getMaChuyenDe(),
                kh.getNgayTao(),
                kh.getNgayKhaiGiang(),
                kh.getMaNhanVien(),
                kh.getGhiChu(),
                kh.getMaKhoaHoc());
    }

    public void delete(int ma) {
        String sql = "delete from KhoaHoc where MaKhoaHoc = ?";
        jdbcHelper.JdbcHelper.executeUpdate(sql, ma);
    }
    
    public KhoaHoc findById(int makh) {
        String sql = "select * from KhoaHoc where MaKhoaHoc = ?";
        ArrayList<KhoaHoc> list = select(sql, makh);
        //System.out.println(list.get(0));
        return list.get(0);
    }

    public ArrayList<KhoaHoc> select() {
        String sql = "select * from KhoaHoc";
        return select(sql);
    }

    private ArrayList<KhoaHoc> select(String sql, Object... args) {
        ArrayList<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhoaHoc model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private KhoaHoc readFromResultSet(ResultSet rs) throws SQLException {
        KhoaHoc model = new KhoaHoc();
        model.setMaKhoaHoc(rs.getInt(1));
        model.setNgayKhaiGiang(DateHelper.toString(rs.getDate(4)));
        model.setGhiChu(rs.getString(6));
        model.setMaNhanVien(rs.getString(5));
        model.setNgayTao(DateHelper.toString(rs.getDate(3)));
        model.setMaChuyenDe(rs.getString(2));
        System.out.println("ngày tạo: " + DateHelper.toString(rs.getDate(3)));
        System.out.println("ngày khai giảng: " + DateHelper.toString(rs.getDate(4)));
        return model;
    }
}
