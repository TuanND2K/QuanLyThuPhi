/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ThuPhiPanelController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import views.ThuPhiManagerFrame.CapNhatThuPhiFrame;
import views.ThuPhiManagerFrame.SuaThongTinThuPhiFrame;
import views.ThuPhiManagerFrame.ThemKhoanPhiFrame;

public class ThuPhiManagerPanel extends javax.swing.JPanel {

    private JFrame parentFrame;
    private ThuPhiPanelController controller;

    public ThuPhiManagerPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        controller = new ThuPhiPanelController(tableJpn);
        controller.setParentJFrame(parentFrame);
        controller.setDataTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        themMoiBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        tableJpn = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        themMoiBtn.setBackground(new java.awt.Color(255, 255, 255));
        themMoiBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        themMoiBtn.setText("Thêm mới");
        themMoiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMoiBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(255, 255, 255));
        updateBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        updateBtn.setText("Cập nhật thu phí");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tableJpnLayout = new javax.swing.GroupLayout(tableJpn);
        tableJpn.setLayout(tableJpnLayout);
        tableJpnLayout.setHorizontalGroup(
            tableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        tableJpnLayout.setVerticalGroup(
            tableJpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Quản lý thu phí");

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Sửa thông tin thu phí");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(tableJpn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(themMoiBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(themMoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(tableJpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void themMoiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themMoiBtnActionPerformed
        ThemKhoanPhiFrame themKhoanPhi = new ThemKhoanPhiFrame(controller, parentFrame);
        themKhoanPhi.setLocationRelativeTo(null);
        themKhoanPhi.setResizable(false);
        themKhoanPhi.setVisible(true);
    }//GEN-LAST:event_themMoiBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        if (controller.getSelectedKhoanPhi() == null) {
            JOptionPane.showMessageDialog(null, "Chưa chọn khoản phí!");
        } else {
            CapNhatThuPhiFrame capNhatThuPhiFrame = new CapNhatThuPhiFrame(controller, parentFrame);
            capNhatThuPhiFrame.setLocationRelativeTo(null);
            capNhatThuPhiFrame.setResizable(false);
            capNhatThuPhiFrame.setVisible(true);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (controller.getSelectedKhoanPhi() == null) {
            JOptionPane.showMessageDialog(null, "Chưa chọn khoản phí!");
        } else {
            SuaThongTinThuPhiFrame suaKhoanPhi = new SuaThongTinThuPhiFrame(controller, parentFrame);
            suaKhoanPhi.setLocationRelativeTo(null);
            suaKhoanPhi.setResizable(false);
            suaKhoanPhi.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel tableJpn;
    private javax.swing.JButton themMoiBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
