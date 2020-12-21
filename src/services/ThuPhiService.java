/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.KhoanPhiBatBuocModel;
import java.sql.*;
import Bean.*;
import controllers.LoginController;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.HoKhauModel;
import models.ThuPhiModel;

/**
 *
 * @author TuanNguyen
 */
public class ThuPhiService {

    public boolean addNew(KhoanPhiBatBuocModel khoanPhiModel) {
        try {
            Connection conn = MysqlConnection.getMysqlConnection();
            PreparedStatement query = conn.prepareStatement("insert into khoan_phi_bat_buoc values(?, ?, ?, ?, ?)");
            query.setString(1, khoanPhiModel.getMaPhi());
            query.setString(2, khoanPhiModel.getTenPhi());
            Date date = new Date(khoanPhiModel.getNgayBatDau().getTime());
            query.setDate(3, date);
            date = new Date(khoanPhiModel.getNgayKetThuc().getTime());
            query.setDate(4, date);
            query.setInt(5, khoanPhiModel.getMucPhi());

            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<ThuPhiBean> getListThuPhiBeans() {
        List<ThuPhiBean> list = new ArrayList<>();
        try {
            Connection conn = MysqlConnection.getMysqlConnection();
            String prepareQuery = "select * from khoan_phi_bat_buoc";
            PreparedStatement query = conn.prepareStatement(prepareQuery);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                ThuPhiBean thuPhiBean = new ThuPhiBean();
                KhoanPhiBatBuocModel khoanPhi = thuPhiBean.getKhoanPhiModel();
                khoanPhi.setMaPhi(rs.getString("maPhi"));
                khoanPhi.setTenPhi(rs.getString("tenPhi"));
                khoanPhi.setNgayBatDau(rs.getDate("batDau"));
                khoanPhi.setNgayKetThuc(rs.getDate("ketThuc"));
                khoanPhi.setMucPhi(rs.getInt("mucPhi"));
                list.add(thuPhiBean);
                try {
                    prepareQuery = "select * from thong_tin_ho_khau tthk join thu_phi tp on tp.idHoKhau = tthk.idHoKhau where maPhi = ?";
                    query = conn.prepareStatement(prepareQuery);
                    query.setString(1, khoanPhi.getMaPhi());
                    ResultSet rs1 = query.executeQuery();
                    List<HoKhauModel> listHoKhau = thuPhiBean.getListHoKhau();
                    List<ThuPhiModel> listThuPhi = thuPhiBean.getListThuPhi();
                    while (rs1.next()) {
                        HoKhauModel hoKhau = new HoKhauModel();
                        hoKhau.setID(rs1.getInt("idHoKhau"));
                        hoKhau.setMaHoKhau(rs1.getString("maHoKhau"));
                        hoKhau.setIdChuHo(rs1.getInt("idChuHo"));
                        hoKhau.setTenChuHo(rs1.getString("hoTen"));
                        hoKhau.setSoLuongThanhVien(rs1.getInt("soThanhVien"));
                        listHoKhau.add(hoKhau);

                        ThuPhiModel thuPhi = new ThuPhiModel();
                        thuPhi.setIdHoKhau(rs1.getInt("idHoKhau"));
                        thuPhi.setMaPhi(rs1.getString("maPhi"));
                        thuPhi.setNgayNop(rs1.getDate("ngayNop"));
                        listThuPhi.add(thuPhi);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean capNhatThuPhi(ThuPhiModel thuPhi) {
        if(thuPhi == null) return false;
        try {
            Connection conn = MysqlConnection.getMysqlConnection();
            PreparedStatement insertThuPhi = conn.prepareStatement("insert into thu_phi values(?, ?, ?, ?)");
            insertThuPhi.setInt(1, thuPhi.getIdHoKhau());
            insertThuPhi.setString(2, thuPhi.getMaPhi());
            insertThuPhi.setInt(3, LoginController.currentUser.getID());
            Date ngayNop = new Date(thuPhi.getNgayNop().getTime());
            insertThuPhi.setDate(4, ngayNop);
            insertThuPhi.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Hộ đã đóng tiền trước đó", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DongGopService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DongGopService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}
