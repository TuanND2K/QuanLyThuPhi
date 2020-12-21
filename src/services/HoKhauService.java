package services;

import Bean.ThongKeHoKhauBean;
import controllers.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.*;

/**
 *
 * @author Hai
 */
public class HoKhauService {
     
    public List<HoKhauModel> getListHoKhau() {
        List<HoKhauModel> list = new ArrayList<>();
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thong_tin_ho_khau";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                HoKhauModel hoKhauModel = new HoKhauModel();
                hoKhauModel.setID(rs.getInt("idHoKhau"));
                hoKhauModel.setIdChuHo(rs.getInt("idCHuHo"));
                hoKhauModel.setMaHoKhau(rs.getString("maHoKhau"));
                hoKhauModel.setTenChuHo(rs.getString("hoTen"));
                hoKhauModel.setSoLuongThanhVien(rs.getInt("soThanhVien"));
                
                list.add(hoKhauModel);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<HoKhauModel> getListHoChuaNopPhi(KhoanPhiBatBuocModel khoanPhiModel) {
        List<HoKhauModel> list = new ArrayList<>();
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM thong_tin_ho_khau WHERE thong_tin_ho_khau.idHoKhau "
                    + "NOT IN(SELECT idHoKhau FROM thu_phi WHERE maPhi = ?)";
            
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            preparedStatement.setString(1, khoanPhiModel.getMaPhi());
            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                HoKhauModel hoKhauModel = new HoKhauModel();
                hoKhauModel.setID(rs.getInt("idHoKhau"));
                hoKhauModel.setIdChuHo(rs.getInt("idCHuHo"));
                hoKhauModel.setMaHoKhau(rs.getString("maHoKhau"));
                hoKhauModel.setTenChuHo(rs.getString("hoTen"));
                hoKhauModel.setSoLuongThanhVien(rs.getInt("soThanhVien"));
                
                list.add(hoKhauModel);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ThongKeHoKhauBean getListKhoanDaNop(HoKhauModel hoKhauModel) {
        ThongKeHoKhauBean tkHoKhauBean = new ThongKeHoKhauBean(hoKhauModel);
        List<KhoanDongGopModel> listKhoanDongGop = tkHoKhauBean.getListKhoanDongGopModel();
        List<DongGopModel> listDongGop = tkHoKhauBean.getListKhoanDaDongGop();
        List<KhoanPhiBatBuocModel> listKhoanPhi = tkHoKhauBean.getListKhoanPhiModel();
        List<ThuPhiModel> listDongPhi = tkHoKhauBean.getListPhiDaNop();
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            
            //thong ke dong gop
            String query = "SELECT * FROM dong_gop dg, khoan_dong_gop kdg"
                    + " WHERE dg.maKhoanDongGop = kdg.maPhi AND idHoKhau = ?;";
            
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            preparedStatement.setInt(1, hoKhauModel.getID());
            
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                KhoanDongGopModel khoanDongGopModel = new KhoanDongGopModel();
                DongGopModel dongGopModel = new DongGopModel();
                
                khoanDongGopModel.setMaPhi(rs.getString("maPhi"));
                khoanDongGopModel.setTenPhi(rs.getString("tenPhi"));
                khoanDongGopModel.setNgayBatDau(rs.getDate("batDau"));
                khoanDongGopModel.setNgayKetThuc(rs.getDate("ketThuc"));
                listKhoanDongGop.add(khoanDongGopModel);
                
                dongGopModel.setNgayNop(rs.getDate("ngayNop"));
                dongGopModel.setSoTien(rs.getInt("soTien"));
                listDongGop.add(dongGopModel);
            }
            
            //thong ke thu phi
            query = "SELECT * FROM thu_phi tp, khoan_phi_bat_buoc kp"
                    + " WHERE tp.maPhi = kp.maPhi AND idHoKhau = ?;";
            
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            preparedStatement.setInt(1, hoKhauModel.getID());
            
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                KhoanPhiBatBuocModel khoanPhiModel = new KhoanPhiBatBuocModel();
                ThuPhiModel thuPhiModel = new ThuPhiModel();
                
                khoanPhiModel.setMaPhi(rs.getString("maPhi"));
                khoanPhiModel.setTenPhi(rs.getString("tenPhi"));
                khoanPhiModel.setNgayBatDau(rs.getDate("batDau"));
                khoanPhiModel.setNgayKetThuc(rs.getDate("ketThuc"));
                khoanPhiModel.setMucPhi(rs.getInt("mucPhi"));
                
                listKhoanPhi.add(khoanPhiModel);
                
                thuPhiModel.setNgayNop(rs.getDate("ngayNop"));
        
                listDongPhi.add(thuPhiModel);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tkHoKhauBean;
    }
}
