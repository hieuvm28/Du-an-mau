/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class ChuyenDe {

    public String maChuyenDe, tenChuyenDe;
    public int thoiLuong;
    public double hocPhi;
    public String moTa;
    public String hinh;

    public ChuyenDe(String maChuyenDe, String tenChuyenDe, int thoiLuong, double hocPhi, String hinh, String moTa) {
        this.maChuyenDe = maChuyenDe;
        this.tenChuyenDe = tenChuyenDe;
        this.thoiLuong = thoiLuong;
        this.hocPhi = hocPhi;
        this.moTa = moTa;
        this.hinh = hinh;
    }

    public ChuyenDe() {
    }

    public ChuyenDe(String tenChuyenDe) {
        this.tenChuyenDe = tenChuyenDe;
    }

    public String getMaChuyenDe() {
        return maChuyenDe;
    }

    public void setMaChuyenDe(String maChuyenDe) {
        this.maChuyenDe = maChuyenDe;
    }

    public String getTenChuyenDe() {
        return tenChuyenDe;
    }

    public void setTenChuyenDe(String tenChuyenDe) {
        this.tenChuyenDe = tenChuyenDe;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return this.tenChuyenDe;
                
    }

   

}
