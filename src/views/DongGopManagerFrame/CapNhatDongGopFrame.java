/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.DongGopManagerFrame;

import controllers.DongGopController.CapNhatDongGopController;
import controllers.DongGopPanelController;
import controllers.LoginController;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.DongGopModel;
import models.KhoanDongGopModel;
import services.DongGopService;

public class CapNhatDongGopFrame extends javax.swing.JFrame {

    private DongGopPanelController parentController;
    private JFrame parentFrame;
    private DongGopService dongGopService;
    private CapNhatDongGopController controller;

    /**
     * Creates new form CapNhatDongGop
     * @param parentController
     * @param parentFrame
     */
    public CapNhatDongGopFrame(DongGopPanelController parentController, JFrame parentFrame) {
        initComponents();
        this.parentController = parentController;
        this.parentFrame = parentFrame;
        this.parentFrame.setEnabled(false);
        controller = new CapNhatDongGopController(tableHoKhau);
        dongGopService = new DongGopService();

        setTitle("Cập nhật khoản đóng góp");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        soTienNopTxb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tableHoKhau = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Số tiền đóng góp");

        soTienNopTxb.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("(*)");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Ngày nộp");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("(*)");

        updateBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        updateBtn.setText("Cập nhật");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Danh sách hộ khẩu");

        javax.swing.GroupLayout tableHoKhauLayout = new javax.swing.GroupLayout(tableHoKhau);
        tableHoKhau.setLayout(tableHoKhauLayout);
        tableHoKhauLayout.setHorizontalGroup(
            tableHoKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tableHoKhauLayout.setVerticalGroup(
            tableHoKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel2.setText("nghìn đồng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tableHoKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(cancelBtn)
                                .addGap(18, 18, 18)
                                .addComponent(updateBtn)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(soTienNopTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(50, 50, 50))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableHoKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(soTienNopTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(34, 34, 34)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateBtn)
                            .addComponent(cancelBtn))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        if (controller.getSelectedHoKhauModel() != null) {
            if (validateValueInForm()) {
                // tao moi 1 doi tuong nhan khau
                //KhoanDongGopModel temp = this.dongGopBean.getKhoanDongGopModel();
                DongGopModel temp = new DongGopModel();

                temp.setIdHoKhau(controller.getSelectedHoKhauModel().getID());
                KhoanDongGopModel khoanDongGop = parentController.getSelectedKhoanDongGop();

                temp.setMaPhi(khoanDongGop.getMaPhi());
                temp.setIdNguoiNhap(LoginController.currentUser.getID());
                temp.setSoTien(Integer.parseInt(soTienNopTxb.getText()));
                temp.setNgayNop(jDateChooser1.getDate());

                System.out.println(temp.getIdHoKhau() + " " + temp.getMaPhi() + " " + temp.getIdNguoiNhap() + " " + temp.getNgayNop() + " " + temp.getSoTien());

                if (dongGopService.capNhatDongGop(temp)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!!");
                    close();
                    parentController.refreshData();
                }

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn hộ dân", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure to close this??", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
            close();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    void close() {
        this.parentFrame.setEnabled(true);
        dispose();
    }

    private boolean validateValueInForm() {
        // check null
        if (soTienNopTxb.getText().trim().isEmpty()) {
            String message = "Vui lòng nhập hết các trường bắt buộc";
            JOptionPane.showMessageDialog(rootPane, message, "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        try {
            int d = Integer.parseInt(soTienNopTxb.getText());
            if (d < 0) {
                String message = "Số tiền nộp phải lớn hơn 0";
                JOptionPane.showMessageDialog(rootPane, message, "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (HeadlessException | NumberFormatException e) {
            String message = "Số tiền không thể chứa các ký tự";
            JOptionPane.showMessageDialog(rootPane, message, "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        KhoanDongGopModel khoanDongGop = parentController.getSelectedKhoanDongGop();
        Date ngayNop = jDateChooser1.getDate();
        if (ngayNop.before(khoanDongGop.getNgayBatDau()) || ngayNop.after(khoanDongGop.getNgayKetThuc())) {
            String message = "Ngay nộp phải từ " + khoanDongGop.getNgayBatDau()
                    + "đến " + khoanDongGop.getNgayKetThuc();
            JOptionPane.showMessageDialog(rootPane, message, "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField soTienNopTxb;
    private javax.swing.JPanel tableHoKhau;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
