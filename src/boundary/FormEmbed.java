package boundary;

import controllers.AES;
import controllers.IoManager;
import controllers.LCG;
import controllers.MainController;
import controllers.PsnrManager;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
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
public class FormEmbed extends javax.swing.JFrame {
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
    MainController controller = new MainController();
    
    
    public FormEmbed() {
        this.setTitle("Steganografi Random LSB dan LSB");
        this.setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FormEmbed.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        setLocationRelativeTo(null);
        startForm();
        io = new IoManager();
        
    }
    private void startForm(){
    }
    
    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBg = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlMsg = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAmsg = new javax.swing.JTextArea();
        btnBrowseText = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEncrypt = new javax.swing.JButton();
        txtFkey = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAHasilEncrypt = new javax.swing.JTextArea();
        btnGotoDecode = new javax.swing.JButton();
        pnlRlsb = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblHasilImage = new javax.swing.JLabel();
        lblFileName = new javax.swing.JLabel();
        lblFileSize = new javax.swing.JLabel();
        btnBrowseImage = new javax.swing.JButton();
        btnEmbedRlsb = new javax.swing.JButton();
        pnlStegoImageRlsb = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblStegoImageRlsb = new javax.swing.JLabel();
        btnSaveStegoRlsb = new javax.swing.JButton();
        btnCalculateRlsb = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblMSE = new javax.swing.JLabel();
        lblHasilMSE = new javax.swing.JLabel();
        lblPsnr = new javax.swing.JLabel();
        lblHasilPsnr = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblHasilImageLsb = new javax.swing.JLabel();
        lblFileNameLsb = new javax.swing.JLabel();
        lblFileSizeLsb = new javax.swing.JLabel();
        btnBrowseImageLsb = new javax.swing.JButton();
        pnlStegoImageRlsb1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblStegoImageLsb = new javax.swing.JLabel();
        btnSaveStegoLsb = new javax.swing.JButton();
        btnCalculateLsb = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblMseLsb = new javax.swing.JLabel();
        lblHasilMseLsb = new javax.swing.JLabel();
        lblPsnrLsb = new javax.swing.JLabel();
        lblHasilPsnrLsb = new javax.swing.JLabel();
        btnEmbedLsb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTitle.setText("Form Encode");

        txtAmsg.setEditable(false);
        txtAmsg.setColumns(20);
        txtAmsg.setRows(5);
        jScrollPane1.setViewportView(txtAmsg);

        btnBrowseText.setText("Browse Text");
        btnBrowseText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseTextActionPerformed(evt);
            }
        });

        jLabel1.setText("Messages");

        btnEncrypt.setText("Encrypt");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        jLabel9.setText("Set Key ");

        txtAHasilEncrypt.setColumns(20);
        txtAHasilEncrypt.setRows(5);
        jScrollPane2.setViewportView(txtAHasilEncrypt);

        btnGotoDecode.setText("Go Back to Main");
        btnGotoDecode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGotoDecodeMouseClicked(evt);
            }
        });
        btnGotoDecode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGotoDecodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMsgLayout = new javax.swing.GroupLayout(pnlMsg);
        pnlMsg.setLayout(pnlMsgLayout);
        pnlMsgLayout.setHorizontalGroup(
            pnlMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMsgLayout.createSequentialGroup()
                .addGroup(pnlMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMsgLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(pnlMsgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMsgLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlMsgLayout.createSequentialGroup()
                                .addComponent(txtFkey, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlMsgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addGroup(pnlMsgLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBrowseText))))
                    .addGroup(pnlMsgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMsgLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGotoDecode)))
                .addContainerGap())
        );
        pnlMsgLayout.setVerticalGroup(
            pnlMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMsgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrowseText)
                .addGap(33, 33, 33)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMsgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEncrypt))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnGotoDecode)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Cover Image RLSB");

        lblFileName.setText("jLabel3");

        lblFileSize.setText("kB");

        btnBrowseImage.setText("Browse Image");
        btnBrowseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseImageActionPerformed(evt);
            }
        });

        btnEmbedRlsb.setText("Embed");
        btnEmbedRlsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmbedRlsbActionPerformed(evt);
            }
        });

        jLabel4.setText("Stego Image RLSB");

        btnSaveStegoRlsb.setText("Save");
        btnSaveStegoRlsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveStegoRlsbActionPerformed(evt);
            }
        });

        btnCalculateRlsb.setText("Calculate");
        btnCalculateRlsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateRlsbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStegoImageRlsbLayout = new javax.swing.GroupLayout(pnlStegoImageRlsb);
        pnlStegoImageRlsb.setLayout(pnlStegoImageRlsbLayout);
        pnlStegoImageRlsbLayout.setHorizontalGroup(
            pnlStegoImageRlsbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStegoImageRlsbLayout.createSequentialGroup()
                .addGroup(pnlStegoImageRlsbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStegoImageRlsbLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel4)
                        .addGap(0, 158, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStegoImageRlsbLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCalculateRlsb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveStegoRlsb)))
                .addContainerGap())
            .addGroup(pnlStegoImageRlsbLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblStegoImageRlsb, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStegoImageRlsbLayout.setVerticalGroup(
            pnlStegoImageRlsbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStegoImageRlsbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStegoImageRlsb, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStegoImageRlsbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveStegoRlsb)
                    .addComponent(btnCalculateRlsb))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Image Quality ");

        lblMSE.setText("MSE :");

        lblPsnr.setText("PSNR :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblPsnr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHasilPsnr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblMSE)
                                .addGap(18, 18, 18)
                                .addComponent(lblHasilMSE, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHasilMSE, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMSE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPsnr)
                    .addComponent(lblHasilPsnr, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlRlsbLayout = new javax.swing.GroupLayout(pnlRlsb);
        pnlRlsb.setLayout(pnlRlsbLayout);
        pnlRlsbLayout.setHorizontalGroup(
            pnlRlsbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlStegoImageRlsb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRlsbLayout.createSequentialGroup()
                .addGroup(pnlRlsbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRlsbLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFileSize))
                    .addGroup(pnlRlsbLayout.createSequentialGroup()
                        .addGroup(pnlRlsbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRlsbLayout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jLabel2))
                            .addGroup(pnlRlsbLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(lblHasilImage, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRlsbLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlRlsbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEmbedRlsb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBrowseImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlRlsbLayout.setVerticalGroup(
            pnlRlsbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRlsbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblHasilImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRlsbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFileName)
                    .addComponent(lblFileSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBrowseImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmbedRlsb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStegoImageRlsb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(341, 341, 341))
        );

        jLabel3.setText("Cover Image LSB");

        lblFileNameLsb.setText("jLabel4");

        lblFileSizeLsb.setText("kB");

        btnBrowseImageLsb.setText("Browse Image");
        btnBrowseImageLsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseImageLsbActionPerformed(evt);
            }
        });

        jLabel6.setText("Stego Image LSB");

        btnSaveStegoLsb.setText("Save");
        btnSaveStegoLsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveStegoLsbActionPerformed(evt);
            }
        });

        btnCalculateLsb.setText("Calculate");
        btnCalculateLsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateLsbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStegoImageRlsb1Layout = new javax.swing.GroupLayout(pnlStegoImageRlsb1);
        pnlStegoImageRlsb1.setLayout(pnlStegoImageRlsb1Layout);
        pnlStegoImageRlsb1Layout.setHorizontalGroup(
            pnlStegoImageRlsb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStegoImageRlsb1Layout.createSequentialGroup()
                .addGroup(pnlStegoImageRlsb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStegoImageRlsb1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(lblStegoImageLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 106, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStegoImageRlsb1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCalculateLsb)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveStegoLsb)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStegoImageRlsb1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(161, 161, 161))
        );
        pnlStegoImageRlsb1Layout.setVerticalGroup(
            pnlStegoImageRlsb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStegoImageRlsb1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStegoImageLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStegoImageRlsb1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveStegoLsb)
                    .addComponent(btnCalculateLsb))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Image Quality ");

        lblMseLsb.setText("MSE :");

        lblPsnrLsb.setText("PSNR :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel7))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lblPsnrLsb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHasilPsnrLsb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lblMseLsb)
                                .addGap(18, 18, 18)
                                .addComponent(lblHasilMseLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHasilMseLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMseLsb))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPsnrLsb)
                    .addComponent(lblHasilPsnrLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEmbedLsb.setText("Embed");
        btnEmbedLsb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmbedLsbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFileNameLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFileSizeLsb))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBrowseImageLsb)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblHasilImageLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlStegoImageRlsb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEmbedLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHasilImageLsb, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFileNameLsb)
                    .addComponent(lblFileSizeLsb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrowseImageLsb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmbedLsb)
                .addGap(21, 21, 21)
                .addComponent(pnlStegoImageRlsb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(332, 332, 332))
        );

        javax.swing.GroupLayout pnlBgLayout = new javax.swing.GroupLayout(pnlBg);
        pnlBg.setLayout(pnlBgLayout);
        pnlBgLayout.setHorizontalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addComponent(pnlMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlRlsb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBgLayout.setVerticalGroup(
            pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRlsb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBg, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseTextActionPerformed
        // TODO add your handling code here:
        chooser = new JFileChooser();
        filter = new FileNameExtensionFilter("Secret Message Files","txt");
        chooser.setFileFilter(filter);
        if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            try {
                io.inputSecretMessage(file);
            } catch (IOException ex) {
                Logger.getLogger(FormEmbed.class.getName()).log(Level.SEVERE, null, ex);
            }
            secret_message = io.getSecretMessage();
            txtAmsg.setLineWrap(true);
            txtAmsg.setText(secret_message);
            txtAmsg.setWrapStyleWord(true);
            label_jumlah_char = String.valueOf(io.getJumlahChar());
            btnBrowseText.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "No file selected!");
        }
    }//GEN-LAST:event_btnBrowseTextActionPerformed

    private void btnBrowseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseImageActionPerformed
        // TODO add your handling code here:
        chooser = new JFileChooser();
        filter = new FileNameExtensionFilter("Cover Image Files","bmp");
        chooser.setFileFilter(filter);
        if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            try {
                io.inputCoverImage(file);
            } catch (IOException ex) {
                Logger.getLogger(FormEmbed.class.getName()).log(Level.SEVERE, null, ex);
            }
            label_filename = io.getFileName();
            lblFileName.setText(label_filename);
            label_filesize = String.valueOf(io.getFileSize()) + " kB";
            lblFileSize.setText(label_filesize);
            cover_image = io.getCoverImage();
            icon = new ImageIcon(cover_image);
            lblHasilImage.setEnabled(true);
            lblHasilImage.setIcon(icon);
        }
        else if(chooser.showOpenDialog(this) == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "No file selected!");
        }
    }//GEN-LAST:event_btnBrowseImageActionPerformed

    private void btnBrowseImageLsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseImageLsbActionPerformed
        // TODO add your handling code here:
        chooser = new JFileChooser();
        filter = new FileNameExtensionFilter("Cover Image Files","bmp");
        chooser.setFileFilter(filter);
        if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            try {
                io.inputCoverImage(file);
            } catch (IOException ex) {
                Logger.getLogger(FormEmbed.class.getName()).log(Level.SEVERE, null, ex);
            }
            label_filename = io.getFileName();
            lblFileNameLsb.setText(label_filename);
            label_filesize = String.valueOf(io.getFileSize()) + " kB";
            lblFileSizeLsb.setText(label_filesize);
            cover_image_lsb = io.getCoverImage();
            icon = new ImageIcon(cover_image_lsb);
            lblHasilImageLsb.setEnabled(true);
            lblHasilImageLsb.setIcon(icon);
        }
        else {
            JOptionPane.showMessageDialog(null, "No file selected!");
        }
    }//GEN-LAST:event_btnBrowseImageLsbActionPerformed

    private void btnEmbedRlsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmbedRlsbActionPerformed

        // CLONE IMAGE INPUT
        BufferedImage cloneImage = io.cloneImage(cover_image);
        // DO STEGANOGRAPHY RLSB        
        stego_image = controller.doRLSB(cloneImage, secret_message);
        
        icon = new ImageIcon(stego_image);
        lblStegoImageRlsb.setEnabled(true);
        lblStegoImageRlsb.setIcon(icon);
        btnSaveStegoRlsb.setEnabled(true);
        btnEmbedRlsb.setEnabled(false);
        btnEmbedRlsb.setText("Encoded");
    }//GEN-LAST:event_btnEmbedRlsbActionPerformed

    private void btnSaveStegoRlsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveStegoRlsbActionPerformed
        // TODO add your handling code here:
        chooser = new JFileChooser();
        filter = new FileNameExtensionFilter("BMP Files","bmp");
        chooser.setFileFilter(filter);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            try{
                io.saveStegoImage(chooser.getSelectedFile().getAbsolutePath() + ".bmp",stego_image);
                btnSaveStegoRlsb.setEnabled(false);
                btnSaveStegoRlsb.setText("Saved");
                
                JOptionPane.showMessageDialog(null, "Stego image saved!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Save Failed!");
        }
    }//GEN-LAST:event_btnSaveStegoRlsbActionPerformed

    private void btnCalculateRlsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateRlsbActionPerformed
        // TODO add your handling code here:
        PsnrManager psnr = new PsnrManager(cover_image, stego_image);
        psnr.calculatePSNR();
        lblHasilMSE.setText(String.format("%.5f", psnr.getMSE()));
        lblHasilPsnr.setText(String.format("%.5f", psnr.getPSNR()));
    }//GEN-LAST:event_btnCalculateRlsbActionPerformed

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        // TODO add your handling code here:
        
        txtAHasilEncrypt.setLineWrap(true);  
        txtAHasilEncrypt.setWrapStyleWord(true);
        
        String pesan = txtAmsg.getText();
        String kunciEnkripsi = txtFkey.getText();
        AES AES = new AES();
        
        try{
            String pesanEnkripsi = AES.encryptAES(pesan, kunciEnkripsi);
            
            txtAHasilEncrypt.setText(pesanEnkripsi);              
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void btnEmbedLsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmbedLsbActionPerformed
        // TODO add your handling code here:
        // CLONE IMAGE INPUT
        BufferedImage cloneImage = io.cloneImage(cover_image_lsb);
        // DO STEGANOGRAPHY RLSB        
        stego_image_lsb = controller.doLSB(cloneImage, secret_message);
        
        icon = new ImageIcon(stego_image_lsb);
        lblStegoImageLsb.setEnabled(true);
        lblStegoImageLsb.setIcon(icon);
        btnSaveStegoLsb.setEnabled(true);
        btnEmbedLsb.setEnabled(false);
        btnEmbedLsb.setText("Encoded");
    }//GEN-LAST:event_btnEmbedLsbActionPerformed

    private void btnCalculateLsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateLsbActionPerformed
        // TODO add your handling code here:
        PsnrManager psnr = new PsnrManager(cover_image_lsb, stego_image_lsb);
        psnr.calculatePSNR();
        lblHasilMseLsb.setText(String.format("%.5f", psnr.getMSE()));
        lblHasilPsnrLsb.setText(String.format("%.5f", psnr.getPSNR()));
    }//GEN-LAST:event_btnCalculateLsbActionPerformed

    private void btnSaveStegoLsbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveStegoLsbActionPerformed
        // TODO add your handling code here:
        chooser = new JFileChooser();
        filter = new FileNameExtensionFilter("BMP Files","bmp");
        chooser.setFileFilter(filter);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            try{
                io.saveStegoImage(chooser.getSelectedFile().getAbsolutePath() + ".bmp",stego_image_lsb);
                btnSaveStegoLsb.setEnabled(false);
                btnSaveStegoLsb.setText("Saved");
                
                JOptionPane.showMessageDialog(null, "Stego image saved!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveStegoLsbActionPerformed

    private void btnGotoDecodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGotoDecodeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGotoDecodeMouseClicked

    private void btnGotoDecodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGotoDecodeActionPerformed
        // TODO add your handling code here:
        close();
        FormMain fm = new FormMain();
        fm.setVisible(true);
    }//GEN-LAST:event_btnGotoDecodeActionPerformed

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
            java.util.logging.Logger.getLogger(FormEmbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEmbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEmbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEmbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEmbed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseImage;
    private javax.swing.JButton btnBrowseImageLsb;
    private javax.swing.JButton btnBrowseText;
    private javax.swing.JButton btnCalculateLsb;
    private javax.swing.JButton btnCalculateRlsb;
    private javax.swing.JButton btnEmbedLsb;
    private javax.swing.JButton btnEmbedRlsb;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnGotoDecode;
    private javax.swing.JButton btnSaveStegoLsb;
    private javax.swing.JButton btnSaveStegoRlsb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFileName;
    private javax.swing.JLabel lblFileNameLsb;
    private javax.swing.JLabel lblFileSize;
    private javax.swing.JLabel lblFileSizeLsb;
    private javax.swing.JLabel lblHasilImage;
    private javax.swing.JLabel lblHasilImageLsb;
    private javax.swing.JLabel lblHasilMSE;
    private javax.swing.JLabel lblHasilMseLsb;
    private javax.swing.JLabel lblHasilPsnr;
    private javax.swing.JLabel lblHasilPsnrLsb;
    private javax.swing.JLabel lblMSE;
    private javax.swing.JLabel lblMseLsb;
    private javax.swing.JLabel lblPsnr;
    private javax.swing.JLabel lblPsnrLsb;
    private javax.swing.JLabel lblStegoImageLsb;
    private javax.swing.JLabel lblStegoImageRlsb;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBg;
    private javax.swing.JPanel pnlMsg;
    private javax.swing.JPanel pnlRlsb;
    private javax.swing.JPanel pnlStegoImageRlsb;
    private javax.swing.JPanel pnlStegoImageRlsb1;
    private javax.swing.JTextArea txtAHasilEncrypt;
    private javax.swing.JTextArea txtAmsg;
    private javax.swing.JTextField txtFkey;
    // End of variables declaration//GEN-END:variables
}
