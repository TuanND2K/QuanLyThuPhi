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
	public DongGopBean(KhoanDongGopModel dongGopModel, List<HoKhauModel> listHoKhau, List<DongGopModel> listDongGop) {
		super();
		this.khoanDongGopModel = dongGopModel;
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
	
	
}
