package controllers;

import Bean.DongGopBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.KhoanDongGopModel;
import models.NhanKhauModel;
import services.DongGopService;
import utility.ClassTableModel;
import views.infoViews.InfoJframe;

/**
 *
 * @author Hai
 */
public class DongGopPanelController {
    
    private JPanel jpnView;
    private DongGopService dongGopService;
    private List<DongGopBean> listDongGopBeans;
    private ClassTableModel tableModelKhoanDongGop = null;
    private final String[] COLUMNS = {"Mã", "Tên đóng góp", "Ngày bắt đầu", "Ngày kết thúc"};
    private JFrame parentJFrame;
    private KhoanDongGopModel selectedKhoanDongGop;
    public DongGopPanelController(JPanel jpnView) {
        this.jpnView = jpnView;
        tableModelKhoanDongGop = new ClassTableModel();
        this.dongGopService = new DongGopService();
        this.listDongGopBeans = this.dongGopService.getListDongGopBeans();
    }

    public DongGopPanelController() {
    }
    
    public void setDataTable() {
        List<KhoanDongGopModel> listItem = new ArrayList<>();
        this.listDongGopBeans.forEach(dongGop -> {
            listItem.add(dongGop.getKhoanDongGopModel());
        });
        //if(listItem.isEmpty()) System.out.println("rong");
        DefaultTableModel model = tableModelKhoanDongGop.setTableKhoanDongGop(listItem, COLUMNS);
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
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                    List<KhoanDongGopModel> listKhoanDongGop = new ArrayList<>();
                    for(DongGopBean dongGopBean: listDongGopBeans) {
                        KhoanDongGopModel khoanDongGop = dongGopBean.getKhoanDongGopModel();
                        listKhoanDongGop.add(khoanDongGop);
                    }
                    selectedKhoanDongGop = listKhoanDongGop.get(table.getSelectedRow());
                    /*NhanKhauBean temp = listKhoanDongGop.get(table.getSelectedRow());
                    NhanKhauBean info = dongGopService.getNhanKhau(temp.getChungMinhThuModel().getSoCMT());
                    InfoJframe infoJframe = new InfoJframe(info.toString(), parentJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);*/
                //table.getSelectedRow();
            }
            
        });
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
       
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
    public void refreshData() {
        this.listDongGopBeans = this.dongGopService.getListDongGopBeans();
        setDataTable();
    }
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }
    
    public KhoanDongGopModel getSelectedKhoanDongGop() {
        return this.selectedKhoanDongGop;
    }
}
