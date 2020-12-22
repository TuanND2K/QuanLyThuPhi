/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.ThuPhiManagerFrame;

import controllers.LoginController;
import controllers.ThuPhiController.CapNhatThuPhiController;
import controllers.ThuPhiPanelController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.KhoanPhiBatBuocModel;
import models.ThuPhiModel;
import services.ThuPhiService;

/**
 *
 * @author Ngo Van Giang
 */
public class CapNhatThuPhiFrame extends javax.swing.JFrame {

    private ThuPhiPanelController parentController;
    private JFrame parentFrame;
    private ThuPhiService thuPhiService;
    private CapNhatThuPhiController controller;

    /**
     * Creates new form CapNhatThuPhiFrame
     */
    public CapNhatThuPhiFrame(ThuPhiPanelController parentController, JFrame parentFrame) {
        initComponents();
        this.parentController = parentController;
        this.parentFrame = parentFrame;
        this.parentFrame.setEnabled(false);
        controller = new CapNhatThuPhiController(tablePanel, soTienNopLabel, parentController);
        thuPhiService = new ThuPhiService();

        setTitle("Cập nhật thu phí");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        ngayNopChooser = new com.toedter.calendar.JDateChooser();
        cancelBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        soTienNopLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Ngày nộp");

        ngayNopChooser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cancelBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        updateBtn.setText("Cập nhật");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Danh sách hộ khẩu");

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );

        soTienNopLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        soTienNopLabel.setText("Số tiền nộp :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateBtn)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tablePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(soTienNopLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(39, 39, 39)
                                .addComponent(ngayNopChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(142, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(soTienNopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngayNopChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure to close this??", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
            close();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        if (controller.getSelectedHoKhauModel() != null) {

            if (validateValueInForm()) {
                // tao moi 1 doi tuong nhan khau
                //KhoanDongGopModel temp = this.dongGopBean.getKhoanDongGopModel();
                ThuPhiModel temp = new ThuPhiModel();

                temp.setIdHoKhau(controller.getSelectedHoKhauModel().getID());
                KhoanPhiBatBuocModel khoanPhi = parentController.getSelectedKhoanPhi();
                temp.setMaPhi(khoanPhi.getMaPhi());
                temp.setIdNguoiNhap(LoginController.currentUser.getID());
                temp.setNgayNop(ngayNopChooser.getDate());

                if (thuPhiService.capNhatThuPhi(temp)) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công!!");
                    close();
                    parentController.refreshData();
                }

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn hộ dân", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    void close() {
        this.parentFrame.setEnabled(true);
        dispose();
    }

    private boolean validateValueInForm() {

        KhoanPhiBatBuocModel khoanPhi = parentController.getSelectedKhoanPhi();
        Date ngayNop = ngayNopChooser.getDate();
        if (ngayNop.before(khoanPhi.getNgayBatDau()) || ngayNop.after(khoanPhi.getNgayKetThuc())) {
            String message = "Ngày nộp phải từ " + khoanPhi.getNgayBatDau()
                    + " đến " + khoanPhi.getNgayKetThuc();
            JOptionPane.showMessageDialog(rootPane, message, "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private com.toedter.calendar.JDateChooser ngayNopChooser;
    private javax.swing.JLabel soTienNopLabel;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
