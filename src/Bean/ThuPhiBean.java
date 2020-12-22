package Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import models.HoKhauModel;
import models.KhoanPhiBatBuocModel;
import models.ThuPhiModel;
import services.HoKhauService;


public class ThuPhiBean {

    private KhoanPhiBatBuocModel khoanPhiModel;
    private List<HoKhauModel> listHoKhau;
    private List<ThuPhiModel> listThuPhi;

    public ThuPhiBean() {
        khoanPhiModel = new KhoanPhiBatBuocModel();
        listHoKhau = new ArrayList<>();
        listThuPhi = new ArrayList<>();
    }

    public ThuPhiBean(KhoanPhiBatBuocModel khoanPhiModel, List<HoKhauModel> listHoKhau, List<ThuPhiModel> listThuPhi) {
        this.khoanPhiModel = khoanPhiModel;
        this.listHoKhau = listHoKhau;
        this.listThuPhi = listThuPhi;
    }

    public KhoanPhiBatBuocModel getKhoanPhiModel() {
        return khoanPhiModel;
    }

    public void setKhoanPhiModel(KhoanPhiBatBuocModel khoanPhiModel) {
        this.khoanPhiModel = khoanPhiModel;
    }

    public List<HoKhauModel> getListHoKhau() {
        return listHoKhau;
    }

    public void setListHoKhau(List<HoKhauModel> listHoKhau) {
        this.listHoKhau = listHoKhau;
    }

    public List<ThuPhiModel> getListThuPhi() {
        return listThuPhi;
    }

    public void setListThuPhi(List<ThuPhiModel> listThuPhi) {
        this.listThuPhi = listThuPhi;
    }
    
    private int getTongThuPhi() {
        int sum = 0;
        int mucPhi = khoanPhiModel.getMucPhi();
        for (int i = 0; i < listHoKhau.size(); i++) {
            sum += listHoKhau.get(i).getSoLuongThanhVien() * mucPhi;
        }
        return sum;
    }

    /**
     *
     * @return hien thi thong tin bang html
     */
    @Override
    public String toString() {
        
        String res = "<html> <style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
                    + "<h3>Thông tin cơ bản"
                    + "<p>Mã khoản phí: <b>" + khoanPhiModel.getMaPhi() + "</p>"
                    + "<p>Tên khoản phí: <b>" + khoanPhiModel.getTenPhi() + "</p>"
                    + "<p>Ngày bắt đầu: <b>" + khoanPhiModel.getNgayBatDau() + "</p>"
                    + "<p>Ngày kết thúc: <b>" + khoanPhiModel.getNgayKetThuc() + "</p>"
                    + "<p>Tổng số tiền đã thu được: <b>" + getTongThuPhi() + ".000 đ</p>"
                    + "<h4>Danh sách hộ nộp phí: " + listHoKhau.size() + " hộ đã nộp<table>"
                    + "<tr>"
                    + "<th>ID hộ</th>"
                    + "<th>Mã hộ</th>"
                    + "<th>ID chủ hộ</th>"
                    + "<th>Tên chủ hộ</th>"
                    + "<th>Số tiền</th>"
                    + "<th>Ngày đóng</th>"
                    + "</tr>";
        
        int mucPhi = khoanPhiModel.getMucPhi();
        for (int i = 0; i < listHoKhau.size(); i++) {
            int soThanhVien = listHoKhau.get(i).getSoLuongThanhVien();
            res += "<tr>"
                    + "<td>" + listHoKhau.get(i).getID() + "</td>"
                    + "<td>" + listHoKhau.get(i).getMaHoKhau() + "</td>"
                    + "<td>" + listHoKhau.get(i).getIdChuHo() + "</td>"
                    + "<td>" + listHoKhau.get(i).getTenChuHo() + "</td>" 
                    + "<td>" + soThanhVien*mucPhi+ ".000 đ</td>"
                    + "<td>" + listThuPhi.get(i).getNgayNop() + "</td>"
                    + "</tr>";
        }
        res += "</table>";
        
        Set<HoKhauModel> setHoChuaNop = new HashSet<>(new HoKhauService().getListHoChuaNopPhi(khoanPhiModel));
        setHoChuaNop.removeAll(listHoKhau);
        res += "<P/>"
                + "<h4>Danh sách chưa nộp: " + setHoChuaNop.size() + " hộ chưa nộp<table>"
                + "<tr>"
                + "<th>ID hộ</th>"
                + "<th>Mã hộ</th>"
                + "<th>ID chủ hộ</th>"
                + "<th>Tên chủ hộ</th>"
                + "<th>Số tiền cần nộp</th>"
                + "</tr>";                    
        for (HoKhauModel hoChuaNop : setHoChuaNop) {
            int soThanhVien = hoChuaNop.getSoLuongThanhVien();
            res += "<tr>"
                    + "<td>" + hoChuaNop.getID() + "</td>"
                    + "<td>" + hoChuaNop.getMaHoKhau() + "</td>"
                    + "<td>" + hoChuaNop.getIdChuHo() + "</td>"
                    + "<td>" + hoChuaNop.getTenChuHo() + "</td>" 
                    + "<td>" + soThanhVien + " x " + mucPhi + ".000 đ = " + soThanhVien*mucPhi+ ".000 đ</td>"
                    + "</tr>";             
        }
        res += "</table></div></html>";
        
        return res;
    }
}