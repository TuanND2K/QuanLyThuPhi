package controllers;


import Bean.ThuPhiBean;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.KhoanDongGopModel;
import models.KhoanPhiBatBuocModel;
import services.ThuPhiService;
import views.infoViews.InfoJframe;
import utility.ClassTableModel;
/**
 *
 * @author Hai
 */
public class ThuPhiPanelController {
    private JPanel jpnView;
    private ThuPhiService thuPhiService;
    private List<ThuPhiBean> listThuPhiBean;
    private ClassTableModel tableModelKhoanPhi = null;
    private final String[] COLUMNS = {"Mã phí", "Tên phí", "Mức phí/người(nghìn đồng)", "Ngày bắt dầu", "Ngày kết thúc"};
    private JFrame parentJFrame;

    public ThuPhiPanelController(JPanel tableJpn) {
        this.jpnView = tableJpn;
        tableModelKhoanPhi = new ClassTableModel();
        this.thuPhiService = new ThuPhiService();
        this.listThuPhiBean = this.thuPhiService.getListThuPhiBeans();
    }
    
    public void setDataTable() {
        List<KhoanPhiBatBuocModel> listItem = new ArrayList<>();
        this.listThuPhiBean.forEach(thuPhi -> {
            listItem.add(thuPhi.getKhoanPhiModel());
        });
        //if(listItem.isEmpty()) System.out.println("rong");
        DefaultTableModel model = tableModelKhoanPhi.setTableKhoanPhi(listItem, COLUMNS);
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
        
        //
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
        this.listThuPhiBean = this.thuPhiService.getListThuPhiBeans();
        setDataTable();
    }
    
}
