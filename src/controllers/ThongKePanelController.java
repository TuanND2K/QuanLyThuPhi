package controllers;


import Bean.ThongKeHoKhauBean;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import models.HoKhauModel;
import services.HoKhauService;
import utility.ClassTableModel;
import views.infoViews.InfoJframe;


/**
 *
 * @author Hai
 */
public class ThongKePanelController {
   private JPanel tablePanel;
   private final String[] COLUMNS = {"ID Hộ khẩu", "Mã hộ khẩu", "Tên chủ hộ", "Số thành viên"};
   private HoKhauService hoKhauService = new HoKhauService();
   private ClassTableModel tableModelHoKhau = null;
   private HoKhauModel selectedHoKhauModel;
   private JFrame parentFrame;
   
   public ThongKePanelController(JPanel tablePanel, JFrame parentFrame) {
       this.tablePanel = tablePanel;
       tableModelHoKhau = new ClassTableModel();
       this.parentFrame = parentFrame;
       setTableModel();
   }
   
   public void setTableModel() {
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
                if (e.getClickCount() > 1) {
                    selectedHoKhauModel = listItem.get(table.getSelectedRow());
                    ThongKeHoKhauBean info = hoKhauService.getListKhoanDaNop(selectedHoKhauModel);
                    InfoJframe infoJframe = new InfoJframe(info.toString(), parentFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                }
            }
            
        });
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
       
        tablePanel.removeAll();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scroll);
        tablePanel.validate();
        tablePanel.repaint();
       
   }
}
