package models;

import java.util.Date;

public class ThuPhiModel {
	private int idHoKhau;
	private String maPhi;
	private int idNguoiNhap;
	private Date ngayNop;
	
	public int getIdHoKhau() {
		return idHoKhau;
	}
	
	public void setIdHoKhau(int idHoKhau) {
		this.idHoKhau = idHoKhau;
	}
	
	public String getMaPhi() {
		return maPhi;
	}
	
	public void setMaPhi(String maPhi) {
		this.maPhi = maPhi;
	}
	
	public int getIdNguoiNhap() {
		return idNguoiNhap;
	}
	
	public void setIdNguoiNhap(int idNguoiNhap) {
		this.idNguoiNhap = idNguoiNhap;
	}
	
	public Date getNgayNop() {
		return ngayNop;
	}
	
	public void setNgayNop(Date ngayNop) {
		this.ngayNop = ngayNop;
	}
		
}
