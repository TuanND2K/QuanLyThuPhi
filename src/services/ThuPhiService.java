/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.KhoanPhiBatBuocModel;
import java.sql.*;
import Bean.*;
import java.util.List;
import java.util.ArrayList;
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
        }catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public List<ThuPhiBean> getListThuPhiBeans(){
        List<ThuPhiBean> list = new ArrayList<>();
        try {
            Connection conn = MysqlConnection.getMysqlConnection();
            String prepareQuery = "select * from khoan_phi_bat_buoc";
            PreparedStatement query = conn.prepareStatement(prepareQuery);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                ThuPhiBean thuPhiBean = new ThuPhiBean();
                KhoanPhiBatBuocModel khoanDongGop = thuPhiBean.getKhoanPhiModel();
                khoanDongGop.setMaPhi(rs.getString("maPhi"));
                khoanDongGop.setTenPhi(rs.getString("tenPhi"));
                khoanDongGop.setNgayBatDau(rs.getDate("batDau"));
                khoanDongGop.setNgayKetThuc(rs.getDate("ketThuc"));
                khoanDongGop.setMucPhi(rs.getInt("mucPhi"));
                
                list.add(thuPhiBean);
                /*try {
                     prepareQuery = "select * from thong_tin_ho_khau tthk join dong_gop dg on dg.idHoKhau = tthk.idHoKhau where maKhoanDongGop = ?";
                     query = conn.prepareStatement(prepareQuery);
                     query.setString(1, khoanDongGop.getMaPhi());
                     ResultSet rs1 = query.executeQuery();
                     List<HoKhauModel> listHoKhau = thuPhiBean.getListHoKhau();
                     List<DongGopModel> listDongGop = thuPhiBean.getListDongGop();
                     while(rs1.next()) {
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
                }catch (Exception e) {
                    e.printStackTrace();
                }*/
                
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("kich thuoc = " + list.size());
        return list;
    }
}
