/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Bean.DongGopBean;
import controllers.LoginController;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.DongGopModel;
import models.HoKhauModel;

import models.KhoanDongGopModel;

/**
 *
 * @author TuanNguyen
 */
public class DongGopService {

    public boolean addNew(KhoanDongGopModel khoanDongGop) {
        try {
            Connection conn = MysqlConnection.getMysqlConnection();
            PreparedStatement insertKhoanDongGop = conn.prepareStatement("insert into khoan_dong_gop values(?, ?, ?, ?)");
            insertKhoanDongGop.setString(1, khoanDongGop.getMaPhi());
            insertKhoanDongGop.setString(2, khoanDongGop.getTenPhi());
            Date batDau = new Date(khoanDongGop.getNgayBatDau().getTime());
            insertKhoanDongGop.setDate(3, batDau);
            Date ketThuc = new Date(khoanDongGop.getNgayKetThuc().getTime());
            insertKhoanDongGop.setDate(4, ketThuc);
            insertKhoanDongGop.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DongGopService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DongGopService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<DongGopBean> getListDongGopBeans() {
        List<DongGopBean> list = new ArrayList<>();
        try {
            Connection conn = MysqlConnection.getMysqlConnection();
            String prepareQuery = "select * from khoan_dong_gop";
            PreparedStatement query = conn.prepareStatement(prepareQuery);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                DongGopBean dongGopBean = new DongGopBean();
                KhoanDongGopModel khoanDongGop = dongGopBean.getKhoanDongGopModel();
                khoanDongGop.setMaPhi(rs.getString("maPhi"));
                khoanDongGop.setTenPhi(rs.getString("tenPhi"));
                khoanDongGop.setNgayBatDau(rs.getDate("batDau"));
                khoanDongGop.setNgayKetThuc(rs.getDate("ketThuc"));
                list.add(dongGopBean);
                try {
                    prepareQuery = "select * from thong_tin_ho_khau tthk join dong_gop dg on dg.idHoKhau = tthk.idHoKhau where maKhoanDongGop = ?";
                    query = conn.prepareStatement(prepareQuery);
                    query.setString(1, khoanDongGop.getMaPhi());
                    ResultSet rs1 = query.executeQuery();
                    List<HoKhauModel> listHoKhau = dongGopBean.getListHoKhau();
                    List<DongGopModel> listDongGop = dongGopBean.getListDongGop();
                    while (rs1.next()) {
                        HoKhauModel hoKhau = new HoKhauModel();
                        hoKhau.setID(rs1.getInt("idHoKhau"));
                        hoKhau.setMaHoKhau(rs1.getString("maHoKhau"));
                        hoKhau.setIdChuHo(rs1.getInt("idChuHo"));
                        hoKhau.setTenChuHo(rs1.getString("hoTen"));
                        hoKhau.setSoLuongThanhVien(rs1.getInt("soThanhVien"));
                        listHoKhau.add(hoKhau);

                        DongGopModel dongGop = new DongGopModel();
                        dongGop.setIdHoKhau(rs1.getInt("idHoKhau"));
                        dongGop.setMaPhi(rs1.getString("maKhoanDongGop"));
                        dongGop.setSoTien(rs1.getInt("soTien"));
                        dongGop.setNgayNop(rs1.getDate("ngayNop"));
                        listDongGop.add(dongGop);
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

    /*
    public List<DongGopBean> getListDongGop() {
        List<DongGopBean> list = new ArrayList<>();
        try {
            Connection conn = MysqlConnection.getMysqlConnection();
            String prepareQuery = "select * from khoan_dong_gop kdg, ho_khau hk "
                    + "where kdg.maPhi = dg.maKhoanDongGop and hk.ID = dg.idHoKhau";
            PreparedStatement query = conn.prepareStatement(prepareQuery);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                DongGopBean dongGopBean = new DongGopBean();
                KhoanDongGopModel khoanDongGop = dongGopBean.getKhoanDongGopModel();
                khoanDongGop.setMaPhi(rs.getString("maPhi"));
                khoanDongGop.setTenPhi(rs.getString("tenPhi"));
                khoanDongGop.setNgayBatDau(rs.getDate("batDau"));
                khoanDongGop.setNgayKetThuc(rs.getDate("ketThuc"));
                
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        //System.out.println("kich thuoc = " + list.size());
        return list;
    }*/
    public boolean capNhatDongGop(DongGopModel dongGop) {
        if(dongGop == null) return false;
        try {
            Connection conn = MysqlConnection.getMysqlConnection();
            PreparedStatement insertDongGop = conn.prepareStatement("insert into dong_gop values(?, ?, ?, ?, ?)");
            insertDongGop.setInt(1, dongGop.getIdHoKhau());
            insertDongGop.setString(2, dongGop.getMaPhi());
            insertDongGop.setInt(3, LoginController.currentUser.getID());
            Date ngayNop = new Date(dongGop.getNgayNop().getTime());
            insertDongGop.setDate(4, ngayNop);
            insertDongGop.setInt(5, dongGop.getSoTien());
            insertDongGop.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Hộ đã đóng tiền trước đó", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DongGopService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean suaDongGop(KhoanDongGopModel khoanDongGop) {
        try {
            Connection conn = MysqlConnection.getMysqlConnection();
            PreparedStatement query = conn.prepareStatement("update khoan_dong_gop"
                    + " set tenPhi = ? where maPhi = ?");
            query.setString(1, khoanDongGop.getTenPhi());
            query.setString(2, khoanDongGop.getMaPhi());
            
            query.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
