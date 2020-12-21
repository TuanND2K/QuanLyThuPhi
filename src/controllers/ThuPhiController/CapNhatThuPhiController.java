/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.ThuPhiController;

import controllers.ThuPhiPanelController;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.*;
import services.HoKhauService;
import utility.ClassTableModel;

/**
 *
 * @author TuanNguyen
 */
public class CapNhatThuPhiController {
    private HoKhauModel selectedHoKhauModel;
    private JPanel tableHoKhau;
    private JLabel soTienNop;
    private ThuPhiPanelController parentController;
    private HoKhauService hoKhauService = new HoKhauService();
    private ClassTableModel tableModelHoKhau = null;
    private final String[] COLUMNS = {"ID Hộ khẩu", "Mã hộ khẩu", "Tên chủ hộ", "Số thành viên"};
    
    public CapNhatThuPhiController(JPanel tableHoKhau, JLabel soTienNop, ThuPhiPanelController parentController){
        this.tableHoKhau = tableHoKhau;
        this.soTienNop = soTienNop;
        this.parentController = parentController;
        tableModelHoKhau = new ClassTableModel();
        setDataTable();
    }

    public HoKhauModel getSelectedHoKhauModel() {
        return selectedHoKhauModel;
    }

    public void setSelectedHoKhauModel(HoKhauModel selectedHoKhauModel) {
        this.selectedHoKhauModel = selectedHoKhauModel;
    }

    public HoKhauService getHoKhauService() {
        return hoKhauService;
    }

    public void setHoKhauService(HoKhauService hoKhauService) {
        this.hoKhauService = hoKhauService;
    }
    
    public void setDataTable() {
       
        List<HoKhauModel> listItem = hoKhauService.getListHoKhau();
        DefaultTableModel model = tableModelHoKhau.setTableHoKhau(listItem, COLUMNS);
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        
        // thiet ke bang
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
     
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//              JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                selectedHoKhauModel = listItem.get(table.getSelectedRow());
                soTienNop.setText("Số tiền nộp: " 
                        + parentController.getSelectedKhoanPhi().getMucPhi() * selectedHoKhauModel.getSoLuongThanhVien() + " nghìn đồng");
            }
            
        });
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
       
        tableHoKhau.removeAll();
        tableHoKhau.setLayout(new BorderLayout());
        tableHoKhau.add(scroll);
        tableHoKhau.validate();
        tableHoKhau.repaint();
       
    }
}
