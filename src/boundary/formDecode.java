/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary;

import controllers.IoManager;
import controllers.AES;
import controllers.Encoder;
import controllers.RLSB;
import controllers.PsnrManager;
import controllers.LCG;
import controllers.MainController;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mabdipme
 */
public class formDecode extends javax.swing.JFrame {

    IoManager io;
    JFileChooser chooser;
    BufferedImage cover_image,cover_image_lsb, stego_image, stego_image_lsb;
    FileNameExtensionFilter filter;
    BufferedImage image;
    ImageIcon icon;
    File file;
    String label_filename;
    String label_filesize;
    String label_jumlah_bits;
    String label_jumlah_char;
    String label_bits_embedded;
    String label_bits_extracted;
    String secret_message;
    String binaryPesanAsli;
    BigInteger cipher_decimal;
    String binaryCipherAes;
    MainController controller = new MainController(); //instansiasi
    /**
     * Creates new form formDecode
     */
    public formDecode() {
        this.setTitle("Steganografi Random LSB + AES");
        this.setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(formDecode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        setLocationRelativeTo(null);
        startForm();
        io = new IoManager();
        initComponents();
    }

      private void startForm(){
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblStegoRlsb = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNameStegoRlsb = new javax.swing.JLabel();
        lblSizeStegoRlsb = new javax.swing.JLabel();
        btnDecode = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtASmRlsb = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnBrowseStegoRlsb = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblStegoLsb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNameStegoLsb = new javax.swing.JLabel();
        lblSizeStegoLsb = new javax.swing.JLabel();
        btnDecodeLsb = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtASmLsb = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnBrowseStegoLsb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Form Decode");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Stego Image RLSB");

        lblNameStegoRlsb.setText("jLabel2");

        lblSizeStegoRlsb.setText("kB");

        btnDecode.setText("Decode");
        btnDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecodeActionPerformed(evt);
            }
        });

        txtASmRlsb.setColumns(20);
        txtASmRlsb.setRows(5);
        jScrollPane1.setViewportView(txtASmRlsb);

        jLabel2.setText("Secret Massage");

        btnBrowseStegoRlsb.setText("Browse ");
        btnBrowseStegoRlsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseStegoRlsbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNameStegoRlsb, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSizeStegoRlsb))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDecode, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBrowseStegoRlsb))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(lblStegoRlsb, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 92, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStegoRlsb, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameStegoRlsb)
                    .addComponent(lblSizeStegoRlsb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDecode)
                    .addComponent(btnBrowseStegoRlsb))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Stego Image LSB");

        lblNameStegoLsb.setText("jLabel2");

        lblSizeStegoLsb.setText("kB");

        btnDecodeLsb.setText("Decode");
        btnDecodeLsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecodeLsbActionPerformed(evt);
            }
        });

        txtASmLsb.setColumns(20);
        txtASmLsb.setRows(5);
        jScrollPane2.setViewportView(txtASmLsb);

        jLabel5.setText("Secret Massage");

        btnBrowseStegoLsb.setText("Browse ");
        btnBrowseStegoLsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseStegoLsbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblNameStegoLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSizeStegoLsb))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDecodeLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBrowseStegoLsb))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jLabel4))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jLabel5))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(lblStegoLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 68, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStegoLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameStegoLsb)
                    .addComponent(lblSizeStegoLsb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDecodeLsb)
                    .addComponent(btnBrowseStegoLsb))
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseStegoRlsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseStegoRlsbActionPerformed
        // TODO add your handling code here:
        chooser = new JFileChooser();
        filter = new FileNameExtensionFilter("Cover Image Files","bmp");
        chooser.setFileFilter(filter);
        if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            try {
                io.inputCoverImage(file);
            } catch (IOException ex) {
                Logger.getLogger(formEncodeNew.class.getName()).log(Level.SEVERE, null, ex);
            }
            label_filename = io.getFileName();
            lblNameStegoRlsb.setText(label_filename);
            label_filesize = String.valueOf(io.getFileSize()) + " kB";
            lblSizeStegoRlsb.setText(label_filesize);
            cover_image = io.getCoverImage();
            icon = new ImageIcon(cover_image);
            lblStegoRlsb.setEnabled(true);
            lblStegoRlsb.setIcon(icon);
        }
        else if(chooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "No file selected!");
        }
    }//GEN-LAST:event_btnBrowseStegoRlsbActionPerformed

    private void btnDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecodeActionPerformed
        // TODO add your handling code here:
//        stego_image = io.cloneImage(cover_image);
        
        String secretMessage = controller.doRLSBDecode(cover_image);
        
        
    }//GEN-LAST:event_btnDecodeActionPerformed

    private void btnDecodeLsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecodeLsbActionPerformed
        // TODO add your handling code here:
        String secretMessage = controller.doRLSBDecode(cover_image_lsb);
    }//GEN-LAST:event_btnDecodeLsbActionPerformed

    private void btnBrowseStegoLsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseStegoLsbActionPerformed
        // TODO add your handling code here:
        chooser = new JFileChooser();
        filter = new FileNameExtensionFilter("Stego Image Files","bmp");
        chooser.setFileFilter(filter);
        if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            try {
                io.inputCoverImage(file);
            } catch (IOException ex) {
                Logger.getLogger(formEncodeNew.class.getName()).log(Level.SEVERE, null, ex);
            }
            label_filename = io.getFileName();
            lblNameStegoLsb.setText(label_filename);
            label_filesize = String.valueOf(io.getFileSize()) + " kB";
            lblSizeStegoLsb.setText(label_filesize);
            cover_image_lsb = io.getCoverImage();
            icon = new ImageIcon(cover_image_lsb);
            lblStegoLsb.setEnabled(true);
            lblStegoLsb.setIcon(icon);
        }
        else if(chooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "No file selected!");
        }
    }//GEN-LAST:event_btnBrowseStegoLsbActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formDecode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formDecode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formDecode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formDecode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formDecode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseStegoLsb;
    private javax.swing.JButton btnBrowseStegoRlsb;
    private javax.swing.JButton btnDecode;
    private javax.swing.JButton btnDecodeLsb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNameStegoLsb;
    private javax.swing.JLabel lblNameStegoRlsb;
    private javax.swing.JLabel lblSizeStegoLsb;
    private javax.swing.JLabel lblSizeStegoRlsb;
    private javax.swing.JLabel lblStegoLsb;
    private javax.swing.JLabel lblStegoRlsb;
    private javax.swing.JTextArea txtASmLsb;
    private javax.swing.JTextArea txtASmRlsb;
    // End of variables declaration//GEN-END:variables
}
