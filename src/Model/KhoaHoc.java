/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

import jdbcHelper.DateHelper;

/**
 *
 * @author Admin
 */
public class KhoaHoc {

    private int maKhoaHoc;
    private String maChuyenDe;
    private String tenChuyenDe;
    private String ngayKhaiGiang;
    private String ghiChu;
    private String maNhanVien;
    private String ngayTao;
    private int thoiLuong;
    private double hocPhi;

    @Override
    public String toString() {
        return Integer.toString(this.maKhoaHoc);
    }

    public int getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(int maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public String getMaChuyenDe() {
        return maChuyenDe;
    }

    public void setMaChuyenDe(String maChuyenDe) {
        this.maChuyenDe = maChuyenDe;
    }

    public String getNgayKhaiGiang() {
        return ngayKhaiGiang;
    }

    public void setNgayKhaiGiang(String ngayKhaiGiang) {
        this.ngayKhaiGiang = ngayKhaiGiang;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

  

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public String getTenChuyenDe() {
        return tenChuyenDe;
    }

    public void setTenChuyenDe(String tenChuyenDe) {
        this.tenChuyenDe = tenChuyenDe;
    }


    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    
    
    
}