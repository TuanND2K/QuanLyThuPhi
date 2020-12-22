package Bean;

import java.util.ArrayList;
import java.util.List;
import models.*;

public class ThongKeHoKhauBean {

    private HoKhauModel hoKhauModel;
    private List<KhoanDongGopModel> listKhoanDongGopModel;
    private List<KhoanPhiBatBuocModel> listKhoanPhiModel; //luu thong tin phi
    private List<ThuPhiModel> listPhiDaNop;
    private List<DongGopModel> listKhoanDaDongGop; // luu thong tin ngay nop

    public ThongKeHoKhauBean(HoKhauModel hoKhauModel) {
        this.hoKhauModel = hoKhauModel;
        this.listKhoanDongGopModel = new ArrayList<>();
        this.listKhoanPhiModel = new ArrayList<>();
        this.listPhiDaNop = new ArrayList<>();
        this.listKhoanDaDongGop = new ArrayList<>();
    }

    public List<ThuPhiModel> getListPhiDaNop() {
        return listPhiDaNop;
    }

    public void setListPhiDaNop(List<ThuPhiModel> listPhiDaNop) {
        this.listPhiDaNop = listPhiDaNop;
    }

    public List<DongGopModel> getListKhoanDaDongGop() {
        return listKhoanDaDongGop;
    }

    public void setListKhoanDaDongGop(List<DongGopModel> listKhoanDaDongGop) {
        this.listKhoanDaDongGop = listKhoanDaDongGop;
    }

    public HoKhauModel getHoKhauModel() {
        return hoKhauModel;
    }

    public void setHoKhauModel(HoKhauModel hoKhauModel) {
        this.hoKhauModel = hoKhauModel;
    }

    public List<KhoanDongGopModel> getListKhoanDongGopModel() {
        return listKhoanDongGopModel;
    }

    public void setListKhoanDongGopModel(List<KhoanDongGopModel> listKhoanDongGopModel) {
        this.listKhoanDongGopModel = listKhoanDongGopModel;
    }

    public List<KhoanPhiBatBuocModel> getListKhoanPhiModel() {
        return listKhoanPhiModel;
    }

    public void setListKhoanPhiModel(List<KhoanPhiBatBuocModel> listKhoanPhiModel) {
        this.listKhoanPhiModel = listKhoanPhiModel;
    }

    @Override
    public String toString() {
        int tongPhiDaNop = 0;
        int tongTienDongGop = 0;

        for (DongGopModel dg : listKhoanDaDongGop) {
            tongTienDongGop += dg.getSoTien();
        }

        int soThanhVien = hoKhauModel.getSoLuongThanhVien();
        for (KhoanPhiBatBuocModel phi : listKhoanPhiModel) {
            tongPhiDaNop += (soThanhVien * phi.getMucPhi());
        }

        String res = "<html> <style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
                + "<h3>Thông tin cơ bản"
                + "<p>Mã hộ khẩu: <b>" + hoKhauModel.getMaHoKhau() + "</p>"
                + "<p>Họ tên chủ hộ: <b>" + hoKhauModel.getTenChuHo() + "</p>"
                + "<p>Số thành viên: <b>" + hoKhauModel.getSoLuongThanhVien() + "</p>"
                + "<h3>Tổng tiền phí đã nộp: " + tongPhiDaNop + ".000 đ</h3>"
                + "<h3>Tổng số tiền đã đóng góp: " + tongTienDongGop + ".000 đ</h3>"
                + "<h3>Danh sách phí đã nộp:<table>"
                + "<tr>"
                + "<th>Mã phí</th>"
                + "<th>Tên phí</th>"
                + "<th>Ngày bắt dầu</th>"
                + "<th>Ngày kết thúc</th>"
                + "<th>Mức phí/người</th>"
                + "<th>Ngày đóng</th>"
                + "</tr>";

        for (int i = 0; i < listPhiDaNop.size(); i++) {
            res += "<tr>"
                    + "<td>" + listKhoanPhiModel.get(i).getMaPhi() + "</td>"
                    + "<td>" + listKhoanPhiModel.get(i).getTenPhi() + "</td>"
                    + "<td>" + listKhoanPhiModel.get(i).getNgayBatDau() + "</td>"
                    + "<td>" + listKhoanPhiModel.get(i).getNgayKetThuc() + "</td>"
                    + "<td>" + listKhoanPhiModel.get(i).getMucPhi() + " nghìn đồng</td>"
                    + "<td>" + listPhiDaNop.get(i).getNgayNop() + "</td>"
                    + "</tr>";
        }
        res += "</table>";

        res += "<p></P>";
        res += "<p></p>";

        res += "<h3>Danh sách các khoản đã đóng góp<table>"
                + "<tr>"
                + "<th>Mã đợt đóng góp</th>"
                + "<th>Tên đóng góp</th>"
                + "<th>Ngày nộp</th>"
                + "<th>Số tiền đóng góp</th>"
                + "</tr>";
        for (int i = 0; i< listKhoanDaDongGop.size(); i++) {
            res += "<tr>"
                    + "<td>" + listKhoanDongGopModel.get(i).getMaPhi() + "</td>"
                    + "<td>" + listKhoanDongGopModel.get(i).getTenPhi() + "</td>"
                    + "<td>" + listKhoanDaDongGop.get(i).getNgayNop() + "</td>"
                    + "<td>" + listKhoanDaDongGop.get(i).getSoTien() + ".000 đ</td>"
                    + "</tr>";
        }
        res += "</table></div></html>";
        return res;
    }
    
}
