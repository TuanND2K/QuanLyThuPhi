package Bean;

import java.util.*;

import models.DongGopModel;
import models.HoKhauModel;
import models.KhoanDongGopModel;

public class DongGopBean {
	private KhoanDongGopModel khoanDongGopModel;
	private List<HoKhauModel> listHoKhau;
	private List<DongGopModel> listDongGop;
	
        public DongGopBean() {
            khoanDongGopModel = new KhoanDongGopModel();
            listHoKhau = new ArrayList<>();
            listDongGop = new ArrayList<>();
        }
        
	public DongGopBean(KhoanDongGopModel khoanDongGopModel, List<HoKhauModel> listHoKhau, List<DongGopModel> listDongGop) {
		this.khoanDongGopModel = khoanDongGopModel;
		this.listHoKhau = listHoKhau;
		this.listDongGop = listDongGop;
	}

	public KhoanDongGopModel getKhoanDongGopModel() {
		return khoanDongGopModel;
	}

	public void setKhoanDongGopModel(KhoanDongGopModel dongGopModel) {
		this.khoanDongGopModel = dongGopModel;
	}

	public List<HoKhauModel> getListHoKhau() {
		return listHoKhau;
	}

	public void setListHoKhau(List<HoKhauModel> listHoKhau) {
		this.listHoKhau = listHoKhau;
	}

	public List<DongGopModel> getListDongGop() {
		return listDongGop;
	}

	public void setListDongGop(List<DongGopModel> listDongGop) {
		this.listDongGop = listDongGop;
	}
        
        public int getTongDongGop() {
            int sum = 0;
            for (DongGopModel dongGop : listDongGop) {
                sum += dongGop.getSoTien();
            }
            return sum;
        }
	
    /**
     *
     * hien thi thong tin bang html 
     */
    @Override
	public String toString() {
            String res = "<html> <style>p {padding: 5px; margin-left: 20px} table, th, td {border: 1px solid black; border-collapse: collapse;} table {width: 500px}</style> <div>"
                        + "<h3>Thông tin cơ bản"
                        + "<p>Mã khoản đóng góp: <b>" + khoanDongGopModel.getMaPhi() + "</p>"
                        + "<p>Tên khoản đóng góp: <b>" + khoanDongGopModel.getTenPhi() + "</p>"
                        + "<p>Ngày bắt đầu: <b>" + khoanDongGopModel.getNgayBatDau() + "</p>"
                        + "<p>Ngày kết thúc: <b>" + khoanDongGopModel.getNgayKetThuc() + "</p>"
                        + "<p>Tổng số tiền đã thu được: <b>" + getTongDongGop() + ".000 đ</p>"
                        + "<h4>Danh sách hộ đóng góp: " + listHoKhau.size() + " hộ đã đóng góp<table>"
                        + "<tr>"
                        + "<th>ID hộ</th>"
                        + "<th>Mã hộ</th>"
                        + "<th>ID chủ hộ</th>"
                        + "<th>Tên chủ hộ</th>"
                        + "<th>Số tiền</th>"
                        + "<th>Ngày đóng</th>"
                        + "</tr>";
            for (int i = 0; i < listHoKhau.size(); i++) {
                res += "<tr>"
                        + "<td>" + listHoKhau.get(i).getID() + "</td>"
                        + "<td>" + listHoKhau.get(i).getMaHoKhau() + "</td>"
                        +"<td>" + listHoKhau.get(i).getIdChuHo() + "</td>"
                        + "<td>" + listHoKhau.get(i).getTenChuHo() + "</td>" 
                        + "<td>" + listDongGop.get(i).getSoTien() + ".000 đ</td>"
                        + "<td>" + listDongGop.get(i).getNgayNop()+ "</td>"
                        + "</tr>";
            }
            res += "</table></div></html>";
            
            return res;
        }
}