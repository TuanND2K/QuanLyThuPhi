package Bean;

import java.util.ArrayList;
import java.util.List;

import models.HoKhauModel;
import models.KhoanPhiBatBuocModel;
import models.ThuPhiModel;

public class ThuPhiBean {

    private KhoanPhiBatBuocModel khoanPhiModel;
    private List<HoKhauModel> listHoKhau;
    private List<ThuPhiModel> listThuPhi;

    public ThuPhiBean() {
        khoanPhiModel = new KhoanPhiBatBuocModel();
        listHoKhau = new ArrayList<>();
        listThuPhi = new ArrayList<>();
    }

    public ThuPhiBean(KhoanPhiBatBuocModel thuPhiModel, List<HoKhauModel> listHoKhau, List<ThuPhiModel> listThuPhi) {
        super();
        this.khoanPhiModel = thuPhiModel;
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

}
