/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ChuyenDe;
import jdbcHelper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAO_ChuyenDe {

    public void insert(ChuyenDe objChuyenDe) {
        String sql = "insert into ChuyenDe values (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, 
                objChuyenDe.getMaChuyenDe(),
                objChuyenDe.getTenChuyenDe(),
                objChuyenDe.getHocPhi(),
                objChuyenDe.getThoiLuong(),
                objChuyenDe.getHinh(),
                objChuyenDe.getMoTa()
        );

    }

    public void update(ChuyenDe model) {
        String sql = "update ChuyenDe set TenChuyenDe = ?, HocPhi = ?, ThoiLuong = ?, Hinh = ?, MoTa = ? where MaChuyenDe = ?";
        JdbcHelper.executeUpdate(sql, model.getTenChuyenDe(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getHinh(),
                model.getMoTa(),
                model.getMaChuyenDe()
        );
    }

    public ChuyenDe findbyID(String ma){
        String sql = "Select * from ChuyenDe where MaChuyenDe = ?";
        ArrayList<ChuyenDe> listChuyenDe = select(sql, ma);
        return listChuyenDe.size() > 0 ? listChuyenDe.get(0) : null;
    }
    
    public void delete(String maCD) {
        String sql = "delete from ChuyenDe where MaChuyenDe = ?";
        JdbcHelper.executeUpdate(sql, maCD);
    }

    public ArrayList<ChuyenDe> select() {
        String sql = "select * from ChuyenDe";
        return select(sql);
    }

    private ArrayList<ChuyenDe> select(String sql, Object...cd) {
        ArrayList<ChuyenDe> listChuyenDe = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, cd);
                while (rs.next()) {
                    ChuyenDe model = readFromReslutSet(rs);
                    listChuyenDe.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listChuyenDe;
    }

    private ChuyenDe readFromReslutSet(ResultSet rs) throws SQLException{

        ChuyenDe model = new ChuyenDe();
        try {
            model.setMaChuyenDe(rs.getString(1));
            model.setTenChuyenDe(rs.getString(2));
            model.setHocPhi(rs.getDouble(3));
            model.setThoiLuong(rs.getInt(4));
            model.setHinh(rs.getString(5));
            model.setMoTa(rs.getString(6));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    

}
