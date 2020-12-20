package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.KhoanDongGopModel;
import models.KhoanPhiBatBuocModel;


/**
 *
 * @author Tuan 
 */
public class ClassTableModel {
    // bang cho main frame
    public DefaultTableModel setTableKhoanDongGop(List<KhoanDongGopModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
       
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((KhoanDongGopModel item) -> {
            obj[0] = item.getMaPhi();
            obj[1] = item.getTenPhi();
            obj[2] = item.getNgayBatDau();
            obj[3] = item.getNgayKetThuc();
            dtm.addRow(obj);
        });
        return dtm;
    }
 
    public DefaultTableModel setTableKhoanPhi(List<KhoanPhiBatBuocModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
      
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((KhoanPhiBatBuocModel item) -> {
            obj[0] = item.getMaPhi();
            obj[1] = item.getTenPhi();
            obj[2] = item.getMucPhi();
            obj[3] = item.getNgayBatDau();
            obj[4] = item.getNgayKetThuc();
            dtm.addRow(obj);
        });
        return dtm;
    }
}
