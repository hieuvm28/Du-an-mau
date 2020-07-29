/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbcHelper.DateHelper;
import jdbcHelper.JdbcHelper;

/**
 *
 * @author Admin
 */
public class DAO_ThongKe {

    public ArrayList<Object[]> getNguoiHoc() {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select YEAR(NgayDangKy) Nam,count(*) SoLuong,min(NgayDangKy) DauTien,max(NgayDangKy) CuoiCung from NguoiHoc group by year(NgayDangKy)";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    
                    Object[] row = {
                        rs.getInt("Nam"),
                        rs.getInt("SoLuong"),
                        rs.getDate("DauTien"),
                        rs.getDate("CuoiCung")
                    };
                    list.add(row);
                }

            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object[]> getBangDiem(Integer makh) {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select \n"
                        + "		NguoiHoc.MaNguoiHoc,\n"
                        + "		NguoiHoc.HoTen,\n"
                        + "		HocVien.DiemTrungBinh\n"
                        + "	from HocVien \n"
                        + "	join NguoiHoc on HocVien.MaNguoiHoc = NguoiHoc.MaNguoiHoc\n"
                        + "	where HocVien.MaKhoaHoc = ?\n"
                        + "	order by HocVien.DiemTrungBinh desc";
                rs = JdbcHelper.executeQuery(sql, makh);
                while (rs.next()) {
                    double diem = rs.getDouble(3);
                    String xepLoai = "Xuất sắc";

                    if (diem < 0) {
                        xepLoai = "Chưa nhập";
                    } else if (diem < 3) {
                        xepLoai = "Kém";
                    } else if (diem < 5) {
                        xepLoai = "Yếu";
                    } else if (diem < 6.5) {
                        xepLoai = "Trung Bình";
                    } else if (diem < 7.5) {
                        xepLoai = "Khá";
                    } else if (diem < 9) {
                        xepLoai = "Giỏi";
                    }

                    Object[] row = {
                        rs.getString(1),
                        rs.getString(2),
                        diem,
                        xepLoai
                    };
                    list.add(row);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Object[]> getDiemTheoChuyenDe() {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "SELECT\n"
                        + "		TenChuyenDe ChuyenDe,\n"
                        + "		COUNT(MaHocVien) SoHV,\n"
                        + "		MIN(DiemTrungBinh) ThapNhat,\n"
                        + "		MAX(DiemTrungBinh) CaoNhat,\n"
                        + "		AVG(DiemTrungBinh) TrungBinh\n"
                        + "FROM KhoaHoc kh\n"
                        + "JOIN HocVien hv ON kh.MaKhoaHoc=hv.MaKhoaHoc\n"
                        + "JOIN ChuyenDe cd ON cd.MaChuyenDe=kh.MaChuyenDe\n"
                        + "GROUP BY TenChuyenDe";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getDouble(4),
                        rs.getDouble(3),
                        rs.getDouble(5)
                    };
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

    public ArrayList<Object[]> getDoanhThu(int nam) {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "select\n"
                        + "		TenChuyenDe                                     ChuyenDe,\n"
                        + "		count(Distinct KhoaHoc.MaKhoaHoc)               SoKhoaHoc,\n"
                        + "		count(HocVien.MaHocVien)			SoHocVien,\n"
                        + "		sum(ChuyenDe.HocPhi)				DoanhThu,\n"
                        + "		max(ChuyenDe.HocPhi)				CaoNhat,\n"
                        + "		min(ChuyenDe.HocPhi)				NhapNhat,\n"
                        + "		avg(ChuyenDe.HocPhi)				TrungBinh\n"
                        + "	from KhoaHoc \n"
                        + "	   join HocVien on KhoaHoc.MaKhoaHoc = HocVien.MaKhoaHoc\n"
                        + "	   join ChuyenDe on ChuyenDe.MaChuyenDe = KhoaHoc.MaChuyenDe\n"
                        + "	where year(NgayKhaiGiang) = ?\n"
                        + "	group by TenChuyenDe";
                rs = JdbcHelper.executeQuery(sql, nam);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        rs.getDouble(7)
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
