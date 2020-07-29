/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbcHelper.JdbcHelper;

/**
 *
 * @author Admin
 */
public class DAO_NhanVien {

    public void insert(NhanVien nv) {
        String sql = "insert into NhanVien values (?,? ,? ,? )";
        JdbcHelper.executeUpdate(sql,
                nv.getMaNhanVien(),
                nv.getMatKhau(),
                nv.getNameNV(),
                nv.isRole());
    }

    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET MatKhau= ?, HoTen= ?, VaiTro=? WHERE MaNhanVien= ?";
        JdbcHelper.executeUpdate(sql,
                model.getMatKhau(),
                model.getNameNV(),
                model.isRole(),
                model.getMaNhanVien());
    }

    public void delete(String maNv) {
        String sql = "delete from NhanVien where MaNhanVien = ?";
        JdbcHelper.executeUpdate(sql, maNv);
    }

    public NhanVien findById(String maNV) {
        String sql = "select * from NhanVien where MaNhanVien = ?";
        ArrayList<NhanVien> list = select(sql, maNV);
        return list.get(0);
    }

    public ArrayList<NhanVien> select() {
        String sql = "select * from NhanVien";
        return select(sql);
    }

    public ArrayList<NhanVien> select(String sql, Object... nv) {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, nv);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            } 
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return list;
    }

    public NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(rs.getString(1));
        nv.setMatKhau(rs.getString(2));
        nv.setNameNV(rs.getString(3));
        nv.setRole(rs.getBoolean(4));
       
        return nv;
    }
}
